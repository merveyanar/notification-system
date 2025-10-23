package com.example.notification_system.service.template;

import com.example.notification_system.model.User;

public abstract class AbstractNotificationSender {

    public final void send(User user, String message) {
        if (!isEnabled(user)) {
            System.out.println("❌ Bildirim türü kullanıcı tarafından devre dışı bırakılmış.");
            return;
        }

        prepare();
        sendMessage(user, message);
        logSuccess(user);
    }

    protected abstract boolean isEnabled(User user);
    protected abstract void sendMessage(User user, String message);

    protected void prepare() {
        System.out.println("🔧 Bildirim hazırlığı yapılıyor...");
    }

    protected void logSuccess(User user) {
        System.out.println("✅ Bildirim başarıyla gönderildi: " + user.getUsername());
    }
}

