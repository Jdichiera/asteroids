package com.asteroids.screen;

import com.asteroids.config.GameConfig;
import com.asteroids.entity.Player;
import com.asteroids.util.GdxUtils;
import com.asteroids.util.ViewportUtils;
import com.asteroids.util.debug.DebugCameraController;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameRenderer implements Disposable {
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;

    GameController controller;

    private DebugCameraController debugCameraController;

    public GameRenderer() {
        init();
    }

    private void init() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        controller = new GameController();

        // Debug camera
        debugCameraController = new DebugCameraController();
        debugCameraController.setStartPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);
    }

    public void render(float delta) {
        debugCameraController.handleDebugInput(delta);
        debugCameraController.applyTo(camera);

        GdxUtils.clearScreen();

        // Render the debug items
        renderDebug();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    // == UI ==

    // == Debug ==
    private void renderDebug() {
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        drawDebug();

        renderer.end();

        // This happens outside of the regular render since begin and end rendering
        // happen inside of drawGrid.
        ViewportUtils.drawGrid(viewport, renderer);
    }

    private void drawDebug() {
        Player player = controller.getPlayer();
        player.drawDebug(renderer);

    }

    // == Clean up ==
    @Override
    public void dispose() {
        renderer.dispose();
    }
}
