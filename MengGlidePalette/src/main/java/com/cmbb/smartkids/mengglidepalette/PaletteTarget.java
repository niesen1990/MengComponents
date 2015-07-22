package com.cmbb.smartkids.mengglidepalette;

import android.support.v4.util.Pair;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/21 上午10:54
 */
public class PaletteTarget {

    @BitmapPalette.Profile.PaletteProfile
    protected int paletteProfile = GlidePalette.Profile.VIBRANT;

    protected ArrayList<Pair<View, Integer>> targetsBackground = new ArrayList<>();
    protected ArrayList<Pair<TextView, Integer>> targetsText = new ArrayList<>();

    public PaletteTarget(@BitmapPalette.Profile.PaletteProfile int paletteProfile) {
        this.paletteProfile = paletteProfile;
    }

    public void clear() {
        targetsBackground.clear();
        targetsText.clear();

        targetsBackground = null;
        targetsText = null;
    }
}
