package ui.board;

import core.ui.components.Board;
import core.ui.components.Button;
import ui.button.ButtonMenuOptions;
import ui.button.ButtonMenuQuit;
import ui.button.ButtonStartGame;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuBoard extends Board {

    private final Map<MenuOption, Button> buttons;

    public MenuBoard() {
        super(LoadSave.loadImage("boards/menu_board.png"));
        this.width = 282;
        this.height = 336;

        this.buttons = new LinkedHashMap<>();
        this.buttons.put(MenuOption.START_GAME, new ButtonStartGame());
        this.buttons.put(MenuOption.OPTIONS, new ButtonMenuOptions());
        this.buttons.put(MenuOption.QUIT, new ButtonMenuQuit());
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        for (Button button : buttons.values()) {
            button.draw(g);
        }

    }

    @Override
    public void update() {
        super.update();

        for (Button button : buttons.values()) {
            button.update();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        for (Button button : buttons.values()) {
            if (button.getColliderBox().isContainMouse(e.getX(), e.getY())) {
                button.onClick(e);
            }
        }
    }

    @Override
    public void onMounted() {
        super.onMounted();

        int offsetY = 110;
        int gap = 10;


        for (Button button : buttons.values()) {
            int buttonX = (int) (this.getX() + this.getWidth() * 0.5 - button.getWidth() * 0.5);
            int buttonY = this.getY() + offsetY;

            button.setX(buttonX);
            button.setY(buttonY);
            offsetY += button.getHeight() + gap;
        }

    }

    private enum MenuOption {
        START_GAME,
        OPTIONS,
        QUIT,
    }


}
