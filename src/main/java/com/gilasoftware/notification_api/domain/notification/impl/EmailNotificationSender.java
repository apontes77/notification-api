package com.gilasoftware.notification_api.domain.notification.impl;

import com.gilasoftware.notification_api.domain.entities.Message;
import com.gilasoftware.notification_api.domain.entities.User;
import com.gilasoftware.notification_api.domain.notification.NotificationSender;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(User user, Message message) {
        // Logic to send Email
        System.out.println("Sending Email to " + user.getEmail() + ": " + message.getBody());
    }
}