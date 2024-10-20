package com.gilasoftware.notification_api.domain.strategy;

import com.gilasoftware.notification_api.domain.enums.NotificationChannel;
import com.gilasoftware.notification_api.domain.notification.NotificationSender;

public interface NotificationStrategy {
    NotificationSender getSender(NotificationChannel channel);
}
