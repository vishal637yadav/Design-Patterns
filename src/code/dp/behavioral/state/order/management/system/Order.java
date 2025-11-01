package code.dp.behavioral.state.order.management.system;

// Order.java - Context Class
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private String customerId;
    private List<OrderItem> items;
    private double totalAmount;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String trackingNumber;
    private OrderState currentState;
    private boolean paymentProcessed;
    private LocalDateTime returnWindowEnd;

    // Services (Dependency Injection)
    private PaymentService paymentService;
    private InventoryService inventoryService;
    private ShippingService shippingService;
    private NotificationService notificationService;

    public Order(String customerId, List<OrderItem> items, double totalAmount) {
        this.id = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.currentState = new PendingState();
        this.paymentProcessed = false;

        // Initialize services (In real app, these would be injected)
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    // State operations (delegated to current state)
    public void confirmPayment() {
        currentState.confirmPayment(this);
    }

    public void cancel() {
        currentState.cancelOrder(this);
    }

    public void ship() {
        currentState.shipOrder(this);
    }

    public void deliver() {
        currentState.deliverOrder(this);
    }

    public void initiateReturn() {
        currentState.returnOrder(this);
    }

    public void processRefund() {
        currentState.refund(this);
    }

    // State management
    public void setState(OrderState state) {
        this.currentState = state;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    // Business logic methods
    public boolean isPaymentValid() {
        // Simulate payment validation
        return paymentService.validatePayment(this);
    }

    public boolean wasPaymentProcessed() {
        return paymentProcessed;
    }

    public void markPaymentProcessed() {
        this.paymentProcessed = true;
    }

    public void startReturnWindow() {
        this.returnWindowEnd = LocalDateTime.now().plusDays(30); // 30-day return window
    }

    public boolean isReturnWindowOpen() {
        return returnWindowEnd != null && LocalDateTime.now().isBefore(returnWindowEnd);
    }

    // Getters and setters
    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public List<OrderItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public LocalDateTime getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDateTime deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    // Service getters
    public PaymentService getPaymentService() { return paymentService; }
    public InventoryService getInventoryService() { return inventoryService; }
    public ShippingService getShippingService() { return shippingService; }
    public NotificationService getNotificationService() { return notificationService; }

    // Display methods
    public void displayOrderInfo() {
        System.out.println("\n📋 ORDER INFORMATION");
        System.out.println("Order ID: " + id);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Current State: " + getCurrentStateName());
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Order Date: " + orderDate);
        if (trackingNumber != null) {
            System.out.println("Tracking Number: " + trackingNumber);
        }
        if (deliveryDate != null) {
            System.out.println("Delivery Date: " + deliveryDate);
        }
    }
}

// Supporting classes
class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters...
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTotalPrice() { return quantity * price; }
}

// Service classes (simplified implementations)
class PaymentService {
    public boolean validatePayment(Order order) {
        // Simulate payment validation
        System.out.println("🔍 Validating payment for Order: " + order.getId());
        return Math.random() > 0.1; // 90% success rate
    }

    public void initiateRefund(Order order) {
        System.out.println("💰 Initiating refund for Order: " + order.getId());
        // Process refund logic
    }

    public void processRefund(Order order) {
        System.out.println("✅ Refund processed for Order: " + order.getId());
        // Actual refund processing
    }
}

class InventoryService {
    public void releaseItems(List<OrderItem> items) {
        System.out.println("📦 Releasing inventory for " + items.size() + " items");
        // Release inventory logic
    }

    public void restockItems(List<OrderItem> items) {
        System.out.println("📥 Restocking " + items.size() + " returned items");
        // Restock inventory logic
    }
}

class ShippingService {
    public String createShipment(Order order) {
        String trackingNumber = "TRK" + System.currentTimeMillis();
        System.out.println("🚚 Created shipment with tracking: " + trackingNumber);
        return trackingNumber;
    }

    public void createReturnLabel(Order order) {
        System.out.println("🏷️ Generated return label for Order: " + order.getId());
        // Generate return shipping label
    }
}

class NotificationService {
    public void sendOrderConfirmation(Order order) {
        System.out.println("📧 Sending order confirmation email for: " + order.getId());
    }

    public void sendShippingNotification(Order order) {
        System.out.println("📧 Sending shipping notification for: " + order.getId());
    }

    public void sendDeliveryConfirmation(Order order) {
        System.out.println("📧 Sending delivery confirmation for: " + order.getId());
    }

    public void sendReturnInstructions(Order order) {
        System.out.println("📧 Sending return instructions for: " + order.getId());
    }

    public void sendRefundConfirmation(Order order) {
        System.out.println("📧 Sending refund confirmation for: " + order.getId());
    }
}

