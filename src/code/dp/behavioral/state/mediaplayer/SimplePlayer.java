package code.dp.behavioral.state.mediaplayer;

public class SimplePlayer {
    enum State {PLAY, PAUSE, STOP}

    State state = State.STOP;

    public void play() {
        switch (state) {
            case STOP -> state = State.PLAY;
            case PAUSE -> state = State.PLAY;
            case PLAY -> System.out.println("Already playing.");
        }
    }

    public void pause() {
        switch (state) {
            case PLAY -> state = State.PAUSE;
            case STOP, PAUSE -> System.out.println("Cannot pause now.");
        }
    }

    public void stop() {
        switch (state) {
            case PLAY, PAUSE -> state = State.STOP;
            case STOP -> System.out.println("Already stopped.");
        }
    }

}
