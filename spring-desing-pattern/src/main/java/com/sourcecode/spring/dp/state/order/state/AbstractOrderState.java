package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public abstract class AbstractOrderState implements OrderState {

    protected final OrderStateResolver orderStateResolver;
    protected final ObjectProvider<OrderContext> createOrderContextProvider;

    @Override
    public OrderContext orderCreation(List<ItemEnum> items) {
        log.info("Order is currently in {} state and Order Creation not supported in {} State", this.getState(), this.getState());
        throw new IllegalStateException("Order is currently in " + this.getState() + " state and Order Creation not supported in " + this.getState() + " State");
    }

    @Override
    public void billGeneration(OrderContext order) {
        log.info("Order is currently in {} state and Order Bill Generation not supported in {} State", order.getState(), order.getState());
        throw new IllegalStateException("Order is currently in " + order.getState() + " state and Order Bill Generation not supported in " + order.getState() + " State");
    }

    @Override
    public void paymentProcessing(OrderContext order) {
        log.info("Order is currently in {} state and Order Payment Processing not supported in {} State", order.getState(), order.getState());
        throw new IllegalStateException("Order is currently in " + order.getState() + " state and Order Payment Processing not supported in " + order.getState() + " State");
    }

    @Override
    public void orderDelivery(OrderContext order) {
        log.info("Order is currently in {} state and Order Delivery not supported in {} State", order.getState(), order.getState());
        throw new IllegalStateException("Order is currently in " + order.getState() + " state and Order Delivery not supported in " + order.getState() + " State");
    }

    @Override
    public String toString() {
        return getState().toString();
    }

}
