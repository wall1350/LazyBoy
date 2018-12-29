package com.example.jesuiswilliam.lazyboy;

import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;
import android.content.Context;
import com.bumptech.glide.Glide;


public class GlideImageLoader extends ImageLoader {
    private static String TAG = "GlideImageLoader";
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
