package com.yxy.study.demos.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by yxy on 2016/12/1.<br/>
 * 简单的ListView适配器
 */

public class SimpleListAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> data;//数据源
    private int layoutId;//单布局
    private int variableId;//BR.xxx

    public SimpleListAdapter(Context context, List<T> data, int layoutId, int variableId) {
        this.context = context;
        this.data = data;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(variableId, data.get(position));
        return binding.getRoot();
    }
}
