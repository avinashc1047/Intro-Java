/**This class is represents a Game Piece to be used in our final project
 * The Blue Hen can attack, fly and spawn.
 */
public class PieceBlueHen {

    // Step 1 through 3 - attributes
    private int numAttacked;
    private boolean isOriginal;
    private boolean canFly;

    //Step 11 - Constant for maximum number of attacks allowed
    final int MAX_ATTACK = 5;

    // Step 4 - Constructor – this should have two parameters
    public PieceBlueHen(int numAttacked, boolean isOriginal) {
    this.numAttacked = numAttacked;
    this.isOriginal = isOriginal;
    // Step 13 - updateFly
        updateFly();
    }


    // Step 5 - Constructor – zero parameters - should call Step 4 constructor
    public PieceBlueHen() {
        this(5, true);
    }

    // Step 7 - getter #1
    public int getNumAttacked() {
        return this.numAttacked;
    }

    // Step 7 - getter #2
    public boolean getIsOrigianl() {
        return this.isOriginal;
    }

    // Step 7 - getter #3
    public boolean getCanFly() {
        return this.canFly;
    }

    // Step 8 - setter
    public void setNumAttacked(int numAttacked) {
        this.numAttacked = numAttacked;
        // Step 14 – call updateFly in this setter
        updateFly();
    }

    // Step 12 – updateFly method definition
    private void updateFly() {
        if (numAttacked < MAX_ATTACK) {
            this.canFly = true;
        }
        else {
            this.canFly = false;
        }
    }

    // Step 15 - spawnBlenHen
    public PieceBlueHen spawnBlueHen() {
        PieceBlueHen baby = new PieceBlueHen(this.numAttacked, false);
        return baby;
    }

    // Step 6  - add main method
    public static void main(String[] args) {
        // Step 6 - create instance using the constructor that has no parameters
        PieceBlueHen hen1 = new PieceBlueHen();

        // Step 6 - create instance using the constructor that has 2 parameters
        PieceBlueHen hen2 = new PieceBlueHen(4, true);

        // Step 9 - call the setter for one of your objects
        hen2.setNumAttacked(4);

        // Step 10 - print attribute #1 for one of your objects
        System.out.println("NumAttacked: " + hen2.getNumAttacked());

        // Step 10 - print attribute #2 for one of your objects
        System.out.println("isOriginal: " + hen2.getIsOrigianl());

        // Step 10 - print attribute #3 for one of your objects
        System.out.println("canFly: " + hen2.getCanFly());

        // Step 16 - call one of your objects spawnBlueHen and assign to a variable named henBaby
        PieceBlueHen henBaby = hen2.spawnBlueHen();

        // Step 17 - print all attributes of henBaby
        System.out.println("NumAttacked - henBaby: " + henBaby.getNumAttacked());

        System.out.println("isOriginal - henBaby: " + henBaby.getIsOrigianl());

        System.out.println("canFly - henBaby: " + henBaby.getCanFly());

        System.out.println(hen2);
    }
}
