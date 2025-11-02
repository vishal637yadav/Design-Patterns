package code.dp.behavioral.state.mediaplayer.state;

import code.dp.behavioral.state.mediaplayer.PlayerContext;

public class PausedState implements PlayerState {

    @Override
    public void switchToPlayingState(PlayerContext ctx) {
        System.out.println("Resuming playback...");
        ctx.setState(new PlayingState());
    }

    @Override
    public void switchToPausedState(PlayerContext ctx) {
        System.out.println("Already in paused state.");
        throw new IllegalStateException("Cannot pause media as it is Already in PausedState!!");
    }

    @Override
    public void switchToStoppedState(PlayerContext ctx) {
        System.out.println("Stopping from paused...");
        ctx.setState(new StoppedState());
    }

    @Override
    public String getCurrentState() {
        return "Paused";
    }

}
