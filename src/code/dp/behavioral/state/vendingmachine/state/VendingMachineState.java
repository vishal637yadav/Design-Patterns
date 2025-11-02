package code.dp.behavioral.state.vendingmachine.state;

import code.dp.behavioral.state.vendingmachine.VendingMachineContext;

public interface VendingMachineState {
    enum MachineStates {
        READY,
        PRODUCT_SELECTED,
        PAYMENT_PENDING,
        DISPENSING_PRODUCT,
        OUT_OF_SERVICE
    }

    void handleRequest(VendingMachineContext context);

    MachineStates getMachineState();
}
