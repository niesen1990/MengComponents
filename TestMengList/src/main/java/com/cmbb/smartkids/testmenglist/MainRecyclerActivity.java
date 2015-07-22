package com.cmbb.smartkids.testmenglist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cmbb.smartkids.testmenglist.fragments.EntryListFragment;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：2015/7/1 10:51
 */
public class MainRecyclerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new EntryListFragment()).commit();
    }
}
