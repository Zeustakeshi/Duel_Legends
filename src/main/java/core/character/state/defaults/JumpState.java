package core.character.state.defaults;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.BaseState;
import core.character.state.CharacterState;
import utils.ObjectDirection;

public class JumpState<T extends Character> extends BaseState<T> {

    public JumpState(T character) {
        super(CharacterState.JUMP, character);
    }

    @Override
    public void enter() {
        super.enter();

        if (character.getDirection() == ObjectDirection.LEFT) {
            character.setSpeedX((-character.getMaxSpeedX()));
        } else {
            character.setSpeedX((character.getMaxSpeedX()));
        }
        character.setSpeedY(-(character.getMaxSpeedY() + character.getPower()));
    }

    @Override
    public void update() {
        character.setSpeedY(character.getSpeedY() + character.getWeight());
        if (character.getSpeedY() > 1) {
            character.getCommandExecutor().execute(character, CharacterCommand.FALL);
        }
    }
}
