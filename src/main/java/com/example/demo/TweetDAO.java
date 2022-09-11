package com.example.demo;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;

public class TweetDAO {

    private final AtomicLong counter;
    private final ConcurrentHashMap<Long, Tweet> tweets;

    public TweetDAO() {
       counter = new AtomicLong();
       tweets = new ConcurrentHashMap<Long, Tweet>();
       // create("lars","topic","message");
    }

    public Tweet create(String author, String topic, String message) {

        long id = counter.incrementAndGet();

        Tweet tweet = new Tweet(id, author, topic, message);

        tweets.put(id,tweet);

        return tweet;
    }

    public Tweet read(Long id) {

        Tweet tweet = tweets.get(id);

        tweets.put(id,tweet);

        return tweet;
    }

    public boolean update(Long id, String author, String topic, String message) {

        Tweet tweet = tweets.get(id);

        tweet.setTopic(topic);
        tweet.setAuthor(author);
        tweet.setAuthor(message);

        return true; // TODO: add error handling
    }

    public Tweet delete(Long id) {

        Tweet tweet = tweets.remove(id);

        return tweet;
    }

    public Collection<Tweet> all() {
        return tweets.values();
    }

}
