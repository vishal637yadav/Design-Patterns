package com.sourcecode.spring.dp.strategy.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStrategyFactory strategyFactory;

    public PaymentResult processPayment(String paymentType, PaymentRequest request) {
        PaymentStrategy strategy = strategyFactory.getStrategy(paymentType);
        return strategy.processPayment(request);
    }

    public List<String> getSupportedPaymentMethods() {
        return new ArrayList<>(strategyFactory.getAvailablePaymentTypes());
    }

}
