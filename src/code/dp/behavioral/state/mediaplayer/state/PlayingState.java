package code.dp.behavioral.state.mediaplayer.state;

import code.dp.behavioral.state.mediaplayer.PlayerContext;

public class PlayingState implements PlayerState {

    @Override
    public void switchToPlayingState(PlayerContext ctx) {
        System.out.println("Already in playing state.");
        throw new IllegalStateException("Already in playing state.");
    }

    @Override
    public void switchToPausedState(PlayerContext ctx) {
        System.out.println("Pausing playback...");
        ctx.setState(new PausedState());
    }

    @Override
    public void switchToStoppedState(PlayerContext ctx) {
        System.out.println("Stopping playback...");
        ctx.setState(new StoppedState());
    }

    @Override
    public String getCurrentState() {
        return "Playing";
    }

}
