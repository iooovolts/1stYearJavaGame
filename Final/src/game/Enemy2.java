package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Steve, Odai-Stephens, steve.odai-stephens@city.ac.uk
 */
public class Enemy2 extends DynamicBody implements StepListener {

    /**
     *
     */
    private int Left = -10;

    /**
     *
     */
    private int Right = 10;

    /**
     *
     */
    private int direction = 1;
    /**
     * img variable of type BodyImage creates a new BodyImage of size 5
     */
    BodyImage img = new BodyImage("data/knight.gif", 5);

    /**
     *
     * @param w the world.
     */
    public Enemy2(World w) {
        super(w, new PolygonShape(-0.66f, 2.44f, -2.11f, -2.49f, 1.7f, -2.45f, 2.11f, 0.29f, 1.89f, 1.16f, 0.21f, 2.44f));
        addImage(img);
    }

    /**
     * 
     * @param e step event
     */
    @Override
    public void preStep(StepEvent e) {
       
    }

    /**
     * will enable mob to move when game loads up
     * @param e step event
     */
    @Override
    public void postStep(StepEvent e) {
        if (this.getPosition().x > Right) {
            direction = -5;
        } else if (this.getPosition().x < Left) {
            direction = 4;
        }
        this.setLinearVelocity(new Vec2(direction, 0));
    }
}
