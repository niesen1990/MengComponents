package com.cmbb.smartkids.menglisttest.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import com.cmbb.smartkids.menglist.tools.logger.Log;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by N.Sun
 */
public class OkHttp {
    private static final String TAG = "OkHttp";
    public static final OkHttpClient mOkHttpClient = new OkHttpClient();
    private static int cacheSize = 10 * 1024 * 1024; // 10 MiB

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    // timeout
    static {
        mOkHttpClient.setConnectTimeout(50, TimeUnit.SECONDS);
        mOkHttpClient.setWriteTimeout(50, TimeUnit.SECONDS);
        mOkHttpClient.setReadTimeout(50, TimeUnit.SECONDS);
        //mOkHttpClient.networkInterceptors().add(new StethoInterceptor());
        //mOkHttpClient.setCookieHandler(new CookieManager(new PersistentCookieStore(Application.context()), CookiePolicy.ACCEPT_ALL));
        //mOkHttpClient.setCache(new Cache(Application.context().getExternalCacheDir(), cacheSize));
    }

    /**
     * 不使用异步线程。
     *
     * @param request
     * @return
     * @throws IOException
     */
    private static Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 开启异步线程访问网络
     *
     * @param request
     * @param responseCallback
     */
    private static void enqueue(Request request, Callback responseCallback) {
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 同步Get(一般不使用)
     *
     * @param url
     * @return String
     */
    public static String syncGet(String url) throws IOException {
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = execute(request);
        if (!response.isSuccessful())
            throw new IOException("Unexpected code " + response);
        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            Log.i(TAG, responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }
        Log.i(TAG, "cache response:    " + response.cacheResponse());
        Log.i(TAG, "network response:  " + response.networkResponse());
        return response.body().string();
    }

    /**
     * 异步get
     *
     * @param url
     * @param callback
     * @return
     */
    public static void asyncGet(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        enqueue(request, callback);
    }

    // post without file
    public static void asyncPost(String url, Map<String, String> body, Callback callback) {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        for (String key : body.keySet()) {
            if (TextUtils.isEmpty(body.get(key))) {
                return;
            }
            formEncodingBuilder.add(key, body.get(key));
        }
        RequestBody formBody = formEncodingBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        enqueue(request, callback);
    }

    // post without file with tag
    public static void asyncPost(String url, Map<String, String> body, String tag, Callback callback) {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        for (String key : body.keySet()) {
            if (TextUtils.isEmpty(body.get(key))) {
                return;
            }
            formEncodingBuilder.add(key, body.get(key));
        }
        RequestBody formBody = formEncodingBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .tag(tag)
                .build();
        enqueue(request, callback);
    }

    // post with file
    public static void asyncPost(String url, Map<String, String> body, File file, Callback callback) {

        MultipartBuilder multipartBuilder = new MultipartBuilder();
        multipartBuilder.type(MultipartBuilder.MIXED);

        for (String key : body.keySet()) {
            multipartBuilder.addFormDataPart(key, body.get(key));
        }
        Date date = new Date();
        if (file != null && file.exists()) {
////            //图片处理
//        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//        bitmapOptions.inSampleSize = 3;
//        bitmapOptions.inPreferredConfig= Bitmap.Config.RGB_565;
//
////            //Bitmap cameraBitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapOptions);
//        Bitmap cameraBitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapOptions);
//
//        /**
//         * 把图片旋转为正的方向
//         */
//        Bitmap bitmap = ImageTools.rotaingImageView(ImageTools.readPictureDegree(file.getAbsolutePath()), cameraBitmap);
//        date1 = new Date();
////          byte[] bytes = Bitmap2Bytes(bitmap);
//
//        FileTools.createDirs("萌宝派");
//        File sendFile = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), File.separator + "萌宝派" + File.separator + file.getName());
//        boolean b = ImageTools.saveBitmap(bitmap, sendFile.getAbsolutePath());
//        //图片处理
//        if (b) {
//            multipartBuilder.addFormDataPart("image", "image", RequestBody.create(MEDIA_TYPE_PNG, sendFile));
//            Log.i(TAG, "add picture addres = " + sendFile.getAbsolutePath());
//        }
            multipartBuilder.addFormDataPart("image", "image", RequestBody.create(MEDIA_TYPE_PNG, getSmallBitmap(file.getPath())));
        }
        RequestBody formBody = multipartBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        enqueue(request, callback);
    }

    // post with files
    public static void asyncPost(String url, Map<String, String> body, ArrayList<String> files, Callback callback) {
        MultipartBuilder multipartBuilder = new MultipartBuilder();
        multipartBuilder.type(MultipartBuilder.MIXED);
        for (String key : body.keySet()) {
            multipartBuilder.addFormDataPart(key, body.get(key));
        }
        if (files != null && files.size() > 0) {
//            if (files.size() > 10) {
//                for (int i = 0; i < 10; i++) {
//                    //图片处理
//                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//                    bitmapOptions.inSampleSize = 8;
//                    Bitmap cameraBitmap = BitmapFactory.decodeFile(files.get(i), bitmapOptions);
//                    /**
//                     * 把图片旋转为正的方向
//                     */
//                    Bitmap bitmap = ImageTools.rotaingImageView(ImageTools.readPictureDegree(files.get(i)), cameraBitmap);
//
//
//                    FileTools.createDirs("萌宝派");
//                    File sendFile = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), File.separator + "萌宝派" + File.separator + new File(files.get(i)).getName());
//                    boolean b = ImageTools.saveBitmap(bitmap, sendFile.getAbsolutePath());
//                    //图片处理
//                    if (b) {
//                        multipartBuilder.addFormDataPart("image" + i, "image" + i, RequestBody.create(MEDIA_TYPE_PNG, sendFile));
//                        Log.i(TAG, "add picture addres = " + files.get(i) + "image" + (i + 1));
//                    }
//                }
//            } else {
                for (int i = 0; i < files.size(); i++) {
//                    //图片处理
//                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//                    bitmapOptions.inSampleSize = 8;
//                    Bitmap cameraBitmap = BitmapFactory.decodeFile(files.get(i), bitmapOptions);
//                    /**
//                     * 把图片旋转为正的方向
//                     */
//                    Bitmap bitmap = ImageTools.rotaingImageView(ImageTools.readPictureDegree(files.get(i)), cameraBitmap);
//                    FileTools.createDirs("萌宝派");
//                    File sendFile = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), File.separator + "萌宝派" + File.separator + new File(files.get(i)).getName());
//
//                    boolean b = ImageTools.saveBitmap(bitmap, sendFile.getAbsolutePath());
                    //图片处理
//                    if (b) {
                    multipartBuilder.addFormDataPart("image" + i, "image" + i, RequestBody.create(MEDIA_TYPE_PNG, getSmallBitmap(files.get(i))));
                    Log.i(TAG, "add picture addres = " + files.get(i) + "image" + (i + 1));
//                    }
//                }
            }
        }
        RequestBody formBody = multipartBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        enqueue(request, callback);
    }
    // 根据路径获得图片并压缩，返回bitmap用于显示
    public static byte[] getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, baos);
        return baos.toByteArray();
    }

    //计算图片的缩放值
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }


}
