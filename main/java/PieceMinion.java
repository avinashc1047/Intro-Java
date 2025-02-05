public class PieceMinion extends Piece implements Recruiter{
    private int numTimesSpawned;
    private int numRecruits;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor,
                       int numRecruits, int numTimesSpawned,
                       boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);

        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }

    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruitee, int columnRecruitee) {
        // same as move path

        int diffX = Math.abs(rowRecruiter - rowRecruitee);
        int diffY = Math.abs(columnRecruiter - columnRecruitee);

        return (diffX==2 && diffY==0) || (diffX==0);
    }

    public void speak(){
        System.out.println("Bello!");
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // same as move path

        int diffX = Math.abs(fromSquareRow - toSquareRow);
        int diffY = Math.abs(fromSquareCol - toSquareCol);

        return (diffX==2 && diffY==0) || (diffX==0);
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // has two options
        // can move any number up or down, no left/right
        // or two left or right, and no up/down

        int diffX = Math.abs(fromSquareRow - toSquareRow);
        int diffY = Math.abs(fromSquareCol - toSquareCol);

        return (diffX==2 && diffY==0) || (diffX==0);
    }

    public PieceMinion spawn(){
        this.numTimesSpawned++;
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

}