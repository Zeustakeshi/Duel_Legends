package core.character.state;

import core.character.Character;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class StateManager<T extends Character> {

    private final Map<CharacterState, BaseState<T>> states;
    private BaseState<T> currentState;
    private BaseState<T> previousState;

    public StateManager() {
        this.states = new HashMap<>();
        this.currentState = null;
        this.previousState = null;
    }

    public void addState(CharacterState stateType, BaseState<T> state) {
        this.states.put(stateType, state);
    }


    public synchronized void setState(CharacterState stateType) {
        BaseState<T> existedState = this.states.get(stateType);

        if (existedState == null) return;

        if (previousState != null && currentState.state.equals(stateType)) return;

        previousState = currentState;
        currentState = existedState;

        currentState.enter();
    }

    public void undoState() {
        if (this.previousState == null) return;
        this.currentState = this.previousState;
        this.previousState = null;
        this.currentState.enter();
    }


    public void updateState() {
        getCurrentState().update();
    }

}
