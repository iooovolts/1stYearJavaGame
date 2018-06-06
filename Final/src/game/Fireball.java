package game;

import city.cs.engine.*;

/**
 *
 * @author Steve Odai-Stephens
 */
public class Fireball extends DynamicBody {

    /**
     * img variable of type BodyImage creates a new BodyImage of size 4
     */
    private static final BodyImage ballImage = new BodyImage("data/fireball.gif", 4);

    /**
     * score variable is of type int and stores the score
     */
    public int score;

    /**
     * outputScore variable is of type String and stores the score
     */
    private String outputScore;
    
    /**
     * Initialise a new Fireball;
     * @param world the world
     */
    public Fireball(World world) {
        super(world, new PolygonShape(0.426f,0.596f, 0.928f,0.156f, 0.934f,-0.28f, 0.329f,-0.605f, -0.192f,-0.371f, -0.176f,0.352f));
        addImage(ballImage);
        score = 0;
        outputScore = "Score:" + score;
    }

    /**
     * gets the score count
     * @return the score value
     */
    public int getScore() {
        return score;
    }

    /**
     * sets the score 
     * @param score this is the new score
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * increments the score value
     */
    public void addScore() {
        score++;
        outputScore = "Score:" + score;
        System.out.println("Score Count: "+ score);
    }
    
    /**
     * gets the score count
     * @return the score count
     */
    public String getOutputScore(){
        return outputScore;
    }
}
