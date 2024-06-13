package core.character.command.defaults;

import core.character.Character;
import core.character.command.CharacterCommand;
import core.character.command.Command;

public class StopWalkCommand implements Command {
    @Override
    public void execute(Character character) {
        character.getCommandExecutor().execute(character, CharacterCommand.IDLE);
    }
}
