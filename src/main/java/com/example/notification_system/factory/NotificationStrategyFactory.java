package com.example.notification_system.factory;

import com.example.notification_system.model.NotificationType;
import com.example.notification_system.service.strategy.EmailNotificationStrategy;
import com.example.notification_system.service.strategy.NotificationStrategy;
import com.example.notification_system.service.strategy.PushNotificationStrategy;
import com.example.notification_system.service.strategy.SmsNotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class NotificationStrategyFactory {

    private final Map<NotificationType, NotificationStrategy> strategies = new EnumMap<>(NotificationType.class);

    public NotificationStrategyFactory(
            EmailNotificationStrategy emailStrategy,
            SmsNotificationStrategy smsStrategy,
            PushNotificationStrategy pushStrategy
    ) {
        strategies.put(NotificationType.EMAIL, emailStrategy);
        strategies.put(NotificationType.SMS, smsStrategy);
        strategies.put(NotificationType.PUSH, pushStrategy);
    }

    public NotificationStrategy getStrategy(NotificationType type) {
        NotificationStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Desteklenmeyen bildirim türü: " + type);
        }
        return strategy;
    }
}
