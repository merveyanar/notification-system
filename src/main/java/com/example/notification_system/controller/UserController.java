package com.example.notification_system.controller;

import com.example.notification_system.event.UserRegisteredEvent;
import com.example.notification_system.model.User;
import com.example.notification_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);

        // Event'i yayınla
        eventPublisher.publishEvent(new UserRegisteredEvent(this, user));

        return "Kullanıcı kaydedildi ve bildirim tetiklendi.";
    }
}

