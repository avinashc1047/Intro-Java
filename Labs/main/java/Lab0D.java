/**
 * Lab0D
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * Conversion of the python document to java.
 * Program calculates the taxes and the gross income
 * that you have to pay. Uses three different classes
 * to execute the entire program.
 *
 * @author Avinash Chouhan
 * @since February 9, 2022
 */

public class Lab0D {

    // First function to compute the tax
    public static double computeTax(int income, int exemptions, boolean non_profit) {

        int adjusted_income = income - (exemptions * 5000);

        if (non_profit || adjusted_income < 0 ) {
            return 0;
        } else if (adjusted_income < 10000) {
            return adjusted_income * 0.1;
        } else if (adjusted_income < 20000) {
            return adjusted_income * 0.15;
        } else if (adjusted_income < 50000) {
            return adjusted_income * 0.2;
        } else {
            return adjusted_income * 0.25;
        }
    }

    // Second function to find the gross income
    public static double grossIncome(int income, int exemptions, boolean non_profit) {
        return income - computeTax(income, exemptions, non_profit);
    }

    // The main function that calls on the others and prints the results
    public static void main(String[] args) {
        // Compute tax
        System.out.println(computeTax(30000, 2, false));
        System.out.println(computeTax(10000, 6, false));
        System.out.println(computeTax(75000, 1, false));
        System.out.println(computeTax(75000, 1, true));

        // Compute gross income
        System.out.println(grossIncome(30000, 2, false));
        System.out.println(grossIncome(10000, 6, false));
        System.out.println(grossIncome(75000, 1, false));
        System.out.println(grossIncome(75000, 1, true));
    }

}