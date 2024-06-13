package character.pawn.state;

import character.pawn.Pawn;
import core.character.state.defaults.WalkState;

public class Walk extends WalkState<Pawn> {

    public Walk(Pawn character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setFrameX(0);
        character.setFrameY(1);

    }

    @Override
    public void update() {
        super.update();
    }
}
