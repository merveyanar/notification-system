package com.example.notification_system.event;

import com.example.notification_system.model.NotificationType;
import com.example.notification_system.model.User;
import com.example.notification_system.service.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    private final NotificationService notificationService;

    public NotificationEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventListener
    public void handleUserRegistered(UserRegisteredEvent event) {
        User user = event.getUser();

        System.out.println("📡 Olay alındı: Kullanıcı kaydı → " + user.getUsername());

        // Her aktif kanal için bildirim gönder
        if (user.isEmailEnabled()) {
            notificationService.sendNotification(user, "E-posta ile hoş geldiniz!", NotificationType.EMAIL);
        }
        if (user.isSmsEnabled()) {
            notificationService.sendNotification(user, "SMS ile hoş geldiniz!", NotificationType.SMS);
        }
        if (user.isPushEnabled()) {
            notificationService.sendNotification(user, "Push bildirimi ile hoş geldiniz!", NotificationType.PUSH);
        }
    }
}
