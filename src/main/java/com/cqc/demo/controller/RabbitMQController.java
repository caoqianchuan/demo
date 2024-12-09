package com.cqc.demo.controller;

import com.cqc.demo.config.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;



    @GetMapping("/send")
    public String sendMessage() {
        rabbitMQProducer.sendMessage("Hello, RabbitMQ!");
        return "Message sent to RabbitMQ!";
    }
}

