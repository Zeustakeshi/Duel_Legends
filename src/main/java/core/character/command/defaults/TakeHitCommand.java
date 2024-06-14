package core.character.command.defaults;

import core.character.Character;
import core.character.command.Command;
import core.character.state.CharacterState;

public class TakeHitCommand implements Command {
    @Override
    public void execute(Character character) {
        character.getStateManager().setState(CharacterState.TAKE_HIT);
    }
}
