package code.dp.behavioral.state;

public class Context {

    private State currentState;
    private String data;

    public Context(State initialState) {
        this.currentState = initialState;
        this.data = "";
    }

    public void setState(State state) {
        System.out.println("Changing state from " +
                (currentState != null ? currentState.getStateName() : "null") +
                " to " + state.getStateName());
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
