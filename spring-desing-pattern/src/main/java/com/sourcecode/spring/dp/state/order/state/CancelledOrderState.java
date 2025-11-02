package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("CANCELLED")
public class CancelledOrderState implements OrderState {
    @Override
    public void processPayment(OrderContext order) {
        log.info("Order {} has already been paid.",order.getId());
        throw new IllegalStateException("Cannot process payment for a cancelled order.");
    }

    @Override
    public void ship(OrderContext order) {
        log.info("Order {} has already been paid.",order.getId());

    }

    @Override
    public void deliver(OrderContext order) {
        log.info("Order {} has already been paid.",order.getId());

    }

    @Override
    public void cancel(OrderContext order) {
        log.info("Order {} has already been paid.",order.getId());

    }
}
