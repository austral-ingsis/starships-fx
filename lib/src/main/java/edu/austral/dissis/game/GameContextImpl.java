package edu.austral.dissis.game;

import org.jetbrains.annotations.NotNull;

public class GameContextImpl implements GameContext {
    @NotNull
    private final KeyTracker keyTracker;

    public GameContextImpl(@NotNull KeyTracker keyTracker) {
        this.keyTracker = keyTracker;
    }

    @Override
    public @NotNull KeyTracker getKeyTracker() {
        return keyTracker;
    }
}
