package code.dp.behavioral.state.vendingmachine.state;

import code.dp.behavioral.state.vendingmachine.VendingMachineContext;

public class PaymentPendingState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachineContext context) {
        System.out.println("Payment pending. Please insert payment.");
        // Simulate payment received
        System.out.println("Payment received.");
        // Transition to DispensingProductState
        context.setState(new DispensingProductState());
    }

    @Override
    public MachineStates getMachineState() {
        return MachineStates.PAYMENT_PENDING;
    }
}
