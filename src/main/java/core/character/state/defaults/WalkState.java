package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;
import utils.ObjectDirection;

public class WalkState<T extends Character> extends BaseState<T> {

    public WalkState(T character) {
        super(CharacterState.WALK, character);
    }

    @Override
    public void enter() {
        super.enter();
        if (character.getDirection() == ObjectDirection.LEFT) {
            character.setSpeedX(-character.getMaxSpeedX());
        } else {
            character.setSpeedX(character.getMaxSpeedX());
        }
    }

    @Override
    public void update() {

    }
}
