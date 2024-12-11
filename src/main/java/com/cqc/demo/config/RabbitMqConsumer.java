package com.cqc.demo.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    @Value("${rabbitmq.queue}")
    private String queueName;

    @RabbitListener(queues = "#{rabbitConfig.queue().name}")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
