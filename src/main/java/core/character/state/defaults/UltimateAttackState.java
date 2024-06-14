package core.character.state.defaults;

import core.character.Character;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class UltimateAttackState<T extends Character> extends BaseState<T> {


    public UltimateAttackState(T character) {
        super(CharacterState.ULTIMATE_ATTACK, character);
    }

    @Override
    public void enter() {
        super.enter();
    }

    @Override
    public void update() {

    }
}
