package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class MeleeAttackState<T extends Character> extends BaseState<T> {

    public MeleeAttackState(T character) {
        super(CharacterState.MELEE_ATTACK, character);
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
