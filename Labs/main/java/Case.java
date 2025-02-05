/**
 * Lab 4
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * Case class for lab 4. Holds the properties for a case.
 * Different methods include various getters and the overriding toString method.
 *
 * @author Avinash Chouhan
 * @since March 22, 2022
 */

public class Case {
    protected String ownerName;
    protected String caseColor;

    /**
     * @param name - name of the owner
     * @param color - color of the case
     *              Constructor to make a new object with the specified parameters
     */
    public Case(String name, String color) {
        this.ownerName = name;
        this.caseColor = color;
    }

    /**
     * @return returns the owner name, this is a getter method.
     */
    // Access methods
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @return returns the casecolor, this is a getter method.
     */
    public String getColor() {
        return caseColor;
    }

    /**
     * @return return a string containing the class's instances
     *         This is an overriding method that overrides the default toString method
     *         in order to print more useful information about the object.
     */
    @Override
    public String toString() {
        return ("Case Owner : " + ownerName + " , Color : " + caseColor);
    }

    public static void main(String[] args) {
        // Creating a new Case object with the passed parameters
        Case case1 = new Case("Sue", "Maroon");

        // Invoking the toString method, so that the object info is displayed.
        System.out.println(case1);
    }
}