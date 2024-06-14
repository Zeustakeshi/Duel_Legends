package game.gameStateManager.state;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.inputs.InputHandler;
import game.gameStateManager.GameStateManager;
import ui.healthBar.HealthBar;
import utils.ObjectDirection;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static constant.GameConstant.GAME_WIDTH;

public class PlayingState implements BaseState {
    private final HealthBar player1HealthBar;
    private final HealthBar player2HealthBar;
    private Character player1;
    private Character player2;
    private InputHandler player1Input;
    private InputHandler player2Input;


    public PlayingState() {
        this.player1HealthBar = new HealthBar();
        this.player2HealthBar = new HealthBar();
    }

    public void initialHealthBar() {

        this.player1HealthBar.setX(10);
        this.player1HealthBar.flip(ObjectDirection.LEFT);
        this.player2HealthBar.setX(GAME_WIDTH - this.player2HealthBar.getWidth() - 10);
        this.player2HealthBar.flip(ObjectDirection.RIGHT);
    }


    public void initialPlayer() {


        player1 = GameStateManager.getPlayer1();
        player2 = GameStateManager.getPlayer2();


        player1.setPosX(10);
        player2.setPosX(GAME_WIDTH - 100);

        player1Input = new InputHandler(player1);
        player2Input = new InputHandler(player2);


        // binding input for player 1

        player1Input.bindingCommand(KeyEvent.VK_D, CharacterCommand.TURN_RIGHT);
        player1Input.bindingCommand(KeyEvent.VK_A, CharacterCommand.TURN_LEFT);
        player1Input.bindingCommand(KeyEvent.VK_K, CharacterCommand.JUMP);
        player1Input.bindingCommand(KeyEvent.VK_J, CharacterCommand.MELEE_ATTACK);
        player1Input.bindingCommand(KeyEvent.VK_U, CharacterCommand.RANGED_ATTACK);
        player1Input.bindingCommand(KeyEvent.VK_I, CharacterCommand.ULTIMATE_ATTACK);
        player1Input.bindingCommand(KeyEvent.VK_S, CharacterCommand.DEFEND);

        player1Input.bindingReleasedCommand(KeyEvent.VK_D, CharacterCommand.STOP_WALK);
        player1Input.bindingReleasedCommand(KeyEvent.VK_A, CharacterCommand.STOP_WALK);

        // binding input for player 2
        player2Input.bindingCommand(KeyEvent.VK_RIGHT, CharacterCommand.TURN_RIGHT);
        player2Input.bindingCommand(KeyEvent.VK_LEFT, CharacterCommand.TURN_LEFT);
        player2Input.bindingCommand(KeyEvent.VK_NUMPAD2, CharacterCommand.JUMP);
        player2Input.bindingCommand(KeyEvent.VK_NUMPAD1, CharacterCommand.MELEE_ATTACK);
        player2Input.bindingCommand(KeyEvent.VK_NUMPAD4, CharacterCommand.RANGED_ATTACK);
        player2Input.bindingCommand(KeyEvent.VK_NUMPAD5, CharacterCommand.ULTIMATE_ATTACK);
        player2Input.bindingCommand(KeyEvent.VK_DOWN, CharacterCommand.DEFEND);


        player2Input.bindingReleasedCommand(KeyEvent.VK_RIGHT, CharacterCommand.STOP_WALK);
        player2Input.bindingReleasedCommand(KeyEvent.VK_LEFT, CharacterCommand.STOP_WALK);

        this.player1HealthBar.setMaximumEnergy(player1.getMaximumEnergy());
        this.player1HealthBar.setMaximumHealth(player1.getMaximumHealth());

        this.player2HealthBar.setMaximumEnergy(player2.getMaximumEnergy());
        this.player2HealthBar.setMaximumHealth(player2.getMaximumHealth());

        initialHealthBar();
    }

    private void updateHealth () {
        this.player1HealthBar.setHealth(player1.getHealth());
        this.player1HealthBar.setEnergy(player1.getEnergy());
        this.player2HealthBar.setHealth(player2.getHealth());
        this.player2HealthBar.setEnergy(player2.getEnergy());
    }

    @Override
    public void update() {
        player1HealthBar.update();
        player2HealthBar.update();
        player1.update();
        player2.update();

        updateHealth();
    }

    @Override
    public void draw(Graphics g) {
        player1HealthBar.draw(g);
        player2HealthBar.draw(g);
        player1.draw(g);
        player2.draw(g);

    }

    @Override
    public void onMounted() {


        initialPlayer();

        player1.onMounted();
        player2.onMounted();
    }

    @Override
    public void onUnmounted() {
        player1.onUnmounted();
        player2.onUnmounted();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player1Input.executeCommand(e);
        player2Input.executeCommand(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1Input.executeReleasedCommand(e);
        player2Input.executeReleasedCommand(e);

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
