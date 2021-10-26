package edu.austral.dissis.game;

import org.jetbrains.annotations.NotNull;

public class WindowSettings {
    private final static int DEFAULT_WIDTH = 640;
    private final static int DEFAULT_HEIGHT = 480;
    private final static boolean DEFAULT_FULLSCREEN = false;

    @NotNull
    private final String title;

    private final int width;
    private final int height;
    private final boolean fullscreen;

    public WindowSettings(@NotNull String title, int width, int height, boolean fullscreen) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public WindowSettings withTitle(@NotNull String title) {
        return new WindowSettings(title, width, height, fullscreen);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @NotNull
    public WindowSettings withSize(int width, int height) {
        return new WindowSettings(title, width, height, fullscreen);
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    @NotNull
    public WindowSettings withFullscreen(boolean fullscreen) {
        return new WindowSettings(title, width, height, fullscreen);
    }

    @NotNull
    public static WindowSettings fromTitle(@NotNull String title) {
        return new WindowSettings(title, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_FULLSCREEN);
    }
}
