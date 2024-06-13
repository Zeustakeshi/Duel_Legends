package character.buu.state;

import character.buu.Buu;
import core.character.state.defaults.JumpState;

public class Jump extends JumpState<Buu> {

    public Jump(Buu character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(3);
        character.setFrameY(2);
    }


}
