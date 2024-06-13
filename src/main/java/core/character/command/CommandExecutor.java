package core.character.command;

import core.character.Character;
import game.gameStateManager.GameStateManager;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private final Map<CharacterCommand, Command> commands;

    public CommandExecutor() {
        this.commands = new HashMap<>();
    }

    public void addCommand(CharacterCommand type, Command command) {
        commands.put(type, command);
    }

    public void execute(Character character, CharacterCommand type) {
        if (!commands.containsKey(type)) return;
        if (GameStateManager.isDebugger()) System.out.println("execute command " + type);
        commands.get(type).execute(character);
    }

}

