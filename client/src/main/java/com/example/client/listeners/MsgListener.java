package com.example.client.listeners;

import jakarta.jms.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {

    private static final Logger LOGGER = LogManager.getLogger(MsgListener.class);

    @JmsListener(destination = "${jms.topic}")
    public void receiveMessage(Message message) {
        try {
            LOGGER.info("Received message: {}", message.getBody(Object.class));
        } catch (Exception e) {
            LOGGER.error("Error in message read: {}", e.getMessage(), e);
        }
    }
}
