package com.sourcecode.spring.dp.state.order.state;

import com.sourcecode.spring.dp.state.order.OrderContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Primary
public class OrderCreationState extends AbstractOrderState {


    public OrderCreationState(OrderStateResolver orderStateResolver, ObjectProvider<OrderContext> createOrderContextProvider) {
        super(orderStateResolver, createOrderContextProvider);
    }

    @Override
    public OrderContext orderCreation(List<ItemEnum> items) {
        log.info("Order Creation is in progress for items:{}", items.toArray());
        // Each call to createOrderContext() returns a brand-new instance of OrderContext
        OrderContext newOrder = createOrderContextProvider.getObject();
        newOrder.setItems(items);
        newOrder.setState(this);
        log.info("newOrder Object :::> {}", newOrder);
        return newOrder;
    }

    @Override
    public void billGeneration(OrderContext order) {
        log.info("Order Bill Generation is in Progress...........");
        order.setBilledAmount(
                order.getItems().stream().mapToInt(itemEnum -> (int) itemEnum.getPrice()).sum()
        );
        log.info("Order Bill Generation Completed Successfully !!");
        order.nextStateTransition(orderStateResolver.resolveOrderState(OrderStateEnum.PENDING_PAYMENT));
    }

    @Override
    public OrderStateEnum getState() {
        return OrderStateEnum.CREATED;
    }

}
