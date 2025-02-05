public class Bandit extends Piece implements Attacker{
    // New Piece Modification
    int numAttacks;

    public Bandit(char symbol, String teamColor, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public int getNumAttacks() {
        return this.numAttacks;
    }

    @Override
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        conceal();
    }

    @Override
    public boolean validAttackPath(int rowAttacker, int columnAttacker, int rowAttackee, int columnAttackee) {
        // can move any direction 1 square, even diagonal

        int diffX = Math.abs(rowAttackee - rowAttacker);
        int diffY = Math.abs(columnAttackee - columnAttacker);

        return diffX==1 || diffY==1;
    }

    @Override
    public void speak() {
        System.out.println("Dash!");
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // never spawns a new piece
        return false;
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // can only move two square up/down, or one square diagonal

        int diffX = Math.abs(fromSquareRow - toSquareRow);
        int diffY = Math.abs(fromSquareCol - toSquareCol);

        if(this.isHidden()) {
            return (diffX==1 && diffY==0) || (diffX==0 && diffY==1);
        }

        return ((diffX==2 && diffY==0) || (diffY==2 && diffX==0)) || ((diffX == 1) && (diffY == 1));
    }

    @Override
    public Piece spawn() {
        return null;
    }

    // New Action Modification
    // hidden if numattacked is 2 or bigger
    public void conceal() {
        this.setHidden(getNumAttacks() > 1);
    }
}
