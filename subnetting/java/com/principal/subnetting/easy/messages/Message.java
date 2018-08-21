package com.principal.subnetting.easy.messages;

public class Message {
    private String message;
    private String urlPhoto;
    private String name;
    private String profilePicture;
    private String typeMessage;

    public Message(String message, String urlPhoto, String name, String profilePicture, String typeMessage) {
        this.message = message;
        this.urlPhoto = urlPhoto;
        this.name = name;
        this.profilePicture = profilePicture;
        this.typeMessage = typeMessage;
    }

    public Message(String message, String name, String profilePicture, String typeMessage) {
        this.message = message;
        this.name = name;
        this.profilePicture = profilePicture;
        this.typeMessage = typeMessage;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }
}

