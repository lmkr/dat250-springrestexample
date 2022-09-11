package com.example.demo;

class TweetNotFoundException extends RuntimeException {

    TweetNotFoundException(Long id) {
        super("Could not find tweet " + id);
    }
}
