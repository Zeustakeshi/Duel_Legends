package core.character;

import constant.GameConstant;
import core.character.command.CharacterCommand;
import core.character.command.CommandExecutor;
import core.character.command.defaults.*;
import core.character.state.StateManager;
import core.colliderBox.ColliderBox;
import core.event.ComponentEvent;
import game.gameStateManager.GameStateManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import utils.ObjectDirection;

import java.awt.*;
import java.awt.image.BufferedImage;


@Getter
@Setter
public abstract class Character implements ComponentEvent {
    /**
     * Manages the state of the object.
     */
    protected final StateManager<? extends Character> stateManager;
    /**
     * ....
     */
    protected final CommandExecutor commandExecutor;
    protected ColliderBox attackBox;
    /**
     * X-coordinate position of the object.
     */
    protected int posX;
    /**
     * Y-coordinate position of the object.
     */
    protected int posY;
    /**
     * Speed of the object along the X-axis.
     */
    protected int speedX;
    /**
     * Speed of the object along the Y-axis.
     */
    protected int speedY;
    /**
     * Maximum speed in the horizontal (X) direction.
     */
    protected int maxSpeedX;
    /**
     * Maximum speed in the vertical (Y) direction.
     */
    protected int maxSpeedY;
    /**
     * Width of the object.
     */
    protected int width;
    /**
     * Height of the object.
     */
    protected int height;
    /**
     * Current frame X in the animation.
     */
    protected int frameX;
    /**
     * Current frame Y in the animation.
     */
    protected int frameY;
    /**
     * Maximum frame X for the animation.
     */
    protected int maxFrameX;
    /**
     * Scale factor for the object's size.
     */
    protected double scale;
    /**
     * Width of the object in the game world.
     */
    protected int imageWidth;
    /**
     * Height of the object in the game world.
     */
    protected int imageHeight;
    /**
     * Indicates if the animation has ended.
     */
    protected boolean animationEnd;
    /**
     * Image representing the object.
     */
    protected BufferedImage image;
    /**
     * Collision box of the object.
     */
    protected ColliderBox colliderBox;

    /**
     * Indicates if the object is on the ground.
     */
    protected boolean onGround;
    /**
     * Direction the object is facing or moving.
     */
    protected ObjectDirection direction;
    /**
     * Weight of the object.
     */
    protected int weight;
    /**
     * ....
     */
    protected int power;

    /**
     * X-coordinate position of the object.
     */
    protected int meleeDamage;
    /**
     * X-coordinate position of the object.
     */
    protected int rangedDamage;
    /**
     * X-coordinate position of the object.
     */
    protected int ultimateDamage;
    /**
     * Speed of the animation.
     */
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private int animationSpeed = 5;
    /**
     * Current tick count for the animation.
     */
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private int animationTick = 0;
    /**
     * X-coordinate position of the image within a sprite sheet.
     */
    @Setter(AccessLevel.PRIVATE)
    private int imageX;
    /**
     * Y-coordinate position of the image within a sprite sheet.
     */
    @Setter(AccessLevel.PRIVATE)
    private int imageY;


    protected int health;

    private int energy;

    @Setter(AccessLevel.PRIVATE)
    private int maximumHealth;

    @Setter(AccessLevel.PRIVATE)
    private int maximumEnergy;


    public Character() {
        super();
        this.attackBox = null;
        this.commandExecutor = bindingCommand();
        this.weight = 5;
        this.stateManager = bindingStateManager();
        this.colliderBox = new ColliderBox(0, 0, 50, 50);
        this.power = 10;
        this.meleeDamage = 2;
        this.rangedDamage = 4;
        this.setSpeedX(0);
        this.setPosY(0);
        this.ultimateDamage = 10;

        this.maximumEnergy =100;
        this.maximumHealth = 100;
        this.energy = this.maximumEnergy;
        this.health = this.maximumHealth;
        setScale(GameConstant.SCALE);
    }

    public abstract StateManager<? extends Character> bindingStateManager();


    public CommandExecutor bindingCommand() {
        var commandExecutor = new CommandExecutor();
        commandExecutor.addCommand(CharacterCommand.WALK, new WalkCommand());
        commandExecutor.addCommand(CharacterCommand.STOP_WALK, new StopWalkCommand());
        commandExecutor.addCommand(CharacterCommand.TURN_LEFT, new TurnLeftCommand());
        commandExecutor.addCommand(CharacterCommand.TURN_RIGHT, new TurnRightCommand());
        commandExecutor.addCommand(CharacterCommand.JUMP, new JumpCommand());
        commandExecutor.addCommand(CharacterCommand.MELEE_ATTACK, new MeleeAttackCommand());
        commandExecutor.addCommand(CharacterCommand.FALL, new FallCommand());
        commandExecutor.addCommand(CharacterCommand.IDLE, new IdleCommand());
        commandExecutor.addCommand(CharacterCommand.STOP_WALK, new StopWalkCommand());
        commandExecutor.addCommand(CharacterCommand.RANGED_ATTACK, new RangedAttackCommand());
        commandExecutor.addCommand(CharacterCommand.ULTIMATE_ATTACK, new UltimateAttackCommand());
        commandExecutor.addCommand(CharacterCommand.DEFEND, new DefendCommand());
        commandExecutor.addCommand(CharacterCommand.TAKE_HIT, new TakeHitCommand());
        commandExecutor.addCommand(CharacterCommand.DIE, new DieCommand());

        return commandExecutor;
    }

    public void die () {
        this.speedX = 0;
        this.speedY = 0;
        this.health = 0;
        this.energy = 0;
    }

    public void draw(Graphics g) {
        BufferedImage subImage = this.image.getSubimage(
                this.imageWidth * this.frameX,
                this.imageHeight * this.frameY,
                this.imageWidth,
                this.imageHeight
        );


        g.drawImage(
                subImage,
                this.imageX,
                this.imageY,
                this.width,
                this.height,
                null
        );
        if (GameStateManager.isDebugger()) {
            this.colliderBox.draw(g, 0, Color.ORANGE);
            if (this.attackBox != null) this.attackBox.draw(g, 0, Color.GREEN);

            g.setColor(Color.BLUE);
            g.drawRect((int) (imageX - Math.abs(imageWidth) * 0.5 + width * 0.5), imageY, Math.abs(width), height);
        }

    }

    public void update() {
        this.animationTick++;
        if (this.animationTick >= this.animationSpeed) {
            this.animationEnd = false;
            this.animationTick = 0;
            if (this.frameX < this.maxFrameX - 1) {
                this.frameX++;
            } else {
                this.frameX = 0;
                this.animationEnd = true;
            }
        }

        stateManager.updateState();
        updateColliderBox();
        updateObjectPos();

    }

    protected void updateObjectPos() {

        this.setImageX((int) (
                        colliderBox.getX() -
                                this.getWidth() * 0.5 +
                                colliderBox.getWidth() * 0.5
                )
        );

        this.setImageY((int) (
                colliderBox.getY() - this.getHeight() * 0.5 + colliderBox.getHeight() * 0.5)
        );

    }


    protected void updateColliderBox() {
        this.setPosX(this.getPosX() + this.getSpeedX());
        this.setPosY((int) (this.getPosY() + this.getSpeedY() + this.weight + GameConstant.GRAVITY));

        if (this.getPosY() >= GameConstant.GAME_HEIGHT - colliderBox.getHeight() - GameConstant.GAME_BASE) {
            this.setPosY((GameConstant.GAME_HEIGHT - colliderBox.getHeight() - GameConstant.GAME_BASE));
            this.onGround = true;
        } else {
            this.onGround = false;
        }
    }

    public void setPosX(int posX) {
        this.colliderBox.setX(posX);
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.colliderBox.setY(posY);
        this.posY = posY;
    }


    public void flip(ObjectDirection direction) {
        if (this.direction == direction) return;
        this.setImageX(this.getImageX() + this.getWidth());
        this.setWidth(this.getWidth() * -1);
        this.direction = direction;
    }

    public void setScale(double scale) {
        this.scale = scale;
        this.width = (int) (this.width * scale);
        this.height = (int) (this.height * scale);

    }

    @Override
    public void onMounted() {

    }

    @Override
    public void onUnmounted() {

    }

}
