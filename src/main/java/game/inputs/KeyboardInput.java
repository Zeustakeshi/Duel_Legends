package game.inputs;

import game.gameStateManager.GameStateManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyboardInput implements KeyListener {

    private final Set<Integer> pressedKeys = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {
        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().keyTyped(e);
        }
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        if (pressedKeys.contains(e.getKeyCode())) return;
        pressedKeys.add(e.getKeyCode());

        if (GameStateManager.getCurrentState() == null) return;
        GameStateManager.getCurrentState().getValue().keyPressed(e);


        if (e.getKeyCode() == KeyEvent.VK_B) GameStateManager.setDebugger(!GameStateManager.isDebugger());
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        if (!pressedKeys.contains(e.getKeyCode())) return;
        pressedKeys.remove(e.getKeyCode());

        if (GameStateManager.getCurrentState() != null) {
            GameStateManager.getCurrentState().getValue().keyReleased(e);
        }
    }
}
