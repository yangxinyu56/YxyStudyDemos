package com.yxy.study.demos.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxy on 2016/12/15.<br/>
 * 简单的ExpandableListView适配器
 */

public class SimpleExpandableListAdapter<K, T> extends BaseExpandableListAdapter {
    private Context context;
    private List<List<T>> childData = new ArrayList<>();
    private List<K> groupData = new ArrayList<>();
    private int groupLayoutId;//父布局
    private int groupVariableId;//BR.xxx
    private int childLayoutId;//子布局
    private int childVariableId;//BR.xxx

    public SimpleExpandableListAdapter(Context context, List<List<T>> childData, List<K> groupData, int groupLayoutId, int groupVariableId, int childLayoutId, int childVariableId) {
        this.context = context;
        this.childData = childData;
        this.groupData = groupData;
        this.groupLayoutId = groupLayoutId;
        this.groupVariableId = groupVariableId;
        this.childLayoutId = childLayoutId;
        this.childVariableId = childVariableId;
    }

    //  获得父项的数量
    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.size() > 0 ? childData.get(groupPosition).size() : 0;
    }

    //  获得某个父项
    @Override
    public Object getGroup(int i) {
        return groupData.get(i);
    }

    //  获得某个父项的某个子项
    @Override
    public Object getChild(int parentPos, int childPos) {
        return childData.get(parentPos).get(childPos);
    }

    //  获得某个父项的id
    @Override
    public long getGroupId(int i) {
        return i;
    }

    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int parentPos, int childPos) {
        return childPos;
    }

    //是否具有稳定的id
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //  获得父项显示的view
    @Override
    public View getGroupView(int i, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), groupLayoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(groupVariableId, groupData.get(i));
        return binding.getRoot();
    }

    //  获得子项显示的view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), childLayoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(childVariableId, childData.get(groupPosition).get(childPosition));
        return binding.getRoot();
    }

    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
