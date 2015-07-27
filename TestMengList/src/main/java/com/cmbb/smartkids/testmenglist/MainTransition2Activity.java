package com.cmbb.smartkids.testmenglist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

public class MainTransition2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_transition2);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (null != bar) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        final ImageView mIcon = (ImageView) findViewById(R.id.iv_01);
        Interpolator mInterpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in);
        mIcon.setImageResource(R.mipmap.ic_launcher);
        mIcon.animate()
                .scaleX(1)
                .scaleY(1)
                .alpha(1)
                .setInterpolator(mInterpolator)
                .setStartDelay(500)
                .start();

        FloatingActionButton mQuizFab = (FloatingActionButton) findViewById(R.id.fab_quiz);
        mQuizFab.setImageResource(android.R.drawable.ic_menu_call);
        mQuizFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PaletteFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_container, fragment, "PaletteFragment").commit();
                final View fragmentContainer = findViewById(R.id.rl_container);
                int centerX = (view.getLeft() + view.getRight()) / 2;
                int centerY = (view.getTop() + view.getBottom()) / 2;
                int finalRadius = Math.max(fragmentContainer.getWidth(), fragmentContainer.getHeight());
                final Animator mCircularReveal = ViewAnimationUtils.createCircularReveal(fragmentContainer, centerX, centerY, 0, finalRadius);
                fragmentContainer.setVisibility(View.VISIBLE);
                view.setVisibility(View.GONE);

                mCircularReveal.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mIcon.setVisibility(View.GONE);
                        mCircularReveal.removeListener(this);
                    }
                });

                mCircularReveal.start();

                // the toolbar should not have more elevation than the content while playing
            }
        });
        mQuizFab.animate()
                .scaleX(1)
                .scaleY(1)
                .setInterpolator(mInterpolator)
                .setStartDelay(400)
                .start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_transition2, menu);
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
