package basketball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
* Graphical User Interface for entire court as well as the players and ball.
* This class is responsible to repainting the images while they are being
* updated in real-time.
*
* @author Sunhoo Ahn, Shree Phadke, Lakshay Maharana
* @version May 27, 2019 
* @author Period: 3
* @author Assignment: APCS GameTime
*
* @author Sources: None
*/

public class GUI extends JFrame{
	
	private Graphics graphics;
	private BufferedImage bImage;
	private Image image; 
	private Court court;
	
	
	 /**
     * This is the GUI constructor which is in charge of displaying the court
     * and score on the screen.
     * 
     * @param c court object
     */

	public GUI(Court c) {
		
		super("Basketball");
		
		court = c;
		
		bImage = new BufferedImage(Court.getWidth(), Court.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = bImage.createGraphics();
		
		image = new javax.swing.ImageIcon("court.png").getImage();
		
		 
		setSize(Court.getWidth(), Court.getHeight());
		
		this.setVisible(true);
		
		
	}
	
	 /**
     * The paint method allows for drawing the actual objects for players, ball,
     * and court on screen, while updating and repainting them too.
     * 
     * @param g
     *            graphics - easy way to draw on screen
     */

	public void paint(Graphics g) {
		
		
		//graphics.fillRect(0, 0, bImage.getWidth(), bImage.getHeight());
		
		
	    //sets player graphics
		court.getPlayer()[0].drawPlayer(graphics);
		court.getPlayer()[1].drawPlayer(graphics);
		//
		court.getBall().drawBall(graphics);
		
	
		//draws court image
		graphics.drawImage(image, 0, 0, this);
		
		//draws player image
		
		
	
		graphics.drawImage(court.getScore1(), 700, 265, this);
		graphics.drawImage(court.getScore2(), 750, 265, this);
		
		//court.drawScore(g);
            if (Ball.getScored() ) {
            	
            	Ball.setIn(false);
            	graphics.drawImage(court.scoredDisplay(), 600, 100, this);
            	
		}
		
		
	
		
		//draws court again, updating
		court.drawScore1(graphics);
		court.drawScore2(graphics);
		
		
		
		
		
		graphics.drawImage(court.getPlayer()[0].getPlayerImage(), court.getPlayer()[0].getX(), court.getPlayer()[0].getY(), this);
		court.getPlayer()[0].go();
		graphics.drawImage(court.getPlayer()[1].getPlayerImage(), court.getPlayer()[1].getX(), court.getPlayer()[1].getY(), this);
		court.getPlayer()[1].go();
		
		//draws ball image
		
		graphics.drawImage(court.getBall().getBallImage(), court.getBall().getX(), court.getBall().getY(), this);
		
		//updates ball
		court.getBall().updateBall(court.getPlayer()[0]);
		court.getBall().updateBall(court.getPlayer()[1]);
		
		
		
       
		g.drawImage(bImage, 0, 0, this);
		
		
 
	}
	
	
}







