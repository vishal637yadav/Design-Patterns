package code.dp.behavioral.state.trafficlight;

public class GreenState extends State {
    public GreenState() {
        super(TrafficLightState.GREEN.getDefaultDuration());
    }

    public GreenState(int duration) {
        super(duration);
    }

    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Light " + trafficLight.getId() + ": Green - GO");
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
        return TrafficLightState.GREEN;
    }
}
