package com.example.notification_system.service.strategy;

import com.example.notification_system.model.User;
import com.example.notification_system.service.template.AbstractNotificationSender;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationStrategy extends AbstractNotificationSender implements NotificationStrategy {

    @Override
    public void sendNotification(User user, String message) {
        send(user, message);
    }

    @Override
    protected boolean isEnabled(User user) {
        return user.isSmsEnabled();
    }

    @Override
    protected void sendMessage(User user, String message) {
        System.out.println("📱 SMS gönderildi: " + user.getPhone() + " | Mesaj: " + message);
    }
}
