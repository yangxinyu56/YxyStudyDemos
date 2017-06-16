package com.yxy.study.demos.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.yxy.study.demos.R;
import com.yxy.study.demos.databinding.ActivityAnimBinding;
import com.yxy.study.demos.manager.AnimManager;

import java.util.ArrayList;
import java.util.List;

public class AnimActivity extends AppCompatActivity {

    ActivityAnimBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this, R.layout.activity_anim);
        List<View> views = getViews();
        List<Animation> anims = getAnimations();

        AnimManager manager = new AnimManager(views, anims);
        manager.setOnEndListener(new AnimManager.OnEndListener() {
            @Override
            public void onStart(Animation animation, View view) {
                Toast.makeText(AnimActivity.this, "动画开始执行", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onEnd(Animation animation, View view) {
                Toast.makeText(AnimActivity.this, "动画执行完毕", Toast.LENGTH_SHORT).show();
            }
        });

        manager.startAnimation();
    }

    @NonNull
    private List<Animation> getAnimations() {
        List<Animation> anims = new ArrayList<>();
        anims.add(AnimationUtils.loadAnimation(this, R.anim.anim_tv1));
        anims.add(AnimationUtils.loadAnimation(this, R.anim.anim_tv2));
        anims.add(AnimationUtils.loadAnimation(this, R.anim.anim_btn1));
        anims.add(AnimationUtils.loadAnimation(this, R.anim.anim_btn2));
        anims.add(AnimationUtils.loadAnimation(this, R.anim.anim_iv1));
        return anims;
    }


    @NonNull
    private List<View> getViews() {
        List<View> views = new ArrayList<View>();
        views.add(binding.tv1);
        views.add(binding.tv2);
        views.add(binding.btn1);
        views.add(binding.btn2);
        views.add(binding.iv1);
        for (View v : views) {
            hideView(v);
        }
        return views;
    }

    private void hideView(View v) {
        v.setVisibility(View.INVISIBLE);
    }
}
