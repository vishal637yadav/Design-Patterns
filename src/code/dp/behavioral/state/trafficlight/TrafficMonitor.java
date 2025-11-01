package code.dp.behavioral.state.trafficlight;

public class TrafficMonitor implements Observer{

    private String monitorId;

    public TrafficMonitor(String monitorId) {
        this.monitorId = monitorId;
    }

    @Override
    public void update(TrafficLight trafficLight, State state) {
        System.out.println("Monitor [" + monitorId + "]: Light " +
                trafficLight.getId() + " changed to " +
                state.getStateType().getName());

        // Log to database, send alerts, etc.
        logStateChange(trafficLight.getId(), state.getStateType());
    }

    private void logStateChange(String lightId, TrafficLightState state) {
        // Implementation for logging
        System.out.println("Logging: " + lightId + " -> " + state.getName() +
                " at " + java.time.LocalDateTime.now());
    }

}
