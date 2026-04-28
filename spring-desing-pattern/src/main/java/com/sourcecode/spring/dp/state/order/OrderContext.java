package com.sourcecode.spring.dp.state.order;

import com.sourcecode.spring.dp.state.order.state.ItemEnum;
import com.sourcecode.spring.dp.state.order.state.OrderState;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Data
@Component
@Scope("prototype")
public class OrderContext {
    //Order Attributes
    private String orderId;
    private List<ItemEnum> items;
    private double billedAmount;

    private OrderState state;

    public OrderContext(List<ItemEnum> items, OrderState state) {
        this.items = items;
        this.state = state;
        this.orderId = UUID.randomUUID().toString();
    }

    public void generateOrderBilledAmount() {
    }

    public void nextStateTransition(OrderState newOrderState) {
        log.debug("-----OrderContext State Transition ::::  {} ===-->>> {} ", state.getState(), newOrderState.getState());
        this.state = newOrderState;
    }

    //Delegate actions to the current state object ---

    // State Transition : From CREATED ---to--> PENDING_PAYMENT State
    void billGeneration(OrderContext order) {
        state.billGeneration(this);
    }

    // Order State : Changes from PENDING_PAYMENT ---to--> SHIPPED State
    void paymentProcessing(OrderContext order) {
        state.paymentProcessing(this);
    }

    // Order State : Changes from SHIPPED ---to--> DELIVERED State
    void orderDelivery(OrderContext order) {
        state.orderDelivery(this);
    }

}
