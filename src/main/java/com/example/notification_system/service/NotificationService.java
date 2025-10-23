package com.example.notification_system.service;

import com.example.notification_system.factory.NotificationStrategyFactory;
import com.example.notification_system.model.NotificationType;
import com.example.notification_system.model.User;
import com.example.notification_system.service.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationStrategyFactory strategyFactory;
    private final AuditService auditService;

    public NotificationService(NotificationStrategyFactory strategyFactory, AuditService auditService) {
        this.strategyFactory = strategyFactory;
        this.auditService = auditService;
    }

    public void sendNotification(User user, String message, NotificationType type) {
        boolean success = true;
       try {
           NotificationStrategy strategy = strategyFactory.getStrategy(type);
           strategy.sendNotification(user, message);
       }catch(Exception e){
           success=false;
           System.out.println("❌ Bildirim hatası: " + e.getMessage());;
       }finally {
           auditService.saveAudit(user.getUsername(), type, message, success);

       }
    }
}

