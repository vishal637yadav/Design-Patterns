package com.sourcecode.spring.scope.prototype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService1 notificationService1;
    private final NotificationService2 notificationService2;
    private final NotificationService3 notificationService3;
    private final NotificationService4 notificationService4;

    private final Map<String,NotificationTask> notificationTaskMap = new ConcurrentHashMap<>();


    @PostMapping("/service1")
    public String sendNotification1(@RequestBody NotificationDto notificationDto) {
        log.info("service1 -- Get Request --->--- send notification: {}", notificationDto);
        NotificationTask task = notificationService1.sendNotification(notificationDto.getRecipient(), notificationDto.getMessage());
        log.info("service1 -- After Sending Notification --->--- send notification: {}", notificationDto);
        notificationTaskMap.put(task.getNotificationId(), task);
        return "service1 -- Notification sent!";
    }

    @PostMapping("/service2")
    public String sendNotification2(@RequestBody NotificationDto notificationDto) {
        log.info("service2 -- Get Request --->--- send notification: {}", notificationDto);
        notificationService2.sendNotification(notificationDto.getRecipient(), notificationDto.getMessage());
        log.info("service2 -- After Sending Notification --->--- send notification: {}", notificationDto);
        return "service2 -- Notification sent!";
    }

    @PostMapping("/service3")
    public String sendNotification3(@RequestBody NotificationDto notificationDto) {
        log.info("service3 -- Get Request --->--- send notification: {}", notificationDto);
        notificationService3.sendNotification(notificationDto.getRecipient(), notificationDto.getMessage());
        log.info("service3 -- After Sending Notification --->--- send notification: {}", notificationDto);
        return "service3 -- Notification sent!";
    }

    @PostMapping("/service4")
    public String sendNotification4(@RequestBody NotificationDto notificationDto) {
        log.info("service4 -- Get Request --->--- send notification: {}", notificationDto);
        notificationService4.sendNotification(notificationDto.getRecipient(), notificationDto.getMessage());
        log.info("service4 -- After Sending Notification --->--- send notification: {}", notificationDto);
        return "service4 -- Notification sent!";
    }

}
