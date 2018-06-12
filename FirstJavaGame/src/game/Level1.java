package game;

import city.cs.engine.*;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    /**
     * NUM_COINS is a variable of type int which stores the value 3
     */
    private static final int NUM_COINS = 3;

    /**
     * instantiating a variable of Enemy1 class
     */
    private Enemy1 mob;

    /**
     * instantiating a variable of Health class
     */
    private Health hp;

    /**
     * instantiating a variable of Dragon class
     */
    private Dragon drake;

    /**
     * Populate the world.
     *
     * @param game the game
     */
    @Override
    public void populate(Game game) {

        super.populate(game);
        // make the ground
        Shape groundShape = new BoxShape(50, 2f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -16f));

        mob = new Enemy1(game);
        mob.setPosition(new Vec2(10f, -9.6f));
        mob.addCollisionListener(new ListenerEnemy(game));
        mob.addCollisionListener(new ListenerObstacle(getPlayer()));

        hp = new Health(this);
        hp.setPosition(new Vec2(-10f, -9.6f));
        hp.addCollisionListener(new ListenerHealth(getPlayer()));

        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 4 - 8, 10));
            coin.addCollisionListener(new ListenerCoin(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -10);
    }

    @Override
    public Vec2 eggPosition() {
        return new Vec2(15f, -10.5f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == NUM_COINS;
    }
}
