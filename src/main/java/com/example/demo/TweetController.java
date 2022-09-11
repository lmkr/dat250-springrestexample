package com.example.demo;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    private final AtomicLong counter;
    private final TweetDAO tweets;

    public TweetController() {
        super();
        counter = new AtomicLong();
        tweets = new TweetDAO();
    }

    @GetMapping("/tweet")
    public Collection<Tweet> tweet(@RequestParam(value = "name", defaultValue = "World") String name) {
        // return new Tweet(counter.incrementAndGet(), "lars", "topic", String.format(template, name));
        return tweets.all();
    }

    @GetMapping("/tweet/{id}")
    public Tweet tweet(@PathVariable Long id) {
        // return new Tweet(counter.incrementAndGet(), "lars", "topic", String.format(template, name));
        return tweets.read(id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {

        tweets.delete(id);
    }

}
