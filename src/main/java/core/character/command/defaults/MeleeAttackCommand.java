package core.character.command.defaults;

import core.character.Character;
import core.character.command.Command;
import core.character.state.CharacterState;

public class MeleeAttackCommand implements Command {
    @Override
    public void execute(Character character) {
        if (!character.isOnGround()) return;
        character.getStateManager().setState(CharacterState.MELEE_ATTACK);
    }


}
