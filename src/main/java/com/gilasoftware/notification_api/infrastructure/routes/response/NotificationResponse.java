package com.gilasoftware.notification_api.infrastructure.routes.response;

import com.gilasoftware.notification_api.domain.entities.NotificationLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NotificationResponse {

    private String message;
    private List<NotificationLog> notificationLogList;
}
