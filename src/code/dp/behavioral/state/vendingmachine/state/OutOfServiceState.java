package code.dp.behavioral.state.vendingmachine.state;

import code.dp.behavioral.state.vendingmachine.VendingMachineContext;

public class OutOfServiceState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachineContext context) {
        System.out.println("Machine is out of service. Please try again later.");
        throw new IllegalStateException("Machine is out of service.");
    }

    @Override
    public MachineStates getMachineState() {
        return MachineStates.OUT_OF_SERVICE;
    }
}
