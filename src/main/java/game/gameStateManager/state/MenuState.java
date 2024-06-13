package game.gameStateManager.state;

import core.ui.components.Board;
import ui.board.MenuBoard;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static constant.GameConstant.GAME_HEIGHT;
import static constant.GameConstant.GAME_WIDTH;

public class MenuState implements BaseState {
    private final BufferedImage backgroundImage;
    private final Board menuBoard;


    public MenuState() {
        this.backgroundImage = LoadSave.loadImage("backgrounds/menu_background.jpg");
        this.menuBoard = new MenuBoard();

        int menuBoardX = (int) (GAME_WIDTH * 0.5 - this.menuBoard.getWidth() * 0.5);
        int menuBoardY = (int) (GAME_HEIGHT * 0.5 - this.menuBoard.getHeight() * 0.5);

        menuBoard.setX(menuBoardX);
        menuBoard.setY(menuBoardY);
    }


    @Override
    public void update() {
        menuBoard.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.backgroundImage, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        menuBoard.draw(g);
    }

    @Override
    public void onMounted() {
        menuBoard.onMounted();
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
        this.menuBoard.mouseClicked(e);
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
