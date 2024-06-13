package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;
import utils.ObjectDirection;

public class TurnRightState<T extends Character> extends BaseState<T> {

    public TurnRightState(T character) {
        super(CharacterState.TURN_RIGHT, character);

    }

    @Override
    public void enter() {
        super.enter();
        character.flip(ObjectDirection.RIGHT);
        character.getStateManager().undoState();
    }

    @Override
    public void update() {

    }
}
