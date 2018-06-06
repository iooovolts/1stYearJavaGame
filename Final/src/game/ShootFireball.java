package game;

import city.cs.engine.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.jbox2d.common.Vec2;

/**
 * @author Steve Odai-Stephens
 * A MouseListener that drops a bowling ball on each mouse press.
 */
public class ShootFireball extends KeyAdapter {

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private WorldView view;

    /**
     * variable of type SoundClip
     */
    private SoundClip gameMusic;
    /**
     * Construct a listener.
     *
     */
    private Game game;

    /**
     * This methods sets the variables to the current instance
     * @param view gameview
     * @param game the game
     */
    public ShootFireball(WorldView view, Game game) {
        this.view = view;
        this.game = game;

    }

    /**
     * Create a fireball at the current mouse position.
     * @param e event object containing the key
     */

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_J) {
            DynamicBody fireball = new Fireball(view.getWorld());
            Dragon drake = game.getPlayer();
            fireball.setPosition(new Vec2(drake.getPosition().x + 4, drake.getPosition().y));
            fireball.setLinearVelocity(new Vec2(50, 5));
        } else if (code == KeyEvent.VK_L) {
            DynamicBody fireball = new Fireball(view.getWorld());
            Dragon drake = game.getPlayer();
            fireball.setPosition(new Vec2(drake.getPosition().x - 4, drake.getPosition().y));
            fireball.setLinearVelocity(new Vec2(-50, 5));
        }
    }
}
