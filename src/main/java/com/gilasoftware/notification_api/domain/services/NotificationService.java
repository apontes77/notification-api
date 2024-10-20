package com.gilasoftware.notification_api.domain.services;

import com.gilasoftware.notification_api.domain.entities.Message;
import com.gilasoftware.notification_api.domain.entities.NotificationLog;
import com.gilasoftware.notification_api.domain.entities.User;
import com.gilasoftware.notification_api.domain.enums.NotificationChannel;
import com.gilasoftware.notification_api.domain.notification.NotificationSender;
import com.gilasoftware.notification_api.domain.strategy.NotificationStrategy;
import com.gilasoftware.notification_api.infrastructure.repository.NotificationRepository;
import com.gilasoftware.notification_api.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationStrategy notificationStrategy;
    private final UserRepository userRepository;
    private final NotificationRepository logRepository;

    public NotificationService(NotificationStrategy notificationStrategy, UserRepository userRepository, NotificationRepository logRepository) {
        this.notificationStrategy = notificationStrategy;
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    public List<NotificationLog> sendNotifications(Message message) {
        List<NotificationLog> logs = new ArrayList<>();

        List<User> users = userRepository.findAll(); // Simula a consulta a usuários
        for (User user : users) {
            if (user.getSubscribedCategories().contains(message.getCategory())) {
                for (NotificationChannel channel : user.getPreferredChannels()) {
                    NotificationSender sender = notificationStrategy.getSender(channel);
                    sender.send(user, message);

                    // Cria um log para registrar a notificação enviada
                    NotificationLog log = new NotificationLog();
                    log.setUser(user);
                    log.setMessage(message);
                    log.setChannel(channel);
                    log.setTimestamp(LocalDateTime.now());
                    log.setDelivered(true);  // Simulando que a entrega foi bem-sucedida
                    logs.add(log);

                    // Salva o log no repositório
                    logRepository.save(log);
                }
            }
        }

        return logs;
    }
}
