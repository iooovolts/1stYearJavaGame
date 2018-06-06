package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Steve, Odai-Stephens, steve.odai-stephens@city.ac.uk
 * @version 3.0 Enemy in a game. When actor collides with it, lives will be
 * decremented
 */
public class Enemy1 extends DynamicBody implements StepListener {

    /**
     * left is an int variable which will make mob move
     */
    private int Left = -10;

    /**
     * right is an int variable which will make mob move
     */
    private int Right = 10;

    /**
     * direction is an int variable which will make the mob have direction
     */
    private int direction = 1;
    /**
     * img variable of type BodyImage creates a new BodyImage of size 5
     */
    BodyImage img = new BodyImage("data/leftmage.gif", 5);

    /**
     * game variable is of type game which is the computer game the user will be
     * playing
     */
    Game game;

    /**
     * Initialise a new enemy1
     *
     * @param game this is the game world the user is playing in
     */
    public Enemy1(Game game) {
        super(game.getWorld(), new PolygonShape(-0.66f, 2.44f, -2.11f, -2.49f, 1.7f, -2.45f, 2.11f, 0.29f, 1.89f, 1.16f, 0.21f, 2.44f));
        this.game = game;
        addImage(img);
    }

    /**
     *
     * @param e
     */
    @Override
    public void preStep(StepEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param e
     */
    @Override
    public void postStep(StepEvent e) {
        if (this.getPosition().x > Right) {
            direction = -8;
        } else if (this.getPosition().x < Left) {
            direction = 6;
        }
        this.setLinearVelocity(new Vec2(direction, 0));

    }
}

