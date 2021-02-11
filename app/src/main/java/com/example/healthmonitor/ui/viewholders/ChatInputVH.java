package com.example.healthmonitor.ui.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.healthmonitor.R;
import com.example.healthmonitor.model.chat.ChatObject;

public class ChatInputVH extends BaseViewHolder {

    private TextView tvInputText;

    public ChatInputVH(View itemView) {
        super(itemView);
        this.tvInputText = (TextView) itemView.findViewById(R.id.tv_input_text);
    }

    @Override
    public void onBindView(ChatObject object) {
        this.tvInputText.setText(object.getText());
    }
}
