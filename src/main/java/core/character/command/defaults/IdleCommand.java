package core.character.command.defaults;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.command.Command;
import core.character.state.CharacterState;

public class IdleCommand implements Command {
    @Override
    public void execute(Character character) {
        if (!character.isOnGround()) {
            character.getCommandExecutor().execute(character, CharacterCommand.FALL);
            return;
        }
        character.getStateManager().setState(CharacterState.IDLE);
    }


}
