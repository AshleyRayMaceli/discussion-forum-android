package com.example.guest.discussionforum.models;

public class Thread {
    String userName;
    String message;
    int score;

    public Thread() {}

    public Thread(String userName, String message, int score) {
        this.userName = userName;
        this.message = message;
        this.score = score;
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
