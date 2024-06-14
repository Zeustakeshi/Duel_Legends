package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class RangedAttackState <T extends Character> extends BaseState<T> {

    public RangedAttackState( T character) {
        super(CharacterState.RANGED_ATTACK, character);
    }

    @Override
    public void enter() {
        super.enter();
    }

    @Override
    public void update() {

    }
}
