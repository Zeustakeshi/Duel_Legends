package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class DefendState<T extends Character> extends BaseState<T> {

    public DefendState(CharacterState state, T character) {
        super(state, character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setSpeedX(0);
    }

    @Override
    public void update() {

    }
}
