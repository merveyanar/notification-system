package com.example.notification_system.controller;

import com.example.notification_system.model.NotificationType;
import com.example.notification_system.model.User;
import com.example.notification_system.repository.UserRepository;
import com.example.notification_system.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final UserRepository userRepository;

    public NotificationController(NotificationService notificationService, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

    // 🔹 Tüm kullanıcılara gönder
    @PostMapping("/sendToAll")
    public String sendToAll(@RequestParam String message, @RequestParam NotificationType type) {
        List<User> users = userRepository.findAll();
        users.forEach(user -> notificationService.sendNotification(user, message, type));
        return "📢 Tüm kullanıcılara " + type + " bildirimi gönderildi.";
    }

    // 🔹 Belirli kullanıcıya gönder
    @PostMapping("/sendToUser/{id}")
    public String sendToUser(@PathVariable Long id,
                             @RequestParam String message,
                             @RequestParam NotificationType type) {
        return userRepository.findById(id)
                .map(user -> {
                    notificationService.sendNotification(user, message, type);
                    return "📨 Kullanıcıya " + type + " bildirimi gönderildi.";
                })
                .orElse("❌ Kullanıcı bulunamadı.");
    }
}
