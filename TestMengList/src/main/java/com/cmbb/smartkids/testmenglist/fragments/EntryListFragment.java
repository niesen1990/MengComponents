package com.cmbb.smartkids.testmenglist.fragments;

import android.support.v7.widget.RecyclerView;

import com.cmbb.smartkids.mengrecyclerview.actions.DataController;
import com.cmbb.smartkids.mengrecyclerview.fragments.CommonFragment;
import com.cmbb.smartkids.testmenglist.network.HomeSameAge;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：2015/7/1 10:54
 */
public class EntryListFragment extends CommonFragment<HomeSameAge> {

    @Override
    protected DataController<HomeSameAge> onGenerateDataController() {
        return new EntryListProvider();
    }

    @Override
    protected RecyclerView.Adapter onGenerateAdapter(DataController<HomeSameAge> controller) {
        return new EntryListAdapter(getActivity(), controller);
    }

    @Override
    protected boolean enableRefresh() {
        return true;
    }
}
