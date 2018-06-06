package game;

import city.cs.engine.*;


/**
 * @author Steve Odai-Stephens
 */
public class Health extends DynamicBody {

    /**
     * ballImage variable contains an image with a defined size of 2.5
     */
    private static final BodyImage image = new BodyImage("data/hp.gif", 2.5f);
    
    /**
      This method is used to pass the hp image and shape through to world
     * @param world the world
     */
    public Health(World world) {
        super(world, new PolygonShape(-1.13f,1.005f, 1.13f,1.0f, 1.12f,-0.995f, -1.125f,-1.005f));
        addImage(image);
    }
}
