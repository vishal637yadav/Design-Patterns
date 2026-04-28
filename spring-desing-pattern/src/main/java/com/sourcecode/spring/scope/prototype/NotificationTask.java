package com.sourcecode.spring.scope.prototype;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Slf4j
@Setter
@Getter
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("prototype")
public class NotificationTask
{
    private String notificationId;
    private String recipient;
    private String message;

    @PostConstruct
    public void init() {
        log.info("NotificationTask initialized with hashCode: {}", this.hashCode());
        this.notificationId = UUID.randomUUID().toString();

    }

    public void sendingToQueue() {
        // Simulate sending the notification
        log.info("-------------------------------------");
        log.info("NotificationId : {}", notificationId);
        log.info("Sending notification to: {}", recipient);
        log.info("Message: {}", message);
        log.info("Processed by task with hashCode: {}", this.hashCode());
        log.info("-------------------------------------\n");
    }

}
