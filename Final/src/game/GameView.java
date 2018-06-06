package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import static game.Game.menuend;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * extended view
 */
public class GameView extends UserView implements ActionListener {

    /**
     * instantiating a variable of Dragon class
     */
    Dragon drake;

    /**
     * instantiating a variable of Enemy1 class
     */
    Enemy1 mob;

    /**
     * instantiating a variable of Game class
     */
    Game game;

    /**
     * timer is a variable of type Timer which sets a new timer
     */
    private Timer timer;

    /**
     * time is a variable of type int which holds the number 99
     */
    public int time = 99;

    /**
     * time0 is a variable of type int which holds the number 0;
     */
    public int time0 = 0;

    /**
     * background1 is a variable of type Image which holds a background image
     */
    private Image background1,
            /**
             * background2 is a variable of type Image which holds a background
             * image
             */
            background2,
            /**
             * background3 is a variable of type Image which holds a background
             * image
             */
            background3,
            /**
             * background4 is a variable of type Image which holds a background
             * image
             */
            background4,
            /**
             * hp is a variable of type Image which holds an image
             */
            hp,
            /**
             * coin is a variable of type Image which holds an image
             */
            coin;

    /**
     * name is a variable of type String which holds an empty String
     */
    public static String name = "";

    /**
     * Initialises a new GameView
     *
     * @param world the world
     * @param drake the dragon
     * @param width width of view
     * @param height height of view
     * @param game this is the game world the user is playing in
     */
    public GameView(World world, Dragon drake, int width, int height, Game game) {
        super(world, width, height);
        this.drake = drake;
        this.mob = mob;
        this.game = game;
        this.background1 = new ImageIcon("data/background1.gif").getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        this.background2 = new ImageIcon("data/background2.gif").getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        this.background3 = new ImageIcon("data/background3.gif").getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        this.background4 = new ImageIcon("data/background4.gif").getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);

        this.hp = new ImageIcon("data/hp.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        this.coin = new ImageIcon("data/coin.gif").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);

        timer = new Timer(1000, this);
        timer.start();
    }

    /**
     * sets the dragon variable to the current instance
     *
     * @param drake the dragon
     */
    public void setDragon(Dragon drake) {
        this.drake = drake;
    }

    /**
     * gets the time
     *
     * @return the time as a string
     */
    public String getStringTime() {
        return Integer.toString(time);
    }

    /**
     * gets the time
     *
     * @return the time as int
     */
    public int getIntTime() {
        return time;
    }

    /**
     * get the time
     *
     * @return the time
     */
    public int getGameTime() {
        return time0;
    }

    /**
     * This method draws the background images for the levels
     *
     * @param g the graphics
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.level == 1) {
            g.drawImage(background1, 0, 0, this);
        } else if (game.level == 2) {
            g.drawImage(background2, 0, 0, this);
        } else if (game.level == 3) {
            g.drawImage(background3, 0, 0, this);
        } else {
            g.drawImage(background4, 0, 0, this);
        }
    }

    /**
     * This method prints to the foreground of the levels
     *
     * @param g the graphics
     */
    @Override
    protected void paintForeground(Graphics2D g
    ) {
        Font font = new Font("SansSerif", Font.BOLD, 24);
        Font levelFont = new Font("SansSerif", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(drake.getOutputLife(), 80, 40);
        g.drawString(drake.getOutputCoin(), 950, 40);
        //g.drawString(mob.getOutputScore(), 450, 90);
        g.drawString("Level: " + game.getLevelCount(), 450, 20);
        g.drawImage(hp, 5, 1, this);
        g.drawImage(coin, 880, 5, this);
        g.drawString(name, 460, 100);
        g.setFont(levelFont);
        g.drawString(getStringTime(), 460, 70);
    }

    /**
     * This method opens up game over menu when time is up
     *
     * @param ae action event
     */
    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        time -= 1;
        time0 += 1;
        if (time <= 0) {
            MenuEnd end = new MenuEnd();
            end.setVisible(true);
            menuend.setSize(538, 543);
            menuend.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuend.setVisible(true);
            menuend.add(end);
            game.frame.dispose();
            game.gameMusic.stop();
        }
    }
}
