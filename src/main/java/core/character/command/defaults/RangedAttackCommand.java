package core.character.command.defaults;

import core.character.Character;
import core.character.command.Command;
import core.character.state.CharacterState;

public class RangedAttackCommand implements Command {
    @Override
    public void execute(Character character) {
        character.getStateManager().setState(CharacterState.RANGED_ATTACK);
    }
}
