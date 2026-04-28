package com.sourcecode.spring.dp.state.order.state;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemEnum {
    LAPTOP("Laptop", 75000),
    SMARTPHONE("Smartphone", 45000),
    HEADPHONES("Headphones", 2500),
    KEYBOARD("Keyboard", 1500),
    MONITOR("Monitor", 12000);

    private final String name;
    private final double price;
}
