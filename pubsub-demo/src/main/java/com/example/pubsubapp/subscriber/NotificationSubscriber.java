//package com.example.pubsubapp.subscriber;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationSubscriber {
//
//    private static final Logger logger = LoggerFactory.getLogger(NotificationSubscriber.class);
//
//    @ServiceActivator(inputChannel = "inputMessageChannel")
//    public void receiveMessage(Message<String> message) {
//        logger.info("Received Pub/Sub message: {}", message.getPayload());
//    }
//}
