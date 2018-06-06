package game;

import city.cs.engine.*;
import static game.Game.menuend;
import javax.swing.JFrame;

/**
 * @author Steve, Odai-Stephens, steve.odai-stephens@city.ac.uk
 * @version 3.0
* Simple character
 */
public class Dragon extends Walker {

    /**
     *shape variable stores a polygonshape which will be used as a wrap around for the images below
     */
    private static final Shape shape = new PolygonShape(-3.67f, -0.22f, -2.19f, -2.44f, 2.25f, -2.45f, 3.6f, 0.64f, -0.11f, 1.93f, -3.08f, 0.72f);

    /**
     * image variable of type BodyImagee stores an image with a size of 5
     */
    private static final BodyImage image
            = new BodyImage("data/dragon1.gif", 5f);

    /**
     * image2 variable of type BodyImagee stores an image with a size of 5
     */  
    private static final BodyImage image2
            = new BodyImage("data/dragon.gif", 5f);

    /**
     * gameMusic variable is of type SoundClip and will store an audio file
     */
    public SoundClip gameMusic;

    /**
     * count variable is of type int and stores a number of coins
     */
    private int count;

    /**
     * lives variable is of type int and stores a number of lives
     */
    private int lives;

    /**
     * outputLife variable is of type String and stores the number of lives as a String
     */
    private String outputLife;

    /**
     * outputCoin variable is of type String and stores the number of coins as a String
     */
    private String outputCoin;

    /**
     * game variable is of type game which is the computer game the user will be playing
     */
    public Game game;

    /**
     *  Initialise a new dragon
     * @param world this is the world
     * @param game this is the game world the user is playing in
     */
    public Dragon(World world, Game game) {
        super(world, shape);
        addImage(image);
        this.game = game;
        count = 0;
        lives = 1;
        outputLife = "x " + lives;
        outputCoin = "x " + count;
        gameMusic = game.gameMusic;
    }

    /**
     * gets the coin count of the dragon
     * @return the coin count
     */
    public int getCount() {
        return count;
    }

    /**
     * gets the lives count of the dragon
     * @return the lives count
     */
    public int getLives() {
        return lives;
    }

    /**
     * gets the coins count
     * @return the coins count
     */
    public String getOutputCoin() {
        return outputCoin;
    }

    /**
     * gets the lives count
     * @return the lives count
     */
    public String getOutputLife() {
        return outputLife;
    }

    /**
     *  sets the coin count of the dragon
     * @param count this is the count of coins
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * sets the lives count of the dragon
     * @param lives this is the count of lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * increments the value of the coins
     */
    public void addOne() {
        count++;
        outputCoin = "x " + count;
        System.out.println("Coin Count: " + count);
    }

    /**
     * decrements the value of lives
     */
    public void loseLives() {
        lives--;
        outputLife = "x " + lives;
        System.out.println("Life Count: " + lives);
    }
    
    /**
     * increments the value of lives
     */
    public void gainLives() {
        lives++;
        outputLife = "x " + lives;
        System.out.println("Life Count: " + lives);
    }

    /**
     * this method opens the game over menu if the dragon dies
     */
    public void dieDragon() {
        getOutputLife();
        
        if (lives < 1) { 
            game.gameMusic.stop();
            System.out.println("Yay it works");
            MenuEnd end = new MenuEnd();
            end.setVisible(true);
            menuend.setSize(538, 543);
            menuend.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuend.setVisible(true);
            menuend.add(end);
            game.frame.dispose();
        }
        
    }

    /**
     *  swaps between two images
     * @param dir should include false value
     */
    public void swapimage(boolean dir) {
        if (dir) {
            this.removeAllImages();
            addImage(image);
        } else {
            this.removeAllImages();
            addImage(image2);
        }
    }
}
