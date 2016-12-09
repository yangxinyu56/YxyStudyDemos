package com.yxy.study.demos.ui.glide;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.yxy.study.demos.databinding.ActivityGlideRecyclerBinding;
import com.yxy.study.demos.R;
import com.yxy.study.demos.BR;
import com.yxy.study.demos.bean.GlideRecyclerItemEntity;
import com.yxy.study.demos.ui.adapter.SimpleRecyclerViewAdapter;

import java.util.ArrayList;


public class GlideRecyclerActivity extends AppCompatActivity {

    private ArrayList<GlideRecyclerItemEntity> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGlideRecyclerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_glide_recycler);
        initData();
        SimpleRecyclerViewAdapter myAdapter = new SimpleRecyclerViewAdapter<>(mList, R.layout.item_glide_recycler, BR.glideRecyclerItemEntity);
        binding.rcvGlideRecycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        binding.rcvGlideRecycler.setAdapter(myAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String url = "https://p.qpic.cn/music_cover/nn2Y0DVttzd70kwibAZpBF6U1Th1z6DNDiadOmczRKB8KvrepNviaibKEA/300?n=1";
            mList.add(new GlideRecyclerItemEntity(i, url));
        }
    }
}
