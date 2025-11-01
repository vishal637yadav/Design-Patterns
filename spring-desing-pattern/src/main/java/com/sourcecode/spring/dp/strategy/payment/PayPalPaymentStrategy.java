package com.sourcecode.spring.dp.strategy.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("paypal")
public class PayPalPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        // PayPal processing logic
        System.out.println("Processing PayPal payment: " + request.amount());
        return new PaymentResult("SUCCESS", "PP-" + System.currentTimeMillis());
    }

    @Override
    public String getPaymentType() {
        return "PAYPAL";
    }

}
