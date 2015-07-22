package com.cmbb.smartkids.testmenglist;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaletteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(String param1, String param2) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_palette, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleimage);
        final FrameLayout headBac = (FrameLayout) view.findViewById(R.id.head_bac);
        simpleDraweeView.setImageURI(Uri.parse("http://b.hiphotos.baidu.com/image/w%3D400/sign=381258d974094b36db921aed93cd7c00/5d6034a85edf8db1c2acda620b23dd54564e7431.jpg"));

        ImageRequest request = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse("http://b.hiphotos.baidu.com/image/w%3D400/sign=381258d974094b36db921aed93cd7c00/5d6034a85edf8db1c2acda620b23dd54564e7431.jpg"))
                .setAutoRotateEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .setProgressiveRenderingEnabled(false)
                .build();

        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(request, this);
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
                                 @Override
                                 public void onNewResultImpl(@Nullable Bitmap bitmap) {
                                     // You can use the bitmap in only limited ways
                                     // No need to do any cleanup.
                                     if (bitmap == null) {
                                         return;
                                     }
                                     Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                         @Override
                                         public void onGenerated(Palette palette) {
                                             final Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
                                             Palette.Swatch c = palette.getDarkVibrantSwatch();//有活力 暗色
                                             Palette.Swatch d = palette.getLightVibrantSwatch();//有活力 亮色
                                             Palette.Swatch f = palette.getMutedSwatch();//柔和
                                             Palette.Swatch a = palette.getDarkMutedSwatch();//柔和 暗色
                                             Palette.Swatch b = palette.getLightMutedSwatch();//柔和 亮色
                                             if (vibrant != null) {
                                                 int color1 = vibrant.getBodyTextColor();//内容颜色
                                                 int color2 = vibrant.getTitleTextColor();//标题颜色
                                                 int color3 = vibrant.getRgb();//rgb颜色
                                                 headBac.setBackgroundColor(d.getRgb());
                                                 //title.setTextColor(vibrant.getTitleTextColor());
                                             }
                                         }
                                     });
                                 }

                                 @Override
                                 public void onFailureImpl(DataSource dataSource) {
                                     // No cleanup required here.
                                 }
                             },
                CallerThreadExecutor.getInstance());


         /*final FrameLayout headBac = (FrameLayout) view.findViewById(R.id.head_bac);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequest imageRequest = ImageRequest.fromUri(Uri.parse("http://b.hiphotos.baidu.com/image/w%3D400/sign=381258d974094b36db921aed93cd7c00/5d6034a85edf8db1c2acda620b23dd54564e7431.jpg"));;
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, getActivity());
       try {
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
                            final Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
                            Palette.Swatch c = palette.getDarkVibrantSwatch();//有活力 暗色
                            Palette.Swatch d = palette.getLightVibrantSwatch();//有活力 亮色
                            Palette.Swatch f = palette.getMutedSwatch();//柔和
                            Palette.Swatch a = palette.getDarkMutedSwatch();//柔和 暗色
                            Palette.Swatch b = palette.getLightMutedSwatch();//柔和 亮色

                            if (vibrant != null) {
                                int color1 = vibrant.getBodyTextColor();//内容颜色
                                int color2 = vibrant.getTitleTextColor();//标题颜色
                                int color3 = vibrant.getRgb();//rgb颜色
                                headBac.setBackgroundColor(d.getRgb());
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
        } finally {
            if (dataSource != null) {
                dataSource.close();
            }
        }*/
    }
}
