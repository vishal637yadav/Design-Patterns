package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("shippedOrderState")
public class ShippedOrderState implements OrderState {

    @Override
    public void processPayment(OrderContext order) {
        log.info("Order {} has already been paid.",order.getId());

    }

    @Override
    public void ship(OrderContext order) {
        log.info("Order {} has been paid and will be shipped.",order.getId());
        order.setCurrentState(new DeliveredOrderState());

    }

    @Override
    public void deliver(OrderContext order) {
        throw new IllegalStateException("Cannot deliver an order that has not been shipped.");
    }

    @Override
    public void cancel(OrderContext order) {
        throw new IllegalStateException("Cannot cancel an order that has not been shipped.");
    }
}
