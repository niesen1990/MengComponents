package com.cmbb.smartkids.testmenglist.network;

import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

/**
 * 项目名称：SmartKids
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：2015/5/11 13:37
 * 修改人：N.Sun
 * 修改时间：2015/5/11 13:37
 * 修改备注：
 */
public class StethoInterceptor implements Interceptor {
    private final NetworkEventReporter mEventReporter = NetworkEventReporterImpl.get();

    private final AtomicInteger mNextRequestId = new AtomicInteger(0);

    @Override
    public Response intercept(Chain chain) throws IOException {
        String requestId = String.valueOf(mNextRequestId.getAndIncrement());

        Request request = chain.request();

        int requestSize = 0;
        if (mEventReporter.isEnabled()) {
            OkHttpInspectorRequest inspectorRequest = new OkHttpInspectorRequest(requestId, request);
            mEventReporter.requestWillBeSent(inspectorRequest);
            byte[] requestBody = inspectorRequest.body();
            if (requestBody != null) {
                requestSize += requestBody.length;
            }
        }

        Response response;
        try {
            response = chain.proceed(request);
        } catch (IOException e) {
            if (mEventReporter.isEnabled()) {
                mEventReporter.httpExchangeFailed(requestId, e.toString());
            }
            throw e;
        }

        if (mEventReporter.isEnabled()) {
            if (requestSize > 0) {
                mEventReporter.dataSent(requestId, requestSize, requestSize);
            }

            Connection connection = chain.connection();
            mEventReporter.responseHeadersReceived(
                    new OkHttpInspectorResponse(
                            requestId,
                            request,
                            response,
                            connection));

            ResponseBody body = response.body();
            MediaType contentType = null;
            InputStream responseStream = null;
            if (body != null) {
                contentType = body.contentType();
                responseStream = body.byteStream();
            }

            responseStream = mEventReporter.interpretResponseStream(
                    requestId,
                    contentType != null ? contentType.toString() : null,
                    response.header("Content-Encoding"),
                    responseStream,
                    new DefaultResponseHandler(mEventReporter, requestId));
            if (responseStream != null) {
                response = response.newBuilder()
                        .body(new ForwardingResponseBody(body, responseStream))
                        .build();
            }
        }

        return response;
    }

    private static class OkHttpInspectorRequest implements NetworkEventReporter.InspectorRequest {
        private final String mRequestId;
        private final Request mRequest;
        private byte[] mBody;
        private boolean mBodyGenerated;

        public OkHttpInspectorRequest(String requestId, Request request) {
            mRequestId = requestId;
            mRequest = request;
        }

        @Override
        public String id() {
            return mRequestId;
        }

        @Override
        public String friendlyName() {
            // Hmm, can we do better?  tag() perhaps?
            return null;
        }

        @Nullable
        @Override
        public Integer friendlyNameExtra() {
            return null;
        }

        @Override
        public String url() {
            return mRequest.urlString();
        }

        @Override
        public String method() {
            return mRequest.method();
        }

        @Nullable
        @Override
        public byte[] body() throws IOException {
            if (!mBodyGenerated) {
                mBodyGenerated = true;
                mBody = generateBody();
            }
            return mBody;
        }

        private byte[] generateBody() throws IOException {
            RequestBody body = mRequest.body();
            if (body == null) {
                return null;
            }
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            return buffer.readByteArray();
        }

        @Override
        public int headerCount() {
            return mRequest.headers().size();
        }

        @Override
        public String headerName(int index) {
            return mRequest.headers().name(index);
        }

        @Override
        public String headerValue(int index) {
            return mRequest.headers().value(index);
        }

        @Nullable
        @Override
        public String firstHeaderValue(String name) {
            return mRequest.header(name);
        }
    }

    private static class OkHttpInspectorResponse implements NetworkEventReporter.InspectorResponse {
        private final String mRequestId;
        private final Request mRequest;
        private final Response mResponse;
        private final Connection mConnection;

        public OkHttpInspectorResponse(
                String requestId,
                Request request,
                Response response,
                Connection connection) {
            mRequestId = requestId;
            mRequest = request;
            mResponse = response;
            mConnection = connection;
        }

        @Override
        public String requestId() {
            return mRequestId;
        }

        @Override
        public String url() {
            return mRequest.urlString();
        }

        @Override
        public int statusCode() {
            return mResponse.code();
        }

        @Override
        public String reasonPhrase() {
            return mResponse.message();
        }

        @Override
        public boolean connectionReused() {
            // Not sure...
            return false;
        }

        @Override
        public int connectionId() {
            return mConnection.hashCode();
        }

        @Override
        public boolean fromDiskCache() {
            return mResponse.cacheResponse() != null;
        }

        @Override
        public int headerCount() {
            return mResponse.headers().size();
        }

        @Override
        public String headerName(int index) {
            return mResponse.headers().name(index);
        }

        @Override
        public String headerValue(int index) {
            return mResponse.headers().value(index);
        }

        @Nullable
        @Override
        public String firstHeaderValue(String name) {
            return mResponse.header(name);
        }
    }

    private static class ForwardingResponseBody extends ResponseBody {
        private final ResponseBody mBody;
        private final BufferedSource mInterceptedSource;

        public ForwardingResponseBody(ResponseBody body, InputStream interceptedStream) {
            mBody = body;
            mInterceptedSource = Okio.buffer(Okio.source(interceptedStream));
        }

        @Override
        public MediaType contentType() {
            return mBody.contentType();
        }

        @Override
        public long contentLength() {
            try {
                return mBody.contentLength();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }

        @Override
        public BufferedSource source() {
            // close on the delegating body will actually close this intercepted source, but it
            // was derived from mBody.byteStream() therefore the close will be forwarded all the
            // way to the original.
            return mInterceptedSource;
        }
    }
}