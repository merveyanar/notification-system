package com.example.notification_system.service.strategy;

import com.example.notification_system.model.User;

public interface NotificationStrategy {
    void sendNotification(User user, String message);
}
