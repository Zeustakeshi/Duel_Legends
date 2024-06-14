package character.warrior.state;

import character.warrior.Warrior;
import core.character.state.CharacterState;
import core.character.state.defaults.MeleeAttackState;

public class MeleeAttack extends MeleeAttackState<Warrior> {

    public MeleeAttack(Warrior character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(6);
        character.setFrameY(2);

    }

    @Override
    public void update() {
        super.update();

        if(character.isAnimationEnd()){
            character.getStateManager().undoState();

        }



    }
}
