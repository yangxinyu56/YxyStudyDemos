package com.yxy.study.demos.ui.glide;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.yxy.study.demos.databinding.ActivityGlideBaseBinding;
import com.yxy.study.demos.R;

public class GlideBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGlideBaseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_glide_base);
        //网络静态图片
        Glide.with(this).load("http://img1.mm131.com/pic/2330/16.jpg").into(binding.ivGlideBaseA);
        //网络动态图片
        Glide.with(this).load("http://imgsrc.baidu.com/forum/w=580/sign=1d3bd43165d0f703e6b295d438fa5148/f83aaad3fd1f413400228758221f95cad1c85ea7.jpg")
                .placeholder(R.mipmap.ic_launcher).into(binding.ivGlideBaseB);
        //资源gif
        Glide.with(this).load(R.drawable.maomi_mashaji).asGif().placeholder(R.mipmap.ic_launcher).into(binding.ivGlideBaseC);
        //先加载缩略图
        Glide.with(this).load(R.mipmap.meinv01).thumbnail(0.1f).centerCrop().placeholder(R.mipmap.ic_launcher).into(binding.ivGlideBaseD);

    }
}
