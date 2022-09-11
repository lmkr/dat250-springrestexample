package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/tweet")
    public Tweet tweet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Tweet(counter.incrementAndGet(), "lars", "topic", String.format(template, name));
    }
}
