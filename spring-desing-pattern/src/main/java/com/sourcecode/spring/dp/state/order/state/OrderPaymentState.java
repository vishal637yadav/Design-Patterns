package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderPaymentState extends AbstractOrderState{

    public OrderPaymentState(OrderStateResolver orderStateResolver, ObjectProvider<OrderContext> createOrderContextProvider) {
        super(orderStateResolver, createOrderContextProvider);
    }

    @Override
    public void paymentProcessing(OrderContext order) {
        log.info("Order payment is in Progress...........");
        log.info("Order payment Completed Successfully !!");
        order.nextStateTransition(orderStateResolver.resolveOrderState(OrderStateEnum.SHIPPED));
    }

    @Override
    public OrderStateEnum getState() {
        return OrderStateEnum.PENDING_PAYMENT;
    }

}
