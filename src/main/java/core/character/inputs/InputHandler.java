package core.character.inputs;

import core.character.Character;
import core.character.command.CharacterCommand;
import lombok.Getter;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

@Getter
public class InputHandler {
    private final Map<Integer, CharacterCommand> commandMap;
    private final Map<Integer, CharacterCommand> releasedCommandMap;
    private final Character character;

    public InputHandler(Character character) {
        this.commandMap = new HashMap<>();
        this.releasedCommandMap = new HashMap<>();
        this.character = character;
    }

    public void bindingCommand(int key, CharacterCommand command) {
        this.commandMap.put(key, command);
    }

    public void bindingReleasedCommand(int key, CharacterCommand command) {
        this.releasedCommandMap.put(key, command);
    }

    public void executeCommand(KeyEvent event) {
        CharacterCommand commandType = commandMap.get(event.getKeyCode());
        if (commandType == null) return;
        character.getCommandExecutor().execute(character, commandType);
    }

    public void executeReleasedCommand(KeyEvent event) {
        CharacterCommand commandType = releasedCommandMap.get(event.getKeyCode());
        if (commandType == null) return;
        character.getCommandExecutor().execute(character, commandType);
    }

}
