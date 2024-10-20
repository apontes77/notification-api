package com.gilasoftware.notification_api.infrastructure.repository;

import com.gilasoftware.notification_api.domain.entities.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationLog, Long> {
}
