/**
 * Lab 4
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * CellPhone class for lab 4. Holds the properties for a phone.
 * Different methods include various getters and the overriding toString method.
 *
 * @author Avinash Chouhan
 * @since March 22, 2022
 */

public class CellPhone {
    private String ownerName;
    private String phoneNumber;
    private String ringtone;
    private boolean doNotDisturb;

    /**
     * @param ownerName - name of the phone owner
     * @param phoneNumber - number of the phone
     *                    Sets the parameters with the specified values and parameters.
     */
    public CellPhone(String ownerName, String phoneNumber) {
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.ringtone = "beep";
        this.doNotDisturb = false;
    }

    /**
     * No parameter constructor that sets the variables to certain values.
     */
    public CellPhone() {
        this.ownerName = "John Doe";
        this.phoneNumber = "1234567890";
        this.ringtone = "beep";
        this.doNotDisturb = false;
    }

    /**
     * @return Returns the owner's name of the phone
     */
    public String getOwnerName() {
        return this.ownerName;
    }

    /**
     * @return Returns the number of the cellphone
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @return Returns the ringtone of the cellphone
     */
    public String getRingTone() {
        return this.ringtone;
    }

    /**
     * @return Returns if the phone is set on do not disturb or not.
     */
    public boolean isDoNotDisturb() {
        return this.doNotDisturb;
    }

    /**
     * @param doNotDisturb - do not disturb is on or not
     *                     Sets the donotdisturb to the given parameter
     */
    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    /**
     * @param ringtone - ringtone of the phone
     *                 Sets the ringtone for the phone.
     */
    public void setRingTone(String ringtone) {
        this.ringtone = ringtone;
    }

    /**
     *  Mimics a phone call on the phone. If the phone is on do not disturb then
     *  this displays "shhh" else it displays the phone's ringtone.
     */
    public void incomingCall() {
        if (this.doNotDisturb) {
            System.out.print("shhh");
        }
        else {
            System.out.print(getRingTone());
        }
    }

    /**
     * @return return a string containing the class's instances
     *      This is an overriding method that overrides the default toString method
     *      in order to print more useful information about the object.
     */
    @Override
    public String toString() {
        return ("Phone Owner : " + this.ownerName + " , Number : " + this.phoneNumber);
    }

    public static void main(String[] args) {
        CellPhone cell1 = new CellPhone("Sue", "888-999-0000");
        cell1.setRingTone("tring");

        cell1.incomingCall();

        cell1.setDoNotDisturb(true);
        cell1.incomingCall();

        System.out.println(cell1);
    }
}
