package code.dp.behavioral.state;

public interface State {
    void handle(Context context);
    String getStateName();
}

