package game;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listener for collision with a egg.  When the player collides with a egg,
 * if the current level is complete the game is advanced to the next level. 
 */
public class ListenerEgg implements CollisionListener {

    /**
     * instantiating a variable of Game class
     */
    private Game game;
    
    /**
     * this method sets the game variable to the current instance
     * @param game the game
     */
    public ListenerEgg(Game game) {
        this.game = game;
    }

    /**
     * This methods allows dragon to go to next level
     * @param e collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        Dragon player = game.getPlayer();
        System.out.println("Test123");
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            try {
                game.goNextLevel();
            } catch (IOException ex) {
                Logger.getLogger(ListenerEgg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
