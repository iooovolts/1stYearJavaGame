package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Steve Odai-Stephens
 * Collision listener that allows the dragon to collect things.
 */
public class ListenerHealth implements CollisionListener {

    /**
     * instantiating a variable of Dragon class
     */
    private Dragon drake;

    /**
     * instantiating a variable of SoundClip class
     */
    private SoundClip gameMusic;
    
    /**
     * this method sets the dragon variable to the current instance
     * @param drake the dragon
     */
    public ListenerHealth(Dragon drake) {
        this.drake = drake;
    }

    /**
     * This method allows the dragon to pick up health
     * @param e collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == drake) {
            drake.gainLives();
            e.getReportingBody().destroy();
            
            try {
                gameMusic = new SoundClip("data/hppickup.mp3");
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                System.out.println(e);
            }
        }    
    }
}
