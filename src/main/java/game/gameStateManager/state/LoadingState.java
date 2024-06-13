package game.gameStateManager.state;

import core.ui.components.ProcessBar;
import game.gameStateManager.GameState;
import game.gameStateManager.GameStateManager;
import ui.processBar.GameLoadingProcessBar;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static constant.GameConstant.GAME_HEIGHT;
import static constant.GameConstant.GAME_WIDTH;

public class LoadingState implements BaseState {

    private final BufferedImage backgroundImage;
    private final ProcessBar loadingProcessBar;


    public LoadingState() {
        this.loadingProcessBar = new GameLoadingProcessBar();
        this.loadingProcessBar.setWidth((int) (GAME_WIDTH * 0.8));
        this.loadingProcessBar.setX((int) (GAME_WIDTH * 0.5 - this.loadingProcessBar.getWidth() * 0.5));
        this.loadingProcessBar.setY(GAME_HEIGHT - 50);
        this.backgroundImage = LoadSave.loadImage("backgrounds/loading_background.png");
    }


    @Override
    public void update() {
        loadingProcessBar.update();

        if (loadingProcessBar.isDone()) {
            GameStateManager.setState(GameState.MENU);
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.backgroundImage, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        loadingProcessBar.draw(g);
    }

    @Override
    public void onMounted() {
        loadingProcessBar.start();
    }

    @Override
    public void onUnmounted() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
