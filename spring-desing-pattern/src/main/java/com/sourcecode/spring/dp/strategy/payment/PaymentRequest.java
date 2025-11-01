package com.sourcecode.spring.dp.strategy.payment;

import java.math.BigDecimal;
import java.util.Map;

public record PaymentRequest(
        BigDecimal amount,
        String currency,
        String customerEmail,
        Map<String, Object> additionalData) {
}
