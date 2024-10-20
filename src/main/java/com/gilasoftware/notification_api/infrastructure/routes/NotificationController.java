package com.gilasoftware.notification_api.infrastructure.routes;

import com.gilasoftware.notification_api.domain.services.NotificationService;
import com.gilasoftware.notification_api.infrastructure.routes.request.NotificationRequest;
import com.gilasoftware.notification_api.infrastructure.routes.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    NotificationService notificationService;

    @PostMapping
    public NotificationResponse createNotification(@RequestBody NotificationRequest request) {

        notificationService.create(request);



    }
}
