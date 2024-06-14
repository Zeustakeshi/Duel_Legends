package character.warrior.state;

import character.warrior.Warrior;
import core.character.state.defaults.WalkState;

public class Walk extends WalkState<Warrior> {

    public Walk(Warrior character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(6);
        character.setFrameY(1);
    }
}
