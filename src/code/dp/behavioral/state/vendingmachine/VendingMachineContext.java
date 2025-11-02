package code.dp.behavioral.state.vendingmachine;

import code.dp.behavioral.state.vendingmachine.state.VendingMachineState;

public class VendingMachineContext {
    private VendingMachineState currentState;

    public VendingMachineContext(VendingMachineState initialState) {
        this.currentState = initialState;
    }

    public void setState(VendingMachineState state) {
        System.out.println("Machine State Transition :--->>>   " +currentState.getMachineState()+" --->> "+state.getMachineState());
        this.currentState = state;
    }

    public void request() {
        currentState.handleRequest(this);
    }
}
