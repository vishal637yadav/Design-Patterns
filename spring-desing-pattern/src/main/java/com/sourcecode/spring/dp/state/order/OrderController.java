package com.sourcecode.spring.dp.state.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder() {
        OrderContext order = orderService.createOrder();
        return ResponseEntity.ok("Order created with ID: " + order.getId() + ", Current State: " + order.getCurrentStateName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderStatus(@PathVariable Long id) {
        OrderContext order = orderService.getOrder(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Order ID: " + order.getId() + ", Current State: " + order.getCurrentStateName());
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<String> payOrder(@PathVariable Long id) {
        try {
            OrderContext order = orderService.processPayment(id);
            return ResponseEntity.ok("Payment processed. New state: " + order.getCurrentStateName());
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/ship")
    public ResponseEntity<String> shipOrder(@PathVariable Long id) {
        try {
            OrderContext order = orderService.shipOrder(id);
            return ResponseEntity.ok("Order shipped. New state: " + order.getCurrentStateName());
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
