package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class DieState<T extends Character> extends BaseState<T> {

    public DieState(CharacterState state, T character) {
        super(state, character);
    }

    @Override
    public void enter() {
        super.enter();
        character.die();
    }

    @Override
    public void update() {

    }
}
