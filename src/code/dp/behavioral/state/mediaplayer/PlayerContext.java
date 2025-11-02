package code.dp.behavioral.state.mediaplayer;

import code.dp.behavioral.state.mediaplayer.state.PlayerState;
import code.dp.behavioral.state.mediaplayer.state.StoppedState;

public class PlayerContext {
    private PlayerState state;

    public PlayerContext() {
        this.state = new StoppedState();
    }

    public void setState(PlayerState newState) {
        System.out.println("Transition: " + this.state.getCurrentState() + " -> " + newState.getCurrentState());
        this.state = newState;
    }

    public void play() {
        state.switchToPlayingState(this);
    }

    public void pause() {
        state.switchToPausedState(this);
    }

    public void stop() {
        state.switchToStoppedState(this);
    }

    public String getStateName() {
        return state.getCurrentState();
    }
}
