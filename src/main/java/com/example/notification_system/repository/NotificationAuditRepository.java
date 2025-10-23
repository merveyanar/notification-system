package com.example.notification_system.repository;

import com.example.notification_system.model.NotificationAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationAuditRepository extends JpaRepository<NotificationAudit, Long> {
}
