package game.inputs;

import game.gameStateManager.GameStateManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener, MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mouseExited(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().mouseMoved(e);
        }
    }
}
