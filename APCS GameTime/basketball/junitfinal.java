package basketball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class junitfinal
{

    @Test
    void gameConstructor()
    {

        Game g = new Game();

        assertNotNull( g.getCourt() );

        assertNotNull( g.getGUI() );

    }


    @Test
    void courtConstructor()
    {
        Court c = new Court();

        assertNotNull( c.getBall() );
        assertNotNull( c.getPlayer()[0] );
        assertNotNull( c.getPlayer()[1] );

        assertEquals( c.getWidth(), 1440 );
        assertEquals( c.getHeight(), 810 );

        assertNotEquals( c.getPlayer()[0].getNumber(), c.getPlayer()[1].getNumber() );

        assertEquals( c.getWinner(), c.getPlayer()[0] );

        assertEquals( c.getLoser(), c.getPlayer()[1] );

    }


    @Test
    void playerConstructor()
    {
        Player p1 = new Player( 0, 0, 1 );

        assertEquals( p1.getNumber(), 1 );
        assertTrue( p1.hasBall() );

        assertEquals( p1.getX(), 0 );
        assertEquals( p1.getY(), 0 );
        assertEquals( p1.getIsShooting(), 0 );
        assertEquals( p1.getScore(), 0 );

        Player p2 = new Player( 0, 0, 2 );
        assertEquals( p2.getNumber(), 2 );
        assertFalse( p2.hasBall() );

        Player p3 = new Player( 0, 0, 3 );

        assertEquals( p3.hasBall(), false );

    }


    @Test
    void playerGetIsShooting()
    {
        Player test = new Player( 0, 0, 1 );
        assertEquals( test.getIsShooting(), 0 );
    }


    @Test
    void playerSetIsShooting()
    {
        Player test = new Player( 0, 0, 1 );
        test.setIsShooting( 1 );
        assertEquals( test.getIsShooting(), 1 );
    }


    @Test
    void playerGetScore()
    {
        Player test = new Player( 0, 0, 1 );
        assertEquals( test.getScore(), 0 );
    }


    @Test
    void playerScoreIncrease()
    {
        Player test = new Player( (int)( ( Math.random() * 1114 ) + 25 ),
            (int)( Math.random() * 390 ) + 240,
            1 );
        int initial = test.getScore();
        int finalPoints = test.calculatePoints();
        assertTrue( initial < finalPoints );
    }


    @Test
    void playerGetX()
    {
        Player test = new Player( 0, 0, 1 );
        assertNotNull( test.getX() );
    }


    @Test
    void playerGetY()
    {
        Player test = new Player( 0, 0, 1 );
        assertNotNull( test.getY() );
    }


    @Test
    void playerSetX()
    {
        Player test = new Player( 0, 0, 1 );
        int random = (int)( ( Math.random() * 1114 ) + 25 );
        test.setX( random );
        assertTrue( test.getX() == random );
    }


    @Test
    void playerSetY()
    {
        Player test = new Player( 0, 0, 1 );
        int random = (int)( ( Math.random() * 390 ) + 240 );
        test.setY( random );
        assertTrue( test.getY() == random );
    }


    @Test
    void playerHasBall()
    {
        Player test = new Player( 0, 0, 1 );
        assertTrue( test.hasBall() );

    }


    @Test
    void playerGetShotChance()
    {
        Player test = new Player( (int)( ( Math.random() * 1114 ) + 25 ),
            (int)( Math.random() * 390 ) + 240,
            1 );
        assertNotNull( test.getShotChance() );
    }


    @Test
    void playerCalculatePoints()
    {
        Player test = new Player( 570, 405, 1 );
        test.calculatePoints();
        assertTrue( test.points == 1 );
        Player test1 = new Player( 560, 445, 1 );
        test1.calculatePoints();
        assertTrue( test1.points == 1 );
        Player test2 = new Player( 825, 505, 1 );
        test2.calculatePoints();
        assertTrue( test2.points == 1 );
        Player test3 = new Player( 540, 375, 1 );
        test3.calculatePoints();
        assertTrue( test3.points == 1 );
        Player test4 = new Player( 760, 335, 1 );
        test4.calculatePoints();
        assertTrue( test4.points == 1 );
    }


    @Test
    void playerGetNumber()
    {
        Player test = new Player( 0, 0, 1 );
        assertNotNull( test.getNumber() );
    }


    @Test
    void playerCheck()
    {
        Player test = new Player( 500, 640, 1 );
        test.check();
        assertTrue( test.getY() == 630 );
        test.setY( 210 );
        test.check();
        assertTrue( test.getY() == 240 );
    }


    @Test
    void playerCheck2()
    {
        Player test = new Player( -50, 450, 1 );
        test.check();
        if ( ( Math.abs( ( test.getX() + 35 ) ) < Math.abs( ( -1 * test.getY() + 630 ) / 3.71 ) ) )
        {
            test.setX( (int)Math.abs( ( ( -1 * test.getY() + 630 ) / 3.71 ) ) - 35 );
        }
        assertTrue( test.getX() == (int)Math.abs( ( ( -1 * test.getY() + 630 ) / 3.71 ) ) - 35 );
    }


    @Test
    void playerCheck3()
    {
        Player test = new Player( 1330, 450, 1 );
        test.check();

        assertTrue( test.getX() == (int)Math.abs( ( ( -1 * test.getY() + 250 ) / 1.3 ) ) + 1020 );
    }


    @Test

    void ballConstructor()
    {

        assertFalse( Ball.getBeingShot() );

        // assertFalse( Ball.getScored() );

    }


    @Test

    void ballGetScored()
    {
        Ball.setScored( true );
        assertTrue( Ball.getScored() );
    }


    @Test
    void ballGetApexX()
    {
        Ball.setApexX( 400 );
        assertEquals( 400, Ball.getApexX() );
    }


    @Test
    void ballSetDone()
    {
        Ball.setDone( true );
        assertNotNull( Ball.getDone() );

    }


    @Test

    void ballSetScored()
    {
        Ball.setScored( true );
        assertNotNull( Ball.getScored() );

    }


    @Test

    void ballGetIn()
    {
        assertEquals( Ball.getIn(), Ball.getScored() );
    }


    @Test

    void ballSetIn()
    {
        Ball.setIn( true );
        assertNotNull( Ball.getIn() );

    }


    @Test
    void ballGetStart()
    {
        Ball.setStart( true );
        assertTrue( Ball.getStart() );
    }


    @Test
    void ballGetBeingShot()
    {
        Player player = new Player( 700, 400, 1 );
        assertEquals( Ball.getBeingShot(), !player.hasBall() );
        assertEquals( !Ball.getBeingShot(), player.hasBall() );

    }


    @Test
    void ballSetBeingShot()
    {
        Ball.setBeingShot( true );
        assertTrue( Ball.getBeingShot() );
    }


    @Test
    void ballSetX()
    {
        Ball.setX( 700 );
        assertEquals( 700, Ball.getX() );
    }


    @Test
    void ballSetY()
    {
        Ball.setY( 300 );
        assertEquals( 300, Ball.getY() );
    }


    @Test
    void ballGetX()
    {
        Ball.setX( 400 );
        assertEquals( Ball.getX(), 400 );
    }


    @Test
    void ballGetY()
    {
        Ball.setY( 200 );
        assertEquals( Ball.getY(), 200 );
    }


    @Test
    void ballShotChance()
    {
        Player player = new Player( 400, 200, 1 );
        if ( Ball.getScored() )
        {
            assertTrue( Ball.prob < Player.getShotChance() );
        }
        Ball.shotChance();

    }


    @Test
    void ballGetInitY()
    {
        Ball.setInitY( 400 );
        assertEquals( 400, Ball.getInitY() );
    }


    @Test
    void ballShootMotion()
    {
        Ball.shootMotion();
        Ball.setX( 420 );
        Ball.setY( 405 );
        assertEquals( 1225, Ball.getHoopX() );
        assertEquals( 245, Ball.getHoopY() );
        Ball.setInitX( 100 );
        Ball.setApexY( 100 );
        assertEquals( 100, Ball.getApexY() );

    }


    @Test
    void ballUpdateBall()
    {
        Player p = new Player( 0, 0, 1 );
        Ball b = new Ball();
        b.setBeingShot( false );
        p.setHasBall( true );

        b.updateBall( p );

        assertEquals( b.getX(), p.getX() + 65 );

        b.setBeingShot( true );

        b.updateBall( p );

        assertFalse( p.hasBall() );

        b.setStart( true );
        b.updateBall( p );

        assertFalse( p.hasBall() );
        assertEquals( p.getIsShooting(), 0 );
        assertFalse( b.getDone() );

        p.setHasBall( false );
        b.setBeingShot( false );
        b.setStart( false );

        p.setX( 0 );
        p.setY( 0 );

        b.setX( 90 );
        b.setY( 90 );

        b.updateBall( p );

        // assertTrue(p.hasBall());

    }

    // @Test
    // void


    @Test
    void courtGetWinner()
    {

        Court c = new Court();

        assertEquals( Court.getWinner(), Court.getPlayer()[0] );

    }


    @Test
    void courtGetLoser()
    {

        Court c = new Court();

        assertEquals( Court.getLoser(), Court.getPlayer()[1] );

    }


    @Test
    void courtGetXDistance()
    {

        assertEquals( Court.getXDistance(), ( Court.getWidth() / 2 - Court.getWidth() / 3 ) );

        Court.getPlayer()[0].setX( 0 );
        Court.getPlayer()[1].setX( 0 );
        assertEquals( Court.getXDistance(), 0 );

    }


    @Test
    void courtGetYDistance()
    {

        assertEquals( Court.getYDistance(), 0 );

        Court.getPlayer()[0].setY( 100 );
        Court.getPlayer()[1].setY( 0 );

        assertEquals( Court.getYDistance(), 100 );

    }


    @Test
    void courtReset()
    {

        Court c = new Court();

        Court.reset();
        // TODO

        assertEquals( Court.getWinner().getX(), Court.getWidth() / 3 );
        assertEquals( Court.getLoser().getX(), Court.getWidth() / 2 );

        assertEquals( Court.getWinner().getY(), Court.getHeight() / 2 );
        assertEquals( Court.getLoser().getY(), Court.getHeight() / 2 );

        assertTrue( Court.getWinner().hasBall() );
        assertFalse( Court.getLoser().hasBall() );

        assertFalse( Court.getBall().getIn() );

    }


    @Test
    void courtWho()
    {

        Court c = new Court();
        assertEquals( Court.who(), Court.getPlayer()[0] );

        Court.changePoss();

        assertEquals( Court.who(), Court.getPlayer()[1] );

        Court.getPlayer()[1].setHasBall( false );

        assertNull( Court.who() );

    }


    @Test
    void courtgetWidth()
    {

        assertEquals( Court.getWidth(), 1440 );

    }


    @Test
    void courtgetHeight()
    {

        assertEquals( Court.getHeight(), 810 );

    }


    @Test
    void courtGetHoopXDistance()
    {

        Court.getPlayer()[0].setX( 200 );
        assertEquals( Court.hoopXDistance(), Math.abs( Court.getPlayer()[0].getX() - 1220 ) );
        Court.getPlayer()[0].setHasBall( false );
        Court.getPlayer()[1].setHasBall( true );

        Court.getPlayer()[1].setX( 400 );
        assertEquals( Court.hoopXDistance(), Math.abs( Court.getPlayer()[1].getX() - 1220 ) );

    }


    @Test
    void courtGetHoopYDistance()
    {

        Court.getPlayer()[0].setY( 200 );
        assertEquals( Court.hoopYDistance(), Math.abs( Court.getPlayer()[0].getY() - 231 ) );

        Court.getPlayer()[0].setHasBall( false );
        Court.getPlayer()[1].setHasBall( true );

        Court.getPlayer()[1].setY( 400 );
        assertEquals( Court.hoopYDistance(), Math.abs( Court.getPlayer()[1].getY() - 231 ) );

    }


    @Test
    void courtgetPlayer()
    {

        assertNotNull( Court.getPlayer() );

        assertNotNull( Court.getPlayer()[0] );
        assertNotNull( Court.getPlayer()[1] );

    }


    @Test
    void courtgetBall()
    {

        Court c = new Court();
        assertNotNull( Court.getBall() );

    }


    @Test
    void courtCheckScore()
    {

        // Court c = new Court();

        Court.getPlayer()[0].setIsShooting( 1 );
        Ball.setIn( true );

        Court.checkScore();

        assertEquals( Court.getPlayer()[0], Court.getWinner() );
        assertEquals( Court.getPlayer()[1], Court.getLoser() );
        assertFalse( Ball.getIn() );

        assertEquals( Court.getPlayer()[0].getIsShooting(), 0 );

        Court.getPlayer()[1].setIsShooting( 2 );
        Ball.setIn( true );

        Court.checkScore();

        assertEquals( Court.getPlayer()[1], Court.getWinner() );
        assertEquals( Court.getPlayer()[0], Court.getLoser() );
        assertFalse( Ball.getIn() );

        assertEquals( Court.getPlayer()[1].getIsShooting(), 0 );

    }


    @Test
    void courtChangePoss()
    {

        Court c = new Court();

        assertFalse( Court.getPlayer()[1].hasBall() );
        assertTrue( Court.getPlayer()[0].hasBall() );

        Court.changePoss();

        assertFalse( Court.getPlayer()[0].hasBall() );
        assertTrue( Court.getPlayer()[1].hasBall() );

        Court.changePoss();

        assertFalse( Court.getPlayer()[1].hasBall() );
        assertTrue( Court.getPlayer()[0].hasBall() );

    }

}
