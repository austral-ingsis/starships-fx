package edu.austral.dissis.starships.collision;

import javafx.scene.shape.Shape;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CollisionEngine {
    @NotNull
    private static <T> T head(@NotNull List<T> list) {
        return list.get(0);
    }

    @NotNull
    private static <T> List<T> tail(List<T> list) {
        return list.subList(1, list.size());
    }

    @NotNull
    public <T extends Collider<T>> void checkCollisions(@NotNull List<T> colliders) {
        if (colliders.isEmpty()) return;

        checkCollisions(head(colliders), tail(colliders));
    }

    @NotNull
    private boolean testIntersection(@NotNull Shape shapeA, @NotNull Shape shapeB) {
        final boolean layoutIntersects = shapeA.getBoundsInParent().intersects(shapeB.getBoundsInParent());
        if (!layoutIntersects) return false;

        final Shape shapeIntersection = Shape.intersect(shapeA, shapeB);
        return !shapeIntersection.getLayoutBounds().isEmpty();
    }

    @NotNull
    private <T extends Collider<T>> void checkCollisions(@NotNull T current, @NotNull List<T> colliders) {
        if (colliders.isEmpty()) return;

        colliders
                .forEach(collider -> {
                    if (testIntersection(current.getShape(), collider.getShape())) {
                        current.handleCollisionWith(collider);
                        collider.handleCollisionWith(current);
                    }
                });

        checkCollisions(head(colliders), tail(colliders));
    }
}