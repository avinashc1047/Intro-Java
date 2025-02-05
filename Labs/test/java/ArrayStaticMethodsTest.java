import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStaticMethodsTest {
    @Test
    public void testSumSqrPos() {
        System.out.println("Testing sumSqrPos");
        Assert.assertEquals(0, ArrayStaticMethods.sumSqrPos(new double[]{-1.9, -2.5, -3.7, -2, -1, -6, -3, -4, -5, -2}), 0.01);
        Assert.assertEquals(42.08, ArrayStaticMethods.sumSqrPos(new double[]{1.9, -2.5, 3.7, -2, 1, -6, -3, 4.3, -5, 2.3}), 0.01);
        Assert.assertEquals(2, ArrayStaticMethods.sumSqrPos(new double[]{1.414}), 0.01);
        //add a test with negative numbers
        Assert.assertEquals(141.0, ArrayStaticMethods.sumSqrPos(new double[]{4, -1, 5, -4, 10, -1}), 0.01);
    }

    @Test
    public void testCountChars() {
        System.out.println("Testing countChars");
        assertEquals(4, ArrayStaticMethods.countChars("The quick brown fox leaps over the lazy dog.".toCharArray(), 'e'));
        assertEquals(6, ArrayStaticMethods.countChars("My mother comes home from Alabama tomorrow".toCharArray(), 'm'));
        assertEquals(3, ArrayStaticMethods.countChars("Can't wait for spring break!".toCharArray(), 'a'));
        // add another test case
        assertEquals(2, ArrayStaticMethods.countChars("Testing if The upper case works".toCharArray(), 'T'));
    }

    @Test
    public void testReplace() {
        System.out.println("Testing replace");
        assertArrayEquals(new int[]{1, 6, 6, 1}, ArrayStaticMethods.replace(new int[]{1, 0, 0, 1}, 0, 6));
        assertArrayEquals(new int[]{5, 5, 5, 5}, ArrayStaticMethods.replace(new int[]{5, 0, 0, 5}, 0, 5));
        assertArrayEquals(new int[]{}, ArrayStaticMethods.replace(new int[]{}, 0, 5));
        // add a test where no replacements occur
        assertArrayEquals(new int[]{1, 2, 3, 4}, ArrayStaticMethods.replace(new int[]{1, 2, 3, 4}, 0, 5));
    }

    @Test
    public void testMoveNegatives() {
        System.out.println("Testing moveNegatives");
        assertArrayEquals(new int[]{1, 0, 0, 1}, ArrayStaticMethods.moveNegatives(new int[]{1, 0, 0, 1}));
        assertArrayEquals(new int[]{-1, -5, -7, 1, 3, 0}, ArrayStaticMethods.moveNegatives(new int[]{-1, 1, -5, 3, 0, -7}));
        assertArrayEquals(new int[]{1}, ArrayStaticMethods.moveNegatives(new int[]{1}));
        assertArrayEquals(new int[]{}, ArrayStaticMethods.moveNegatives(new int[]{}));
        //add 2 tests with: a mix of positive and negative values
        assertArrayEquals(new int[]{-1, -4, 5, 2, 3}, ArrayStaticMethods.moveNegatives(new int[]{-1, 5, 2, 3, -4}));
        assertArrayEquals(new int[]{-1, -6, -4, -3, 0}, ArrayStaticMethods.moveNegatives(new int[]{0, -1, -6, -4, -3}));
    }
}