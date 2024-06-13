package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;
import utils.ObjectDirection;

public class TurnLeftState<T extends Character> extends BaseState<T> {

    public TurnLeftState(T character) {
        super(CharacterState.TURN_LEFT, character);

    }

    @Override
    public void enter() {
        super.enter();
        character.flip(ObjectDirection.LEFT);
        character.getStateManager().undoState();
    }

    @Override
    public void update() {

    }
}
