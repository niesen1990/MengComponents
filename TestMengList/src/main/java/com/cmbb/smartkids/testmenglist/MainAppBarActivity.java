package com.cmbb.smartkids.testmenglist;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cmbb.smartkids.testmenglist.fragments.EntryListFragment;
import com.cmbb.smartkids.testmenglist.network.HomeSameAge;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainAppBarActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private AppBarLayout appbar;
    private EntryListFragment entryListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_bar);
        // 设置Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (null != bar) {
            bar.setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("详情界面");


        // 设置背景图片
        SimpleDraweeView backDrop = (SimpleDraweeView) findViewById(R.id.back_drop);
        HomeSameAge homeSameAge = getIntent().getParcelableExtra("model");
        backDrop.setImageURI(Uri.parse("http://mengbaopai.smart-kids.com/image" + homeSameAge.getBigImg()));

        appbar = (AppBarLayout) findViewById(R.id.appbar);
        //设置Recycler
        entryListFragment = new EntryListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, entryListFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        appbar.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appbar.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            entryListFragment.getmSwipeRefresh().setEnabled(true);
        } else {
            entryListFragment.getmSwipeRefresh().setEnabled(false);
        }
    }
}
