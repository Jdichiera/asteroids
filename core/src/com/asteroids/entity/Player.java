package com.asteroids.entity;

public class Player extends GameObject{
    private static final float BOUNDS_RADIUS = 0.4f;
    private static final float SIZE = 2 * BOUNDS_RADIUS;

    public Player() {
        super(BOUNDS_RADIUS);
    }

    public void update() {
        updateBounds();
    }

    public float getWidth() {
        return SIZE;
    }
}
