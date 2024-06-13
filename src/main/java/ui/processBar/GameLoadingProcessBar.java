package ui.processBar;

import core.ui.components.ProcessBar;

import java.awt.*;

public class GameLoadingProcessBar extends ProcessBar {

    private int percent;

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        int centerPositionX = (int) (this.x + this.width * 0.5 - 80);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        String loadingText = "Loading.... ( " + percent + "% )";
        g.drawString(loadingText, centerPositionX, this.y - 20);
    }

    @Override
    public void update() {
        super.update();
        this.percent = (int) (((double) this.getValue() / this.getMaximum()) * 100);
    }
}
