package game;

import city.cs.engine.*;
/**
 * @author Steve Odai-Stephens
 * Collision listener that allows the dragon to lose lives on collision.
 */
public class ListenerObstacle implements CollisionListener{

    /**
     * instantiating a variable of Dragon class
     */
    private Dragon drake;

    /**
     * this method sets the drake variable to the current instance
     * @param drake the dragon
     */
    public ListenerObstacle(Dragon drake) {
        this.drake = drake;
    }

    /**
     * This method will decrement lives when the dragon collides
     * @param e collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == drake) {
            drake.loseLives();
            drake.dieDragon();
            e.getReportingBody().destroy(); 
        } 
    }
}

