package basketball;

import java.awt.Graphics;
import java.awt.Image;


/**
 * 
 * The Court class develops the details of how the court and its pieces are
 * designed. This class includes multiple methods which are referred to
 * throughout the package which help with events such as getting initializing
 * both players at a certain x and y coordinate, updating scoreboard graphics
 * after a score, and calculating distance between players or player and hoop.
 * All of this is done within the Court class because data such as court height,
 * court width, the player array and the reset method are all stored in this
 * class.
 *
 * @author Lakshay Maharana, Sunhoo Ahn, Shree Phadke
 * @version May 25, 2019
 * @author Period: 3
 * @author Assignment: Game
 *
 * @author Sources:
 */

public class Court
{ 

    private static final int WIDTH = 1440;

    private static final int HEIGHT = 810;

    private static Player[] players;

    private static Player winner;

    private static Player loser;

    private Image score1;

    private Image score2;

    private Image scored;
    
    public static int p1score;

    public static int p2score;
    // pos is zero right now

    private static Ball ball;


    /**
     * This is the constructor for the Court class which involves establishing
     * the width and height initializing each player and the ball onto the court
     * on a certain x and y coordinate, and also sets each player to a certain
     * index in the players array.
     */
    public Court()
    {
        players = new Player[2];

        players[0] = new Player( WIDTH / 3, HEIGHT / 2, 1 );
        players[1] = new Player( WIDTH / 2, HEIGHT / 2, 2 );

        winner = players[0];
        loser = players[1];

        ball = new Ball();

        scored = new javax.swing.ImageIcon( "score.png" ).getImage();
    }


    /**
     * 
     * This helper method sets the image of the scoreboard depending on how many
     * points the player score. The method is called in the GUI class and
     * adjusts the image of the RED scoreboard depending on how many points the
     * player scores.
     * 
     * @param g
     *            The graphics object which draws the scoreboard graphics
     */
    public void drawScore1( Graphics g )
    {

        if ( players[0].getScore() == 0 )
        {
            score1 = new javax.swing.ImageIcon( "0.png" ).getImage();
            p1score = 0;

        }
        else if ( players[0].getScore() == 1 )
        {
            score1 = new javax.swing.ImageIcon( "1.png" ).getImage();
            p1score = 1;
        }
        else if ( players[0].getScore() == 2 )
        {
            score1 = new javax.swing.ImageIcon( "2.png" ).getImage();
            p1score = 2;

        }
        else if ( players[0].getScore() == 3 )
        {
            score1 = new javax.swing.ImageIcon( "3.png" ).getImage();
            p1score = 3;

        }
        else if ( players[0].getScore() == 4 )
        {
            score1 = new javax.swing.ImageIcon( "4.png" ).getImage();
            p1score = 4;

        }
        else if ( players[0].getScore() == 5 )
        {
            score1 = new javax.swing.ImageIcon( "5.png" ).getImage();
            p1score = 5;

        }
        else if ( players[0].getScore() == 6 )
        {
            score1 = new javax.swing.ImageIcon( "6.png" ).getImage();
            p1score = 6;

        }
        else if ( players[0].getScore() == 7 )
        {
            score1 = new javax.swing.ImageIcon( "7.png" ).getImage();
            p1score = 7;

        }
        else if ( players[0].getScore() == 8 )
        {
            score1 = new javax.swing.ImageIcon( "8.png" ).getImage();
            p1score = 8;

        }
        else if ( players[0].getScore() == 9 )
        {
            score1 = new javax.swing.ImageIcon( "9.png" ).getImage();
            p1score = 9;

        }
        else if ( players[0].getScore() == 10 )
        {
            score1 = new javax.swing.ImageIcon( "10.png" ).getImage();
            p1score = 10;

        }
        else if ( players[0].getScore() == 11 )
        {
            score1 = new javax.swing.ImageIcon( "11.png" ).getImage();
            p1score = 11;

        }

    }


    /**
     * 
     * This helper method sets the image of the scoreboard depending on how many
     * points the player score. The method is called in the GUI class and
     * adjusts the image of the BLUE scoreboard depending on how many points the
     * player scores.
     * 
     * @param g
     *            The graphics object which draws the scoreboard graphics
     */
    public void drawScore2( Graphics g )
    {

        if ( players[1].getScore() == 0 )
        {

            score2 = new javax.swing.ImageIcon( "0b.png" ).getImage();
            p2score = 0;
        }
        else if ( players[1].getScore() == 1 )
        {
            score2 = new javax.swing.ImageIcon( "1b.png" ).getImage();
            p2score = 1;

        }
        else if ( players[1].getScore() == 2 )
        {
            score2 = new javax.swing.ImageIcon( "2b.png" ).getImage();
            p2score = 2;

        }
        else if ( players[1].getScore() == 3 )
        {
            score2 = new javax.swing.ImageIcon( "3b.png" ).getImage();
            p2score = 3;

        }
        else if ( players[1].getScore() == 4 )
        {
            score2 = new javax.swing.ImageIcon( "4b.png" ).getImage();
            p2score = 4;

        }
        else if ( players[1].getScore() == 5 )
        {
            score2 = new javax.swing.ImageIcon( "5b.png" ).getImage();
            p2score = 5;

        }
        else if ( players[1].getScore() == 6 )
        {
            score2 = new javax.swing.ImageIcon( "6b.png" ).getImage();
            p2score = 6;

        }
        else if ( players[1].getScore() == 7 )
        {
            score2 = new javax.swing.ImageIcon( "7b.png" ).getImage();
            p2score = 7;

        }
        else if ( players[1].getScore() == 8 )
        {
            score2 = new javax.swing.ImageIcon( "8b.png" ).getImage();
            p2score = 8;

        }
        else if ( players[1].getScore() == 9 )
        {
            score2 = new javax.swing.ImageIcon( "9b.png" ).getImage();
            p2score = 9;

        }
        else if ( players[1].getScore() == 10 )
        {
            score2 = new javax.swing.ImageIcon( "10.png" ).getImage();
            p2score = 10;

        }
        else if ( players[1].getScore() == 11 )
        {
            score2 = new javax.swing.ImageIcon( "11.png" ).getImage();
            p2score = 11;

        }

    }


    /**
     * 
     * This method returns the image that says "SCORE!" when a player makes a
     * shot and is designed to be a helper method that the GUI class calls when
     * the ball enters the hoop.
     * 
     * @return the Image object scored which is a large green banner with the
     *         text "SCORE!"
     */
    public Image scoredDisplay()
    {
        return scored;
    }


    /**
     * 
     * This method returns the image corresponding to the number of points
     * Player 1 has scored in the game and it is the same image that shows up on
     * the scoreboard. This is a helper method that is called in the GUI class
     * when developing the scoreboard's graphics.
     * 
     * @return the Image object which has the correct number corresponding to
     *         the score Player 1 has
     */
    public Image getScore1()
    {
        return score1;
    }


    /**
     * 
     * This method returns the image corresponding to the number of points
     * Player 2 has scored in the game and it is the same image that shows up on
     * the scoreboard. This is a helper method that is called in the GUI class
     * when developing the scoreboard's graphics.
     * 
     * @return the Image object which has the correct number corresponding to
     *         the score Player 2 has
     */
    public Image getScore2()
    {
        return score2;
    }


    /**
     * 
     * This method compares the scores between Player 1 and Player 2 to
     * determine who is the winner.
     * 
     * @return The player object of the player with a higher score is returned
     *         as a result of this method.
     */
    public static Player getWinner()
    {
        return winner;
    }


    /**
     * 
     * This method compares the scores between Player 1 and Player 2 to
     * determine who is the loser.
     * 
     * @return The player object of the player with a lower score is returned as
     *         a result of this method.
     */
    public static Player getLoser()
    {
        return loser;
    }


    /**
     * 
     * This method calculate the horizontal distance between the two players
     * using their getX methods and is designed to be a helper method for the
     * Player class's methods such as collide() as the method depends on using
     * the players' distance to set boundaries.
     * 
     * @return The method returns the horizontal distance between the two
     *         players as an integer
     */
    public static int getXDistance()
    {
        return Math.abs( players[0].getX() - players[1].getX() );
    }


    /**
     * 
     * This method calculate the vertical distance between the two players using
     * their getY methods and is designed to be a helper method for the Player
     * class's methods such as collide() as the method depends on using the
     * players' distance to set boundaries.
     * 
     * @return The method returns the vertical distance between the two players
     *         as an integer
     */
    public static int getYDistance()
    {
        return Math.abs( players[0].getY() - players[1].getY() );
    }


    /**
     * 
     * This method calculates the distance between the player who possesses the
     * ball and the x coordinate 1220, which is the center of the hoop and is a
     * helper method for the Player class's methods such as collide().
     * 
     * @return The method returns difference in x coordinates between the hoop
     *         and the offensive player's x coordinates.
     */
    public static int hoopXDistance()
    {
        if ( players[0].hasBall() )
        {
            return Math.abs( 1220 - players[0].getX() );
        }

        if ( players[1].hasBall() )
        {
            return Math.abs( 1220 - players[1].getX() );
        }
        return 0;
    }


    /**
     * 
     * This method calculates the distance between the player who possesses the
     * ball and the y coordinate 231, which is the center of the hoop. The
     * method is a helper method for the Player class's methods such as
     * getShotChance() because the method relies on calculating shot probability
     * based on the distance between the player and hoop.
     * 
     * @return The method returns difference in y coordinates between the hoop
     *         and the offensive player's y coordinates.
     */
    public static int hoopYDistance()
    {
        if ( players[0].hasBall() )
        {
            return Math.abs( 231 - players[0].getY() );
        }

        if ( players[1].hasBall() )
        {
            return Math.abs( 231 - players[1].getY() );
        }

        return 0;
    }


    /**
     * When the ball is in the hoop, as in the player has scored, this method
     * resets the players' positions depending on who won the point. For
     * example, if player B steals the ball from player A and makes, the new
     * reset positions will display player B with the ball and player A guarding
     * and vice versa.
     */
    public static void reset()
    {

        // Ball.in = false;

        winner.setX( WIDTH / 3 );
        winner.setY( HEIGHT / 2 );
        loser.setX( WIDTH / 2 );
        loser.setY( HEIGHT / 2 );

        // System.out.println(winner.number);

        winner.setHasBall( true );
        // Ball.possessed = true;
        loser.setHasBall( false );

        // System.out.println("b " + Ball.possessed);

        Ball.setIn( false );
 
        try
        {
            Thread.sleep( 1000 );
        }
        catch ( InterruptedException e )
        {
            // Auto-generated catch block
            e.printStackTrace();
        }

        if ( winner.getScore() >= 10 )
        {

            // end game

            try
            {
                Thread.sleep( Long.MAX_VALUE );
            }
            catch ( InterruptedException e )
            {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    /**
     * This method simply returns the player who is in possession of the ball.
     * 
     * @return player that has the ball
     */
    public static Player who()
    {
        if ( players[0].hasBall() )
        {
            return players[0];
        }
        else if ( players[1].hasBall() )
        {
            return players[1];
        }
        return null;
    }


    /**
     * The getter method for the court's width.
     * 
     * @return width of the court
     */
    public static int getWidth()
    {
        return WIDTH;

    }


    /**
     * The getter method for the court's height.
     * 
     * @return height of the court
     */
    public static int getHeight()
    {
        return HEIGHT;
    }


    /**
     * The getter method for the array of Player objects.
     * 
     * @return array of players
     */
    public static Player[] getPlayer()
    {
        // player1
        return players;
    }


    /**
     * The getter method for the ball object.
     * 
     * @return ball
     */
    public static Ball getBall()
    {
        return ball;
    }


    /**
     * This method keeps track of the players' scores and decides what player 
     * gets the ball after the shot has been made. 
     */
    public static void checkScore()
    {

        // System.out.println("aa");
        if ( players[0].getIsShooting() == 1 && Ball.getIn() )
        {

            // players[0].scoreIncrease();

            winner = players[0];
            loser = players[1];

            players[0].setIsShooting( 0 );
            reset();

            System.out.println( "Player 1 " + players[0].getScore() );

            Ball.setIn( false );

        }

        else if ( players[1].getIsShooting() == 2 && Ball.getIn() )
        {
            // players[1].scoreIncrease();

            winner = players[1];
            loser = players[0];

            players[1].setIsShooting( 0 );

            reset();

            System.out.println( "Player 2 " + players[1].getScore() );
            Ball.setIn( false );
        }

    }


    /**
     * If a player has posession of the ball, the boolean value of the 
     * respective player's hasBall is made true, else false if they do not have
     * possession.
     */
    public static void changePoss()
    {

        if ( players[0].hasBall() )
        {

            players[0].setHasBall( false );
            players[1].setHasBall( true );
            // System.out.println("a");

        }

        else if ( players[1].hasBall() )
        {
            players[1].setHasBall( false );
            players[0].setHasBall( true );

        }
    }

}



