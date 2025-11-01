package code.dp.behavioral.state.trafficlight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight {
    private String id;
    private State currentState;
    private boolean isActive;
    private List<Observer> observers;
    private final ReentrantLock lock;
    private Thread lightThread;

    public TrafficLight(String id) {
        this.id = id;
        this.currentState = new RedState();
        this.isActive = false;
        this.observers = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void setState(State state) {
        lock.lock();
        try {
            this.currentState = state;
            notifyObservers();
        } finally {
            lock.unlock();
        }
    }

    public State getCurrentState() {
        lock.lock();
        try {
            return currentState;
        } finally {
            lock.unlock();
        }
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void activate() {
        this.isActive = true;
        startCycle();
        System.out.println("Traffic Light " + id + " activated");
    }

    public void deactivate() {
        this.isActive = false;
        if (lightThread != null && !lightThread.isInterrupted()) {
            lightThread.interrupt();
        }
        System.out.println("Traffic Light " + id + " deactivated");
    }

    private void startCycle() {
        lightThread = new Thread(this::runCycle);
        lightThread.setDaemon(true);
        lightThread.start();
    }

    private void runCycle() {
        while (isActive && !Thread.currentThread().isInterrupted()) {
            try {
                currentState.handle(this);
            } catch (Exception e) {
                System.err.println("Error in traffic light cycle: " + e.getMessage());
                // Fail-safe: set to RED state
                setState(new RedState());
            }
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            try {
                observer.update(this, currentState);
            } catch (Exception e) {
                System.err.println("Error notifying observer: " + e.getMessage());
            }
        }
    }

    // Emergency override - force to RED state
    public void emergencyStop() {
        lock.lock();
        try {
            setState(new RedState());
            System.out.println("EMERGENCY: Traffic Light " + id + " forced to RED");
        } finally {
            lock.unlock();
        }
    }

    // Set custom duration for current state
    public void setStateDuration(int duration) {
        lock.lock();
        try {
            currentState.setDuration(duration);
        } finally {
            lock.unlock();
        }
    }
}
