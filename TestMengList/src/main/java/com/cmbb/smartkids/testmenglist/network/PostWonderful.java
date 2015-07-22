package com.cmbb.smartkids.testmenglist.network;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：MengBao
 * 类描述：Wonderful 数据Api
 * 创建人：N.Sun
 * 创建时间：2015/6/26 10:23
 */
public class PostWonderful {

    public static void findByAreaTypeFromPlate(final ResponseCallback<HomeSameAge> responseCallback) {
        Map<String, String> body = new HashMap<>();
        body.put("areaType", "WONDERFUL");
        body.put("token", "083cbf5c89a44c01a2fe92f9b81baaf5");
        OkHttp.asyncPost("http://mengbaopai.smart-kids.com/iosAndroid" + "/plate/findByAreaTypeFromPlate", body, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                responseCallback.getDataFailure();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                ResponseListModel data = gson.fromJson(result, ResponseListModel.class);
                responseCallback.getDataSuccess(data.getContext());
            }
        });
    }

    public interface ResponseCallback<T> {

        public void getDataSuccess(List<T> data);

        public void getDataFailure();
    }
}
