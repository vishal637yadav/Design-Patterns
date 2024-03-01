package code.dp.behavioral.mediator;

public interface Airplane {

    void requestTakeoff();

    void requestLanding();

    void notifyAirTrafficControl(String message);
}

