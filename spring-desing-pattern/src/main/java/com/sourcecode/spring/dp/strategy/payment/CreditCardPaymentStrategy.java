package com.sourcecode.spring.dp.strategy.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("creditCard")
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        // Credit card processing logic
        System.out.println("Processing credit card payment: " + request.amount());
        return new PaymentResult("SUCCESS", "CC-" + System.currentTimeMillis());
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }

}
