package character.pawn;

import character.pawn.state.*;
import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.CharacterState;
import core.character.state.StateManager;
import utils.LoadSave;
import utils.ObjectDirection;

public class Pawn extends Character {


    public Pawn() {
        String imagePath = "characters/pawn_Purple.png";
        image = LoadSave.loadImage(imagePath);

        speedX = 0;
        speedY = 0;
        maxSpeedX = 10;
        maxSpeedY = 10;

        width = 192;
        height = 192;

        frameX = 0;
        frameY = 0;
        maxFrameX = 6;

        imageWidth = 192;
        imageHeight = 192;

        direction = ObjectDirection.RIGHT;

        setScale(2.2);

        power = 40;


        commandExecutor.execute(this, CharacterCommand.IDLE);

    }

    @Override
    public StateManager<? extends Character> bindingStateManager() {
        StateManager<Pawn> stateManager = new StateManager<>();

        stateManager.addState(CharacterState.IDLE, new Idle(this));
        stateManager.addState(CharacterState.FALL, new Fall(this));
        stateManager.addState(CharacterState.TURN_LEFT, new TurnLeft(this));
        stateManager.addState(CharacterState.TURN_RIGHT, new TurnRight(this));
        stateManager.addState(CharacterState.WALK, new Walk(this));
        stateManager.addState(CharacterState.MELEE_ATTACK, new MeleeAttack(this));
        stateManager.addState(CharacterState.JUMP, new Jump(this));


        return stateManager;
    }

}
