package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Steve, Odai-Stephens, steve.odai-stephens@city.ac.uk
 * @version 3.0
 */
public class Controller extends KeyAdapter {

    // class body

    /**
     *  STOP_WALKING variable stores value 0 and will be used for motion;
     */
    private static final float STOP_WALKING = 0;

    /**
     *  JUMPING_SPEED variable stores value 15 and will be used for motion;
     */
    private static final float JUMPING_SPEED = 15;

    /**
     *  WALKING_SPEED variable stores value 10 and will be used for motion;
     */
    private static final float WALKING_SPEED = 10;

    /**
     *  body variable is of type Walker and represents character the player will be using
     */
    private Walker body;

    /**
     *  view variable of WorldView class 
     */
    private final WorldView view;

    /**
     * game variable is of type game which is the computer game the user will be playing
     */
    private final Game game;

    /**
     * variable of SoundClip class 
     */
    private SoundClip gameMusic;

    /**
     *  governs the way in which the character will be controlled in the game
     * @param body  contains the Dragon
     * @param view contains the WorldView
     * @param game contains the Game class
     */
    public Controller(Walker body, WorldView view, Game game) {
        this.body = body;
        this.view = view;
        this.game = game;
    }

    /**
     * Handle key press events for walking, jumping and shooting fireballs in both directions
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
            if (body instanceof Dragon) {
                ((Dragon) body).swapimage(false);
            }
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            if (body instanceof Dragon) {
                ((Dragon) body).swapimage(true);
            }
        } else if (code == KeyEvent.VK_L) {
            DynamicBody fireball = new Fireball(view.getWorld());
            Dragon drake = game.getPlayer();
            fireball.setPosition(new Vec2(drake.getPosition().x + 4, drake.getPosition().y));
            fireball.setLinearVelocity(new Vec2(50, 5));
            try {
                gameMusic = new SoundClip("data/fireballjutsu.mp3");
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                System.out.println(e);
            }
        } else if (code == KeyEvent.VK_J) {
            DynamicBody fireball = new Fireball(view.getWorld());
            Dragon drake = game.getPlayer();
            fireball.setPosition(new Vec2(drake.getPosition().x - 4, drake.getPosition().y));
            fireball.setLinearVelocity(new Vec2(-50, 5));
            try {
                gameMusic = new SoundClip("data/fireballjutsu.mp3");
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                System.out.println(e);
            }
        }
    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.startWalking(STOP_WALKING);
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(STOP_WALKING);
        }
    }

    /**
     * Method allows controls set specificied above to be utilised
     *
     * @param body This is should include body variable which is of type Walker and represents character the player will be using
     */
    public void setBody(Walker body) {
        this.body = body;
    }
}
