package character.warrior.state;

import character.warrior.Warrior;
import core.character.state.defaults.FallState;

public class Fall extends FallState<Warrior> {


    public Fall(Warrior character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setFrameY(3);
        character.setMaxFrameX(6);

    }
}
