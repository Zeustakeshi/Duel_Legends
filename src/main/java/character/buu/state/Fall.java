package character.buu.state;

import character.buu.Buu;
import core.character.state.defaults.FallState;

public class Fall extends FallState<Buu> {

    public Fall(Buu character) {
        super(character);
    }
    
    @Override
    public void enter() {
        super.enter();
        character.setFrameY(3);
        character.setMaxFrameX(1);
    }

}
