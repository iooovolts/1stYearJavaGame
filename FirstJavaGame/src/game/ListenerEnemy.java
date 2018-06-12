package game;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Steve Odai-Stephens Listener for collision with the enemy. When the
 * player collides with the enemy
 */
public class ListenerEnemy implements CollisionListener {

    /**
     * instantiating a variable of Game class
     */
    private Game game;

    /**
     * instantiating a variable of SoundClip
     */
    private SoundClip gameMusic;

    /**
     * this method sets the game variable to the current instance
     *
     * @param game the game
     */
    public ListenerEnemy(Game game) {
        this.game = game;
    }

    /**
     * This method allows the dragon to destroy enemies with a fireball
     *
     * @param e collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        Fireball fireball = game.getFireball();
        if (e.getOtherBody() instanceof Fireball) {
            System.out.println("Fire Style: Fireball Jutsu");
            e.getReportingBody().destroy();
            e.getOtherBody().destroy();

            try {
                gameMusic = new SoundClip("data/die.mp3");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ListenerEnemy.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ListenerEnemy.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ListenerEnemy.class.getName()).log(Level.SEVERE, null, ex);
            }
            gameMusic.play();
            System.out.println(e);
        }
    }
}
