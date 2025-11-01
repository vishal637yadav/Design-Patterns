package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("PAID") // Use a qualifier to easily inject this specific state
public class PaidOrderState implements OrderState {

    @Override
    public void processPayment(OrderContext order) {
        log.info("Order {} has already been paid.",order.getId());
    }

    @Override
    public void ship(OrderContext order) {
        log.info("Shipping paid order: " + order.getId());
        order.setCurrentState(new ShippedOrderState());
    }

    @Override
    public void deliver(OrderContext order) {
        throw new IllegalStateException("Cannot deliver an order that has not been shipped.");
    }

    @Override
    public void cancel(OrderContext order) {
        // In a real app, this would trigger a refund process.
        throw new IllegalStateException("Cannot cancel a paid order directly. Please process a refund.");
    }

}
