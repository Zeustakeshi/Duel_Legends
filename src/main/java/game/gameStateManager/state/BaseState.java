package game.gameStateManager.state;

import core.event.GameEvent;

import java.awt.*;

public interface BaseState extends GameEvent {
    void update();

    void draw(Graphics g);


}
