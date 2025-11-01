package code.dp.behavioral.state.trafficlight;

public class LightStatus {
    private String currentState;
    private boolean isActive;
    private int duration;

    public LightStatus(String currentState, boolean isActive, int duration) {
        this.currentState = currentState;
        this.isActive = isActive;
        this.duration = duration;
    }

    // Getters
    public String getCurrentState() { return currentState; }
    public boolean isActive() { return isActive; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return String.format("State: %s, Active: %s, Duration: %ds",
                currentState, isActive, duration);
    }

}
