package edu.austral.dissis.vector;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.*;

public class Vector2 {
    private final float x;
    private final float y;

    private Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getAngle() {
        return (float) (atan2(y, x) - atan2(0, 1));
    }

    public float getModule() {
        return (float) Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @NotNull
    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    @NotNull
    public Vector2 subtract(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    @NotNull
    public Vector2 multiply(Float scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    @NotNull
    public Vector2 rotate(float angle) {
        return new Vector2((float) (x * cos(angle) - y * sin(angle)), (float) (x * sin(angle) + y * cos(angle)));
    }

    @NotNull
    public Vector2 asUnitary() {
        final float module = getModule();
        return new Vector2(x / module, y / module);
    }

    @NotNull
    public static Vector2 vector(float x, float y) {
        return new Vector2(x, y);
    }

    @NotNull
    public static Vector2 vectorFromModule(float module, float angle) {
        return new Vector2((float) (module * cos(angle)), (float) (module * sin(angle)));
    }
}
