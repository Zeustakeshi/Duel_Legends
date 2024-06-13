package character.buu.state;

import character.buu.Buu;
import core.character.state.BaseState;
import core.character.state.CharacterState;
import utils.ObjectDirection;

public class TurnLeft extends BaseState<Buu> {
    public TurnLeft(Buu character) {
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
