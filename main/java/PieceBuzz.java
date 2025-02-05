public class PieceBuzz extends Piece implements Attacker{
    private int numTimesBeenAttacked;
    private boolean workingLaser;
    private int numAttacks;

    public PieceBuzz(char symbol,
                     String teamColor,
                     int numAttacks,
                     int numTimesBeenAttacked,
                     boolean workingLaser,
                     boolean hidden,
                     boolean original) {
        super(symbol, teamColor, hidden, original);

        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    public PieceBuzz(){
        this('B',"- -",
                0,0,
                true, false, true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowAttacker, int columnAttacker, int rowAttackee, int columnAttackee) {
        // has two options
        // can move any number left or right, and no up/down
        // or two up or down, and no left/right

        int diffX = Math.abs(rowAttackee - rowAttacker);
        int diffY = Math.abs(columnAttackee - columnAttacker);

        return (diffY==2 && diffX==0) || (diffY==0);
    }

    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // always false
        return false;
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // anywhere on board
        return true;
    }

    public Piece spawn(){
        return null;
    }
    public boolean canSpawn(){
        return false;
    }

}