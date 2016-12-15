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
 * 万能ExpandableListAdapter适配器
 */
public class CommonExpandableListAdapter<T, K> extends BaseExpandableListAdapter {
    private int childResource;
    private int groupResource;
    private List<List<T>> childrenData = new ArrayList<>();
    private List<K> groupData = new ArrayList<>();
    private Context context;
    private int groupVariableId;
    private int childVariableId;

    public List<List<T>> getChildrenData() {
        return childrenData;
    }

    public List<K> getGroupData() {
        return groupData;
    }

    public CommonExpandableListAdapter(Context context, int childResource, int groupResource, int childVariableId, int groupVariableId) {
        this.context = context;
        this.childResource = childResource;
        this.groupResource = groupResource;
        this.childVariableId = childVariableId;
        this.groupVariableId = groupVariableId;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childrenData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), childResource, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(childVariableId, childrenData.get(groupPosition).get(childPosition));
        return binding.getRoot();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childrenData.size() > 0 ? childrenData.get(groupPosition).size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), groupResource, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(groupVariableId, groupData.get(groupPosition));
        return binding.getRoot();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}