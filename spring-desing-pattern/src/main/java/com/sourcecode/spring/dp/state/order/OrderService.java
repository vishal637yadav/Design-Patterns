package com.sourcecode.spring.dp.state.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class OrderService {

    // Using an in-memory map as a mock database
    private final Map<Long, OrderContext> orderRepository = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    public OrderContext createOrder() {
        OrderContext order = new OrderContext(nextId);
        orderRepository.put(nextId, order);
        nextId++;
        log.info("Created new order with ID: {} and State: {}", order.getId(), order.getCurrentStateName());
        return order;
    }

    public OrderContext getOrder(Long id) {
        return orderRepository.get(id);
    }

    // The service methods delegate the action to the context object
    public OrderContext processPayment(Long id) {
        OrderContext order = getOrder(id);
        order.processPayment();
        log.info("After payment, Order ID: {}, New State: {}", order.getId(), order.getCurrentStateName());
        return order;
    }

    public OrderContext shipOrder(Long id) {
        OrderContext order = getOrder(id);
        order.ship();
        log.info("After shipping, Order ID: {}, New State: {}", order.getId(), order.getCurrentStateName());
        return order;
    }
}
