/**
 * Lab 4
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * CellPhoneCase class for lab 4. This extends the case class to have all of its properties.
 * Has different methods like getters and overriding toString() methods.
 *
 * @author Avinash Chouhan
 * @since March 22, 2022
 */

public class CellPhoneCase extends Case{
    private CellPhone phone;

    /**
     * @param ownerName name of the case owner
     * @param caseColor color of the case
     * @param phoneNumber number of the phone in the case
     *                    Constructor that creates a new CellPhone object
     */
    public CellPhoneCase(String ownerName, String caseColor, String phoneNumber) {
        super(ownerName, caseColor);
        phone = new CellPhone(ownerName, phoneNumber);
    }

    /**
     * @return returns the CellPhone in the case
     */
    public CellPhone getCellPhone() {
        return phone;
    }

    /**
     * Sets the phone on do not disturb
     */
    public void quietPhone() {
        phone.setDoNotDisturb(true);
    }

    /**
     * @param case1 The first case to swap
     * @param case2 The second case to swap
     *              returns nothing but swaps the phones in the two cases
     */
    public static void swapPhones(CellPhoneCase case1, CellPhoneCase case2) {
        CellPhone tempPhone = case1.getCellPhone();
        case1.phone = case2.getCellPhone();
        case2.phone = tempPhone;
    }

    /**
     * @return Returns a string which overrides the toString method.
     *          Calls on the super class and adds the CellPhone toString()
     */
    @Override
    public String toString() {
        return (super.toString() + " , " + phone.toString());
    }

    public static void main(String[] args) {
        CellPhoneCase case1 = new CellPhoneCase("Tim", "black", "111-222-3333");
        CellPhoneCase case2 = new CellPhoneCase("Neena", "blue", "444-555-6666");

        System.out.println(case1);
        System.out.println(case2);

        CellPhoneCase.swapPhones(case1, case2);

        System.out.println(case1);
        System.out.println(case2);
    }
}
