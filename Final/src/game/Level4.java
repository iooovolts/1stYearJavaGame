package game;

import city.cs.engine.*;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    /**
     * NUM_COINS is a variable of type int which stores the value 12
     */
    private static final int NUM_COINS = 12;

    /**
     * instantiating a variable of Enemy1 class
     */
    private Enemy1 mob;

    /**
     * instantiating a variable of Enemy2 class
     */
    private Enemy2 mob1;

    /**
     * instantiating a variable of Enemy3 class
     */
    private Enemy3 mob2;

    /**
     * instantiating a variable of Health class
     */
    private Health hp;
    
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
        Shape platformShape = new BoxShape(2, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-20, 6f));

        Shape platformShape1 = new BoxShape(2, 0.5f);
        Body platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(-10, 2f));

        Shape platformShape2 = new BoxShape(2, 0.5f);
        Body platform3 = new StaticBody(this, platformShape2);
        platform3.setPosition(new Vec2(4, -3f));
        
        hp = new Health(this);
        hp.setPosition(new Vec2(5.5f, 10f));
        hp.addCollisionListener(new ListenerHealth(getPlayer()));
        
        mob = new Enemy1(game);
        mob.setPosition(new Vec2(-10, 15));
        mob.addCollisionListener(new ListenerEnemy(game));
        mob.addCollisionListener(new ListenerObstacle(getPlayer()));
        

        mob1 = new Enemy2(this);
        mob1.setPosition(new Vec2(14f, -15));
        mob1.addCollisionListener(new ListenerEnemy(game));
        mob1.addCollisionListener(new ListenerObstacle(getPlayer()));
        addStepListener(mob1);

        mob2 = new Enemy3(this);
        mob2.setPosition(new Vec2(-10, -15));
        mob2.addCollisionListener(new ListenerEnemy(game));
        mob2.addCollisionListener(new ListenerObstacle(getPlayer()));
      addStepListener(mob2);
        
        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 4 - 10, 10));
            coin.addCollisionListener(new ListenerCoin(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -10);
    }

    @Override
    public Vec2 eggPosition() {
        return new Vec2(-20f, 10.5f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == NUM_COINS + 15;
    }
}
