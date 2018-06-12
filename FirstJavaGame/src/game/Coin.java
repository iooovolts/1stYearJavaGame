package game;

import city.cs.engine.*;

/**
 *@author Steve, Odai-Stephens, steve.odai-stephens@city.ac.uk
 *@version 3.0
 */
public class Coin extends DynamicBody {
    // class body

    /**
     * ballImage variable contains an image with a defined size of 2
     */
    private static final BodyImage ballImage = new BodyImage("data/coin.gif", 2f);
    
    /**
     *  This method is used to pass the coin image and shape through to world
     * @param world is an object type world.
     */
    public Coin(World world) {
        super(world, new PolygonShape(-1.246f,-1.242f, 1.242f,-1.242f, 1.246f,1.242f, -1.246f,1.238f));
        addImage(ballImage);
    }
    
}
