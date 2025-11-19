package com.example.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-08 16:21
 */
@Component
public class GameRunner {
//    private MarioGame game;
//
//    public GameRunner(MarioGame game) {
//        this.game = game;
//    }
//    TankGame game = new TankGame();
//    public GameRunner(TankGame game) {
//        this.game = game;
//    }

    @Autowired
    private GamingConsole game;

    public GameRunner(GamingConsole console) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.right();
        game.down();
        game.left();
    }
}
