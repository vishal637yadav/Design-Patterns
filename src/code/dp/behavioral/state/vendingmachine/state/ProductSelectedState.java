package code.dp.behavioral.state.vendingmachine.state;

import code.dp.behavioral.state.vendingmachine.VendingMachineContext;

public class ProductSelectedState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachineContext context) {
        System.out.println("Product selected. Awaiting payment...");
        // Transition to PaymentPendingState
        context.setState(new PaymentPendingState());
    }

    @Override
    public MachineStates getMachineState() {
        return MachineStates.PRODUCT_SELECTED;
    }
}
