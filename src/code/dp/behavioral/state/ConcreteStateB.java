package code.dp.behavioral.state;

public class ConcreteStateB implements State {

    @Override
    public void handle(Context context) {
        System.out.println("Handling request in State B");
        context.setData("Processed by State B");

        // Transition back to State A
        context.setState(new ConcreteStateA());
    }

    @Override
    public String getStateName() {
        return "State B";
    }
}
