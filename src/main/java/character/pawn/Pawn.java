package character.pawn;

import character.pawn.state.Fall;
import character.pawn.state.Idle;
import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.CharacterState;
import core.character.state.StateManager;
import utils.LoadSave;

public class Pawn extends Character {

    public Pawn () {
        String imagePath = "characters/pawn_Purple.png";
        image = LoadSave.loadImage(imagePath);

        maxSpeedX = 10;
        maxSpeedY= 10;
        width = 192;
        height = 192;
        imageHeight = 192;
        imageWidth = 192;
        maxFrameX = 6;

        setScale(2.2);

        commandExecutor.execute(this, CharacterCommand.IDLE);

    }


    @Override
    public StateManager<? extends Character> bindingStateManager() {
        StateManager<Pawn> stateManager = new StateManager<>();
        stateManager.addState(CharacterState.IDLE, new Idle(this));
        stateManager.addState(CharacterState.FALL, new Fall(this));
        return stateManager;
    }
}
