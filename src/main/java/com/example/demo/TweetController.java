package com.example.demo;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    private final TweetDAO tweets;

    public TweetController() {
        super();
        tweets = new TweetDAO();
    }

    @GetMapping("/tweet")
    public Collection<Tweet> tweet() {
        return tweets.all();
    }

    @GetMapping("/tweet/{id}")
    public Tweet getTweet(@PathVariable Long id) {
        // return new Tweet(counter.incrementAndGet(), "lars", "topic", String.format(template, name));
        return tweets.read(id);
    }

    @PutMapping("/tweet/{id}")
    Tweet updateTweet(@RequestBody Tweet newTweet, @PathVariable Long id) {

        Tweet tweet = tweets.read(id);

        tweet.setTopic(newTweet.getTopic());

        tweet.setAuthor(newTweet.getAuthor());

        tweet.setMessage(newTweet.getMessage());

        return tweet;
    }

    @PostMapping("/tweet")
    Tweet newEmployee(@RequestBody Tweet newTweet) {
        return tweets.create(newTweet.getAuthor(),newTweet.getTopic(),newTweet.getMessage());
    }

    @DeleteMapping("/tweet/{id}")
    void deleteTweet(@PathVariable Long id) {

        tweets.delete(id);
    }



}
