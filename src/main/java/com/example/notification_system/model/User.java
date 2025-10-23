package com.example.notification_system.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // <--- EKLENDİ
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String phone;

    private boolean emailEnabled;
    private boolean smsEnabled;
    private boolean pushEnabled;
}
