package com.example.healthmonitor.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmonitor.R;
import com.example.healthmonitor.model.chat.ChatObject;
import com.example.healthmonitor.ui.viewholders.BaseViewHolder;
import com.example.healthmonitor.ui.viewholders.ChatInputVH;
import com.example.healthmonitor.ui.viewholders.ChatResponseVH;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<ChatObject> chatObjects;

    public ChatAdapter(ArrayList<ChatObject> chatObjects) {
        this.chatObjects = chatObjects;
    }

    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Create the ViewHolder based on the viewType
        View itemView;
        if (viewType == ChatObject.INPUT_OBJECT) {
            itemView = inflater.inflate(R.layout.chat_input_layout, parent, false);
            return new ChatInputVH(itemView);
        }
        itemView = inflater.inflate(R.layout.chat_response_layout, parent, false);
        return new ChatResponseVH(itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBindView(chatObjects.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return chatObjects.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return chatObjects.size();
    }
}
