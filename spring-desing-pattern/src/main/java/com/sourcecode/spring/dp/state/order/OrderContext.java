package com.sourcecode.spring.dp.state.order;

import com.sourcecode.spring.dp.state.order.state.NewOrderState;
import com.sourcecode.spring.dp.state.order.state.OrderState;
import lombok.Data;

@Data
public class OrderContext {
    private Long id;
    private OrderState currentState;

    public OrderContext(Long id) {
        this.id = id;
        // A new order always starts in the 'New' state.
        this.currentState = new NewOrderState();
    }

    // --- Delegate actions to the current state object ---
    public void processPayment() {
        currentState.processPayment(this);
    }

    public void ship() {
        currentState.ship(this);
    }

    public void deliver() {
        currentState.deliver(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public String getCurrentStateName() {
        return currentState.getClass().getSimpleName();
    }
}
