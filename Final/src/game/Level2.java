package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    /**
     * NUM_COINS is a variable of type int which stores the value 6
     */
    private static final int NUM_COINS = 6;

    
    /**
     * instantiating a variable of Enemy1 class
     */
    
    private Enemy1 mob;

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

        // make some platforms
        Shape platformShape = new BoxShape(5, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-15, 7f));
        Shape platformShape1 = new BoxShape(5, 0.5f);
        Body platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(15, -2f));
        
        mob = new Enemy1(game);
        mob.setPosition(new Vec2(14f, -9.6f));
        mob.addCollisionListener(new ListenerEnemy(game));
        mob.addCollisionListener(new ListenerObstacle(getPlayer()));

        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 2 - -11, 10));
            coin.addCollisionListener(new ListenerCoin(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -10);
    }

    @Override
    public Vec2 eggPosition() {
        return new Vec2(-15, 10f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == NUM_COINS + 3;
    }
}
