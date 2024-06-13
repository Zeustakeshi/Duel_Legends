package game.gameStateManager.state;

import core.ui.components.Button;
import ui.button.ButtonTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ChooseCharacterState implements BaseState {

    private final Button testButton;

    public ChooseCharacterState() {

        testButton = new ButtonTest();

    }
    
    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawString("Choose character ....", 100, 100);
        testButton.draw(g);
    }

    @Override
    public void onMounted() {

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

        if (testButton.getColliderBox().isContainMouse(e.getX(), e.getY())) {
            testButton.onClick(e);
        }

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
