package com.cmbb.smartkids.testmenglist.fragmentbs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cmbb.smartkids.mengbottomsheets.BottomSheet;
import com.cmbb.smartkids.mengbottomsheets.BottomSheetHelper;
import com.cmbb.smartkids.testmenglist.R;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/22 上午10:30
 */
public class BSViewHolder extends RecyclerView.ViewHolder {

    private CardView rootview;
    private TextView tvBsItem;

    private static BottomSheet sheet;


    private void assignViews(View view) {
        rootview = (CardView) view.findViewById(R.id.cv_item);
        tvBsItem = (TextView) view.findViewById(R.id.tv_bs_item);
    }

    public BSViewHolder(View itemView) {
        super(itemView);
        assignViews(itemView);
    }

    /**
     * 创建 ViewHolder
     *
     * @param context
     * @param parent
     * @return
     */
    public static BSViewHolder create(final Context context, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.bs_item, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BSModel bsModel = (BSModel) v.getTag();
                if (bsModel != null) {
                    switch (bsModel.getTag()) {
                        case 0:
                            sheet = new BottomSheet.Builder(context).icon(getRoundedBitmap(context, R.mipmap.ic_launcher)).title("To " + bsModel.getName()).sheet(R.menu.menu_list_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).build();

                            break;
                        case 1:
                            sheet = new BottomSheet.Builder(context).sheet(R.menu.menu_noicon_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).build();
                            break;
                        case 2:
                            sheet = new BottomSheet.Builder(context).darkTheme().title("To " + bsModel.getName()).sheet(R.menu.menu_list_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).build();
                            break;
                        case 3:
                            sheet = new BottomSheet.Builder(context).sheet(R.menu.menu_list_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).grid().build();
                            break;
                        case 4:
                            sheet = new BottomSheet.Builder(context, R.style.BottomSheet_StyleDialog).title("To " + bsModel.getName()).sheet(R.menu.menu_list_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).build();
                            break;
                        case 5:
                            sheet = new BottomSheet.Builder(context).title("To " + bsModel.getName()).sheet(R.menu.menu_longlist_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).limit(R.integer.bs_initial_list_row).build();
                            break;
                        case 6:
                            sheet = getShareActions(context, "Hello " + bsModel.getName()).title("Share To " + bsModel.getName()).limit(R.integer.no_limit).build();
                            break;
                        case 7:
                            sheet = getShareActions(context, "Hello " + bsModel.getName()).title("Share To " + bsModel.getName()).build();
                            break;
                        case 8:
                            sheet = new BottomSheet.Builder(context).icon(getRoundedBitmap(context, R.mipmap.ic_launcher)).title("To " + bsModel.getName()).sheet(R.menu.menu_list_bs).listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showToast(context, bsModel, which);
                                }
                            }).build();
                            final Menu menu = sheet.getMenu();
                            menu.getItem(0).setTitle("MenuClickListener");
                            menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {
                                    return true;
                                }
                            });
                            menu.getItem(1).setVisible(false);
                            menu.getItem(2).setEnabled(false);
                            menu.add(Menu.NONE, 23, Menu.NONE, "Fresh meal!");
                            menu.findItem(23).setIcon(R.mipmap.ic_launcher);
                            menu.findItem(23).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {
                                    return true;
                                }
                            });
                            menu.setGroupVisible(android.R.id.empty, false);
                            break;
                    }
                    sheet.show();
                }
            }
        });

        return new BSViewHolder(v);
    }

    /**
     * 分享的BottomSheets.Builder
     *
     * @param context Context
     * @param text    String
     * @return BottomSheet.Builder
     */
    private static BottomSheet.Builder getShareActions(Context context, String text) {
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        return BottomSheetHelper.shareAction(context, shareIntent);
    }

    /**
     * 现实Toast
     *
     * @param context Context
     * @param bsModel BSModel
     * @param which   int
     */
    private static void showToast(Context context, BSModel bsModel, int which) {
        switch (which) {
            case R.id.share:
                Toast.makeText(context, bsModel.getName() + " share ", Toast.LENGTH_LONG).show();
                break;
            case R.id.upload:
                Toast.makeText(context, bsModel.getName() + " upload ", Toast.LENGTH_LONG).show();
                break;
            case R.id.call:
                Toast.makeText(context, bsModel.getName() + " call ", Toast.LENGTH_LONG).show();
                break;
            case R.id.help:
                Toast.makeText(context, bsModel.getName() + " help ", Toast.LENGTH_LONG).show();
                break;
        }
    }

    /**
     * 创建圆角图标
     *
     * @param mContext Context
     * @param imageId  int
     * @return Drawable
     */
    public static Drawable getRoundedBitmap(Context mContext, int imageId) {
        Bitmap src = BitmapFactory.decodeResource(mContext.getResources(), imageId);
        Bitmap dst;
        if (src.getWidth() >= src.getHeight()) {
            dst = Bitmap.createBitmap(src, src.getWidth() / 2 - src.getHeight() / 2, 0, src.getHeight(), src.getHeight());
        } else {
            dst = Bitmap.createBitmap(src, 0, src.getHeight() / 2 - src.getWidth() / 2, src.getWidth(), src.getWidth());
        }
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), dst);
        roundedBitmapDrawable.setCornerRadius(dst.getWidth() / 2);
        roundedBitmapDrawable.setAntiAlias(true);
        return roundedBitmapDrawable;
    }

    public void onBindViewHolder(final BSModel bsModel) {
        rootview.setTag(bsModel);
        tvBsItem.setText(bsModel.getName());
    }
}
