/**
 * Lab0
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * Into to Java. Basic principles of Java.
 * Different types of code structures like
 * functions, loops and conditionals.
 * First lab of the semester
 *
 * @author Avinash Chouhan
 * @since February 9, 2022
 */

public class Lab0 {

    public static double celsius_to_fahrenheit(double cdeg) {
        return 32.0 + (cdeg * 1.8);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(2+4);

        double LBS_TO_KILO = 0.45359237;
        System.out.println(175 * LBS_TO_KILO);

        int age = 19;
        System.out.println(age);
        age++;
        System.out.println(age);

        int JOE_AGE = 25;
        /*
          Need to use parentheses for conditionals
         */
        if (JOE_AGE < 18) {
            System.out.println("minor");
        }
        else if (JOE_AGE < 65) {
            System.out.println("adult");
        }
        else {
            System.out.println("senior");
        }

        int total = 0;
        // For this loop, i is declared to be 0
        // As long as i < 10 keep the loop going.
        // And the i++ is an increment that adds 1
        // after each iteration.
        for (int i = 0; i < 10; i++) {
            total += i;
        }
        System.out.println(total);

        int guess = 1;
        // The % or modulo operator is the same as python.
        // This essentially says as long as the remainder != 0
        // keep the loop running.
        while (guess % 7 != 0) {
            guess = new java.util.Random().nextInt(100);
        }
        System.out.println(guess);

        // The print function for the other class
        System.out.println(celsius_to_fahrenheit(25.0));
    }

}
