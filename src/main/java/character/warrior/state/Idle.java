package character.warrior.state;

import character.warrior.Warrior;
import core.character.state.defaults.IdleState;

public class Idle extends IdleState<Warrior> {

    public Idle(Warrior character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(6);
        character.setFrameY(0);
    }
}
