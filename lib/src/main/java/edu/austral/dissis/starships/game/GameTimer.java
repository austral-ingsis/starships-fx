package edu.austral.dissis.starships.game;

import javafx.animation.AnimationTimer;

public abstract class GameTimer extends AnimationTimer {

    private double lastTimeInSeconds = 0;

    @Override
    public void handle(long now) {
        final double nowSeconds = (((double) now) / 1_000_000_000d);
        final double secondsSinceLastFrame = lastTimeInSeconds == 0 ? 0 : nowSeconds - lastTimeInSeconds;

        lastTimeInSeconds = nowSeconds;

        nextFrame(secondsSinceLastFrame);
    }

    public abstract void nextFrame(double secondsSinceLastFrame);
}
