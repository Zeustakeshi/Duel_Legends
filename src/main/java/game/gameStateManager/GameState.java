package game.gameStateManager;

import game.gameStateManager.state.*;
import lombok.Getter;

@Getter
public enum GameState {
    LOADING(new LoadingState()),
    MENU(new MenuState()),
    CHOOSE_CHARACTER(new ChooseCharacterState()),
    CHOOSE_MAP(new ChooseMapState()),
    PLAYING(new PlayingState());

    private final BaseState value;

    GameState(BaseState value) {
        this.value = value;
    }

}
