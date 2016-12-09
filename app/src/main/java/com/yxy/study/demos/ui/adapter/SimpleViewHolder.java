package com.yxy.study.demos.ui.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yxy on 2016/12/9.<br/>
 * 简单的RecyclerViewViewHolder
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder{
    private ViewDataBinding binding;
    public SimpleViewHolder(View itemView) {
        super(itemView);
    }
    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public ViewDataBinding getBinding() {
        return this.binding;
    }
}
