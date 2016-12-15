package com.yxy.study.demos.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.yxy.study.demos.BR;
import com.yxy.study.demos.R;
import com.yxy.study.demos.bean.ClassEntity;
import com.yxy.study.demos.bean.StudentEntity;
import com.yxy.study.demos.databinding.ActivityExpandableListViewBinding;
import com.yxy.study.demos.ui.adapter.CommonExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;


public class ExpandableListViewActivity extends AppCompatActivity {
    CommonExpandableListAdapter<StudentEntity, ClassEntity> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ActivityExpandableListViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_expandable_list_view);
        adapter = new CommonExpandableListAdapter<>(this, R.layout.item_expandable_child, R.layout.item_expandable_group, BR.studentEntity, BR.classEntity);
        binding.elvDemo.setAdapter(adapter);

        addTestData();
        binding.elvDemo.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(ExpandableListViewActivity.this, "NO." + adapter.getChildrenData().get(i).get(i1).studentName, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addTestData() {
        for (int i = 0; i < 5; i++) {
            ClassEntity groupData = new ClassEntity();
            groupData.className = "第" + i + "班";
            adapter.getGroupData().add(groupData);
        }
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            List<StudentEntity> temp = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                StudentEntity childData = new StudentEntity();
                childData.studentName = "第" + i + "班学生-" + j;
                temp.add(childData);

            }
            adapter.getChildrenData().add(temp);
        }
        adapter.notifyDataSetChanged();
    }
}
