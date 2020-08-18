package basketball;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import Jama.Matrix;


/**
 * 
a 
 *
 * @author Shree Phadke, Sunhoo Ahn, Shree Phadke
 * @version May 24, 2019
 * @author Period: 3
 * @author Assignment: APCS Final Project - GameTime
 *
 * @author Sources: Sunhoo Ahn, NIST Mathematical and Computational Sciences
 *         Division (JAMA Matrix Library):
 *         https://math.nist.gov/javanumerics/jama/
 */
public class Ball
{

    private static int posX;

    private static int posY;

    private static boolean done;

    private Image image;

    static boolean beingShot;

    private static double a;

    private static double b;

    private static double c;

    private static int count = 0;

    private static boolean scored;

    private static boolean start;

    private static boolean in;

    private static long time;

    private static int hoopX;

    private static int hoopY;

    private static int initX;

    private static int initY;

    private static int apexX;

    private static int apexY;

    public static double prob;


    /**
     * Creates the ball object with boolean statements displaying the conditions
     * for whether or not the ball can be shot, if it has already scored, or if
     * it currently traveling.
     */
    public Ball()
    {

        beingShot = false;

        done = false;
        scored = false;
        start = false;

    }


    /**
     * The getter method for whether the ball has entered the hoop or not.
     * 
     * @return true or false depending on the ball's position.
     */
    public static boolean getScored()
    {
        return scored;
    }


    /**
     * Can change the boolean value of the "scored" variable.
     * 
     * @param given
     *            boolean value
     */
    public static void setScored( boolean set )
    {
        scored = set;
    }


    /**
     * The getter method for whether the ball has entered the hoop or not.
     * 
     * @return true or false depending on the ball's position.
     */
    public static boolean getIn()
    {
        return in;
    }


    /**
     * Can change the boolean value of the "in" variable.
     * 
     * @param given
     *            boolean value
     */
    public static void setIn( boolean set )
    {
        in = set;
    }


    /**
     * The getter method for whether the ball is currently in motion or not.
     * 
     * @return true or false depending on if the ball is not with the player or
     *         not.
     */
    public static boolean getBeingShot()
    {
        return beingShot;
    }


    /**
     * Can change the boolean value of the "beingShot" variable.
     * 
     * @param given
     *            boolean value
     */
    public static void setBeingShot( boolean set )
    {
        beingShot = set;
    }


    /**
     * Returns the x position of the ball at current time.
     * 
     * @return x position
     */
    public static int getX()
    {
        return posX;
    }


    /**
     * Returns the y position of the ball at current time.
     * 
     * @return y position
     */
    public static int getY()
    {
        return posY;
    }


    /**
     * Replaces the x position with a new x position in real time.
     * 
     * @return x position to be replaced by
     */
    public static void setX( int positionX )
    {
        posX = positionX;
    }


    /**
     * Replaces the y position with a new y position in real time.
     * 
     * @return y position to be replaced by
     */
    public static void setY( int positionY )
    {
        posY = positionY;
    }


    /**
     * The probability of whether the shot will be scored or not.
     */
    public static void shotChance()
    {

        prob = Math.random();

        if ( prob < Player.getShotChance() )
        {
            // System.out.println("missed");
            scored = true;
        }
        else
        {
            // System.out.println("made");
            scored = false;
        }

        // scored = true;
    }


    /**
     * Misses shot, rebounds off back board.
     */
    public static void miss()
    {

        // System.out.println("miss");

        if ( posY < Math.random() * 800 + 350 )
        {
            setY( posY + (int)( Math.random() * 10 + 4 ) );
            setX( posX - (int)( Math.random() * 5 + 5 ) );

        }
        else
        {

            start = false;

        }
    }


    /**
     * Testing purposes; setting the x position of the hoop
     * 
     * @param posX
     *            of the hoop
     */
    public static void setHoopX( int posX )
    {
        hoopX = posX;
    }


    /**
     * The getter method for the hoop's x position
     * 
     * @return hoop's x position
     */
    public static int getHoopX()
    {
        return hoopX;
    }


    /**
     * Testing purposes; setting the y position of the hoop
     * 
     * @param posY
     *            of the hoop
     */
    public static void setHoopY( int posY )
    {
        hoopY = posY;
    }


    /**
     * The getter method for the hoop's y position
     * 
     * @return hoop's y position
     */
    public static int getHoopY()
    {
        return hoopY;
    }


    /**
     * Testing purposes; initial x position of the ball
     * 
     * @param posX
     *            of ball
     */
    public static void setInitX( int posX )
    {
        initX = posX;
    }


    /**
     * The getter method for the initial x position of the ball
     * 
     * @return x position of the ball
     */
    public static int getInitX()
    {
        return initX;
    }


    /**
     * Testing purposes; initial y position of the ball
     * 
     * @param posY
     *            of ball
     */
    public static void setInitY( int posY )
    {
        initY = posY;
    }


    /**
     * The getter method for the initial y position of the ball
     * 
     * @return y position of the ball
     */
    public static int getInitY()
    {
        return initY;
    }


    /**
     * Testing purposes; initial x position of the apex
     * 
     * @param posX
     *            of apex
     */
    public static void setApexX( int posX )
    {
        apexX = posX;
    }


    /**
     * Testing purposes; initial y position of the apex
     * 
     * @param posY
     *            of apex
     */
    public static void setApexY( int posY )
    {
        apexY = posY;
    }


    /**
     * The getter method for the initial y position of the ball
     * 
     * @return y position of the ball
     */
    public static int getApexX()
    {
        return apexX;
    }


    /**
     * The getter method for the initial y position of the ball
     * 
     * @return y position of the ball
     */
    public static int getApexY()
    {
        return apexY;
    }


    /**
     * The getter method for the initial y position of the ball
     * 
     * @return y position of the ball
     */
    public static boolean getStart()
    {
        return start;
    }


    /**
     * Testing purposes; changes the start boolean value.
     * 
     * @param b boolean to be changed to.
     */
    public static void setStart( boolean b )
    {
        start = b;
    }


    /**
     * Testing purposes; changes the done boolean value.
     * @param b boolean to be changed to.
     */
    public static void setDone( boolean b )
    {
        done = b;
    }


    /**
     * The getter method for the boolean done
     * 
     * @return y position of the ball
     */
    public static boolean getDone()
    {
        return done;
    }


    /**
     * Responsible for calculating the trajectory (equation) via which the ball
     * will travel on the way to the hoop.
     * 
     * In order to map the perfect equation the ball will travel, we have to
     * determine the 3 points it will go through: the initial position, the apex
     * (vertex), and the final hoop position.
     * 
     * In order to solve for such an equation, a system of equations is used,
     * however, the way to solve this S.O.E. is by using matrices, and more
     * specifically, determinants. After importing the JAMA Matrix lib, the 5
     * arrays (one for each coefficient's determinant, one for the y values, and
     * one for the determinant of the entire array) were then converted into
     * matrices. Then, Cramer's rule was applied to get the coefficients for the
     * parabolic equation and plugged into the equation of format: y = ax^2+bx+c
     * 
     * Additionally, these initializations are within an if statement so that
     * they aren't recalculated every time the graphics are repainted on the
     * screen, hence being more efficient.
     * 
     * Additionally, since the ball is being moved frame by frame, there had to
     * be an account of what velocities the ball would travel at based on
     * distances (for example, up close the incrementing would need to be minute
     * whereas it would be much larger from a farther distance to cover that
     * much ground in roughly the same amount of time).
     * 
     */

    public static void shootMotion()
    {
        setHoopX( 1225 );
        setHoopY( 245 );
        setInitX( posX );
        setInitY( posY );

        int x = initX;

        // increment each frame by 4 pixels in the x direction if in 30-500
        // distance range
        if ( Math.abs( initX - hoopX ) >= 30 && Math.abs( initX - hoopX ) < 500 && initX < hoopX )
            x = initX + 4;

        // increment each frame by 6 pixels in the x direction if in 500-800
        // distance range
        else if ( Math.abs( initX - hoopX ) >= 500 && Math.abs( initX - hoopX ) < 800 )
            x = initX + 6;

        // increment each frame by 8 pixels in the x direction if distance is
        // greater than 800
        else if ( Math.abs( initX - hoopX ) >= 800 )
            x = initX + 8;

        /*
         * The apex's x value is the sum of the initial x position and
         * two-thirds of x distance from the initial position to the hoop,
         * however, if the player shoots from the bottom right most corner of
         * the court, where the initial x value is greater than the hoop's x
         * value, the apex will be the initial distance MINUS two-thirds of the
         * x distance to the hoop.
         */
        setApexX( (int)( initX + Math.abs( hoopX - initX ) * 2.0 / 3 ) );
        if ( initX > hoopX )
            setApexX( (int)( initX - Math.abs( hoopX - initX ) * 2.0 / 3 ) );

        /*
         * The apex's y value varies at different ranges.
         */
        setApexY( 140 );

        if ( initX < 200 )
            setApexY( 0 );

        if ( initX < 300 && initX > 200 )
            setApexY( 50 );

        if ( initX > 300 && initX < 600 && initY > 200 && initY < 400 )
            setApexY( 25 );

        if ( initX > 900 )
            setApexY( 100 );

        if ( Math.abs( hoopX - initX ) < 10 )
            setApexY( 40 );

        /*
         * System of equations:
         * 
         * Equation 1: (initX^2)a + (initX)b + c = initY Equation 2: (apexX^2)a
         * + (apexX)b + c = apexY Equation 3: (hoopX^2)a + (hoopX)b + c = hoopY
         * 
         */

        if ( done != true )
        {
            double[][] arrLeft = { { initX * initX, apexX * apexX, hoopX * hoopX },
                { initX, apexX, hoopX }, { 1, 1, 1 } };
            double[] arrRight = { initY, apexY, hoopY };
            double[][] arrA = { arrRight, { initX, apexX, hoopX }, { 1, 1, 1 } };
            double[][] arrB = { { initX * initX, apexX * apexX, hoopX * hoopX }, arrRight,
                { 1, 1, 1 } };
            double[][] arrC = { { initX * initX, apexX * apexX, hoopX * hoopX },
                { initX, apexX, hoopX }, arrRight };
            Matrix m = new Matrix( arrLeft );
            Matrix mA = new Matrix( arrA );
            Matrix mB = new Matrix( arrB );
            Matrix mC = new Matrix( arrC );
            double det = m.det();
            double dA = mA.det();
            double dB = mB.det();
            double dC = mC.det();

            // Cramer's Rule
            a = dA / det;
            b = dB / det;
            c = dC / det;

            done = true;
        }

        // System.out.println( "THIS IS A: " + a );
        // System.out.println( "THIS IS B: " + b );
        // System.out.println( "THIS IS C: " + c );

        if ( beingShot && done )
        {
            double y = ( a * x * x + b * x + c );

            // System.out.println( "x: " + x );
            // System.out.println( "y: " + y );

            int w = (int)x;
            int z = (int)y;

            if ( Math.abs( w - hoopX ) < 4 && Math.abs( z - hoopY ) < 4 )
            {
                count++;

                if ( count % 2 == 0 )
                {
                    time = System.currentTimeMillis() / 1000;
                    beingShot = false;
                    // done = false;

                    if ( scored )
                    {
                        in = true;

                        if ( in )
                        {

                            if ( Court.getPlayer()[0].getIsShooting() == 1 )
                                Court.getPlayer()[0].scoreIncrease();
                            else if ( Court.getPlayer()[1].getIsShooting() == 2 )
                                Court.getPlayer()[1].scoreIncrease();
                        }

                    }
                    else
                    {
                        start = true;
                    }

                    // return;
                    // done = false;
                    scored = false;
                }

            }

            if ( initX > hoopX )
            {
                setX( x - 2 );
                setY( (int)y );
            }

            else if ( hoopX - initX < 25 )
            {
                setX( x + 1 );
                setY( (int)y );
            }

            else
            {
                setX( x + 2 );
                setY( (int)y );
            }

        }

    }


    /**
     * Displays the image of the ball on-screen.
     * 
     * @param g
     *            graphics class (allows for drawing)
     */
    public void drawBall( Graphics g )
    {

        image = new javax.swing.ImageIcon( "ball.png" ).getImage();

    }


    /**
     * The getter method for the ball image, used in "GUI.java" for drawing and
     * setting the positions of the ball.
     * 
     * @return image of the ball
     */
    public Image getBallImage()
    {
        return image;
    }


    /**
     * Updates the ball's position in real time depending on various situations
     * like if the ball has not been shot and is in possession: the ball
     * dribbliing along with the player; or methods such as the shootMotion
     * method will be called when the ball has just been shot.
     * 
     * @param player
     *            that has/was in possession of the ball
     */
    public void updateBall( Player player )
    {
        if ( !beingShot && player.hasBall() )
        {
            if ( System.currentTimeMillis() / 400 % 2 == 0 )
            {
                setX( player.getX() + 65 );
                setY( player.getY() + 80 );
            }
            else
            {
                setX( player.getX() + 65 );
                setY( player.getY() + 110 );
            }

        }

        else if ( Math.abs( player.getX() + 100 - posX ) < 30
            && Math.abs( player.getY() + 100 - posY ) < 30 && !player.hasBall()
            && Court.who() == null )
        {
            player.setHasBall( true );
        }

        if ( beingShot )
        {
            shootMotion();
            player.setHasBall( false );

        }

        if ( start )
        {

            player.setHasBall( false );
            player.setIsShooting( 0 );

            miss();

            done = false;

        }

        if ( in && player.getIsShooting() > 0 && done
            && ( System.currentTimeMillis() / 1000 - time ) == 2 )
        {

            Court.getWinner().setHasBall( true );
            beingShot = false;
            done = false;

            Court.checkScore();

        }

    }
}
