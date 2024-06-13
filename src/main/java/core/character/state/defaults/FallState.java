package core.character.state.defaults;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class FallState<T extends Character> extends BaseState<T> {

    public FallState(T character) {
        super(CharacterState.FALL, character);
    }

    @Override
    public void update() {
        if (character.isOnGround()) {
            character.getCommandExecutor().execute(character, CharacterCommand.IDLE);
        }
    }
}
