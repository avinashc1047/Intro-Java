public class PieceBlueHen extends Piece implements Attacker, Recruiter{
    private int numRecruits;
    private boolean flies;
    private int numAttacks;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen (char symbol,
                         String teamColor,
                         int numAttacks, int numRecruits,
                         boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);

        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();

    }

    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }

    public boolean canFly()    {
        return this.flies;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }

    @Override
    public boolean validAttackPath(int rowAttacker, int columnAttacker, int rowAttackee, int columnAttackee) {
        // if can fly, anywhere on board
        // if not, only one space left or right

        int diffX = Math.abs(rowAttackee - rowAttacker);
        int diffY = Math.abs(columnAttackee - columnAttacker);

        return flies || (diffX==1 && diffY==0);
    }

    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruitee, int columnRecruitee) {
        // if can fly, anywhere on board
        // if not, only one space up or down

        int diffX = Math.abs(rowRecruiter - rowRecruitee);
        int diffY = Math.abs(columnRecruitee - columnRecruiter);

        return flies || (diffY==1 && diffX==0);
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }
    public void speak(){
        System.out.println("Go UD!");
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // if can fly, anywhere on board
        // if not, only one space diagonal

        int diffX = Math.abs(fromSquareRow - toSquareRow);
        int diffY = Math.abs(fromSquareCol - toSquareCol);

        return flies || ((diffX == 1) && (diffY == 1));
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // if can fly, anywhere on board
        // if not, only one space any direction even diagonal

        int diffX = Math.abs(fromSquareRow - toSquareRow);
        int diffY = Math.abs(fromSquareCol - toSquareCol);

        return flies || ((diffX == 1) || (diffY == 1));
    }

    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    public boolean canSpawn(){
        return true;
    }
}