package com.sourcecode.spring.dp.state.order.state;

public enum OrderStateEnum {
    CREATED,
    PENDING_PAYMENT,
    SHIPPED,
    DELIVERED,
    CANCELED,
    REFUNDED
}
