package com.cmbb.smartkids.testmenglist.fragmentbs;

import android.support.v7.widget.RecyclerView;

import com.cmbb.smartkids.mengrecyclerview.actions.DataController;
import com.cmbb.smartkids.mengrecyclerview.fragments.CommonFragment;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/22 上午10:28
 */
public class BSFragment extends CommonFragment<BSModel> {
    @Override
    protected DataController<BSModel> onGenerateDataController() {
        return new BSProvider();
    }

    @Override
    protected RecyclerView.Adapter onGenerateAdapter(DataController<BSModel> controller) {
        return new BSAdapter(getActivity(), controller);
    }

    @Override
    protected boolean enableRefresh() {
        return false;
    }
}
