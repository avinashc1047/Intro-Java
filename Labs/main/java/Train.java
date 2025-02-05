import java.awt.*;

public class Train {
    TrainCar head;

    /**
     * creates a head of the train
     */
    public Train() {
        head = null;
    }

    /**
     * @param cargoType cargotype of the traincar to add
     * @param weight weight of the traincar to add
     */
    public void attachAtEnd(String cargoType, int weight) {
        TrainCar next = head;
        while(next.getNext() != null) {
            next = next.getNext();
        }
        next.setNext(new TrainCar(cargoType, weight, null));
    }

    /**
     * @param cargoType cargotype of the car to attach
     * @param weight weight of the car to attach
     */
    public void attachAtFront(String cargoType, int weight) {
        if (head == null) {
            head = new TrainCar(cargoType, weight, null);
        }
        else {
            head = new TrainCar(cargoType, weight, head);
        }
    }

    /**
     * @return number of train cars in the linked list
     */
    public int countTrainCars() {
        int count = 0;
        TrainCar currCar = head;

        while(currCar != null) {
            count++;
            currCar = currCar.getNext();
        }
        return count;
    }

    /**
     * @return number of empty train cars in the linked list
     */
    public int countEmptyTrainCars() {
        int count = 0;
        TrainCar currCar = head;

        while(currCar != null) {
            if(currCar.getWeight() == 0) {
                count++;
            }
            currCar = currCar.getNext();
        }
        return count;
    }

    /**
     * @return total weight of all the cars
     */
    public int totalWeight() {
        int totWeight = 0;
        TrainCar currCar = head;

        while(currCar != null) {
            totWeight += currCar.getWeight();
            currCar = currCar.getNext();
        }
        return totWeight;
    }

    /**
     * @param cargoType cargotype to unload from the traincar
     * @return traincar that was unloaded
     */
    public int unloadCargo(String cargoType) {
        int count = 0;
        TrainCar currCar = head;

        while(currCar != null) {
            if((currCar.getCargoType()).equals(cargoType)) {
                count++;
                currCar.setWeight(0);
                currCar.setCargoType(cargoType);
            }
            currCar = currCar.getNext();
        }
        return count;
    }

    /**
     * @param cargoType cargotype to load on the train
     * @param weight weight of the cargotype on the train
     */
    public void loadCargo(String cargoType, int weight) {
        TrainCar currCar = head;
        TrainCar emptyCar = null;

        while(currCar != null) {
            if(currCar.getWeight() == 0) {
                emptyCar = currCar;
                break;
            }
            else {
                currCar = currCar.getNext();
            }
        }

        if(emptyCar == null) {
            this.attachAtEnd(cargoType, weight);
        }
        else {
            emptyCar.setCargoType(cargoType);
            emptyCar.setWeight(weight);
        }
    }

    /**
     * @return null or the cargotype of the removed traincar
     */
    public String removeFromFront() {
        String currCargo = "";
        if(head == null) {
            return null;
        }
        else {
            currCargo = head.getCargoType();
            head = head.getNext();
        }
        return currCargo;
    }

    /**
     * @param newCargo cargotype of the new traincar
     * @param weight weight of the new train car
     * @param followCargo cargotype of the car which the new car is added after
     */
    public void insertCargoAfter(String newCargo, int weight, String followCargo) {
        TrainCar followCar = null;
        TrainCar currCar = head;

        while(currCar != null) {
            if ((currCar.getCargoType()).equals(followCargo)) {
                followCar = currCar;
                break;
            }
            else {
                currCar = currCar.getNext();
            }
        }

        if(followCar != null) {
            TrainCar origNext = currCar.getNext();
            currCar.setNext(new TrainCar(newCargo, weight, origNext));
        }
        else {
            attachAtEnd(newCargo, weight);
        }
    }


    /**
     * @param cargoType cargotype of the traincar to remove
     * @return traincar that was removed
     */
    public TrainCar removeTrainCar(String cargoType) {
        TrainCar prevCar = head;
        TrainCar nextCar = head;

        while(nextCar!= null) {
            if(nextCar.getCargoType().equals(cargoType)) {
                if(prevCar == head) {
                    head = nextCar.getNext();
                }
                else {
                    prevCar.setNext(nextCar.getNext());
                }
                return nextCar;
            }
            prevCar = nextCar;
            nextCar = nextCar.getNext();
        }
        return null;
    }

    /**
     * @return string representing info abou teach train car in the linked list
     */
    @Override
    public String toString() {
        TrainCar currCar = head;
        String retStr = "";

        if(currCar == null) {
            retStr += "Empty Train";
        }
        else {
            while(currCar != null) {
                retStr += currCar.toString() + "\n";
                currCar = currCar.getNext();
            }
        }

        return retStr;
    }
}
