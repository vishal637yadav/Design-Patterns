package code.dp.behavioral.state.mediaplayer.state;

import code.dp.behavioral.state.mediaplayer.PlayerContext;

public class StoppedState implements PlayerState {

    @Override
    public void switchToPlayingState(PlayerContext ctx) {
        System.out.println("Starting playback...");
        ctx.setState(new PlayingState());
    }

    @Override
    public void switchToPausedState(PlayerContext ctx) {
        System.out.println("Cannot pause. Media is stopped.");
        throw new IllegalStateException("Cannot pause media as it is Stopped!!");
    }

    @Override
    public void switchToStoppedState(PlayerContext ctx) {
        System.out.println("Media is already stopped.");
        throw new IllegalStateException("Cannot stop media as it is already Stopped!!");
    }

    @Override
    public String getCurrentState() {
        return "Stopped";
    }

}
