import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    public void test_Train() {

        System.out.println("Testing Train");

        Train cargoTrain = new Train();
        // no Train cars
        assertEquals(0,cargoTrain.countEmptyTrainCars());
        assertEquals(0,cargoTrain.countTrainCars());
        assertEquals(0,cargoTrain.totalWeight());
        assertEquals("Empty Train",cargoTrain.toString());

        cargoTrain.attachAtFront("coal", 200);
        // train should have one Train car with coal
        assertEquals(0,cargoTrain.countEmptyTrainCars());
        assertEquals(1,cargoTrain.countTrainCars());
        assertEquals(200,cargoTrain.totalWeight());
        System.out.println(cargoTrain.toString());
        assertEquals("Cargo : 200 pounds of coal\n",cargoTrain.toString());

        cargoTrain.attachAtFront("bananas", 300);
        // train should have    bananas -> coal
        assertEquals(0,cargoTrain.countEmptyTrainCars());
        assertEquals(2,cargoTrain.countTrainCars());
        assertEquals(500,cargoTrain.totalWeight());
        assertEquals("Cargo : 300 pounds of bananas\nCargo : 200 pounds of coal\n",cargoTrain.toString());

        cargoTrain.attachAtFront("", 0);
        // train should have   "" -> bananas -> coal
        assertEquals(1,cargoTrain.countEmptyTrainCars());
        assertEquals(3,cargoTrain.countTrainCars());
        assertEquals(500,cargoTrain.totalWeight());
        assertEquals("Empty Train Car\nCargo : 300 pounds of bananas\nCargo : 200 pounds of coal\n",cargoTrain.toString());

        cargoTrain.attachAtEnd("lumber", 450);
        cargoTrain.attachAtEnd("apples", 280);
        // train should have   "" -> bananas -> coal -> lumber -> apples
        assertEquals(1,cargoTrain.countEmptyTrainCars());
        assertEquals(5,cargoTrain.countTrainCars());
        assertEquals(1230,cargoTrain.totalWeight());
        assertEquals("Empty Train Car\n" + "Cargo : 300 pounds of bananas\n" +
                "Cargo : 200 pounds of coal\n" + "Cargo : 450 pounds of lumber\n" +
                "Cargo : 280 pounds of apples\n" ,cargoTrain.toString());

        cargoTrain.attachAtEnd("", 0);
        // train should have   "" -> bananas -> coal -> lumber -> apples -> ""
        assertEquals(2,cargoTrain.countEmptyTrainCars());
        assertEquals(6,cargoTrain.countTrainCars());

        // load oreos onto first empty train car
        cargoTrain.loadCargo("oreos",600);
        // train should have   "oreos" -> bananas -> coal -> lumber -> apples -> ""
        assertEquals("Cargo : 600 pounds of oreos\n" + "Cargo : 300 pounds of bananas\n" +
                "Cargo : 200 pounds of coal\n" + "Cargo : 450 pounds of lumber\n" +
                "Cargo : 280 pounds of apples\nEmpty Train Car\n" ,cargoTrain.toString());

        // load oranges onto first empty train car
        cargoTrain.loadCargo("oranges",750);
        // train should have   "oreos" -> bananas -> coal -> lumber -> apples -> oranges
        assertEquals("Cargo : 600 pounds of oreos\n" + "Cargo : 300 pounds of bananas\n" +
                "Cargo : 200 pounds of coal\n" + "Cargo : 450 pounds of lumber\n" +
                "Cargo : 280 pounds of apples\nCargo : 750 pounds of oranges\n" ,cargoTrain.toString());

        // remove first Train car - should return oreos
        assertEquals("oreos" ,cargoTrain.removeFromFront());
        // train should have   bananas -> coal -> lumber -> apples -> oranges
        // remove first Train car - should return bananas
        assertEquals("bananas", cargoTrain.removeFromFront());
        // train should have   coal -> lumber -> apples -> oranges
        assertEquals("Cargo : 200 pounds of coal\n" + "Cargo : 450 pounds of lumber\n" +
                "Cargo : 280 pounds of apples\nCargo : 750 pounds of oranges\n" ,cargoTrain.toString());

        // add a Train car to the end with lumber
        cargoTrain.attachAtEnd("lumber",450);
        // unload all Train Cars with lumber
        assertEquals(2,cargoTrain.unloadCargo("lumber"));
        assertEquals(2,cargoTrain.countEmptyTrainCars());
        assertEquals(5,cargoTrain.countTrainCars());
        assertEquals("Cargo : 200 pounds of coal\n" + "Empty Train Car\n" +
                "Cargo : 280 pounds of apples\nCargo : 750 pounds of oranges\nEmpty Train Car\n" ,cargoTrain.toString());

        // insert a TrainCar of potatoes after the TrainCar with apples
        cargoTrain.insertCargoAfter("potatoes",230,"apples");
        assertEquals("Cargo : 200 pounds of coal\n" + "Empty Train Car\n" +
                "Cargo : 280 pounds of apples\n" + "Cargo : 230 pounds of potatoes\n" +
                "Cargo : 750 pounds of oranges\nEmpty Train Car\n" ,cargoTrain.toString());

        System.out.println("Testing removeTrainCar");
        Train trTest = new Train();
        assertNull(trTest.removeTrainCar("onions"));

        // add a coal TrainCar to end
        cargoTrain.attachAtEnd("coal",130);

        // cargoTrain has
        // coal -> "" -> apples -> potatoes -> oranges -> "" -> coal
        // remove TrainCar with apples
        assertEquals(7,cargoTrain.countTrainCars());
        assertEquals("apples",cargoTrain.removeTrainCar("apples").getCargoType());
        assertEquals(6,cargoTrain.countTrainCars());

        System.out.println(cargoTrain.toString());

        // cargoTrain has
        // coal -> "" -> potatoes -> oranges -> "" -> coal
        // remove TrainCar with coal
        assertEquals("coal",cargoTrain.removeTrainCar("coal").getCargoType());
        assertEquals(5,cargoTrain.countTrainCars());

        System.out.println(cargoTrain.toString());

        // cargoTrain has
        // "" -> potatoes -> oranges -> "" -> coal
        // remove TrainCar with coal
        assertEquals("coal",cargoTrain.removeTrainCar("coal").getCargoType());

        // Not working here. Its removing the last coal val rather than the first.
        // Problme with iteration maybe or breaking out of the loop

        assertEquals(4,cargoTrain.countTrainCars());

    }
}