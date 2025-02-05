import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaseTest extends TestCase {

    @Test
    public void testingCaseClass(){
        System.out.println("Testing Case class");
        Case c1 = new Case("Sam", "Blue");
        assertEquals("Sam", c1.getOwnerName());
        assertEquals("Blue", c1.getColor());
        assertEquals(c1.toString(),"Case Owner : Sam , Color : Blue");
    }

}