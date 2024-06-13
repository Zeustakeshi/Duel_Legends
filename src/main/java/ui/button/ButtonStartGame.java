package ui.button;

import core.ui.components.Button;
import game.gameStateManager.GameState;
import game.gameStateManager.GameStateManager;
import utils.LoadSave;

import java.awt.event.MouseEvent;

public class ButtonStartGame extends Button {

    public ButtonStartGame() {
        super(LoadSave.loadImage("buttons/button_atlas.png"));
        this.frameX = 0;
        this.frameY = 0;
        this.width = 140;
        this.height = 56;
        this.imageWidth = 140;
        this.imageHeight = 56;
        this.colliderBox.setX(this.x);
        this.colliderBox.setY(this.y);
        this.colliderBox.setWidth(this.width);
        this.colliderBox.setHeight(this.height);
    }


    @Override
    public void onClick(MouseEvent e) {
        GameStateManager.setState(GameState.CHOOSE_CHARACTER);
    }
}
