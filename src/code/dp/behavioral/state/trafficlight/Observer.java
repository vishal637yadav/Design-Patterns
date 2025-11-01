package code.dp.behavioral.state.trafficlight;

public interface Observer {
    void update(TrafficLight trafficLight, State state);
}
