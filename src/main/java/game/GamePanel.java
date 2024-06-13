package game;

import game.gameStateManager.GameStateManager;
import game.inputs.KeyboardInput;
import game.inputs.MouseInput;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static constant.GameConstant.*;

@Getter
public class GamePanel extends JPanel implements Runnable {

    private static final double NANOSECONDS_IN_SECOND = 1_000_000_000.0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        KeyListener keyboardInput = new KeyboardInput();
        MouseInput mouseInput = new MouseInput();
        this.addKeyListener(keyboardInput);
        this.addMouseListener(mouseInput);
        this.addMouseMotionListener(mouseInput);

        startGameLoop();
    }


    private void update() {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().update();
        }
    }

    private void draw(Graphics g) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().draw(g);
        }
    }

    @Override
    public void run() {
        double nanoTime = NANOSECONDS_IN_SECOND;
        double timePerFrame = nanoTime / FPS_SET;
        double timePerUpdate = nanoTime / UPS_SET;
        long lastCheck = System.currentTimeMillis();

        long previousTime = System.nanoTime();

        double deltaUpdate = 0;
        double deltaFrame = 0;

        while (true) {

            long currentTime = System.nanoTime();
            deltaUpdate += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaUpdate >= 1) {
                this.update();
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                this.repaint();
                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
            }

        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }


    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }


}
