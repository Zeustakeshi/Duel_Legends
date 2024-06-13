package core.colliderBox;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ColliderBox {

    private String id;
    private int x;
    private int y;
    private int width;
    private int height;

    public ColliderBox() {
        this.id = UUID.randomUUID().toString();
        this.x = 0;
        this.y = 0;
        this.width = 10;
        this.height = 10;
    }

    public ColliderBox(int x, int y, int width, int height) {
        this.id = UUID.randomUUID().toString();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(ColliderBox other) {
        return isInsertCollision(
                this.x,
                this.y,
                this.width,
                this.height,
                other.x,
                other.y,
                other.width,
                other.height
        );
    }


    private boolean isInsertCollision(
            double x1, double y1, double w1, double h1, double x2, double y2, double w2, double h2
    ) {
        return !(x1 + w1 < x2 ||  // Right edge of rect1 is left of left edge of rect2
                x1 > x2 + w2 ||  // Left edge of rect1 is right of right edge of rect2
                y1 + h1 < y2 ||  // Bottom edge of rect1 is above top edge of rect2
                y1 > y2 + h2);   // Top edge of rect1 is below bottom edge of rect2
    }

    public void draw(Graphics g) {
        draw(g, Color.PINK);
    }

    public void draw(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawRect(
                this.x,
                this.y,
                this.width,
                this.height
        );
    }


    public void draw(Graphics g, int levelOffsetX) {
        g.setColor(Color.PINK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawRect(
                this.x,
                this.y,
                this.width,
                this.height
        );
    }

    public void draw(Graphics g, int levelOffsetX, Color color) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawRect(
                this.x,
                this.y,
                this.width,
                this.height
        );
    }

    public void update() {

    }


    public void scale(int scale) {
        this.width *= scale;
        this.height *= scale;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isContainMouse(int mouseX, int mouseY) {
        ColliderBox colliderBox = new ColliderBox(mouseX, mouseY, 1, 1);
        return this.intersects(colliderBox);
    }
}
