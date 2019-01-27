package com.asteroids.screen;

import com.asteroids.config.DifficultyLevel;
import com.asteroids.config.GameConfig;
import com.asteroids.entity.Player;
import com.badlogic.gdx.utils.Logger;

public class GameController {
    private static final Logger log = new Logger(GameController.class.getName(), Logger.DEBUG);

    // == Attributes / fields
    private Player player;
    private DifficultyLevel difficultyLevel = DifficultyLevel.NORMAL;

    // == Constructor ==
    public GameController() {
        init();
    }

    // == Init ==
    private void init() {
        player = new Player();

        float playerStartX = GameConfig.WORLD_WIDTH / 2;
        float playerStartY = GameConfig.WORLD_HEIGHT / 2;

        player.setPosition(playerStartX, playerStartY);
    }
    // == Public Methods
    public Player getPlayer() {
        return player;
    }
    // == Private Methods
}
