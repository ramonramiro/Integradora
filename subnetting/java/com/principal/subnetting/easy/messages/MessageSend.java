package com.principal.subnetting.easy.messages;

import java.util.Map;

public class MessageSend extends Message {
    private Map time;

    public MessageSend()  {
    }


    public MessageSend(String message, String urlPhoto, String name, String profilePicture, String typeMessage, Map time) {
        super(message, urlPhoto, name, profilePicture, typeMessage);
        this.time = time;
    }

    public MessageSend(String message, String name, String profilePicture, String typeMessage, Map time) {
        super(message, name, profilePicture, typeMessage);
        this.time = time;
    }

    public MessageSend(Map time) {
        this.time = time;
    }

    public Map getHour() {
        return time;
    }

    public void setHour(Map time) {
        this.time = time;
    }
}
