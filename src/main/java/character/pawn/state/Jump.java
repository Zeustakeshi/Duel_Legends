package character.pawn.state;

import character.pawn.Pawn;
import core.character.state.defaults.JumpState;

public class Jump extends JumpState<Pawn> {

    public Jump(Pawn character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();

        character.setFrameY(5);

    }

    @Override
    public void update() {
        super.update();
    }
}
