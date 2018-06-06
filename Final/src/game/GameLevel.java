package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 * @author Steve Odai-Stephens
 */
public abstract class GameLevel extends World {

    /**
     * variable of Dragon class
     */
    private Dragon drake;

    /**
     * variable of Fireball class
     */
    private Fireball fball;

    /**
     * game variable is of type game which is the computer game the user will be playing
     */
    private Game game;

    /**
     * view is a variable of GameView class which shows the contents of the game
     */
    private GameView view;

    /**
     * world is a variable of the GameLevel class which sets the stage for all levels in the game
     */
    private GameLevel world;
    
    /**
     * gets the game from the Game class
     * @return the game
     */
    public Game getGame(){
        return game;
    }
    
    /**
     * gets the player from the Dragon class
     * @return the dragon or player
     */
    public Dragon getPlayer() {
        return drake;
    }
    
    /**
     * gets fireball from the Fireball class
     * @return the fireball
     */
    public Fireball getFireball(){
        return fball;
    }
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     * @param game this is the game world the user is playing in
     */
    public void populate(Game game) {
        drake = new Dragon(this, game);
        drake.setPosition(startPosition());
        
        Egg egg = new Egg(this);
        egg.setPosition(eggPosition());
        egg.addCollisionListener(new ListenerEgg(game));
        
        
    }
   
    /** The initial position of the player.
     * @return  */
    public abstract Vec2 startPosition();
    
    /** The position of the exit egg.
     * @return  */
    public abstract Vec2 eggPosition();
    
    /** Is this level complete?
     * @return  */
    public abstract boolean isCompleted();
}
    
