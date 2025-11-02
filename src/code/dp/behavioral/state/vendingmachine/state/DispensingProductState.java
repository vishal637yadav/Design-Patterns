package code.dp.behavioral.state.vendingmachine.state;

import code.dp.behavioral.state.vendingmachine.VendingMachineContext;

public class DispensingProductState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachineContext context) {
        System.out.println("Dispensing product...");
        // Simulate product dispensed
        System.out.println("Product dispensed. Thank you!");
        // Transition back to ReadyState
        context.setState(new ReadyState());
    }

    @Override
    public MachineStates getMachineState() {
        return MachineStates.DISPENSING_PRODUCT;
    }
}
