package game;

import city.cs.engine.*;

/**
 * @author Steve, Odai-Stephens, steve.odai-stephens@city.uk
 * @version 3.0 
 * Egg in a game. When the actor collides with a door, if the
 * current level is complete the game is advanced to the next level.
 */
public class Egg extends StaticBody {

    /**
     * Initialise a new egg.
     *
     * @param world The world.
     */
    public Egg(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/egg.png", 2.8f));
    }
}
