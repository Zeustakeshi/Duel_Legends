package character.buu.state;

import character.buu.Buu;
import core.character.state.defaults.IdleState;

public class Idle extends IdleState<Buu> {

    public Idle(Buu character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(5);
        character.setFrameY(0);
    }


}
