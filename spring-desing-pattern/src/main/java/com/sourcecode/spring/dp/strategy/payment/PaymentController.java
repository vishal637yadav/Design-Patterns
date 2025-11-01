package com.sourcecode.spring.dp.strategy.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process/{paymentType}")
    public ResponseEntity<PaymentResult> processPayment(
            @PathVariable String paymentType,
            @RequestBody PaymentRequest request) {

        try {
            PaymentResult result = paymentService.processPayment(paymentType, request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/methods")
    public ResponseEntity<List<String>> getSupportedMethods() {
        return ResponseEntity.ok(paymentService.getSupportedPaymentMethods());
    }

}
