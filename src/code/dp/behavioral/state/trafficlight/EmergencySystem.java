package code.dp.behavioral.state.trafficlight;

public class EmergencySystem implements Observer{

    private boolean emergencyDetected;

    @Override
    public void update(TrafficLight trafficLight, State state) {
        if (state.getStateType() == TrafficLightState.RED) {
            checkForEmergencyVehicles(trafficLight.getId());
        }

        // Monitor for emergency conditions
        monitorEmergencyConditions(trafficLight, state);
    }

    private void checkForEmergencyVehicles(String lightId) {
        // Implementation for emergency vehicle detection
        System.out.println("Checking for emergency vehicles at " + lightId);
    }

    private void monitorEmergencyConditions(TrafficLight trafficLight, State state) {
        // Monitor for system failures, unusual patterns, etc.
    }

    public boolean isEmergencyDetected() {
        return emergencyDetected;
    }

}
