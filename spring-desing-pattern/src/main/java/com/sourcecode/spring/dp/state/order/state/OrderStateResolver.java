package com.sourcecode.spring.dp.state.order.state;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
@Component
public class OrderStateResolver {
    private final Map<OrderStateEnum, OrderState> orderStateMap = new EnumMap<>(OrderStateEnum.class);

    // Initialize the map with available OrderState implementations
    public OrderStateResolver(ApplicationContext context) {
        // Collect all strategies and index by enum key
        context.getBeansOfType(OrderState.class).values()
                .forEach(s -> orderStateMap.put(s.getState(), s));
        log.info("------Content of orderStateMap ::-->> {}", orderStateMap);
    }

    public OrderState resolveOrderState(OrderStateEnum orderStateEnum) {
        OrderState s = orderStateMap.get(orderStateEnum);
        if (s == null) throw new IllegalArgumentException("Unsupported Order State :-:=>> " + orderStateEnum);
        return s;
    }

}