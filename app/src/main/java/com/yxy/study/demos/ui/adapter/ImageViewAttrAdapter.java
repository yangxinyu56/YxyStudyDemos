package com.yxy.study.demos.ui.adapter;

import android.databinding.BindingAdapter;

import com.yxy.study.demos.widget.GlideImageView;

public class ImageViewAttrAdapter {
    @BindingAdapter("load")
    public static void load(GlideImageView imageView, String url){
        imageView.load(url);
    }
}
