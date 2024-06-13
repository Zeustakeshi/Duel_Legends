package character.pawn.state;

import character.pawn.Pawn;
import core.character.state.defaults.MeleeAttackState;

public class MeleeAttack extends MeleeAttackState<Pawn> {

    public MeleeAttack(Pawn character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();

        character.setFrameX(0);
        character.setFrameY(2);


    }


    @Override
    public void update() {
        super.update();
        if (character.isAnimationEnd()) {
            character.getStateManager().undoState();
        }
    }
}
