public class PieceBuzz {
    private char symbol;
    private String teamColor;
    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;
    private boolean hidden;
    private boolean original;

    public PieceBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked,
                     boolean workingLaser, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
        this.hidden = hidden;
        this.original = original;
    }

    public PieceBuzz() {
        this.symbol = 'B';
        this.teamColor = "- -";
        this.numAttacks = 0;
        this.numTimesBeenAttacked = 0;
        this.workingLaser = true;
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

    public int getNumAttacks() {
        return numAttacks;
    }

    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }

    public boolean canAttack() {
        return workingLaser;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isOriginal() {
        return original;
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

    public void setWorkingLaser(boolean isLaserWorking) {
        this.workingLaser = isLaserWorking;
    }

    // For updating times been attacked
    public void updateNumTimesBeenAttacked() {
        ++numTimesBeenAttacked;
        workingLaser = false;
    }

    public void speak() {
        System.out.println("To Infinity and Beyond!");
    }
}
