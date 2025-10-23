package com.example.notification_system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // STRATEJİ METODUNDAN ÖNCE LOG AT
    @Before("execution(* com.example.notification_system.service.strategy.*.sendNotification(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("📤 Bildirim gönderimi başlıyor: " + joinPoint.getSignature().getName());
    }

    // STRATEJİ METODU BAŞARIYLA ÇALIŞINCA LOG AT
    @AfterReturning("execution(* com.example.notification_system.service.strategy.*.sendNotification(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("✅ Bildirim gönderimi tamamlandı: " + joinPoint.getSignature().getName());
    }

    // HATA DURUMUNDA LOG AT
    @AfterThrowing(pointcut = "execution(* com.example.notification_system.service.strategy.*.sendNotification(..))", throwing = "error")
    public void logException(JoinPoint joinPoint, Throwable error) {
        System.out.println("❌ Bildirim gönderimi sırasında hata: " + error.getMessage());
    }
}
