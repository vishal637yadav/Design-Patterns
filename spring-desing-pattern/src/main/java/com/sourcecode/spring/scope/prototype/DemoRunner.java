package com.sourcecode.spring.scope.prototype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DemoRunner implements CommandLineRunner {

    private final NotificationService1 notificationService1;

    @Override
    public void run(String... args) throws Exception {
        log.info("---------------------------------### Starting Notification Demo ###");

        // Send the first notification
        notificationService1.sendNotification("user1@example.com", "Your order has been shipped.");

        // Wait a moment to make the output clear
        Thread.sleep(100);

        // Send the second notification
        notificationService1.sendNotification("user2@example.com", "Your password has been reset.");

        log.info("---------------------------------### Notification Demo Finished ###");
    }

}
