package character.buu.state;

import character.buu.Buu;
import core.character.state.defaults.WalkState;

public class Walk extends WalkState<Buu> {

    public Walk(Buu character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setFrameY(1);
        character.setMaxFrameX(6);
    }


}
