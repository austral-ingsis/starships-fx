package edu.austral.dissis.starships.game;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class KeyTracker {
    @NotNull private Optional<Scene> maybeScene = Optional.empty();
    @NotNull private final Set<KeyCode> keySet = new HashSet<>();

    public void init(@NotNull Scene scene) {
        this.maybeScene = Optional.of(scene);

        scene.setOnKeyPressed(this::handleKeyPressed);
        scene.setOnKeyReleased(this::handleKeyReleased);
    }

    public void dispose() {
        maybeScene.ifPresent(scene -> {
            scene.removeEventHandler(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
            scene.removeEventHandler(KeyEvent.KEY_RELEASED, this::handleKeyReleased);
        });
    }

    @NotNull
    public Set<KeyCode> getKeySet() {
        return keySet;
    }

    private void handleKeyPressed(KeyEvent event) {
        keySet.add(event.getCode());
    }

    private void handleKeyReleased(KeyEvent event) {
        keySet.remove(event.getCode());
    }
}
