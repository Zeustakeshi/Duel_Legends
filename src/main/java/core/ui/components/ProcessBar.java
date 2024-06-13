package core.ui.components;

import core.ui.GameUI;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Getter
@Setter
public class ProcessBar extends GameUI {

    @Setter(AccessLevel.PROTECTED)
    protected int value;
    protected int maximum;
    protected int minimum;
    protected int step;
    protected boolean done;

    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PROTECTED)
    protected boolean isStart;


    public ProcessBar() {
        this.isStart = false;
        this.maximum = 100;
        this.minimum = 0;
        this.value = 0;
        this.step = 100;
        this.done = false;
        this.height = 10;
    }

    public ProcessBar(int minimum, int maximum) {
        this.isStart = false;
        this.minimum = minimum;
        this.maximum = maximum;
        this.value = minimum;
        this.step = 100;
        this.done = false;
        this.height = 10;
    }

    public void start() {
        this.isStart = true;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(this.x, this.y, this.width, this.height);

        g.setColor(Color.GREEN);


        int x = (this.width * this.value) / step;

        g.fillRect(this.x, this.y, x, this.height);
    }


    @Override
    public void update() {
        if (!isStart) return;
        this.value += this.maximum / this.step;

        if (value >= maximum) done = true;

        this.value = Math.min(this.value, this.maximum);
        this.value = Math.max(this.value, this.minimum);
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
