package edu.austral.dissis.starships.collision;

import javafx.scene.shape.Shape;
import org.jetbrains.annotations.NotNull;

public interface Collider<T extends Collider<T>> {
    @NotNull Shape getShape();

    void handleCollisionWith(@NotNull T collider);
}
