package com.gilasoftware.notification_api.infrastructure.repository;

import com.gilasoftware.notification_api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
