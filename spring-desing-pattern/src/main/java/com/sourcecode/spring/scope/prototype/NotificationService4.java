package com.sourcecode.spring.scope.prototype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService4 {

    private final ObjectProvider<NotificationTask> notificationTaskObjectProvider;

    public void sendNotification(String recipient, String message) {
        // Each call to getNotificationTask() returns a brand-new instance
        NotificationTask task = notificationTaskObjectProvider.getObject();

        log.info("NotificationService4  -- Using ObjectProvider -- Sending Notification --->--- send notification: {}", task);

        // Set the state on the new prototype instance
        task.setRecipient(recipient);
        task.setMessage(message);

        // Execute the task (e.g., in a new thread or via an ExecutorService)
        task.sendingToQueue();
    }

}
