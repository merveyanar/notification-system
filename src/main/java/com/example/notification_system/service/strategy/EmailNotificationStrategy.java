package com.example.notification_system.service.strategy;

import com.example.notification_system.model.User;
import com.example.notification_system.service.template.AbstractNotificationSender;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationStrategy extends AbstractNotificationSender implements NotificationStrategy {

    @Override
    public void sendNotification(User user, String message) {
        send(user, message);  // Template Method'u kullan
    }

    @Override
    protected boolean isEnabled(User user) {
        return user.isEmailEnabled();
    }

    @Override
    protected void sendMessage(User user, String message) {
        System.out.println("📧 E-posta gönderildi: " + user.getEmail() + " | Mesaj: " + message);
    }
}
