package com.example.healthmonitor.presenter;

import com.example.healthmonitor.model.chat.ChatObject;

import java.util.ArrayList;

public interface ChatContract {

    interface View {

        void notifyAdapterObjectAdded(int position);

        void scrollChatDown();
    }

    interface Presenter {

        void attachView(View view);

        ArrayList<ChatObject> getChatObjects();

        void onEditTextActionDone(String inputText);
    }
}
