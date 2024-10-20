package com.gilasoftware.notification_api.domain.entities;

import com.gilasoftware.notification_api.domain.enums.NotificationChannel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class NotificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Message message;

    @Enumerated(EnumType.STRING)
    private NotificationChannel channel;

    private LocalDateTime timestamp;
    private boolean delivered;
}