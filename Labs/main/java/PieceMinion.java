/**
 * Lab3
 * CISC 181-041L Spring 2022
 * University of Delaware
 *
 * GamePiece pieces
 * PieceBuzz and PieceMinion
 *
 * @author Avinash Chouhan
 * @since March 3, 2022
 */

class PieceMinion {
    private char symbol;
    private String teamColor;
    private int numRecruits;
    private int numTimesSpawned;
    private boolean hidden;
    private boolean original;
    final int MAX_NUM_SPAWNED = 3;

    public PieceMinion (char symbol, String teamColor, int numRecruits, int numTimesSpawned,
                        boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
        this.hidden = hidden;
        this.original = original;
    }

    public PieceMinion () {
        this.symbol = 'M';
        this.teamColor = "‘- -‘";
        this.numRecruits = 0;
        this.numTimesSpawned = 0;
        this.hidden = false;
        this.original = true;
    }

    // Accessors methods
    public char getSymbol() {
        return symbol;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public int getNumRecruits() {
        return numRecruits;
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isOriginal() {
        return original;
    }

    public boolean canSpawn() {
        return original && (numTimesSpawned<MAX_NUM_SPAWNED);
    }

    //Mutator methods
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setHidden(boolean isHidden) {
        this.hidden = isHidden;
    }

    public void speak() {
        System.out.println("Bello!");
    }

    public PieceMinion spawn() {

        PieceMinion spwnMinion = new PieceMinion(Character.toLowerCase(this.getSymbol()), this.getTeamColor(),
                1, 0, false, false);

        // Adds one to the num times spwnd to control spwning
        ++this.numTimesSpawned;

        return spwnMinion;
    }
}
