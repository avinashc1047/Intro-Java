import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lab2Test {

    @Test
    public void derivCubePoly() {
        System.out.println("Testing derivatives");
        Assert.assertEquals(17.0, Lab2.derivCubePoly(1,1,1,1,2), 0.0001);
        System.out.println("derivCubePoly() works!");
    }

    @Test
    public void cubePoly() {
        System.out.println("Testing cubepoly");
        Assert.assertEquals(15.0, Lab2.cubePoly(1,1,1,1,2), 0.0001);
        System.out.println("cubePoly() works!");
    }

    @Test
    public void cubicRoot() {
        System.out.println("Testing cubicRoot");
        Assert.assertEquals(5.6857, Lab2.cubicRoot(1, -7, 8, -3, 5.0), 0.0001);
        Assert.assertEquals(3.2143, Lab2.cubicRoot(1, -3, -1, 1, 2.5), 0.0001);
        System.out.println("cubicRoot() works!");
    }

    @Test
    public void multiplication() {
        System.out.println("Testing Multiplication");
        assertEquals(10,Lab2.multiplication(2,5));
        assertEquals(8, Lab2.multiplication(-2,-4));
        assertEquals(-15, Lab2.multiplication(-3,5));
        assertEquals(-12, Lab2.multiplication(2,-6));
        assertEquals(0, Lab2.multiplication(2,0));
        assertEquals(0, Lab2.multiplication(0,5));
        System.out.println("multiplication() works!");
    }

}