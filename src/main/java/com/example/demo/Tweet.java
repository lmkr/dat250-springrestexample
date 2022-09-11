package com.example.demo;

public class Tweet {

    private final long id;
    private String author;
    private String topic;
    private String message;

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

    public void setAuthor(String author) { this.author = author; }

    public String getTopic() { return topic; }

    public void setTopic(String topic) { this.topic = topic; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) { this.message = message; }
}
