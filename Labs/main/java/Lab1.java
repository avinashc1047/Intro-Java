/**
 * Lab1
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * Intro to java. Building different methods
 * and using them to solve problems.
 *
 * @author Avinash Chouhan
 * @since February 16, 2022
 */

public class Lab1 {

    /** Problem - A
     * @param a Side a of the scalene triangle
     * @param b Side b of the scalene triangle
     * @param c Side c of the scalene triangle
     * @return The area of the scalene triangle using
     *         the a, b, c sides.
     */
    public static double areaScalene(double a, double b, double c) {
        double s;
        double area;

        s = ((a + b + c) / 2);

        area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return area;
    }

    /** Problem - B
     * @param numOfCredits Number of credits
     * @param numOfCoreCourses Number of Core Courses
     * @return Boolean value, if the course load is acceptable or not.
     */
    public static boolean okCourse(int numOfCredits, int numOfCoreCourses) {

        if (numOfCoreCourses >= 1 && ((numOfCredits >= 15) && (numOfCredits <= 19))) {
            return true;
        }
        else {
            return (numOfCoreCourses >= 2) && ((numOfCredits >= 12) && (numOfCredits <= 14));
        }
    }

    /** Problem - C
     * @param a The first number between 10-99
     * @param b The second number between 10-99
     * @return Boolean value that states if a and b share numbers or not.
     */
    public static boolean shareDigit(int a, int b) {
        int firstANum = a / 10;
        int secondANum = a % 10;
        int firstBNum = b / 10;
        int secondBNum = b % 10;

        if ((firstANum == firstBNum) || (firstANum == secondBNum)) {
            return true;
        }
        else {
            return (secondANum == firstBNum) || (secondANum == secondBNum);
        }
    }

    public static void main(String[] args) {
        System.out.print("The side values are, a = 5.5, b = 3.4, c = 8.7.");
        System.out.print(" The area of the scalene triangle is: ");
        System.out.println(areaScalene(5.5, 3.4, 8.7) + "\n");

        System.out.println("Is taking 5 courses worth 18 credits acceptable for you? "
                + okCourse(18, 5) + "!\n");

        System.out.println("The fact that 15 and 59 share common numbers is " + shareDigit(15,59) + "!\n");
    }
}