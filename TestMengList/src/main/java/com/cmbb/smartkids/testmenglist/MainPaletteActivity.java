package com.cmbb.smartkids.testmenglist;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cmbb.smartkids.mengglidepalette.GlidePalette;

public class MainPaletteActivity extends AppCompatActivity {

    ImageView imageView;

    TextView textVibrant;
    TextView textVibrantLight;
    TextView textVibrantDark;
    TextView textMuted;
    TextView textMutedLight;
    TextView textMutedDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_palette);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (null != bar) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        imageView = (ImageView) findViewById(R.id.image);

        textVibrant = (TextView) findViewById(R.id.textVibrant);
        textVibrantLight = (TextView) findViewById(R.id.textVibrantLight);
        textVibrantDark = (TextView) findViewById(R.id.textVibrantDark);
        textMuted = (TextView) findViewById(R.id.textMuted);
        textMutedLight = (TextView) findViewById(R.id.textMutedLight);
        textMutedDark = (TextView) findViewById(R.id.textMutedDark);

        String url = "http://image.tianjimedia.com/uploadImages/2012/236/5UADNJV31013.jpg";
        Glide.with(this).load(url)
                .centerCrop()
                .listener(GlidePalette.with(url)
                        .use(GlidePalette.Profile.VIBRANT)
                        .intoBackground(textVibrant, GlidePalette.Swatch.RGB)
                        .intoTextColor(textVibrant, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.VIBRANT_DARK)
                        .intoBackground(textVibrantDark, GlidePalette.Swatch.RGB)
                        .intoTextColor(textVibrantDark, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.VIBRANT_LIGHT)
                        .intoBackground(textVibrantLight, GlidePalette.Swatch.RGB)
                        .intoTextColor(textVibrantLight, GlidePalette.Swatch.BODY_TEXT_COLOR)

                        .use(GlidePalette.Profile.MUTED)
                        .intoBackground(textMuted, GlidePalette.Swatch.RGB)
                        .intoTextColor(textMuted, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.MUTED_DARK)
                        .intoBackground(textMutedDark, GlidePalette.Swatch.RGB)
                        .intoTextColor(textMutedDark, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.MUTED_LIGHT)
                        .intoBackground(textMutedLight, GlidePalette.Swatch.RGB)
                        .intoTextColor(textMutedLight, GlidePalette.Swatch.BODY_TEXT_COLOR)

                        .intoCallBack(new GlidePalette.CallBack() {
                            @Override
                            public void onPaletteLoaded(Palette palette) {
                                //specific task
                            }
                        }))
                .into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_palette, menu);
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
