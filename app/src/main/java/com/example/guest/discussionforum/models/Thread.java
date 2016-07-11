package com.example.guest.discussionforum.models;

public class Thread {
    String userName;
    String message;
    int score = 0;

    public Thread() {}

    public Thread(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }
}
