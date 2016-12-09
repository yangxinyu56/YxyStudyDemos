package com.yxy.study.demos.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yxy on 2016/12/9.<br/>
 * Glide加载网络图片的ImageView
 */

public class GlideImageView extends ImageView {
    public GlideImageView(Context context) {
        super(context);
    }

    public GlideImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GlideImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void load(String url){
        Glide.with(this.getContext()).load(url).fitCenter().into(this);
    }
}
