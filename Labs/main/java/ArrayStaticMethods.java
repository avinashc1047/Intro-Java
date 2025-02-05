/**
 * Lab 4
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * Part II of Lab 4
 * ArrayStaticMethod that consists of numerous helper functions.
 * Functions can find square sums, count specific chars, replace vals in array
 * and move negative numbers onto the left side of the array.
 *
 * @author Avinash Chouhan
 * @since March 22, 2022
 */

import java.lang.*;

public class ArrayStaticMethods {

    /**
     * @param data array of doubles
     * @return a double representing the sum of the squares of the positive numbers in
     *          the data array
     */
    public static double sumSqrPos(double[] data) {
        double sum = 0;
        int i;

        for (i=0; i<data.length; ++i) {
            if (data[i] > 0) {
                sum += Math.pow(data[i], 2);
            }
        }
        return sum;
    }

    /**
     * @param arrayChars array of characters
     * @param searchChar the character that needs to be searched
     * @return returns an int representing the count of searchChar in arrayChars
     */
    public static int countChars(char[] arrayChars, char searchChar) {
        int count = 0;
        int i;

        for (i=0; i<arrayChars.length; ++i) {
            if (arrayChars[i] == searchChar) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * @param values array of int vals
     * @param value1 first value that needs to be replaced
     * @param value2 second value that replaces the first
     * @return array of ints with value1 replaced with value2
     */
    public static int[] replace(int[] values, int value1, int value2) {
        int i;


        for (i=0; i<values.length; ++i) {
            if (values[i] == value1) {
                values[i] = value2;
            }
        }
        return values;
    }

    /**
     * @param values array of ints
     * @return array of ints where the negatives are moved to the left side
     */
    public static int[] moveNegatives(int[] values) {
        int i;
        int[] sorted = new int[values.length];
        int sortPos = -1;

        for (i=0; i<values.length; ++i) {
            if (values[i] < 0) {
                sortPos += 1;
                sorted[sortPos] = values[i];
            }
        }

        for (i=0; i<values.length; ++i) {
            if (values[i] >= 0) {
                sortPos += 1;
                sorted[sortPos] = values[i];
            }
        }
        return sorted;
    }
}
