package edu.austral.dissis.starships.vector;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.*;

public class Vector2 {
    private final double x;
    private final double y;

    private Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getAngle() {
        return atan2(y, x) - atan2(0, 1);
    }

    public double getModule() {
        return Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
    }

    public double getX() {
        return x;
    }

    public double getY() {
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
    public Vector2 multiply(double scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    @NotNull
    public Vector2 rotate(double angle) {
        return new Vector2((double) (x * cos(angle) - y * sin(angle)), (double) (x * sin(angle) + y * cos(angle)));
    }

    @NotNull
    public Vector2 asUnitary() {
        final double module = getModule();
        return new Vector2(x / module, y / module);
    }

    @NotNull
    public static Vector2 vector(double x, double y) {
        return new Vector2(x, y);
    }

    @NotNull
    public static Vector2 vectorFromModule(double module, double angle) {
        return new Vector2((double) (module * cos(angle)), (double) (module * sin(angle)));
    }
}
