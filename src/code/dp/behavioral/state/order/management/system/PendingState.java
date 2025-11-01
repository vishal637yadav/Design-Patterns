package code.dp.behavioral.state.order.management.system;

public class PendingState extends OrderState {
    public PendingState() {
        super("PENDING");
    }

    @Override
    public void confirmPayment(Order order) {
        if (order.isPaymentValid()) {
            System.out.println("💳 Payment confirmed for Order: " + order.getId());
            logStateTransition(order.getId(), "PENDING", "CONFIRMED");
            //order.setState(new ConfirmedState());

            // Send confirmation email
            order.getNotificationService().sendOrderConfirmation(order);
        } else {
            System.out.println("❌ Payment failed for Order: " + order.getId());
            logStateTransition(order.getId(), "PENDING", "CANCELLED");
            //order.setState(new CancelledState());
        }
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("🚫 Order cancelled: " + order.getId());
        logStateTransition(order.getId(), "PENDING", "CANCELLED");
        //order.setState(new CancelledState());

        // Release inventory
        order.getInventoryService().releaseItems(order.getItems());
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("❌ Cannot ship pending order. Payment required first.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Cannot deliver pending order.");
    }

    @Override
    public void returnOrder(Order order) {
        System.out.println("❌ Cannot return pending order.");
    }

    @Override
    public void refund(Order order) {
        System.out.println("❌ Cannot refund pending order.");
    }
}
