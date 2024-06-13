package core.ui;

import core.colliderBox.ColliderBox;
import core.event.GameEvent;
import lombok.Data;

import java.awt.*;

@Data
public abstract class GameUI implements GameEvent {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int imageWidth;
    protected int imageHeight;
    protected int frameX;
    protected int frameY;
    protected ColliderBox colliderBox;


    public GameUI() {
        this.x = 10;
        this.y = 10;
        this.width = 100;
        this.height = 100;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.frameX = 0;
        this.frameY = 0;
        this.colliderBox = new ColliderBox(this.x, this.y, this.width, this.height);
    }

    public abstract void draw(Graphics g);

    public abstract void update();
}
