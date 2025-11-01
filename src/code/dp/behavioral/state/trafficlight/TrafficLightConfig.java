package code.dp.behavioral.state.trafficlight;

import java.util.HashMap;
import java.util.Map;

public class TrafficLightConfig {

    private Map<TrafficLightState, Integer> stateDurations;
    private Map<String, IntersectionConfig> intersectionConfigs;

    public TrafficLightConfig() {
        this.stateDurations = new HashMap<>();
        this.intersectionConfigs = new HashMap<>();

        // Set default durations
        stateDurations.put(TrafficLightState.RED, 30);
        stateDurations.put(TrafficLightState.YELLOW, 5);
        stateDurations.put(TrafficLightState.GREEN, 25);
    }

    public void setStateDuration(TrafficLightState state, int duration) {
        if (duration > 0) {
            stateDurations.put(state, duration);
        }
    }

    public int getStateDuration(TrafficLightState state) {
        return stateDurations.getOrDefault(state, 30);
    }

    public void addIntersectionConfig(String intersectionId, IntersectionConfig config) {
        intersectionConfigs.put(intersectionId, config);
    }

    public IntersectionConfig getIntersectionConfig(String intersectionId) {
        return intersectionConfigs.get(intersectionId);
    }

    // Inner class for intersection-specific configuration
    public static class IntersectionConfig {
        private Map<String, Integer> directionDurations;
        private boolean adaptiveTiming;
        private int peakHourMultiplier;

        public IntersectionConfig() {
            this.directionDurations = new HashMap<>();
            this.adaptiveTiming = false;
            this.peakHourMultiplier = 1;
        }

        public void setDirectionDuration(String direction, int duration) {
            directionDurations.put(direction, duration);
        }

        public int getDirectionDuration(String direction) {
            return directionDurations.getOrDefault(direction, 30);
        }

        public void setAdaptiveTiming(boolean adaptive) {
            this.adaptiveTiming = adaptive;
        }

        public boolean isAdaptiveTiming() {
            return adaptiveTiming;
        }

        public void setPeakHourMultiplier(int multiplier) {
            this.peakHourMultiplier = multiplier;
        }

        public int getPeakHourMultiplier() {
            return peakHourMultiplier;
        }
    }

}
