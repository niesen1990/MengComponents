package com.cmbb.smartkids.menglisttest.network;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.OperationApplicationException;
import android.os.RemoteException;

import com.cmbb.smartkids.menglist.App;
import com.cmbb.smartkids.menglist.db.SmartKidContract;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：MengBao
 * 类描述：Wonderful 数据Api
 * 创建人：N.Sun
 * 创建时间：2015/6/26 10:23
 */
public class PostWonderful {

    public static void findByAreaTypeFromPlate() {

        Map<String, String> body = new HashMap<>();
        body.put("areaType", "WONDERFUL");
        body.put("token", "083cbf5c89a44c01a2fe92f9b81baaf5");
        OkHttp.asyncPost("http://mengbaopai.smart-kids.com/iosAndroid" + "/plate/findByAreaTypeFromPlate", body, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                com.cmbb.smartkids.menglist.network.ResponseListModel data = gson.fromJson(result, com.cmbb.smartkids.menglist.network.ResponseListModel.class);
                if ("1".equals(data.getCode().trim())) {
                    ArrayList<ContentProviderOperation> batch = new ArrayList<ContentProviderOperation>();
                    if (App.application.getContentResolver().query(SmartKidContract.PostModelWonderful.TABLE_CONTENT_URI, null, null, null, null).getCount() > 0) {
                        batch.add(ContentProviderOperation.newDelete(SmartKidContract.PostModelWonderful.TABLE_CONTENT_URI).withSelection(" 1 =" + " 1", null).build());
                    }

                    for (int i = 0; i < data.getContext().size(); i++) {
                        if (i == 0) {
                            batch.add(ContentProviderOperation.newInsert(SmartKidContract
                                    .PostModelWonderful.TABLE_CONTENT_URI)
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_TITLE, "【" +
                                            data.getContext().get(i).getTitle() + "】")
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_BIGIMG, data.getContext
                                            ().get(i).getBigImg())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_BIGIMGHEIGHT,
                                            data.getContext().get(i).getBigImgHeight())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_BIGIMGWIDTH,
                                            data.getContext().get(i).getBigImgWidth())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_CONNECTOR,
                                            data.getContext().get(i).getConnector())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_CONTEXT, data.getContext
                                            ().get(i).getContext())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_SMALLIMG,
                                            data.getContext().get(i).getSmallImg())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_SMALLIMGHEIGHT,
                                            data.getContext().get(i).getSmallImgHeight())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_SMALLIMGWIDTH,
                                            data.getContext().get(i).getSmallImgWidth())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_COUNT, data.getContext
                                            ().get(i).getCount())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_TYPE, data.getContext
                                            ().get(i).getType())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_ID, data.getContext
                                            ().get(i).getId())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_COUNT_NAME, "已创建宝宝")
                                    .build());
                        } else {
                            batch.add(ContentProviderOperation.newInsert(SmartKidContract
                                    .PostModelWonderful.TABLE_CONTENT_URI)
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_TITLE, "【" +
                                            data.getContext().get(i).getTitle() + "】")
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_BIGIMG, data.getContext
                                            ().get(i).getBigImg())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_BIGIMGHEIGHT,
                                            data.getContext().get(i).getBigImgHeight())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_BIGIMGWIDTH,
                                            data.getContext().get(i).getBigImgWidth())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_CONNECTOR,
                                            data.getContext().get(i).getConnector())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_CONTEXT, data.getContext
                                            ().get(i).getContext())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_SMALLIMG,
                                            data.getContext().get(i).getSmallImg())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_SMALLIMGHEIGHT,
                                            data.getContext().get(i).getSmallImgHeight())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_SMALLIMGWIDTH,
                                            data.getContext().get(i).getSmallImgWidth())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_COUNT, data.getContext
                                            ().get(i).getCount())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_TYPE, data.getContext
                                            ().get(i).getType())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_ID, data.getContext
                                            ().get(i).getId())
                                    .withValue(SmartKidContract.PostModelWonderful.COLUMN_COUNT_NAME, "已发帖")
                                    .build());
                        }

                    }

                    try {
                        ContentProviderResult[] results = App.application.getContentResolver().applyBatch
                                (SmartKidContract.PostModelWonderful.AUTHORITY, batch);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                    }

                } else {
                }
            }

        });

    }
}
