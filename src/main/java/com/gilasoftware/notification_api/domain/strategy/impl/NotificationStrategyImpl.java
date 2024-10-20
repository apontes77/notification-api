package com.gilasoftware.notification_api.domain.strategy.impl;

import com.gilasoftware.notification_api.domain.enums.NotificationChannel;
import com.gilasoftware.notification_api.domain.strategy.NotificationStrategy;
import com.gilasoftware.notification_api.domain.notification.NotificationSender;
import com.gilasoftware.notification_api.domain.notification.impl.EmailNotificationSender;
import com.gilasoftware.notification_api.domain.notification.impl.PushNotificationSender;
import com.gilasoftware.notification_api.domain.notification.impl.SmsNotificationSender;

public class NotificationStrategyImpl implements NotificationStrategy {
    private final SmsNotificationSender smsSender;
    private final EmailNotificationSender emailSender;
    private final PushNotificationSender pushSender;

    public NotificationStrategyImpl(SmsNotificationSender smsSender, EmailNotificationSender emailSender, PushNotificationSender pushSender) {
        this.smsSender = smsSender;
        this.emailSender = emailSender;
        this.pushSender = pushSender;
    }

    @Override
    public NotificationSender getSender(NotificationChannel channel) {
        return switch (channel) {
            case SMS -> smsSender;
            case EMAIL -> emailSender;
            case PUSH_NOTIFICATION -> pushSender;
        };
    }
}