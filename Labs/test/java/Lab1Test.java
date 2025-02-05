import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab1Test {

    @Test
    public void areaScalene() {
        System.out.println("Testing area scalene 1");
        assertEquals(3.96,Lab1.areaScalene(5.5, 3.4, 8.7), 0.0001);

        System.out.println("Testing area scalene 2");
        assertEquals(1.429,Lab1.areaScalene(2.5, 1.4, 3.5), 0.01);

        System.out.println("Testing area scalene 3");
        assertEquals(6.07,Lab1.areaScalene(5.2, 3.7, 8.4), 0.01);
    }

    @Test
    public void okCourse() {
        System.out.println("Testing okCourse() 1");
        assertTrue(Lab1.okCourse(18, 5));

        System.out.println("Testing okCourse() 2");
        assertFalse(Lab1.okCourse(15, 0));

        System.out.println("Testing okCourse() 3");
        assertFalse(Lab1.okCourse(25, 1));
    }

    @Test
    public void shareDigit() {
    System.out.println("Testing shareDigit - True");

    assertTrue(Lab1.shareDigit(12,24));
    assertTrue(Lab1.shareDigit(86,38));
    assertTrue(Lab1.shareDigit(19,51));

    System.out.println("Testing shareDigit - False");
    assertFalse(Lab1.shareDigit(12,44));
    assertFalse(Lab1.shareDigit(39,26));
    assertFalse(Lab1.shareDigit(92,67));
    }
}