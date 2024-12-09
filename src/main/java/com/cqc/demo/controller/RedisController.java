package com.cqc.demo.controller;

import com.cqc.demo.config.RedisPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisPublisher redisPublisher;

    @GetMapping("/publish")
    public String publish(@RequestParam String topic, @RequestParam String message) {
        redisPublisher.publish(topic, message);
        return "Message published!";
    }
}
