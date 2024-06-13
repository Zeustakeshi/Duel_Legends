package core.ui.components;

import core.ui.GameUI;
import game.gameStateManager.GameStateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Button extends GameUI {

    private final BufferedImage image;

    public Button(BufferedImage image) {
        this.image = image;
        this.width = 140;
        this.height = 56;
        this.frameX = 0;
        this.frameY = 0;
    }

    public void draw(Graphics g) {
        BufferedImage subImage = this.image.getSubimage(
                this.imageWidth * this.frameX,
                this.imageHeight * this.frameY,
                this.imageWidth,
                this.imageHeight
        );


        g.drawImage(
                subImage,
                this.x,
                this.y,
                this.width,
                this.height,
                null
        );
        if (GameStateManager.isDebugger()) {
            this.colliderBox.draw(g, Color.PINK);
        }

    }

    public void setWidth(int width) {
        this.width = width;
        this.colliderBox.setWidth(width);
    }

    public void setHeight(int height) {
        this.height = height;
        this.colliderBox.setHeight(height);
    }

    public void setX(int x) {
        this.x = x;
        this.colliderBox.setX(x);
    }

    public void setY(int y) {
        this.y = y;
        this.colliderBox.setY(y);
    }

    public void update() {

    }


    public abstract void onClick(MouseEvent e);


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
        onClick(e);
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
