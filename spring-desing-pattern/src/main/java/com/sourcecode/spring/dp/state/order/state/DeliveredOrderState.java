package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("delivered")
public class DeliveredOrderState implements OrderState {
    @Override
    public void processPayment(OrderContext order) {
        log.info("Order {} has been already paid.", order.getId());
        throw new IllegalStateException("Cannot Deliver a New Order!!");
    }

    @Override
    public void ship(OrderContext order) {
        log.info("Order: {}, Current-State: {}, so operation is not supported.", order.getId(), order.getCurrentStateName());
        throw new IllegalStateException("Cannot Deliver a CurrentState:"+order.getCurrentState()+" Order!!");
    }

    @Override
    public void deliver(OrderContext order) {
        log.info("Order {} has been paid and will be delivered.", order.getId());
        order.setCurrentState(new CancelledOrderState());
    }

    @Override
    public void cancel(OrderContext order) {
        log.info("Cancelling the {} State order: {}", order.getCurrentState(), order.getId());
        order.setCurrentState(new CancelledOrderState());
    }
}
