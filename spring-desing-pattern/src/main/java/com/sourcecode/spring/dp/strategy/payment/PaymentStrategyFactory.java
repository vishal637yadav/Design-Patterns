package com.sourcecode.spring.dp.strategy.payment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentStrategyFactory {
    private final Map<String, PaymentStrategy> strategies;

    public PaymentStrategyFactory(List<PaymentStrategy> strategyList) {
        System.out.println("Initializing PaymentStrategyFactory with strategies--: " + strategyList);
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        PaymentStrategy::getPaymentType,
                        Function.identity()
                ));
        System.out.println("Registered Payment Strategies: " + strategies.keySet());

    }

    public PaymentStrategy getStrategy(String paymentType) {
        PaymentStrategy strategy = strategies.get(paymentType.toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
        return strategy;
    }

    public Set<String> getAvailablePaymentTypes() {
        return strategies.keySet();
    }

}


