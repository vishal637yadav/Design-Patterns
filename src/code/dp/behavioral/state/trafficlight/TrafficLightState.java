package code.dp.behavioral.state.trafficlight;

public enum TrafficLightState {
    RED("RED",30),
    YELLOW("YELLOW",5),
    GREEN("GREEN",25);

    private final String name;
    private final int defaultDuration;

    TrafficLightState(String name, int defaultDuration) {
        this.name = name;
        this.defaultDuration = defaultDuration;
    }

    public String getName() {
        return name;
    }

    public int getDefaultDuration() {
        return defaultDuration;
    }
}
