package com.cmbb.smartkids.testmenglist.fragmentbs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.cmbb.smartkids.mengrecyclerview.actions.DataController;
import com.cmbb.smartkids.mengrecyclerview.adapter.ContentAdapterBase;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/22 上午10:54
 */
public class BSAdapter extends ContentAdapterBase<BSModel> {

    private Context mContext;

    public BSAdapter(Context mContext, DataController<BSModel> mDataController) {
        super(mContext, mDataController);
        this.mContext = mContext;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateCustomContentHolder(ViewGroup parent, int viewType) {
        return BSViewHolder.create(mContext, parent);
    }

    @Override
    protected void onBindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BSViewHolder) holder).onBindViewHolder(mDataController.getData(position));
    }
}
