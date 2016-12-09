package com.yxy.study.demos.ui.glide;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.yxy.study.demos.R;
import com.yxy.study.demos.databinding.ActivityGlideTransformationsBinding;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;


public class GlideTransformationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGlideTransformationsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_glide_transformations);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new CropTransformation(
                this, 300, 300, CropTransformation.CropType.TOP
        )).into(binding.ivGlideTransA);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new CropCircleTransformation(this
        )).into(binding.ivGlideTransB);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new ColorFilterTransformation(this,
                Color.argb(80,225,0,0)
        )).into(binding.ivGlideTransC);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new GrayscaleTransformation(this
        )).into(binding.ivGlideTransD);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new RoundedCornersTransformation(this,60,0
        )).into(binding.ivGlideTransE);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new BlurTransformation(this,25
        )).into(binding.ivGlideTransF);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new ToonFilterTransformation(this
        )).into(binding.ivGlideTransG);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new SepiaFilterTransformation(this
        )).into(binding.ivGlideTransH);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new ContrastFilterTransformation(this,2.0f
        )).into(binding.ivGlideTransI);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new BrightnessFilterTransformation(this,0.5f
        )).into(binding.ivGlideTransJ);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new KuwaharaFilterTransformation(this,25
        )).into(binding.ivGlideTransK);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new VignetteFilterTransformation(this,
                new PointF(0.5f,0.5f),new float[]{0.0f,0.0f,0.0f},0f,0.75f
        )).into(binding.ivGlideTransL);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new InvertFilterTransformation(this
        )).into(binding.ivGlideTransM);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new PixelationFilterTransformation(this,20
        )).into(binding.ivGlideTransN);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new SketchFilterTransformation(this
        )).into(binding.ivGlideTransO);
        Glide.with(this).load(R.mipmap.meinv02).bitmapTransform(new SwirlFilterTransformation(this
        )).into(binding.ivGlideTransP);
    }
}
