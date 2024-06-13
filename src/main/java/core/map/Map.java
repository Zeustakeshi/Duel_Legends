package core.map;

import constant.GameConstant;
import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;

@Data
public abstract class Map {
    private BufferedImage image;
    private int width;

    private int height;


    public Map(BufferedImage image) {
        this.image = image;
        this.width = GameConstant.GAME_WIDTH;
        this.height = GameConstant.GAME_HEIGHT;

    }

    public void draw(Graphics g) {
        g.drawImage(this.image, 0, 0, this.width, this.height, null);
    }

    public void update() {

    }


}
