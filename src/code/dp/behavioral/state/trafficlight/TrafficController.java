package code.dp.behavioral.state.trafficlight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficController {

    private Map<String, TrafficLight> trafficLights;
    private boolean isEmergency;
    private boolean systemRunning;
    private TrafficLightConfig config;

    public TrafficController() {
        this.trafficLights = new ConcurrentHashMap<>();
        this.isEmergency = false;
        this.systemRunning = false;
        this.config = new TrafficLightConfig();
    }

    public TrafficLight addTrafficLight(String lightId) {
        TrafficLight light = new TrafficLight(lightId);
        trafficLights.put(lightId, light);
        System.out.println("Added traffic light: " + lightId);
        return light;
    }

    public void removeTrafficLight(String lightId) {
        TrafficLight light = trafficLights.get(lightId);
        if (light != null) {
            light.deactivate();
            trafficLights.remove(lightId);
            System.out.println("Removed traffic light: " + lightId);
        }
    }

    public void startSystem() {
        systemRunning = true;
        for (TrafficLight light : trafficLights.values()) {
            light.activate();
        }
        System.out.println("=== TRAFFIC LIGHT SYSTEM STARTED ===");
    }

    public void stopSystem() {
        systemRunning = false;
        for (TrafficLight light : trafficLights.values()) {
            light.deactivate();
        }
        System.out.println("=== TRAFFIC LIGHT SYSTEM STOPPED ===");
    }

    public void emergencyOverride(String lightId) {
        isEmergency = true;
        if (lightId != null && trafficLights.containsKey(lightId)) {
            // Override specific light
            TrafficLight light = trafficLights.get(lightId);
            light.emergencyStop();
        } else {
            // Override all lights
            for (TrafficLight light : trafficLights.values()) {
                light.emergencyStop();
            }
        }
        System.out.println("🚨 EMERGENCY OVERRIDE ACTIVATED 🚨");
    }

    public void emergencyOverride() {
        emergencyOverride(null); // Override all lights
    }

    public void resetEmergency() {
        isEmergency = false;
        System.out.println("Emergency override deactivated - Normal operation resumed");
    }

    public SystemStatus getSystemStatus() {
        Map<String, LightStatus> lightStatuses = new HashMap<>();

        for (Map.Entry<String, TrafficLight> entry : trafficLights.entrySet()) {
            TrafficLight light = entry.getValue();
            LightStatus status = new LightStatus(
                    light.getCurrentState().getStateType().getName(),
                    light.isActive(),
                    light.getCurrentState().getDuration()
            );
            lightStatuses.put(entry.getKey(), status);
        }

        return new SystemStatus(systemRunning, isEmergency, lightStatuses);
    }

    public TrafficLight getTrafficLight(String lightId) {
        return trafficLights.get(lightId);
    }

    public void setStateDuration(String lightId, TrafficLightState state, int duration) {
        TrafficLight light = trafficLights.get(lightId);
        if (light != null) {
            // This would require enhancement to set future state durations
            config.setStateDuration(state, duration);
        }
    }
}
