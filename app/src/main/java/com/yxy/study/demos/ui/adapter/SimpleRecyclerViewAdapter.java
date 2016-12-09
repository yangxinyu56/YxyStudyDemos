package com.yxy.study.demos.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yxy on 2016/12/9.<br/>
 * 简单的RecyclerView适配器
 */


public class SimpleRecyclerViewAdapter<T> extends  RecyclerView.Adapter<SimpleViewHolder>{
    private List<T> data;//数据源
    private int layoutId;//单布局
    private int variableId;//BR.xxx

    public SimpleRecyclerViewAdapter(List<T> data, int layoutId, int variableId) {
        this.data = data;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), layoutId, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.getBinding().setVariable(variableId, data.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
