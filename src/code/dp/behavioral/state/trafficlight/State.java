package code.dp.behavioral.state.trafficlight;

public abstract class State {
    protected int duration;

    public State(int duration) {
        this.duration = duration;
    }

    public abstract void handle(TrafficLight trafficLight);
    public abstract TrafficLightState getStateType();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
