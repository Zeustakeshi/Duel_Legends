package game;

import game.gameStateManager.GameState;
import game.gameStateManager.GameStateManager;

import javax.swing.*;

public class GameWindow extends JFrame {


    public GameWindow() {
        GamePanel gamePanel = new GamePanel();
        this.setTitle("Duel Legends");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        gamePanel.requestFocus();

        // Initial game state
        GameStateManager.setState(GameState.LOADING);

    }
}
