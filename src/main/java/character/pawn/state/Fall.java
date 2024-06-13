package character.pawn.state;

import character.pawn.Pawn;
import core.character.state.defaults.FallState;

public class Fall extends FallState<Pawn> {

    public Fall(Pawn character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();

        character.setFrameX(0);
        character.setFrameY(4);

    }

    @Override
    public void update() {
        super.update();
    }
}
