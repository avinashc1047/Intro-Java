import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceBuzzTest {

    @Test
    public void testingBuzzNoParameterConstructor() {
        System.out.println("Creating Buzz with 0 parameter constructor");
        PieceBuzz buzzLY = new PieceBuzz();

        System.out.println("-- Testing Symbol");
        assertEquals('B', buzzLY.getSymbol());

        System.out.println("-- Testing Num Times Attacked");
        assertEquals(0, buzzLY.getNumAttacks());

        System.out.println("-- Testing Num Times Been Attacked");
        assertEquals(0, buzzLY.getNumTimesBeenAttacked());

        System.out.println("-- Testing Can Attack");
        assertTrue( buzzLY.canAttack());

        System.out.println("-- Testing isHidden");
        assertFalse(buzzLY.isHidden());

    }

    @Test
    public void testingBuzz() {
        System.out.println("Creating Buzz with 6 parameter Constructor");
        PieceBuzz buzzLY = new PieceBuzz( 'L',
                "Blue",3,0,
                true,true,false);

        System.out.println("-- Testing Symbol");
        assertEquals('L', buzzLY.getSymbol());

        System.out.println("-- Testing Color");
        assertEquals("Blue", buzzLY.getTeamColor());

        System.out.println("-- Testing Num Times Attacked");
        assertEquals(3, buzzLY.getNumAttacks());

        System.out.println("-- Testing Num Times Been Attacked");
        assertEquals(0, buzzLY.getNumTimesBeenAttacked());

        System.out.println("-- Testing isHidden");
        assertTrue(buzzLY.isHidden());

        System.out.println("-- Testing isOriginal");
        assertFalse(buzzLY.isOriginal());
    }

    @Test
    public void testingSetters() {
        System.out.println("Testing Setters");
        PieceBuzz buzz2 = new PieceBuzz();

        System.out.println("-- Testing Symbol");
        assertEquals('B', buzz2.getSymbol());
        buzz2.setSymbol('R');
        assertEquals('R', buzz2.getSymbol());

        System.out.println("-- Testing Color");
        assertEquals("- -", buzz2.getTeamColor());
        buzz2.setTeamColor("Red");
        assertEquals("Red", buzz2.getTeamColor());

        System.out.println("-- Testing isHidden");
        assertFalse(buzz2.isHidden());
        buzz2.setHidden(true);
        assertTrue(buzz2.isHidden());


    /* Buzz can attack initially but after he's
       attacked, his laser doesn't work and he
       can't attack
     */
        System.out.println("-- Testing Can Attack");
        assertTrue(buzz2.canAttack());
        buzz2.updateNumTimesBeenAttacked();
        assertFalse(buzz2.canAttack());

        System.out.println("-- Testing Laser");
        buzz2.setWorkingLaser(true);
        assertTrue(buzz2.canAttack());

    }
}