package code.dp.behavioral.state.trafficlight;

import java.util.Map;

public class SystemStatus {

    private boolean systemRunning;
    private boolean emergencyMode;
    private Map<String, LightStatus> lights;

    public SystemStatus(boolean systemRunning, boolean emergencyMode,
                        Map<String, LightStatus> lights) {
        this.systemRunning = systemRunning;
        this.emergencyMode = emergencyMode;
        this.lights = lights;
    }

    // Getters
    public boolean isSystemRunning() { return systemRunning; }
    public boolean isEmergencyMode() { return emergencyMode; }
    public Map<String, LightStatus> getLights() { return lights; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SYSTEM STATUS ===\n");
        sb.append("System Running: ").append(systemRunning).append("\n");
        sb.append("Emergency Mode: ").append(emergencyMode).append("\n");
        sb.append("Traffic Lights:\n");

        for (Map.Entry<String, LightStatus> entry : lights.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ")
                    .append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

}
