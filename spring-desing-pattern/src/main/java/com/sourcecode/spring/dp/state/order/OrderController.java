package com.sourcecode.spring.dp.state.order;

import com.sourcecode.spring.dp.state.order.state.ItemEnum;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // Log Message Constants
    private static final String ORDER_ID = "Order ID: ";
    private static final String INFO_LOG_MESSAGE = "ORDER_ID + \"{}\" + ORDER_STATE + \"{}\" !!";

    private final OrderService orderService;

    @Operation(
            summary = "Order Creation : By Selecting Items",
            description = "Available Items : LAPTOP, SMARTPHONE, HEADPHONES, KEYBOARD, MONITOR"
    )
    @PostMapping
    public ResponseEntity<OrderContext> createOrder(@RequestBody List<ItemEnum> items) {
        OrderContext order = orderService.createOrder(items);
        return ResponseEntity.ok(order);
    }

    @PutMapping("billGeneration/{orderId}")
    public ResponseEntity<OrderContext> generationBill(@PathVariable String orderId) {
        OrderContext order = orderService.generateBill(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PutMapping("paymentProcessing/{orderId}")
    public ResponseEntity<OrderContext> paymentProcessing(@PathVariable String orderId) {
        OrderContext order = orderService.paymentProcessing(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    //orderDelivery
    @PutMapping("orderDelivery/{orderId}")
    public ResponseEntity<OrderContext> orderDelivery(@PathVariable String orderId) {
        OrderContext order = orderService.deliverOrder(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderContext> getOrderStatus(@PathVariable String orderId) {
        OrderContext order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        log.info("Order Details :{}", order.toString());
        return ResponseEntity.ok(order);
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllOrders() {
        List<String> allOrders = orderService.getAllOrders();
        if (allOrders == null) {
            return ResponseEntity.notFound().build();
        }
        log.info("Order Details :{}", allOrders.toString());
        return ResponseEntity.ok(allOrders);
    }

    @PostMapping("/{id}/ship")
    public ResponseEntity<String> shipOrder(@PathVariable String id) {
        try {
            OrderContext order = orderService.shipOrder(id);
            log.info(INFO_LOG_MESSAGE, order.getOrderId(), order.getState());
            return ResponseEntity.ok("Order shipped. New state: " + order.getState());
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
