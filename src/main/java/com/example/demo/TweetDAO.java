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
    }

    public Tweet create(String author, String topic, String message) {

        long id = counter.incrementAndGet();

        Tweet tweet = new Tweet(id, author, topic, message);

        tweets.put(id,tweet);

        return tweet;
    }

    public Tweet read(Long id) {

        Tweet tweet = tweets.get(id);

        return tweet;
    }

    public Tweet update(Long id, Tweet newTweet) {

        Tweet tweet = tweets.get(id);

        tweet.setTopic(newTweet.getTopic());
        tweet.setAuthor(newTweet.getAuthor());
        tweet.setMessage(newTweet.getMessage());

        return tweet;
    }

    public Tweet delete(Long id) {

        Tweet tweet = tweets.remove(id);

        return tweet;
    }

    public Collection<Tweet> all() {
        return tweets.values();
    }
}
