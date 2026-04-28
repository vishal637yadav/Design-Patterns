package com.sourcecode.spring.scope.prototype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService2 {

    private final ApplicationContext applicationContext;

    public void sendNotification(String recipient, String message) {
        // Each call to getNotificationTask() returns a brand-new instance
        NotificationTask task = applicationContext.getBean(NotificationTask.class);

        log.info("NotificationService2  -- Using ApplicationContext -- Sending Notification --->--- send notification: {}", task);

        // Set the state on the new prototype instance
        task.setRecipient(recipient);
        task.setMessage(message);

        task.sendingToQueue();

    }

}
