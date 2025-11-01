package code.dp.behavioral.state.trafficlight;

public class RedState extends State {
    public RedState() {
        super(TrafficLightState.RED.getDefaultDuration());
    }

    public RedState(int duration) {
        super(duration);
    }

    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Light " + trafficLight.getId() + ": RED - STOP");
        try {
            Thread.sleep(duration * 1000); // Convert to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (trafficLight.isActive()) {
            trafficLight.setState(new GreenState());
        }
    }

    @Override
    public TrafficLightState getStateType() {
        return TrafficLightState.RED;
    }
}
