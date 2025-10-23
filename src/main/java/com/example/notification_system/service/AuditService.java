package com.example.notification_system.service;

import com.example.notification_system.model.NotificationAudit;
import com.example.notification_system.model.NotificationType;
import com.example.notification_system.repository.NotificationAuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final NotificationAuditRepository auditRepository;

    public AuditService(NotificationAuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void saveAudit(String username, NotificationType type, String message, boolean success) {
        NotificationAudit audit = NotificationAudit.builder()
                .username(username)
                .notificationType(type)
                .message(message)
                .success(success)
                .timestamp(LocalDateTime.now())
                .build();

        auditRepository.save(audit);
    }
}
