package game.gameStateManager;

import core.character.Character;
import core.map.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GameStateManager {
    private static GameStateManager instance;

    @Getter
    private static Character player1;

    @Getter
    private static Character player2;
    private static Map map;


    @Setter
    @Getter
    private static boolean isDebugger = true;

    @Getter
    private static GameState currentState;


    public static void setState(GameState state) {
        if (currentState != null) currentState.getValue().onUnmounted();
        currentState = state;
        currentState.getValue().onMounted();
    }


    public static void setPlayingMap(Map choosedMap) {
        map = choosedMap;
    }

    public static void setPlayer1Character(Character character) {
        player1 = character;
    }

    public static void setPlayer2Character(Character character) {
        player2 = character;
    }

}
