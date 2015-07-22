package com.cmbb.smartkids.testmenglist.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartkids.testmenglist.App;
import com.cmbb.smartkids.testmenglist.MainAppBarActivity;
import com.cmbb.smartkids.testmenglist.R;
import com.cmbb.smartkids.testmenglist.network.HomeSameAge;
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

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：2015/7/1 11:00
 */
public class EntryListViewHolder extends RecyclerView.ViewHolder {

    public final SimpleDraweeView thumb;
    public final TextView title, content, time;
    public final View parent;
    public final CardView cardview;


    private EntryListViewHolder(View itemView) {
        super(itemView);
        thumb = (SimpleDraweeView) itemView.findViewById(R.id.thumb);
        title = (TextView) itemView.findViewById(R.id.title);
        content = (TextView) itemView.findViewById(R.id.content);
        time = (TextView) itemView.findViewById(R.id.time);
        cardview = (CardView) itemView.findViewById(R.id.cardview);
        parent = itemView;

    }

    public static EntryListViewHolder create(final Context context, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.entry_item, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeSameAge homeSameAge = (HomeSameAge) v.getTag();
                if (homeSameAge != null) {
                    Intent intent = new Intent(context, MainAppBarActivity.class);
                    intent.putExtra("model", homeSameAge);
                    context.startActivity(intent);
                }
            }
        });
        return new EntryListViewHolder(v);
    }

    public void onBindViewHolder(final HomeSameAge entry) {
        parent.setTag(entry);
        title.setText(entry.getTitle());
        content.setText(entry.getContext());
        time.setText(entry.getSmallImgWidth() + entry.getConnector());
        // 第一种方式加载图片（包括动画）
        //        DraweeController controller = Fresco.newDraweeControllerBuilder()
        //                    .setControllerListener(new BaseControllerListener<ImageInfo>(){
        //                        @Override
        //                        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        //                            if (imageInfo == null) {
        //                                return;
        //                            }
        //                        }
        //
        //                        @Override
        //                        public void onFailure(String id, Throwable throwable) {
        //                            super.onFailure(id, throwable);
        //                        }
        //                    })
        //                    .setUri(Uri.parse("http://mengbaopai.smart-kids.com/image" + entry.getBigImg()))
        //                    .build();
        //        thumb.setController(controller);
        // 第二种方式加载图片
        thumb.setImageURI(Uri.parse("http://mengbaopai.smart-kids.com/image" + entry.getBigImg()));
        // 第三种方式获取bitmap
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse("http://mengbaopai.smart-kids.com/image" + entry.getBigImg()))
                .setRequestPriority(Priority.HIGH)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .build();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, App.application);

            dataSource.subscribe(new BaseBitmapDataSubscriber() {
                @Override
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    //异步获得bitmap图片颜色值
                    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
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
                                cardview.setBackgroundColor(vibrant.getRgb());
                                title.setTextColor(vibrant.getTitleTextColor());
                            }
                        }
                    });
                }

                @Override
                public void onFailureImpl(DataSource dataSource) {
                    // No cleanup required here
                }
            }, CallerThreadExecutor.getInstance());


        // 第四种方式Bitmap的引用
        /*ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse("http://mengbaopai.smart-kids.com/image" + entry.getBigImg()))
                .setRequestPriority(Priority.HIGH)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .build();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, this);
        DataSubscriber dataSubscriber = new BaseDataSubscriber<CloseableReference<CloseableImage>>() {
                    @Override
                    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                        if (!dataSource.isFinished()) {

                        }

                        CloseableReference<CloseableImage> imageReference = dataSource.getResult();
                        if (imageReference != null) {
                            *//*try {*//*
                                // do something with the image
                                Bitmap bitmap = ((CloseableBitmap) imageReference.get()).getUnderlyingBitmap();
                                if (bitmap == null) {
                                    return;
                                }
                                //异步获得bitmap图片颜色值
                                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                    @Override
                                    public void onGenerated(Palette palette) {
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
                                            cardview.setBackgroundColor(c.getRgb());
                                            title.setTextColor(c.getTitleTextColor());
                                        }
                                    }
                                });
                            *//*} finally {
                                imageReference.close();
                            }*//*
                        }
                    }
                    @Override
                    public void onFailureImpl(DataSource dataSource) {
                        Throwable throwable = dataSource.getFailureCause();
                        // handle failure
                    }
                };

        dataSource.subscribe(dataSubscriber, CallerThreadExecutor.getInstance());*/
    }
}
