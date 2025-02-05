/**
 * Lab2
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * Special java functions using helper methods.
 *
 * @author Avinash Chouhan
 * @since March 2, 2022
 */

import java.util.Scanner;
import java.lang.Math;

public class Lab2 {

    /**
     * @param minInt - minimum integer of the range
     * @param maxInt - maximum integer of the range
     * @param scr - user input
     * @return - Integer that the user typed, which was also in the given range.
     */
    public static int getValidInt(int minInt, int maxInt, Scanner scr) {
        boolean isRunning = true;
        int userVal = 0;

        while (isRunning) {
            int userInput = scr.nextInt();

            if ((userInput >= minInt) && (userInput <= maxInt)) {
                isRunning = false;
                userVal = userInput;

            } else {
                System.out.println("Type something else: ");
            }
        }
        return userVal;
    }

    /**
     * @param scr - User input
     * @return - Accepted character the user typed
     */
    public static char getUsersNextActionType(Scanner scr) {
        String userStr = "";
        boolean found = false;

        while (!found) {
            userStr = scr.next().toLowerCase();

            if (userStr.charAt(0) == 'a' || userStr.charAt(0) == 'm' ||
                    userStr.charAt(0) == 'r' || userStr.charAt(0) == 's') {
            found = true;
            }
        }
        return userStr.toUpperCase().charAt(0);
    }


    /**
     * cublic polynomial - c3x^3 + c2x^2 + c1x + c0
     * derivative of poly - 3(c3x^2) + 2(c2x^1) + 1(c1) + 0
     * @param c3 - first constant c3x^3
     * @param c2 - second constant c2x^2
     * @param c1 - third constant c1x^1
     * @param c0 - fourth constant c0
     * @param x - the x value to evaluate the derivative at
     * @return - double, the root of the given cubic polynomial
     */
    public static double derivCubePoly(int c3, int c2, int c1, int c0, double x) {
        double derivFunction;

        // cubic-polynomial derivative
        // f(x) = c3x^3 + c2x^2 + c1x + c0
        // f'(x) = 3c3x^2 + 2c2x^1 + c1 + 0
        derivFunction = ((3.0*c3)*Math.pow(x, 2)) + ((2.0*c2)*Math.pow(x, 1))
                                             + ((1.0*c1)*Math.pow(x,0)) + (c0*(0.0));

        return derivFunction;
    }

    /**
     * cublic polynomial - c3x^3 + c2x^2 + c1x + c0
     * @param c3 - first constant c3x^3
     * @param c2 - second constant c2x^2
     * @param c1 - third constant c1x^1
     * @param c0 - fourth constant c0
     * @param x - the x value to evaluate the function at
     * @return - double, the root of the given cubic polynomial
     */
    public static double cubePoly(int c3, int c2, int c1, int c0, double x) {
        double function;

        // cubic-polynomial
        // f(x) = c3x^3 + c2x^2 + c1x + c0
        function = ((c3)*Math.pow(x, 3)) + ((c2)*Math.pow(x, 2))
                + ((c1)*Math.pow(x,1)) + (c0);

        return function;
    }

    /**
     * cublic polynomial - c3x^3 + c2x^2 + c1x + c0
     * @param c3 - first constant c3x^3
     * @param c2 - second constant c2x^2
     * @param c1 - third constant c1x^1
     * @param c0 - fourth constant c0
     * @param initGuess - the initial guess of the cubic root
     * @return - double, the root of the given cubic polynomial
     */
    public static double cubicRoot(int c3, int c2, int c1, int c0, double initGuess) {
        double xN;
        double xNPlusOne;

        // Root Guess
        xN = initGuess;
        xNPlusOne = 999;

        while (Math.abs(xN - xNPlusOne) >= 0.0001) {
            xN = xNPlusOne;
            xNPlusOne = xN - ((cubePoly(c3,c2,c1,c0,xN))/(derivCubePoly(c3,c2,c1,c0,xN)));
        }
        return xNPlusOne;
    }

    /**
     * @param firstNum - first multiplication number
     * @param secondNum - second multiplication number
     * @return - int, the product of firstNum and secondNum
     */
    public static int multiplication(int firstNum, int secondNum) {
    int product = 0;
    int i;
    int absFirst = Math.abs(firstNum);
    int absSecond = Math.abs(secondNum);

    if (firstNum < 0 || secondNum < 0) {
        if (firstNum < 0 && secondNum < 0) {
            for (i=0; i < absSecond; ++i) {
                product += absFirst;
            }
        }
        else {
            for (i=0; i < absSecond; ++i) {
                product -= absFirst;
            }
        }
    }
    else {
        for (i=0; i < absSecond; ++i) {
            product += absFirst;
        }
    }
    return product;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // getValidInt() testing
        System.out.println("Testing getValidInt()");
        System.out.println(getValidInt(5,10, scr));
        System.out.println("Great, done #1");

        // getUsersNextActionType() testing
        System.out.println("Testing getUsersNextActionType()");
        System.out.println(getUsersNextActionType(scr));
        System.out.println("Great, done #2");

        // cubicRoot() testing
        System.out.println("Testing cubicRoot()");
        // with integrated functions - derivCubePoly(), and cubePoly()
        System.out.println(cubicRoot(1,-7,8,-3,5.0));
        System.out.println(cubicRoot(1,-3,-1,1,2.5));
        System.out.println("Great, done #3");

        // multiplication() testing
        System.out.println("Testing multiplication()");
        System.out.println(multiplication(2,5));
        System.out.println(multiplication(5,4));
        System.out.println("Great, done #4");
    }
}
