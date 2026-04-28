package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderShippingState extends AbstractOrderState {

    public OrderShippingState(OrderStateResolver orderStateResolver, ObjectProvider<OrderContext> createOrderContextProvider) {
        super(orderStateResolver, createOrderContextProvider);
    }

    @Override
    public void orderDelivery(OrderContext order){
        log.info("Order Delivery is in Progress...........");
        log.info("Order Delivery Completed Successfully !!");
        order.nextStateTransition(orderStateResolver.resolveOrderState(OrderStateEnum.DELIVERED));
    }

    @Override
    public OrderStateEnum getState() {
        return OrderStateEnum.SHIPPED;
    }

}
