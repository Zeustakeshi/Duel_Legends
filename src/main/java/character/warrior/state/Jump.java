package character.warrior.state;

import character.warrior.Warrior;
import core.character.state.defaults.JumpState;

public class Jump extends JumpState<Warrior> {

    public Jump(Warrior character) {
        super(character);

    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(4);
        character.setFrameY(2);
    }
}
