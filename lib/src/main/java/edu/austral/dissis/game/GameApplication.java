package edu.austral.dissis.game;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public abstract class GameApplication extends Application implements RootSetter {
    private Optional<Scene> maybeScene = Optional.empty();
    private final KeyTracker keyTracker = new KeyTracker();

    @Override
    public void start(Stage stage) {
        final GameContext context = new GameContextImpl(keyTracker);
        final WindowSettings settings = setupWindow();
        final Parent pane = initRoot(context);

        final Scene scene = loadSettingsAndCreateScene(settings, stage, pane);
        maybeScene = Optional.of(scene);

        keyTracker.init(scene);
        stage.setScene(scene);
        pane.requestFocus();

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        keyTracker.dispose();
    }

    private Scene loadSettingsAndCreateScene(@NotNull WindowSettings settings, @NotNull Stage stage, @NotNull Parent pane) {
        stage.setTitle(settings.getTitle());

        if (settings.isFullscreen()) {
            stage.setFullScreen(true);
            return new Scene(pane);
        } else {
            return new Scene(pane, settings.getWidth(), settings.getHeight());
        }
    }

    @NotNull
    public abstract WindowSettings setupWindow();

    public abstract Parent initRoot(@NotNull GameContext context);

    public void setRoot(@NotNull Parent parent) {
        maybeScene.ifPresent(scene -> scene.setRoot(parent));
    }
}
