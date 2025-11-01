package com.sourcecode.spring.dp.strategy.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bankTransfer")
public class BankTransferPaymentStrategy implements  PaymentStrategy {

    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        // Bank transfer processing logic
        System.out.println("Processing bank transfer: " + request.amount());
        return new PaymentResult("SUCCESS", "BT-" + System.currentTimeMillis());
    }

    @Override
    public String getPaymentType() {
        return "BANK_TRANSFER";
    }

}
