package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;

import java.util.List;

/*
    Order Processing System State Interface
    Defines the methods for state transitions in the order processing lifecycle.
 */
public interface OrderState {

    // Order Placed :  CREATED State
    OrderContext orderCreation(List<ItemEnum> items);

    // State Transition : From CREATED ---to--> PENDING_PAYMENT State
    void billGeneration(OrderContext order);

    // Order State : Changes from PENDING_PAYMENT ---to--> SHIPPED State
    void paymentProcessing(OrderContext order);

    // Order State : Changes from SHIPPED ---to--> DELIVERED State
    void orderDelivery(OrderContext order);

    // Method to get the current state of the order
    OrderStateEnum getState();

}
