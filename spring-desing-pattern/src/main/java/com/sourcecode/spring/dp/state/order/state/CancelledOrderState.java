package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;

public class CancelledOrderState implements OrderState {
    @Override
    public void processPayment(OrderContext order) {

    }

    @Override
    public void ship(OrderContext order) {

    }

    @Override
    public void deliver(OrderContext order) {

    }

    @Override
    public void cancel(OrderContext order) {

    }
}
