package core.character.state;

import core.character.Character;
import lombok.Getter;

@Getter
public abstract class BaseState<T extends Character> {
    protected final T character;
    protected final CharacterState state;

    public BaseState(CharacterState state, T character) {
        this.character = character;
        this.state = state;
    }

    public void enter() {
        // if (GameStateManager.isDebugger()) System.out.println(state);
        reset();
    }

    protected void reset() {
        this.character.setFrameX(0);
    }

    public abstract void update();


}
