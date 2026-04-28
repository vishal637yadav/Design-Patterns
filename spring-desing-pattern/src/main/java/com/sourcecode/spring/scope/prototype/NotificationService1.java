package com.sourcecode.spring.scope.prototype;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public abstract class NotificationService1 {

    // This is the correct way to get a new prototype bean inside a singleton.
    // Spring will dynamically override this abstract method.
    @Lookup
    public abstract NotificationTask bads();

    public NotificationTask sendNotification(String recipient, String message) {
        // Each call to getNotificationTask() returns a brand-new instance
        NotificationTask task = bads();
        log.info("NotificationService1 -- Using @Lookup -- Sending Notification --->--- send notification: {}", task);
        task.sendingToQueue();
        return task;
    }

}
