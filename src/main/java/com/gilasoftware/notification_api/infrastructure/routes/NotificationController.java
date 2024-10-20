package com.gilasoftware.notification_api.infrastructure.routes;

import com.gilasoftware.notification_api.domain.entities.Message;
import com.gilasoftware.notification_api.domain.entities.NotificationLog;
import com.gilasoftware.notification_api.domain.services.NotificationService;
import com.gilasoftware.notification_api.infrastructure.repository.NotificationRepository;
import com.gilasoftware.notification_api.infrastructure.routes.request.MessageRequest;
import com.gilasoftware.notification_api.infrastructure.routes.response.NotificationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationRepository logRepository;

    public NotificationController(NotificationService notificationService, NotificationRepository logRepository) {
        this.notificationService = notificationService;
        this.logRepository = logRepository;
    }

    // Endpoint para criar mensagem e enviar notificações
    @PostMapping
    public ResponseEntity<NotificationResponse> sendNotification(@RequestBody MessageRequest messageRequest) {
        Message message = new Message();
        message.setCategory(messageRequest.getCategory());
        message.setBody(messageRequest.getBody());

        List<NotificationLog> notificationLogs = notificationService.sendNotifications(message);

        NotificationResponse response = new NotificationResponse("Notifications sent to subscribed users", notificationLogs);
        return ResponseEntity.ok(response);
    }

    // Endpoint para consultar o log de notificações
    @GetMapping("/logs")
    public ResponseEntity<List<NotificationLog>> getNotificationLogs() {
        List<NotificationLog> logs = logRepository.findAll();
        return ResponseEntity.ok(logs);
    }
}
