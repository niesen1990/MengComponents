package com.cmbb.smartkids.testmenglist.fragmentbs;

import com.cmbb.smartkids.mengrecyclerview.actions.DataController;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/22 上午10:29
 */
public class BSProvider extends DataController<BSModel> {
    @Override
    public void doInitialize(Callback callback) {
        List<BSModel> bsModels = new ArrayList<>();
        String[] items = new String[]{"From Xml", "Without Icon", "Dark Theme", "Grid", "Style", "Style from Theme", "ShareAction", "FullScreen", "Menu Manipulate"};
        for (int i = 0; i < items.length; i++) {
            BSModel bsModel = new BSModel();
            bsModel.setName(items[i]);
            bsModel.setTag(i);
            bsModels.add(bsModel);
        }
        initSuccess(bsModels);
    }

    @Override
    public void doRefresh(Callback callback) {

    }

    @Override
    public void doMore(Callback callback) {

    }

    @Override
    public List doParser(Response response) {
        return null;
    }

    @Override
    public void doSave(List data) {

    }
}
