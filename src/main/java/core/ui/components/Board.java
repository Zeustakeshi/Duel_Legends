package core.ui.components;

import core.ui.GameUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Board extends GameUI {

    private final BufferedImage image;

    public Board(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }

    @Override
    public void update() {

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
