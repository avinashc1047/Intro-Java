import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceMinionTest {

    @Test
    public void TestingPieceMinionTest() {
        System.out.println("\nTesting PieceMinion(no parameters)\n");

        System.out.println("Testing PieceMinion()");
        PieceMinion minion1 = new PieceMinion();

        System.out.println("Testing getSymbol()");
        Assert.assertEquals('M', minion1.getSymbol());

        System.out.println("Testing getNumRecruits");
        Assert.assertEquals(0, minion1.getNumRecruits());

        System.out.println("Testing getNumTimesSpawned()");
        Assert.assertEquals(0, minion1.getNumTimesSpawned());

        System.out.println("Testing isHidden()");
        Assert.assertEquals(false, minion1.isHidden());

        System.out.println("Testing isOriginal()");
        Assert.assertEquals(true, minion1.isOriginal());

        System.out.println("Testing canSpawn()");
        Assert.assertEquals(true, minion1.canSpawn());
    }

    @Test
    public void TestingPieceMinionTestWP() {
        System.out.println("\nTesting PieceMinion(with parameters)\n");

        PieceMinion minion2 = new PieceMinion('A', "Yellow", 5,
                3, true, true);

        System.out.println("Testing getSymbol()");
        Assert.assertEquals('A', minion2.getSymbol());

        System.out.println("Testing getTeamColor()");
        Assert.assertEquals("Yellow", minion2.getTeamColor());

        System.out.println("Testing getNumRecruits");
        Assert.assertEquals(5, minion2.getNumRecruits());

        System.out.println("Testing getNumTimesSpawned()");
        Assert.assertEquals(3, minion2.getNumTimesSpawned());

        System.out.println("Testing isHidden()");
        Assert.assertEquals(true, minion2.isHidden());

        System.out.println("Testing isOriginal()");
        Assert.assertEquals(true, minion2.isOriginal());

        System.out.println("Testing canSpawn()");
        Assert.assertEquals(false, minion2.canSpawn());

        // Setting new value and then getting

        minion2.setSymbol('M');
        System.out.println("Testing getSymbol()");
        Assert.assertEquals('M', minion2.getSymbol());

        minion2.setTeamColor("Red");
        System.out.println("Testing getTeamColor()");
        Assert.assertEquals("Red", minion2.getTeamColor());

        minion2.setHidden(false);
        System.out.println("Testing getSymbol()");
        Assert.assertEquals(false, minion2.isHidden());
    }

    @Test
    public void test_spawn() {
        System.out.println("\nTesting spawn()\n");

        // create a PieceMinion and call its spawn method
        PieceMinion bob = new PieceMinion();
        bob.spawn();

        PieceMinion stuart = new PieceMinion('V',
                "Green", 3,2, false,true);

        // stuart should be able to spawn
        assertTrue(stuart.canSpawn());

        // stuart spawns
        PieceMinion lilStuart = stuart.spawn();

        // Number of times piece has spawned should be increased
        assertEquals(3,stuart.getNumTimesSpawned());

        // Now that max time number of spawns reached - it
        // shouldn't be able to spawn anymore
        assertFalse(stuart.canSpawn());

        // Testing each variable
        System.out.println("Testing getSymbol()");
        Assert.assertEquals('v', lilStuart.getSymbol());

        System.out.println("Testing getTeamColor()");
        Assert.assertEquals("Green", lilStuart.getTeamColor());

        System.out.println("Testing getNumRecruits");
        Assert.assertEquals(1, lilStuart.getNumRecruits());

        System.out.println("Testing getNumTimesSpawned()");
        Assert.assertEquals(0, lilStuart.getNumTimesSpawned());

        System.out.println("Testing isHidden()");
        Assert.assertEquals(false, lilStuart.isHidden());

        System.out.println("Testing isOriginal()");
        Assert.assertEquals(false, lilStuart.isOriginal());

        System.out.println("Testing canSpawn()");
        Assert.assertEquals(false, lilStuart.canSpawn());
    }
}