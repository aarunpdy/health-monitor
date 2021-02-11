package com.example.healthmonitor.model.chat;

public class ChatResponse extends ChatObject {

    @Override
    public int getType() {
        return ChatObject.RESPONSE_OBJECT;
    }
}
