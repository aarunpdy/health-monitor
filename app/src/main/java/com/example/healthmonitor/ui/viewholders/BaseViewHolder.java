package com.example.healthmonitor.ui.viewholders;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmonitor.model.chat.ChatObject;


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBindView(ChatObject object);
}
