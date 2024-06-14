package core.character.state.defaults;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.state.BaseState;
import core.character.state.CharacterState;

public class TakeHitState<T extends Character> extends BaseState<T> {

    public TakeHitState(CharacterState state, T character) {
        super(state, character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setSpeedX(0);
    }


    @Override
    public void update() {
        if (character.isAnimationEnd()) {
            character.getStateManager().undoState();
        }
    }
}
