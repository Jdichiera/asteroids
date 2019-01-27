package com.asteroids.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public abstract class GameObject {
    private float x;
    private float y;

    private Circle bounds;

    public GameObject(float boundsRadius) {
        bounds = new Circle(x, y, boundsRadius);
    }

    // Use the passed renderer to draw the game object bounds circle
    public void drawDebug(ShapeRenderer renderer) {
        renderer.x(bounds.x, bounds.y, 0.1f);
        renderer.circle(bounds.x, bounds.y, bounds.radius);
    }

    // Set the game objects position at X and Y
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        updateBounds();
    }

    // When the game object moves, the bounds should move with it.
    public void updateBounds() {
        bounds.setPosition(x, y);
    }

    public Circle getBounds() {
        return bounds;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
        updateBounds();
    }

    public void setY(float y) {
        this.y = y;
        updateBounds();
    }
}
