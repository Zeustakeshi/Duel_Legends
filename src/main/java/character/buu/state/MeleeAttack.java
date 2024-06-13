package character.buu.state;

import character.buu.Buu;
import core.character.state.defaults.MeleeAttackState;
import core.colliderBox.ColliderBox;
import utils.ObjectDirection;

public class MeleeAttack extends MeleeAttackState<Buu> {


    public MeleeAttack(Buu character) {
        super(character);
    }

    @Override
    public void enter() {
        super.enter();
        character.setMaxFrameX(3);
        character.setFrameY(6);

        ColliderBox attackBox = new ColliderBox();

        attackBox.setX(character.getPosX());
        attackBox.setY(character.getPosY());
        attackBox.setSize(50, 10);

        character.setAttackBox(attackBox);

    }

    @Override
    public void update() {
        if (character.isAnimationEnd()) {
            character.setAttackBox(null);
            character.getStateManager().undoState();
            return;
        }

        if (character.getAttackBox() == null) return;

        calculateAttackBoxPosition();

    }


    private void calculateAttackBoxPosition() {

        ColliderBox colliderBox = character.getColliderBox();

        if (character.getDirection() == ObjectDirection.RIGHT) {
            character.getAttackBox().setX(colliderBox.getX() + 50);
        } else {
            character.getAttackBox().setX(colliderBox.getX() - colliderBox.getWidth());
        }

        character.getAttackBox().setY(colliderBox.getY() + (int) (colliderBox.getHeight() * 0.5 + 8));
    }


}
