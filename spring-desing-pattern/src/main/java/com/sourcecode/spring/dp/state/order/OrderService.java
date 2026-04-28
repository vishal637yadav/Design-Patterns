package com.sourcecode.spring.dp.state.order;

import com.sourcecode.spring.dp.state.order.state.ItemEnum;
import com.sourcecode.spring.dp.state.order.state.OrderState;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {
    //Primary initial state for new orders
    private final OrderState initialOrderState;

    // Using an in-memory map as a mock database
    private Map<String, OrderContext> orderStore;

    @PostConstruct
    void init() {
        orderStore = new ConcurrentHashMap<>();
    }

    // The service methods delegate the action to the context object
    public OrderContext createOrder(List<ItemEnum> items) {
        OrderContext newOrder = initialOrderState.orderCreation(items);
        log.info("Order Created Object :::> {}", newOrder);
        orderStore.put(newOrder.getOrderId(), newOrder);
        log.info("Created new order with ID: {} and State: {}", newOrder.getOrderId(), newOrder.getState());
        return newOrder;
    }

    public OrderContext generateBill(String orderId) {
        OrderContext order = orderStore.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        order.billGeneration(order);
        log.info("Bill Generation Completed Successfully !!");
        return order;
    }

    public OrderContext paymentProcessing(String orderId) {
        OrderContext order = orderStore.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        order.paymentProcessing(order);
        log.info("Payment Processing Completed Successfully !!");
        return order;
    }

    public OrderContext shipOrder(String orderId) {
        OrderContext order = orderStore.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        //order.startShipping();
        log.info("Order Shipping Completed Successfully !!");
        return order;
    }

    public OrderContext deliverOrder(String orderId) {
        OrderContext order = orderStore.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        order.orderDelivery(order);
        log.info("Order Delivery Completed Successfully !!");
        return order;
    }

    public OrderContext cancelOrder(String orderId) {
        OrderContext order = orderStore.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        //order.startCancellation();
        log.info("Order Cancellation Completed Successfully !!");
        return order;
    }

    public OrderContext getOrderById(String orderId) {
        return orderStore.get(orderId);
    }

    public List<String> getAllOrders() {
        log.info("orderStore Content ::-->>{}", orderStore);
        return orderStore.entrySet().stream().map(m -> m.getKey() + " :-->> " + m.getValue()).toList();
    }

}
