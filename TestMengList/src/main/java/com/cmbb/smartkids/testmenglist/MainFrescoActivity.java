package com.cmbb.smartkids.testmenglist;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainFrescoActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fresco);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        // 设置Toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_home_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        // 设置Navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        final SimpleDraweeView head = (SimpleDraweeView) findViewById(R.id.head);
        //head.setImageURI(Uri.parse("http://mengbaopai.smart-kids.com/image/bigImage//dea53309f3c3431d8a98d20c63fdd80b.jpg"));


        final LinearLayout headBac = (LinearLayout) findViewById(R.id.head_bac);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse("http://mengbaopai.smart-kids.com/image/bigImage//dea53309f3c3431d8a98d20c63fdd80b.jpg"))
                .setAutoRotateEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setRequestPriority(Priority.HIGH)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .build();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, this);
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            public void onNewResultImpl(@Nullable Bitmap bitmap) {
                head.setImageURI(Uri.parse("http://mengbaopai.smart-kids.com/image/bigImage//dea53309f3c3431d8a98d20c63fdd80b.jpg"));

                if (bitmap == null) {
                    return;
                }
                //异步获得bitmap图片颜色值
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        // 此方法已经是在UI线程
                        Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
                        Palette.Swatch c = palette.getDarkVibrantSwatch();//有活力 暗色
                        Palette.Swatch d = palette.getLightVibrantSwatch();//有活力 亮色
                        Palette.Swatch f = palette.getMutedSwatch();//柔和
                        Palette.Swatch a = palette.getDarkMutedSwatch();//柔和 暗色
                        Palette.Swatch b = palette.getLightMutedSwatch();//柔和 亮色

                        if (vibrant != null) {
                            int color1 = vibrant.getBodyTextColor();//内容颜色
                            int color2 = vibrant.getTitleTextColor();//标题颜色
                            int color3 = vibrant.getRgb();//rgb颜色
                            headBac.setBackgroundColor(f.getRgb());
                            //title.setTextColor(vibrant.getTitleTextColor());
                        }
                    }
                });
            }

            @Override
            public void onFailureImpl(DataSource dataSource) {
                // No cleanup required here
            }
        }, CallerThreadExecutor.getInstance());


        // 设置TabView
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (viewPager != null) {
            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        }
        /*tabLayout.addTab(tabLayout.newTab().setText("摄影"));
        tabLayout.addTab(tabLayout.newTab().setText("游泳"));
        tabLayout.addTab(tabLayout.newTab().setText("绘画"));
        tabLayout.addTab(tabLayout.newTab().setText("烹饪"));
        tabLayout.addTab(tabLayout.newTab().setText("海淘"));
        tabLayout.addTab(tabLayout.newTab().setText("游戏"));
        tabLayout.addTab(tabLayout.newTab().setText("旅游"));
        tabLayout.addTab(tabLayout.newTab().setText("瘦身"));
        tabLayout.addTab(tabLayout.newTab().setText("育儿"));
        tabLayout.addTab(tabLayout.newTab().setText("健康"));
        tabLayout.addTab(tabLayout.newTab().setText("派对"));
        tabLayout.addTab(tabLayout.newTab().setText("表演"));
        tabLayout.addTab(tabLayout.newTab().setText("故事"));
        tabLayout.addTab(tabLayout.newTab().setText("美食"));*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_fresco, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // 控制DrawerLayout
        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        Fragment fragment = new FrescoFragment();
        adapter.addFragment(fragment, "摄影");
        fragment = new FrescoFragment();
        adapter.addFragment(fragment, "绘本");
        fragment = PaletteFragment.newInstance("美食", "美食");
        adapter.addFragment(fragment, "美食");
        viewPager.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // 关闭Navigation
                        mDrawerLayout.closeDrawers();
                        if (menuItem.getItemId() == R.id.nav_viewpager) {
                        } else if (menuItem.getItemId() == R.id.nav_subsamplingScale) {
                        } else if (menuItem.getItemId() == R.id.nav_gifview) {
                        } else if (menuItem.getItemId() == R.id.nav_home) {
                        }
                        return true;
                    }
                });
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
