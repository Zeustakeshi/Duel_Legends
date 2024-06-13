package core.character.command.defaults;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.command.Command;
import core.character.state.CharacterState;
import utils.ObjectDirection;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(Character character) {

        if (character.getDirection() == ObjectDirection.LEFT && character.isOnGround()) {
            character.getCommandExecutor().execute(character, CharacterCommand.WALK);
            return;
        }

        character.getStateManager().setState(CharacterState.TURN_LEFT);
    }


}
