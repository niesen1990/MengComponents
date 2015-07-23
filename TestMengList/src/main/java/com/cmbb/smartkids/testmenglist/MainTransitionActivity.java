package com.cmbb.smartkids.testmenglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.cmbb.smartkids.testmenglist.utils.TransitionHelper;

public class MainTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_transition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (null != bar) {
            bar.setDisplayHomeAsUpEnabled(true);
        }

        final ImageView ibDemo = (ImageView) findViewById(R.id.ib_demo);
        final FloatingActionButton fabNext = (FloatingActionButton) findViewById(R.id.fab_next);
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabNext.animate()
                        .scaleX(0)
                        .scaleY(0)
                        .setInterpolator(new FastOutSlowInInterpolator())
                        .start();
                final Pair[] pairs = TransitionHelper.createSafeTransitionParticipants(MainTransitionActivity.this, true, new Pair<>(ibDemo, MainTransitionActivity.this.getString(R.string.iv_transition)));
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(MainTransitionActivity.this, pairs);
                Intent starter = new Intent(MainTransitionActivity.this, MainTransition2Activity.class);
                ActivityCompat.startActivity(MainTransitionActivity.this, starter, activityOptions.toBundle());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_transition, menu);
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
}
