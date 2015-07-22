package com.cmbb.smartkids.menglist;

import android.view.View;
import android.widget.AdapterView;

/**
 * 项目名称：MengBao
 * 类描述：List单击辅助类：屏蔽短时间内多次点击时间
 * 创建人：N.Sun
 * 创建时间：2015/6/11 10:48
 */
public abstract class CompatOnItemClickListener implements AdapterView.OnItemClickListener {

    /**
     * 单击间隔时间
     */
    private final static long TIME_INTERVAL = 500;

    private long lastClickTime = 0;

    private boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < TIME_INTERVAL) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (isFastDoubleClick())
            return;
        onCompatItemClick(parent, view, position, id);
    }

    /**
     * 列表单击事件
     *
     * @param view     view
     * @param position 位置
     */
    public abstract void onCompatItemClick(AdapterView<?> parent, View view, int position, long id);
}
