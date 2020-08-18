package basketball;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 * 
 * The Game class class is responsible for running the entire game and is where
 * the client is housed. It is also responsible for receiving key events and
 * constructing GUI and Court objects.
 *
 * @author Shree Phadke, Sunhoo Ahn, Lakshay Maharana
 * @version May 28, 2019
 * @author Period: 3r
 * @author Assignment: APCS GameTime
 *
 * @author Sources: None
 */
public class Game implements Runnable
{

    private GUI g;

    private Court c;


    /**
     * This is the Game constructor, responsible for receiving key events from
     * each of the players as well as constructing the Court and GUI objects.
     */
    public Game()
    {
        c = new Court();
        g = new GUI( c );

        g.addKeyListener( c.getPlayer()[0] );
        g.addKeyListener( c.getPlayer()[1] );
        // g.addKeyListener(c.getBall());

    }


    /**
     * This method simply begins the game without delay.
     */
    public void startGame()
    {

        Thread thread = new Thread( this );
        thread.start();
    }

 
    /**
     * This method is meant for displaying the court and its elements on screen
     * when the game is launched.
     */
    @Override
    public void run()
    {
        while ( true )
        {
            try
            {
                Thread.sleep( 0 );

            }
            catch ( InterruptedException ie )
            {

            }

            g.repaint();

        }

    }


    // for testing only
    public Court getCourt()
    {
        return c;
    }


    // for testing only
    public GUI getGUI()
    {
        return g;
    }


    /**
     * Main method - responsible for running the program; this method also
     * houses the client part of networking (sends updated score and player
     * winning streaks to the server, and manipulates them as necessary)
     * 
     *   
     * @param args
     *            arguments
     */
    public static void main( String[] args ) throws Exception
    {
        boolean done = false;
        boolean start = true;
        boolean fin = false;

        Game game = new Game();

        game.startGame();

        Socket sock = new Socket( "10.18.92.234", 6675 );
        Scanner sc1 = new Scanner( sock.getInputStream() );

        int p1score[] = { 0 };
        int p2score[] = { 0 };

        while ( sock.isConnected() )
        {
            PrintStream p = new PrintStream( sock.getOutputStream() );

            if ( start )
            {
                p.println();
                p.println( "\t" + "SCOREBOARD" );
                p.println();
                p.println( "Player 1: " + Court.p1score + "\t" + "Player 2: " + Court.p2score );

                start = false;
            }

            if ( Court.p1score > p1score[0] || Court.p2score > p2score[0] )
            {
                p1score[0] = Court.p1score;
                p2score[0] = Court.p2score;
                p.println( "Player 1: " + Court.p1score + "\t" + "Player 2: " + Court.p2score );
            }

            if ( ( p1score[0] >= 10 || p2score[0] >= 10 ) && !fin )
            {

                if ( p1score[0] > p2score[0] )
                {
                    p.println();
                    p.println( "Player 1 wins!" );
                    p.println( "Score difference: " + Math.abs( p1score[0] - p2score[0] ) );
                    Scanner scanner = new Scanner( new FileReader( "win streak.txt" ) );

                    try
                    {

                        int win = 0;
                        if ( scanner.hasNext() )
                        {
                            win = scanner.nextInt();
                            win++;
                            p.println();
                            p.println( "Player 1 is on a " + win + " win streak!" );
                        }
                        PrintWriter o = new PrintWriter( "win streak.txt" );
                        o.println( win );
                        o.close();

                    }

                    catch ( FileNotFoundException e )
                    {

                    }

                    try
                    {
                        PrintWriter o = new PrintWriter( "win streak p2.txt" );
                        o.println( 0 );
                        o.close();

                    }

                    catch ( FileNotFoundException e )
                    {

                    }

                    fin = true;

                }

                else
                {
                    p.println( "Player 2 wins!" );
                    p.println( "Score difference: " + Math.abs( p1score[0] - p2score[0] ) );
                    Scanner scanner = new Scanner( new FileReader( "win streak p2.txt" ) );
                    try
                    {

                        int win = 0;
                        if ( scanner.hasNext() )
                        {
                            win = scanner.nextInt();
                            win++;
                            p.println( "Player 2 is on a " + win + " win streak!" );
                        }
                        PrintWriter o = new PrintWriter( "win streak p2.txt" );
                        o.println( win );
                        o.close();

                    }

                    catch ( FileNotFoundException e )
                    {

                    }

                    try
                    {
                        PrintWriter o = new PrintWriter( "win streak.txt" );
                        o.println( 0 );
                        o.close();

                    }

                    catch ( FileNotFoundException e )
                    {

                    }

                    fin = true;

                }

            }

        }

    }
}
