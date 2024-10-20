package com.gilasoftware.notification_api.domain.notification;

import com.gilasoftware.notification_api.domain.entities.Message;
import com.gilasoftware.notification_api.domain.entities.User;

public interface NotificationSender {
    void send(User user, Message message);
}