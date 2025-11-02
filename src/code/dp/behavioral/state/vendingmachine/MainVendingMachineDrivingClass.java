package code.dp.behavioral.state.vendingmachine;

import code.dp.behavioral.state.vendingmachine.state.ReadyState;

public class MainVendingMachineDrivingClass {

    public static void main(String[] args) {
        VendingMachineContext vendingMachine = new VendingMachineContext(new ReadyState());

        vendingMachine.request(); // From Idle to HasMoney
        vendingMachine.request(); // From HasMoney to Dispensing
        vendingMachine.request(); // From Dispensing to Idle
        vendingMachine.request(); // Dispensing product again to Ready


    }
}
