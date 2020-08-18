package basketball;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;


/**
 * 
 * The player class designs the movement,controls, and boundaries of both
 * players on the court The class details multiple features of each player on
 * the court including detecting the number of points they score per shot,
 * calculating the miss and make probability depending on the player's distance,
 * creating collisions between players so no player object can go through
 * another, and also setting boundaries of the player. it represents, and how to
 * use it.
 *
 * @author Lakshay Maharana, Sunhoo Ahn, Shree Phadke
 * @version May 24, 2019
 * @author Period: 3
 * @author Assignment: Game
 *
 * @author Sources:
 *         https://www.gamedev.net/forums/topic/348728-java-smooth-keyboard-input/
 *         https://www.gamedev.net/forums/topic/348728-java-smooth-keyboard-input/
 */
public class Player implements KeyListener
{

    private int posX;

    private int posY;

    private boolean hasBall;

    private Image image;

    private int speed;

    private int vX, vY;

    private boolean up, down, left, right, space, s;

    public int number;

    private int isShooting;

    public int points;

    private int score;


    /**
     * Player class constructor which constructs where player is going to be
     * placed and if the player is player1 or player2 on the court.
     * 
     * @param positionX
     *            the initial x-coordinate of the player
     * @param positionY 
     *            the initial y-coordinate of the player
     * @param code
     *            code associated with player which can be 1 or 2
     */
    public Player( int positionX, int positionY, int code )
    {

        posX = positionX;
        posY = positionY;

        speed = 5;

        number = code;
        isShooting = 0;
        score = 0;

        if ( number == 1 )
        {
            hasBall = true;

        }

        else if ( number == 2 )
        {
            hasBall = false;
        }

        if ( hasBall )
            speed = 4;
    }


    /**
     * 
     * This method returns the number code of the Player who is shooting the
     * ball at that time.
     * 
     * @return The number code corresponding to the player who is shooting the
     *         ball
     */
    public int getIsShooting()
    {
        return isShooting;
    }


    /**
     * 
     * This method is setter method for the field isShooting and sets which
     * player is shooting the ball.
     * 
     * @param num
     *            The number code of the player who is shooting the ball
     */
    public void setIsShooting( int num )
    {
        isShooting = num;
    }


    /**
     * 
     * This is the getter method for the score of the game.
     * 
     * @return The current score of the game
     */
    public int getScore()
    {
        return score;
    }


    /**
     * 
     * This method increases the score of the game if the player makes a shot
     * and calls upon the helper method calculatePoints to calculate if the
     * player gets 2 or 3 points.
     */
    public void scoreIncrease()
    {
        score += calculatePoints();
    }


    /**
     * 
     * This is the getter method for the player's x coordinate.
     * 
     * @return posX which is the x coordinate of the player
     */
    public int getX()
    {
        return posX;
    }


    /**
     * 
     * This is the getter method for the player's y coordinate.
     * 
     * @return posY which is the y coordinate of the player
     */
    public int getY()
    {
        return posY;
    }


    /**
     * 
     * This is the setter method for the player's x coordinate
     * 
     * @param positionX
     *            the desired x position for the player to be set to
     */
    public void setX( int positionX )
    {
        posX = positionX;
    }


    /**
     * 
     * This is the setter method for the player's y coordinate
     * 
     * @param positionY
     *            the desired y position for the player to be set to
     */
    public void setY( int positionY )
    {
        posY = positionY;
    }


    /**
     * 
     * This method determines if the player possesses the ball or not
     * 
     * @return The method returns hasBall, a boolean which is set to true or
     *         false depending on if the player has the ball
     */
    public boolean hasBall()
    {
        return hasBall;
    }


    /**
     * 
     * This method sets the boolean hasBall.
     * 
     * @param poss
     *            this parameter indicates whether or not the player possesses
     *            the ball and sets hasBall accordingly.
     */
    public void setHasBall( boolean poss )
    {
        hasBall = poss;
    }


    /**
     * 
     * This method is a helper method that helps the Ball class determine if the
     * player possesses the ball or not based on the boolean hasBall
     */
    public void shoot()
    {
        if ( hasBall )
        {
            Ball.beingShot = true;
            Ball.shootMotion();
            Ball.shotChance();
        }
    }


    /**
     * 
     * This method draws the player onto the court depending on what the code of
     * the player when initialized.
     * 
     * @param g
     *            The graphics object which loads the player image
     */
    public void drawPlayer( Graphics g )
    {
        if ( number == 1 )
        {

            image = new javax.swing.ImageIcon( "player.png" ).getImage();

            if ( right )
            {
                image = new javax.swing.ImageIcon( "p1rt.gif" ).getImage();
                if ( left )
                    image = new javax.swing.ImageIcon( "p1left.gif" ).getImage();
                if ( space )
                {
                    image = new javax.swing.ImageIcon( "p1shooting.gif" ).getImage();

                }

            }

            if ( left )
            {
                image = new javax.swing.ImageIcon( "p1left.gif" ).getImage();
                if ( right )
                    image = new javax.swing.ImageIcon( "p1rt.gif" ).getImage();
                if ( space )
                {
                    image = new javax.swing.ImageIcon( "p1shooting.gif" ).getImage();

                }
            }

            if ( up || down )
            {
                image = new javax.swing.ImageIcon( "p1updown.gif" ).getImage();
                if ( space )
                {
                    image = new javax.swing.ImageIcon( "p1shooting.gif" ).getImage();

                }
            }

            if ( space && posX > 1225 )
            {
                image = new javax.swing.ImageIcon( "p1shootingleft.gif" ).getImage();

            }

            else if ( space )
                image = new javax.swing.ImageIcon( "p1shooting.gif" ).getImage();

        }
        else if ( number == 2 )
        {
            image = new javax.swing.ImageIcon( "player2.png" ).getImage();

            if ( right )
            {
                image = new javax.swing.ImageIcon( "p2right.gif" ).getImage();
                if ( s )
                {
                    image = new javax.swing.ImageIcon( "p2shooting.gif" ).getImage();

                }
            }

            else if ( left )
            {
                image = new javax.swing.ImageIcon( "p2left.gif" ).getImage();

                if ( right )
                    image = new javax.swing.ImageIcon( "p2right.gif" ).getImage();

                if ( s )
                {
                    image = new javax.swing.ImageIcon( "p2shooting.gif" ).getImage();

                }
            }

            else if ( up || down )
            {
                image = new javax.swing.ImageIcon( "p2updown.gif" ).getImage();
                if ( s )
                {
                    image = new javax.swing.ImageIcon( "p2shooting.gif" ).getImage();

                }
            }

            else if ( s && posX > 1225 )
            {
                image = new javax.swing.ImageIcon( "p2shootingleft.gif" ).getImage();

            }

            else if ( s && posX <= 1225 )
            {
                image = new javax.swing.ImageIcon( "p2shooting.gif" ).getImage();

            }

            else
            {
                image = new javax.swing.ImageIcon( "player2.png" ).getImage();

            }

        }

    }


    /**
     * 
     * This is the getter method for the player's image.
     * 
     * @return the image of the player which is a field
     */
    public Image getPlayerImage()
    {
        return image;
    }


    /**
     * Not used.
     * 
     * @param e
     *            KeyEvent
     */
    @Override
    public void keyTyped( KeyEvent e )
    {
        // Auto-generated method stub

    }


    // source:
    // https://www.gamedev.net/forums/topic/348728-java-smooth-keyboard-input/
    /**
     * 
     * This is the method which moves the player depending on which boolean is
     * set true for direction and adds or subtracts to the x and y velocity.
     */
    public void move()
    {

        vX = 0;
        vY = 0;
        if ( down )
            vY = speed;
        if ( up )
            vY = -speed;
        if ( left )
            vX = -speed;
        if ( right )
            vX = speed;

    }


    /**
     * 
     * This method is a helper method for the ball class that calculates the
     * probability of the shot going into the hoop based on distance to the hoop
     * and distance and opposing player.
     * 
     * @return the calculated probability of the ball making it into the hoop
     */
    public static double getShotChance()
    {
        int hoopDistance = (int)Math
            .sqrt( Math.pow( Court.hoopXDistance(), 2 ) - Math.pow( Court.hoopYDistance(), 2 ) );
        double probability = ( 1 - ( hoopDistance ) / ( 1447.5 ) ) - 0.2;

        int playerDistance = (int)Math
            .sqrt( Math.pow( Court.getXDistance(), 2 ) - Math.pow( Court.getYDistance(), 2 ) );

        System.out.println( playerDistance );
        if ( playerDistance < 120 )
        {
            probability -= 0.28;
        }

        return probability;

    }


    /**
     * 
     * This method determines if the player earns 2 or 3 points based on the
     * region the player is shooting from. If the player is behind the 3 point
     * arc, the shot is considered to be a 3 pointer otherwise 2 pointer.
     * 
     * @return
     */
    public int calculatePoints()
    {
        points = 2;
        int calc1 = (int)( (int)405 - ( ( posX - 500 ) * ( 0.23 ) ) );
        int calc2 = (int)( ( posX - 500 ) * 0.236 + 405 );

        if ( posY > calc1 && posY < calc2 )
        {
            points = 1;
        }
        int calc3 = (int)( 495 - ( 0.777778 * ( posX - 500 ) ) );
        int calc4 = (int)( 590 - ( 0.14563 * Math.abs( ( posX - 560 ) ) ) );
        if ( ( posX >= 500 && posX <= 580 ) && ( posY >= calc2 && posY <= calc3 ) && posY > 405 )
        {
            points = 1;

        }
        if ( ( posX >= 590 && posX <= 1293 ) && ( posY >= calc2 && posY <= calc4 ) && posY > 405 )
        {
            points = 1;

        }
        int calc5 = (int)( 405 - 1.5 * ( posX - 500 ) );
        if ( ( posX >= 500 && posX <= 550 ) && ( posY <= calc1 && posY >= calc5 ) && posY < 405 )
        {
            points = 1;

        }

        int calc6 = (int)( 345 - 0.118577 * ( posX - 540 ) );

        if ( ( posX >= 540 && posX <= 1046 ) && ( posY <= calc1 && posY >= calc6 ) && posY < 405 )
        {
            points = 1;

        }

        return points;
    }


    @Override

    /**
     * This method does the corresponding event below depending on what key is
     * pressed
     * 
     * @param KeyEvent
     *            e this is the KeyEvent or key pressed that the program
     *            responds to
     */
    public void keyPressed( KeyEvent e )
    {
        // Auto-generated method stub

        if ( number == 1 )
        {
            /// System.out.println("er" + number);

            switch ( e.getKeyCode() )
            {
                case KeyEvent.VK_DOWN:
                    down = true;
                    // System.out.println("a");
                    break;
                case KeyEvent.VK_UP:
                    up = true;
                    // System.out.println("a");
                    break;
                case KeyEvent.VK_LEFT:
                    left = true;
                    // System.out.println("a");
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    // System.out.println("a");
                    break;
                case KeyEvent.VK_SPACE:
                    space = true;
                    break;
            }
            move();
        }
        else if ( number == 2 )
        {
            // System.out.println("moved");
            switch ( e.getKeyCode() )
            {
                case KeyEvent.VK_F:
                    down = true;
                    break;
                case KeyEvent.VK_R:
                    up = true;
                    break;
                case KeyEvent.VK_D:
                    left = true;
                    break;
                case KeyEvent.VK_G:
                    right = true;
                    break;
                case KeyEvent.VK_S:
                    s = true;
                    break;
            }
            move();
        }

        if ( e.getKeyCode() == KeyEvent.VK_1 )
        {
            if ( number == 1 )
            {
                System.out.println( posX + ", " + posY );
                System.out.println( this.getShotChance() );
            }

        }

        if ( e.getKeyCode() == KeyEvent.VK_P && number == 1 && !hasBall )
        {

            steal();
            // Court.changePoss();
        }

        if ( e.getKeyCode() == KeyEvent.VK_X && number == 2 && !hasBall )
        {

            steal();
            // Court.changePoss();
        }
        if ( e.getKeyCode() == KeyEvent.VK_SPACE && number == 1 && hasBall )
        {

            isShooting = 1;
            shoot();

        }

        if ( e.getKeyCode() == KeyEvent.VK_S && number == 2 && hasBall )
        {
            isShooting = 2;
            shoot();
        }

    }


    /**
     * 
     * This method calculates if the player on defense is close enough to the
     * player on offensive and then allows for the player on defense to steal
     * the ball with a 20% rate of success.
     */
    public void steal()
    {

        boolean success;

        success = Math.random() < 0.30;

        if ( Ball.getX() > posX )
        {
            if ( Math.abs( posX + 25 - Ball.getX() ) < 120
                && Math.abs( posY + 100 - Ball.getY() ) < 60 && success )
            {
                Court.changePoss();

            }
        }
        else if ( Math.abs( posX + 25 - Ball.getX() ) < 60
            && Math.abs( posY + 100 - Ball.getY() ) < 60 && success )
        {
            Court.changePoss();

        }

    }


    @Override
    /**
     * This method does the corresponding event below depending on what key is
     * released
     * 
     * @param KeyEvent
     *            e this is the KeyEvent or key released that the program
     *            responds to
     */
    public void keyReleased( KeyEvent e )
    {
        // Auto-generated method stub

        if ( number == 1 )
        {
            switch ( e.getKeyCode() )
            {
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                case KeyEvent.VK_SPACE:
                    space = false;
                    break;
            }
            move();
        }
        else if ( number == 2 )
        {
            // System.out.println("moved2");
            switch ( e.getKeyCode() )
            {
                case KeyEvent.VK_F:
                    down = false;
                    break;
                case KeyEvent.VK_R:
                    up = false;
                    break;
                case KeyEvent.VK_D:
                    left = false;
                    break;
                case KeyEvent.VK_G:
                    right = false;
                    break;
                case KeyEvent.VK_S:
                    s = false;
                    break;
            }

            move();
        }

    }


    /**
     * 
     * This is the method that adjusts the player's x and y velocities and also
     * continuously checks if the player is in bounds or colliding with another
     * player based on the formula in other helper methods.
     */
    public void go()
    {

        posY += vY;
        posX += vX;
        check();
        collide();

        // System.out.println(number + " " + hasBall);
        // Court.checkScore();
    }


    /**
     * 
     * This method is the helper method which checks if the player is colliding
     * with another player and then resets x and y coordinates to make sure
     * there is a collision between the two players.
     */
    public static void collide()
    {
        int player0X = Court.getPlayer()[0].getX();
        int player1X = Court.getPlayer()[1].getX();

        if ( Math.abs( Court.getXDistance() ) < 75
            && Court.getPlayer()[0].getX() < Court.getPlayer()[1].getX() )
        {
            if ( Math.abs( Court.getYDistance() ) < 75 )
            {
                Court.getPlayer()[0].setX( player1X - 75 );
                Court.getPlayer()[1].setX( player0X + 75 );
            }
        }

        if ( Math.abs( Court.getXDistance() ) < 75
            && Court.getPlayer()[0].getX() > Court.getPlayer()[1].getX() )
        {
            if ( Math.abs( Court.getYDistance() ) < 75 )
            {
                Court.getPlayer()[0].setX( player1X + 75 );
                Court.getPlayer()[1].setX( player0X - 75 );
            }
        }

    }


    /**
     * 
     * This method looks at the x and y coordinates of the player and then
     * compares them to the x and y coordinates of the boundaries that are set
     * based on the formulas created below and calculated by the program.
     */
    public void check()
    {
        if ( posY > 630 )
        {
            posY = 630;
        }
        if ( posY < 240 )
        {
            posY = 240;

        }

        if ( Math.abs( ( posX + 35 ) ) < Math.abs( ( -1 * posY + 630 ) / 3.71 ) )
        {
            posX = (int)Math.abs( ( ( -1 * posY + 630 ) / 3.71 ) ) - 35;
        }
        if ( ( posX - 1020 ) > Math.abs( ( ( -1 * posY + 250 ) / 1.3 ) ) )
        {
            posX = (int)Math.abs( ( ( -1 * posY + 250 ) / 1.3 ) ) + 1020;
        }
        if ( posX < -40 && posY == 630 )
        {
            posX = 1281;
            posY = 610;
        }

    }


    /**
     * Returns the number code of player (Player 1 or Player 2) in the game,
     * used as a helper method for testing purposes.
     * 
     * @return number of player
     */
    public int getNumber()
    {
        return number;
    }

}
