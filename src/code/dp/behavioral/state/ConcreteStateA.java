package code.dp.behavioral.state;

public class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling request in State A");
        context.setData("Processed by State A");

        // Transition to State B
        context.setState(new ConcreteStateB());
    }

    @Override
    public String getStateName() {
        return "State A";
    }
}
