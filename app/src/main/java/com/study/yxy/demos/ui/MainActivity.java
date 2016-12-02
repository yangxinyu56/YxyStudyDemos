package com.study.yxy.demos.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.study.yxy.demos.BR;
import com.study.yxy.demos.R;
import com.study.yxy.demos.bean.MainItemEntity;
import com.study.yxy.demos.databinding.ActivityMainBinding;
import com.study.yxy.demos.ui.adapter.ListAdapter;
import com.study.yxy.demos.ui.glide.GlideActivity;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by yxy on 2016/12/1.<br/>
 * 主页 运用了dataBinding
 */
public class MainActivity extends AppCompatActivity {

    private List<MainItemEntity> list;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        ListAdapter<MainItemEntity> adapter = new ListAdapter<>(MainActivity.this, list, R.layout.item_main_demos, BR.mainItemEntity);
        binding.setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        binding.lvMainDemos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                jumpActivity(position);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        String[] names = getResources().getStringArray(R.array.main_list_demo_names);
        for (int i = 0; i < 5; i++) {
            list.add(new MainItemEntity(i + 1, names[i]));
        }
    }

    private void jumpActivity(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this,ViewPagerActivity.class));
                break;
            case 1:
                startActivity(new Intent(this,GlideActivity.class));
                break;
            default:
                break;
        }
    }
}
