package ui.button;

import core.ui.components.Button;
import utils.LoadSave;

import java.awt.event.MouseEvent;

public class ButtonMenuOptions extends Button {
    public ButtonMenuOptions() {
        super(LoadSave.loadImage("buttons/button_atlas.png"));
        this.frameX = 0;
        this.frameY = 1;
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
        System.out.println("Show menu options");
    }
}
