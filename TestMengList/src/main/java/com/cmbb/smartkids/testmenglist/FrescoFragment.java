package com.cmbb.smartkids.testmenglist;


import android.support.v7.widget.RecyclerView;

import com.cmbb.smartkids.mengrecyclerview.actions.DataController;
import com.cmbb.smartkids.mengrecyclerview.fragments.CommonFragment;
import com.cmbb.smartkids.testmenglist.fragments.EntryListAdapter;
import com.cmbb.smartkids.testmenglist.fragments.EntryListProvider;
import com.cmbb.smartkids.testmenglist.network.HomeSameAge;


public class FrescoFragment extends CommonFragment<HomeSameAge> {

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
