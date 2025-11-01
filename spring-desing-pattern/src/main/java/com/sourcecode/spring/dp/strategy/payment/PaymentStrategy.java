package com.sourcecode.spring.dp.strategy.payment;

public interface PaymentStrategy {
    PaymentResult processPayment(PaymentRequest request) ;
    String getPaymentType();
}
