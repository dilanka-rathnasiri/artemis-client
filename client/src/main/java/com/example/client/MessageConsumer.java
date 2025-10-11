package com.example.client;

import jakarta.jms.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "${jms.topic}")
    public void receiveMessage(Message message) {
        try {
            LOGGER.info("Received message: {}", message.getBody(Object.class));
        } catch (Exception e) {
            LOGGER.error("Error in message read: {}", e.getMessage(), e);
        }
    }
}
