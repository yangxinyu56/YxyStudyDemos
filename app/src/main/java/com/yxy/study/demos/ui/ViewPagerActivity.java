package com.yxy.study.demos.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yxy.study.demos.R;
import com.yxy.study.demos.databinding.ActivityViewpagerBinding;
import com.yxy.study.demos.ui.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yxy on 2016/12/2.
 */

public class ViewPagerActivity extends AppCompatActivity {
    private List<View> mViewList;//页卡视图集合
    private String[] imgUrls = {
            "http://s1.dwstatic.com/group1/M00/EC/4E/a1afc26b5df89dceebf31cba56fc3a22.jpg",
            "http://s1.dwstatic.com/group1/M00/85/E6/56fe8286c3360bb75b1e47786fcf005f.jpg",
            "http://s1.dwstatic.com/group1/M00/BE/2F/c1dfd965277b98baa11d6a33a34f3ff5.jpg",
            "http://s1.dwstatic.com/group1/M00/6B/2C/3d132dcc459bd64375bb7adaf02f4e8e.jpg",
            "http://s1.dwstatic.com/group1/M00/FA/F0/90e69b2ec66fa6919fb5f26bc8b34697.jpg"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewpagerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_viewpager);
        initData();
        TabLayout tabLayout = binding.tlTabsDemo;
        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        MyViewPagerAdapter mPagerAdapter = new MyViewPagerAdapter(mViewList);
        binding.setVpAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(binding.vpDemo);//将TabLayout和ViewPager关联起来。
        /*
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mPagerAdapter.getTabView(i));
        }*/
    }

    private void initData() {
        mViewList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            View view1 = View.inflate(this, R.layout.item_viewpager_demos, null);
            ImageView imageView = (ImageView) view1.findViewById(R.id.iv_item_vp_demo);
//            ImageView imageView = new ImageView(this);
//            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(400, 300);
//            imageView.setLayoutParams(params);
            Glide.with(this).load(imgUrls[i]).into(imageView);
            mViewList.add(view1);
        }
    }
}
