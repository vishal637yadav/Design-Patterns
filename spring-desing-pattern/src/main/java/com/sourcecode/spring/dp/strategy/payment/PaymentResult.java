package com.sourcecode.spring.dp.strategy.payment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResult {
    private String status;
    private String transactionId;
    private String message;
    private LocalDateTime timestamp;

    public PaymentResult(String status, String transactionId) {
        this.status = status;
        this.transactionId = transactionId;
        this.timestamp = LocalDateTime.now();
    }

}
