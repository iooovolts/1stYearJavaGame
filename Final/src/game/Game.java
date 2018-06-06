package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private final GameView view;

    /**
     * variable of Enemy1 class
     */
    private Enemy1 mob;

    /**
     * level is variable of type int which will store the game levels
     */
    public int level;

    /**
     * variable of Dragon class
     */
    private Dragon drake;

    /**
     * variable of Controller class
     */
    private final Controller controller;

    /**
     * variable of type SoundClip 
     */
    public SoundClip gameMusic;

    /**
     * game variable is of type game which is the computer game the user will be playing
     */
    private Game game;

    /**
     * time1 is a variable of int which stores time of level
     */
    private int time1;

    /**
     * menu is a variable of type JFrame which creates new JFrame
     */
    public static JFrame menu = new JFrame();

    /**
     * menuname is a variable of type JFrame which creates new JFrame
     */
    public static JFrame menuname = new JFrame();

    /**
     * menuscore is a variable of type JFrame which creates new JFrame
     */
    public static JFrame menuscore = new JFrame();

    /**
     * menuend is a variable of type JFrame which creates new JFrame
     */
    public static JFrame menuend = new JFrame();

    /**
     * frame is a variable of type JFrame which creates new JFrame
     */
    final JFrame frame = new JFrame("Smaug Returns: Dark Eclipse");

    /**
     * name is a variable of type String which stores an empty string
     */
    public static String name = "";

    /**
     * Initialise a new Game.
     * @throws java.io.IOException runtime error occurred while trying to run file
     */
    public Game() throws IOException {
        // make the world

        level = 1;
        world = new Level1();
        world.populate(this);

        try {
            gameMusic = new SoundClip("data/background.mp3");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // make a view
        view = new GameView(world, world.getPlayer(), 1000, 650, this);
//        view.addKeyListener(new ShootFireball(view, this));

        // display the view in a frame
        Container buttons = new MenuTop(getWorld());
        frame.add(buttons, BorderLayout.NORTH);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);

        // don't let the game window be resized
        frame.setResizable(true);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        controller = new Controller(world.getPlayer(), view, this);
        frame.addKeyListener(controller);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1000, 650);

        world.start();
    }

    /**
     * gets the world
     * @return the world
     */
    
    public World getWorld() {
        return world;
    }

    /**
     * gets the level value
     * @return the level value
     */
    public int getLevelCount() {
        return level;
    }

    /**
     * gets the player in the current level.
     * @return the player in the current level
     */
    public Dragon getPlayer() {
        return world.getPlayer();
    }

    /**
     * gets the fireball
     * @return the fireball in the current level
     */
    public Fireball getFireball() {
        return world.getFireball();
    }

    /**
     * Is the current level of the game finished?
     * @return the method is completed in the world
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * this is the method that destroys the enemy
     */
    public void destroyMob() {
        mob.destroy();
    }

    /**
     * Advance to the next level of the game.
     * @throws java.io.IOException runtime error occurred while trying to run file
     */
    public void goNextLevel() throws IOException {
        world.stop();
        // create temp vars for coins + lives
        int lives = world.getPlayer().getLives();
        int coins = world.getPlayer().getCount();

        if (level == 4) {

//            WriteFile data = new WriteFile("sample.txt", true);
//            data.writeToFile("Highscore " + view.getStringTime());
//            System.out.println("Text File Written To");
            MenuStart start = new MenuStart();
            start.setVisible(true);
            menu.setSize(538, 543);
            menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menu.setVisible(true);
            menu.add(start);
            frame.dispose();
            gameMusic.stop();

        } else if (level == 3) {
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            //coin count continues
            world.getPlayer().setCount(coins);
            world.getPlayer().setLives(lives);

            world.start();

            view.setDragon(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);

        } else if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            //coin count continues
            world.getPlayer().setCount(coins);
            world.getPlayer().setLives(lives);

            world.start();

            view.setDragon(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);

        } else {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            time1 = view.getIntTime();
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            //coin count continues
            world.getPlayer().setCount(coins);
            world.getPlayer().setLives(lives);

            world.start();

            view.setDragon(world.getPlayer());
            view.getStringTime();
            // show the new world in the view
            view.setWorld(world);

            WriteFile data = new WriteFile("sample.txt", true);
            data.writeToFile(view.getGameTime() + " seconds" + System.lineSeparator());
            System.out.println("Text File Written To");
        }
    }

    /**
     * Run the game.
     * @param args unused
     * @throws java.io.IOException runtime error occurred while trying to run file
     */
    public static void main(String[] args) throws IOException {

        MenuStart start = new MenuStart();
        start.setVisible(true);

        menu.setSize(538, 543);
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setVisible(true);
        menu.add(start);

    }
}
