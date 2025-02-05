import java.util.Objects;

public class TrainCar {
    String cargoType;
    int weight;
    TrainCar next;

    /**
     * @param cargoType - Type of cargo that the car holds
     * @param weight - weight of the cargo
     * @param next - next train car
     */
    public TrainCar(String cargoType, int weight, TrainCar next) {
        this.cargoType = cargoType;
        this.weight = weight;
        this.next = next;
    }

    /**
     * @return cargo type of the current traincar
     */
    public String getCargoType() {
        return cargoType;
    }

    /**
     * @return weight of the current traincar
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return next traincar
     */
    public TrainCar getNext() {
        return next;
    }

    /**
     * @param cargoType the cargo type to set for the train car
     */
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    /**
     * @param weight the weight to set for the train car
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @param next the train car to set after the current car
     */
    public void setNext(TrainCar next) {
        this.next = next;
    }

    /**
     * @return cargo type of the unloaded train car
     */
    public String unload() {
        String tempType = getCargoType();
        setCargoType("");
        setWeight(0);

        return tempType;
    }

    /**
     * @return overridden string prints usable info about the current train car
     */
    @Override
    public String toString() {
        String retString = "";

        if (getWeight() == 0) {
            retString = "Empty Train Car";
        }
        else {
            retString = "Cargo : " + getWeight() + " pounds of " + getCargoType();
        }

        return  retString;
    }
}
