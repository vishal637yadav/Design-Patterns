package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("NEW") // Use a qualifier to easily inject this specific state
public class NewOrderState implements OrderState {

    @Override
    public void processPayment(OrderContext order) {
        log.info("Processing payment for new order: {}", order.getId());
        // Transition to the next state
        order.setCurrentState(new PaidOrderState());
    }

    @Override
    public void ship(OrderContext order) {
        throw new IllegalStateException("Cannot Ship a New Order!!");
    }

    @Override
    public void deliver(OrderContext order) {
        throw new IllegalStateException("Cannot deliver a New Order!!");
    }

    @Override
    public void cancel(OrderContext order) {
        log.info("Cancelling new order: {}", order.getId());
        order.setCurrentState(new CancelledOrderState());
    }
}
