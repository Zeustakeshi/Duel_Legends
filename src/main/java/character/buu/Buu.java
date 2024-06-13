package character.buu;

import character.buu.state.*;
import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.CharacterState;
import core.character.state.StateManager;
import utils.LoadSave;
import utils.ObjectDirection;

public class Buu extends Character {


    public Buu() {

        super();
        String imagePath = "characters/player_sprites.png";

        this.image = LoadSave.loadImage(imagePath);
        this.posX = 100;
        this.posY = 100;
        this.speedX = 0;
        this.speedY = 10;
        this.maxSpeedX = 2;
        this.maxSpeedY = 10;
        this.imageWidth = 64;
        this.imageHeight = 40;
        this.width = 64;
        this.height = 40;
        this.frameX = 0;
        this.frameY = 0;
        this.maxFrameX = 5;
        this.direction = ObjectDirection.RIGHT;
        this.setPower(30);
        this.setScale(5);

        this.commandExecutor.execute(this, CharacterCommand.IDLE);
    }


    @Override
    public StateManager<Buu> bindingStateManager() {
        StateManager<Buu> stateManager = new StateManager<>();
        stateManager.addState(CharacterState.IDLE, new Idle(this));
        stateManager.addState(CharacterState.TURN_RIGHT, new TurnRight(this));
        stateManager.addState(CharacterState.TURN_LEFT, new TurnLeft(this));
        stateManager.addState(CharacterState.WALK, new Walk(this));
        stateManager.addState(CharacterState.MELEE_ATTACK, new MeleeAttack(this));
        stateManager.addState(CharacterState.JUMP, new Jump(this));
        stateManager.addState(CharacterState.FALL, new Fall(this));
        return stateManager;
    }


}
