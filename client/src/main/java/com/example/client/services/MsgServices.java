package com.example.client.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgServices {
    private static final Logger LOGGER = LogManager.getLogger(MsgServices.class);

    private final String topicName;
    private final JmsTemplate jmsTemplate;

    public MsgServices(@Value("${jms.topic}") final String topicName, final JmsTemplate jmsTemplate) {
        this.topicName = topicName;
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMsg(final String msg) {
        try {
            LOGGER.info("Send message: msg={}", msg);
            jmsTemplate.convertAndSend(topicName, msg);
        } catch (Exception e) {
            LOGGER.error("Error in sending message", e);
        }
    }
}
