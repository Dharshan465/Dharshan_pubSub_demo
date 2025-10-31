package com.example.pubsubapp.controller;

import com.example.pubsubapp.model.Notification;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    private static final String TOPIC = "ds-user-notifications";

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody Notification notification) {
        pubSubTemplate.publish(TOPIC, notification.toString());
        return ResponseEntity.ok("Notification sent to topic.");
    }
}
