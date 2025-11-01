package code.dp.behavioral.state.order.management.system;

// OrderState.java - Base State Class
public abstract class OrderState {
    protected String stateName;

    public OrderState(String stateName) {
        this.stateName = stateName;
    }

    // State-specific operations
    public abstract void confirmPayment(Order order);
    public abstract void cancelOrder(Order order);
    public abstract void shipOrder(Order order);
    public abstract void deliverOrder(Order order);
    public abstract void returnOrder(Order order);
    public abstract void refund(Order order);

    public String getStateName() { return stateName; }

    protected void logStateTransition(String orderId, String from, String to) {
        System.out.println("📦 Order " + orderId + ": " + from + " → " + to);
    }
}

/*
// ConfirmedState.java
public class ConfirmedState extends OrderState {
    public ConfirmedState() {
        super("CONFIRMED");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("ℹ️ Payment already confirmed for Order: " + order.getId());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("🚫 Cancelling confirmed order: " + order.getId());
        logStateTransition(order.getId(), "CONFIRMED", "CANCELLED");
        order.setState(new CancelledState());

        // Initiate refund process
        order.getPaymentService().initiateRefund(order);
        order.getInventoryService().releaseItems(order.getItems());
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("📦 Shipping order: " + order.getId());
        logStateTransition(order.getId(), "CONFIRMED", "SHIPPED");
        order.setState(new ShippedState());

        // Generate tracking number
        String trackingNumber = order.getShippingService().createShipment(order);
        order.setTrackingNumber(trackingNumber);

        // Send shipping notification
        order.getNotificationService().sendShippingNotification(order);
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Cannot deliver order that hasn't been shipped.");
    }

    @Override
    public void returnOrder(Order order) {
        System.out.println("❌ Cannot return order that hasn't been delivered.");
    }

    @Override
    public void refund(Order order) {
        cancelOrder(order); // Cancelling confirmed order triggers refund
    }
}

// ShippedState.java
public class ShippedState extends OrderState {
    public ShippedState() {
        super("SHIPPED");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("ℹ️ Payment already processed for shipped order.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("⚠️ Cannot cancel shipped order. Contact customer service.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("ℹ️ Order already shipped: " + order.getId());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("✅ Order delivered: " + order.getId());
        logStateTransition(order.getId(), "SHIPPED", "DELIVERED");
        order.setState(new DeliveredState());
        order.setDeliveryDate(LocalDateTime.now());

        // Send delivery confirmation
        order.getNotificationService().sendDeliveryConfirmation(order);

        // Start return window
        order.startReturnWindow();
    }

    @Override
    public void returnOrder(Order order) {
        System.out.println("❌ Cannot return order that hasn't been delivered.");
    }

    @Override
    public void refund(Order order) {
        System.out.println("❌ Cannot refund shipped order. Wait for delivery.");
    }
}

// DeliveredState.java
public class DeliveredState extends OrderState {
    public DeliveredState() {
        super("DELIVERED");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("ℹ️ Payment completed for delivered order.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("❌ Cannot cancel delivered order. Use return process.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("ℹ️ Order already delivered.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("ℹ️ Order already delivered: " + order.getId());
    }

    @Override
    public void returnOrder(Order order) {
        if (order.isReturnWindowOpen()) {
            System.out.println("🔄 Processing return for Order: " + order.getId());
            logStateTransition(order.getId(), "DELIVERED", "RETURNED");
            order.setState(new ReturnedState());

            // Generate return shipping label
            order.getShippingService().createReturnLabel(order);
            order.getNotificationService().sendReturnInstructions(order);
        } else {
            System.out.println("❌ Return window closed for Order: " + order.getId());
        }
    }

    @Override
    public void refund(Order order) {
        returnOrder(order); // Return process includes refund
    }
}

// ReturnedState.java
public class ReturnedState extends OrderState {
    public ReturnedState() {
        super("RETURNED");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("ℹ️ Processing refund for returned order.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("ℹ️ Order already in return process.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("❌ Cannot ship returned order.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Cannot deliver returned order.");
    }

    @Override
    public void returnOrder(Order order) {
        System.out.println("ℹ️ Order already in return process.");
    }

    @Override
    public void refund(Order order) {
        System.out.println("💰 Processing refund for Order: " + order.getId());
        logStateTransition(order.getId(), "RETURNED", "REFUNDED");
        order.setState(new RefundedState());

        // Process refund
        order.getPaymentService().processRefund(order);
        order.getInventoryService().restockItems(order.getItems());

        // Send refund confirmation
        order.getNotificationService().sendRefundConfirmation(order);
    }
}

// CancelledState.java & RefundedState.java (Terminal states)
public class CancelledState extends OrderState {
    public CancelledState() {
        super("CANCELLED");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("❌ Cannot confirm payment for cancelled order.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("ℹ️ Order already cancelled.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("❌ Cannot ship cancelled order.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Cannot deliver cancelled order.");
    }

    @Override
    public void returnOrder(Order order) {
        System.out.println("❌ Cannot return cancelled order.");
    }

    @Override
    public void refund(Order order) {
        if (order.wasPaymentProcessed()) {
            System.out.println("💰 Processing refund for cancelled order.");
            order.getPaymentService().processRefund(order);
        } else {
            System.out.println("ℹ️ No payment to refund for cancelled order.");
        }
    }
}
*/
