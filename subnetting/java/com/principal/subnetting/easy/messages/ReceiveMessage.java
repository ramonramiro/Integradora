package com.principal.subnetting.easy.messages;

public class ReceiveMessage extends  Message {
    private Long time;

    public ReceiveMessage() {
    }

    public ReceiveMessage(Long time) {
        this.time = time;
    }


    public ReceiveMessage(String message, String urlPhoto, String name, String profilePicture, String typeMessage, Long time) {
        super(message, urlPhoto, name, profilePicture, typeMessage);
        this.time = time;
    }

    public Long getHour() {
        return time;
    }

    public void setHour(Long time) {
        this.time = time;
    }
}
