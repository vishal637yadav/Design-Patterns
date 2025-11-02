package code.dp.behavioral.state.vendingmachine.state;

import code.dp.behavioral.state.vendingmachine.VendingMachineContext;

public class ReadyState implements VendingMachineState {

    @Override
    public void handleRequest(VendingMachineContext context) {
        System.out.println("Waiting for product selection...");
        // Transition to ProductSelectedState
        context.setState(new ProductSelectedState());
    }

    @Override
    public MachineStates getMachineState() {
        return MachineStates.READY;
    }

}
