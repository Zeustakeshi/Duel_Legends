package ui.healthBar;

import core.ui.GameUI;
import lombok.Getter;
import lombok.Setter;
import utils.LoadSave;
import utils.ObjectDirection;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

@Getter
@Setter
public class HealthBar extends GameUI {

    private BufferedImage image;
    private int maximumHealth;
    private int maximumEnergy;
    private int health;
    private int energy;
    private ObjectDirection direction;


    public HealthBar() {
        this.image = LoadSave.loadImage("health/health_power_bar.png");
        this.imageWidth = 192;
        this.imageHeight = 58;
        this.width = 192;
        this.height = 58;
        this.direction = ObjectDirection.LEFT;
    }

    public HealthBar(int maximumHealth, int maximumEnergy) {
        this.maximumHealth = maximumHealth;
        this.maximumEnergy = maximumEnergy;
        this.health = maximumHealth;
        this.energy = maximumEnergy;
        this.image = LoadSave.loadImage("health/health_power_bar.png");
        this.imageWidth = 192;
        this.imageHeight = 58;
        this.width = 192;
        this.height = 58;
        this.direction = ObjectDirection.LEFT;
    }

    public void flip(ObjectDirection direction) {
        if (this.direction == direction) return;
        this.setX(this.x + this.getWidth());
        this.setWidth(this.getWidth() * -1);
        this.direction = direction;
    }


    @Override
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


        int offsetHealthX = 32;
        int offsetHealthY = 15;


        int healthValue = (this.health / this.maximumHealth) * Math.abs(this.width) - 40;

        int energyValue =  (this.energy / this.maximumEnergy) * Math.abs(this.width) - 80;;

        int posHealthX = this.direction == ObjectDirection.LEFT ? this.x + offsetHealthX : this.x - healthValue - offsetHealthX;
        g.setColor(Color.RED);
        g.fillRect(posHealthX, this.y + offsetHealthY, healthValue,5);

        int offsetEnergyX = 45;
        int offsetEnergyY = 32;

        int posEnergyX = this.direction == ObjectDirection.LEFT ? this.x + offsetEnergyX : this.x - energyValue - offsetEnergyY;

        g.setColor(Color.BLUE);
        g.fillRect(posEnergyX, this.y + offsetEnergyY, energyValue,5);


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
