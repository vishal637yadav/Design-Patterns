package com.sourcecode.spring.dp.strategy;

import com.sourcecode.spring.dp.strategy.payment.PaymentRequest;
import com.sourcecode.spring.dp.strategy.payment.PaymentResult;
import com.sourcecode.spring.dp.strategy.payment.PaymentStrategy;
import com.sourcecode.spring.dp.strategy.payment.PaymentStrategyFactory;
import com.sourcecode.spring.dp.strategy.payment.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentStrategyFactory strategyFactory;

    @Mock
    private PaymentStrategy mockStrategy;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    void processPayment() {
    }

    @Test
    void getSupportedPaymentMethods() {

    }

    @Test
    void shouldProcessPaymentSuccessfully() {
        // Given
        PaymentRequest request = new PaymentRequest(BigDecimal.valueOf(100), "USD");
        PaymentResult expectedResult = new PaymentResult("SUCCESS", "TXN-123");

        when(strategyFactory.getStrategy("CREDIT_CARD")).thenReturn(mockStrategy);
        when(mockStrategy.processPayment(request)).thenReturn(expectedResult);

        // When
        PaymentResult result = paymentService.processPayment("CREDIT_CARD", request);

        // Then
        assertThat(result.getStatus()).isEqualTo("SUCCESS");
        assertThat(result.getTransactionId()).isEqualTo("TXN-123");
    }
}