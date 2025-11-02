package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
/*
------------------------------------------------------------------------------------------------------------------------
--- Order State Interface ---
Defines the actions that can be performed on an order in different states.
------------------------------------------------------------------------------------------------------------------------
    1. item selection -> itemSelection
    2. processing payment -> paymentProcessing
    3. shiping item -> shipping
    4. deliver item -> deliver
    5. cancel order -> cancel
------------------------------------------------------------------------------------------------------------------------
 */
public interface OrderState {
    void processPayment(OrderContext order);
    void ship(OrderContext order);
    void deliver(OrderContext order);
    void cancel(OrderContext order);

}
