package character.pawn.state;

import character.pawn.Pawn;
import core.character.state.defaults.IdleState;

public class Idle extends IdleState<Pawn> {

    public Idle(Pawn character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();

        character.setFrameX(0);
        character.setFrameY(0);
        character.setMaxFrameX(6);

    }

    @Override
    public void update() {
        super.update();
    }
}
