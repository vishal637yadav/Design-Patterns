package com.sourcecode.spring.scope.prototype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService3 {

    private final ObjectFactory<NotificationTask> notificationTaskObjectFactory;

    public void sendNotification(String recipient, String message) {
        // Each call to getNotificationTask() returns a brand-new instance
        NotificationTask task = notificationTaskObjectFactory.getObject();

        log.info("NotificationService3  -- Using NotificationTask -- Sending Notification --->--- send notification: {}", task);

        // Set the state on the new prototype instance
        task.setRecipient(recipient);
        task.setMessage(message);

        // Execute the task (e.g., in a new thread or via an ExecutorService)
        task.sendingToQueue();
    }

}
