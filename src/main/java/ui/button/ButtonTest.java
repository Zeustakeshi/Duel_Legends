package ui.button;

import character.buu.Buu;
import character.pawn.Pawn;
import core.ui.components.Button;
import game.gameStateManager.GameState;
import game.gameStateManager.GameStateManager;
import utils.LoadSave;

import java.awt.event.MouseEvent;

public class ButtonTest extends Button {

    public ButtonTest() {
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
        GameStateManager.setPlayer1Character(new Buu());
        GameStateManager.setPlayer2Character(new Pawn());
        GameStateManager.setState(GameState.PLAYING);
    }
}
