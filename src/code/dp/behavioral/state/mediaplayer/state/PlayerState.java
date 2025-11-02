package code.dp.behavioral.state.mediaplayer.state;

import code.dp.behavioral.state.mediaplayer.PlayerContext;

public interface PlayerState {
    // State-specific behavior methods
    void switchToPlayingState(PlayerContext ctx);
    void switchToPausedState(PlayerContext ctx);
    void switchToStoppedState(PlayerContext ctx);

    String getCurrentState();
}
