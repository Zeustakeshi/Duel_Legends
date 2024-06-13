package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class IdleState<T extends Character> extends BaseState<T> {
    public IdleState(T character) {
        super(CharacterState.IDLE, character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setSpeedX(0);
        character.setSpeedY(0);
    }

    @Override
    public void update() {

    }
}
