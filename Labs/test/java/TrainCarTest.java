import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainCarTest {

    @Test
    public void test_TrainCar() {
        System.out.println("Testing TrainCar");
        TrainCar carEmpty = new TrainCar("",0,null);
        TrainCar carLumber = new TrainCar("lumber",500, carEmpty);

        // test Empty Car
        assertEquals("",carEmpty.getCargoType());
        assertEquals(0,carEmpty.getWeight());
        assertEquals(null,carEmpty.getNext());
        assertEquals("Empty Train Car",carEmpty.toString());

        // test Train Car with lumber
        assertEquals("lumber",carLumber.getCargoType());
        assertEquals(500,carLumber.getWeight());
        assertSame(carEmpty,carLumber.getNext());
        assertEquals("Cargo : 500 pounds of lumber",carLumber.toString());

        // test setters
        TrainCar newCar  = new TrainCar("",0,null);
        newCar.setCargoType("coal");
        newCar.setWeight(250);
        newCar.setNext(carLumber);
        assertEquals("coal",newCar.getCargoType());
        assertEquals(250,newCar.getWeight());
        assertSame(carLumber,newCar.getNext());
        assertEquals("Cargo : 250 pounds of coal",newCar.toString());

        // test unload
        assertEquals("lumber",carLumber.unload());
        assertEquals("",carLumber.getCargoType());
        assertEquals(0,carLumber.getWeight());
        assertSame(carEmpty,carLumber.getNext());
        assertEquals("Empty Train Car",carLumber.toString());

    }
}