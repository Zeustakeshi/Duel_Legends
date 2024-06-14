package character.warrior;

import character.buu.Buu;
import character.buu.state.*;
import character.warrior.state.Fall;
import character.warrior.state.Idle;
import character.warrior.state.Jump;
import character.warrior.state.MeleeAttack;
import character.warrior.state.TurnLeft;
import character.warrior.state.TurnRight;
import character.warrior.state.Walk;
import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.CharacterState;
import core.character.state.StateManager;
import utils.LoadSave;
import utils.ObjectDirection;

public class Warrior extends Character {
    public Warrior(){
        super();
        String imagePath = "characters/warrior.png";

        this.image = LoadSave.loadImage(imagePath);
        this.speedX = 0;
        this.speedY = 0;
        this.maxSpeedX =3;
        this.maxSpeedY =10;
        this.imageWidth =192;
        this.imageHeight =192;
        this.width = 192;
        this.height = 192;
        this.frameX =0;
        this.frameY =0;
        this.maxFrameX =5;
        this.direction = ObjectDirection.RIGHT;
      this.setPower(30);
      this.setScale(2);

      this.commandExecutor.execute(this, CharacterCommand.IDLE);
    }

    @Override
    public StateManager<? extends Character> bindingStateManager() {
        StateManager<Warrior> stateManager = new StateManager<>();
        stateManager.addState(CharacterState.FALL, new Fall(this));
        stateManager.addState(CharacterState.IDLE, new Idle(this));
        stateManager.addState(CharacterState.JUMP, new Jump(this));
        stateManager.addState(CharacterState.TURN_LEFT, new TurnLeft(this));
        stateManager.addState(CharacterState.TURN_RIGHT, new TurnRight(this));
        stateManager.addState(CharacterState.MELEE_ATTACK, new MeleeAttack(this));
        stateManager.addState(CharacterState.WALK, new Walk(this));

        return stateManager;

    }
}
