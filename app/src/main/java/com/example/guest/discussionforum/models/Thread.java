package com.example.guest.discussionforum.models;

public class Thread {
    String userName;
    String message;
    int score = 0;

    public Thread(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public Thread() {}

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }

    public void upVote() {
        score ++;
    }

    public void downVote() {
        score --;
    }
}
