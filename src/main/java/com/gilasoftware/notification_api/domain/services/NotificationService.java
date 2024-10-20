package com.gilasoftware.notification_api.domain.services;

import com.gilasoftware.notification_api.infrastructure.repository.NotificationRepository;
import com.gilasoftware.notification_api.infrastructure.routes.request.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public void create(NotificationRequest request) {
    }
}
