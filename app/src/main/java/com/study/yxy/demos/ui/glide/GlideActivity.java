package com.study.yxy.demos.ui.glide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.yxy.demos.R;
import com.study.yxy.demos.databinding.ActivityGlideBinding;

public class GlideActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGlideBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_glide);
        binding.setClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_glide_demo1:
                startActivity(new Intent(this,GlideBaseActivity.class));
                break;
            case R.id.btn_glide_demo2:
                startActivity(new Intent(this,GlideRecyclerActivity.class));
                break;
            case R.id.btn_glide_demo3:
                startActivity(new Intent(this,GlideTransformationsActivity.class));
                break;
            default:
                break;
        }
    }
}
