package com.example.demo;

public class Tweet {

    private final long id;
    private final String author;
    private final String topic;
    private final String message;

    public Tweet(long id, String author, String topic, String message) {
        this.id = id;
        this.author = author;
        this.topic = topic;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() { return author; }

    public String getTopic() { return topic; }

    public String getMessage() {
        return message;
    }
}
