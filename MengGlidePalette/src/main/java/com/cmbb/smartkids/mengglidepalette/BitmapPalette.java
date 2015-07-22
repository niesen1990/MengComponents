package com.cmbb.smartkids.mengglidepalette;

import android.graphics.Bitmap;
import android.support.annotation.IntDef;
import android.support.v4.util.Pair;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/22 上午10:54
 */
public abstract class BitmapPalette {

    private static final String TAG = "BitmapPalette";

    public interface CallBack {
        void onPaletteLoaded(Palette palette);
    }

    private LruCache<String, Palette> cache = new LruCache<>(40);

    public static class Profile {
        public static final int VIBRANT = 0;
        public static final int VIBRANT_DARK = 1;
        public static final int VIBRANT_LIGHT = 2;
        public static final int MUTED = 3;
        public static final int MUTED_DARK = 4;
        public static final int MUTED_LIGHT = 5;

        @IntDef({VIBRANT, VIBRANT_DARK, VIBRANT_LIGHT, MUTED, MUTED_DARK, MUTED_LIGHT})
        @Retention(RetentionPolicy.SOURCE)
        public @interface PaletteProfile {
        }
    }

    public static class Swatch {
        public static final int RGB = 0;
        public static final int TITLE_TEXT_COLOR = 1;
        public static final int BODY_TEXT_COLOR = 2;

        @IntDef({RGB, TITLE_TEXT_COLOR, BODY_TEXT_COLOR})
        @Retention(RetentionPolicy.SOURCE)
        public @interface PaletteSwatch {
        }
    }

    protected BitmapPalette() {
    }

    protected String url;

    protected LinkedList<PaletteTarget> targets = new LinkedList<>();
    protected ArrayList<CallBack> callbacks = new ArrayList<>();

    public BitmapPalette use(@Profile.PaletteProfile int paletteProfile) {
        this.targets.add(new PaletteTarget(paletteProfile));
        return this;
    }


    protected BitmapPalette intoBackground(View view, @Swatch.PaletteSwatch int paletteSwatch) {
        if (this.targets.isEmpty())
            throw new UnsupportedOperationException("You must specify a palette with use(Profile.PaletteProfile)");

        this.targets.getLast().targetsBackground.add(new Pair<>(view, paletteSwatch));
        return this;
    }

    protected BitmapPalette intoTextColor(TextView textView, @Swatch.PaletteSwatch int paletteSwatch) {
        if (this.targets.isEmpty())
            throw new UnsupportedOperationException("You must specify a palette with use(Profile.PaletteProfile)");

        this.targets.getLast().targetsText.add(new Pair<>(textView, paletteSwatch));
        return this;
    }

    protected BitmapPalette intoCallBack(BitmapPalette.CallBack callBack) {
        if (callBack != null)
            callbacks.add(callBack);
        return this;
    }


    //region apply

    protected void apply(Palette palette) {
        for (BitmapPalette.CallBack c : callbacks) {
            c.onPaletteLoaded(palette);
        }

        for (PaletteTarget target : targets) {
            Palette.Swatch swatch = null;
            switch (target.paletteProfile) {
                case Profile.VIBRANT:
                    swatch = palette.getVibrantSwatch();
                    break;
                case Profile.VIBRANT_DARK:
                    swatch = palette.getDarkVibrantSwatch();
                    break;
                case Profile.VIBRANT_LIGHT:
                    swatch = palette.getLightVibrantSwatch();
                    break;
                case Profile.MUTED:
                    swatch = palette.getMutedSwatch();
                    break;
                case Profile.MUTED_DARK:
                    swatch = palette.getDarkMutedSwatch();
                    break;
                case Profile.MUTED_LIGHT:
                    swatch = palette.getLightMutedSwatch();
                    break;
            }

            if (swatch != null) {
                for (Pair<View, Integer> t : target.targetsBackground) {
                    int color = getColor(swatch, t.second);
                    t.first.setBackgroundColor(color);
                }

                for (Pair<TextView, Integer> t : target.targetsText) {
                    int color = getColor(swatch, t.second);
                    t.first.setTextColor(color);
                }

                target.clear();
                this.callbacks = null;
            }
        }
    }

    protected static int getColor(Palette.Swatch swatch, @Swatch.PaletteSwatch int paletteSwatch) {
        if (swatch != null) {
            switch (paletteSwatch) {
                case Swatch.RGB:
                    return swatch.getRgb();
                case Swatch.TITLE_TEXT_COLOR:
                    return swatch.getTitleTextColor();
                case Swatch.BODY_TEXT_COLOR:
                    return swatch.getBodyTextColor();
            }
        } else {
            Log.e(TAG, "error while generating Palette, null palette returned");
        }
        return 0;
    }

    protected void start(Bitmap bitmap) {
        if (cache.get(url) != null) {
            BitmapPalette.this.apply(cache.get(url));
        } else {
            new Palette.Builder(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    cache.put(url, palette);
                    BitmapPalette.this.apply(palette);
                }
            });
        }
    }
}
