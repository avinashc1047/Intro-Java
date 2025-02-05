import java.lang.*;
public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter{
    private char symbol;
    private String teamColor;
    private int numRecruits;
    private int numAttacks;
    private int numTimesSpawned;
    private boolean hidden;
    private boolean original;
    private boolean hungry;

    final private int MAX_NUM_SPAWNED = 3;
    final private int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks,
                           int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    public PieceEvilMinion() {
        new PieceEvilMinion('E', "Non", 0, 0,
                0, false, true);
    }

    // Accessor methods

    public int getNumAttacks() {
        return numAttacks;
    }

    public boolean canAttack() {
        return hungry;
    }

    // Mutator methods
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowAttacker, int columnAttacker, int rowAttackee, int columnAttackee) {
        // has two options
        // can move any number up or down, no left/right
        // or two left or right, and no up/down

        int diffX = Math.abs(rowAttackee - rowAttacker);
        int diffY = Math.abs(columnAttackee - columnAttacker);

        return (diffX==2 && diffY==0) || (diffX==0);
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public void updateHungry() {
        hungry = numAttacks <= MAX_NUM_ATTACKS;
    }

    public void speak() {
        System.out.println("Roar!");
    }

    @Override
    public PieceEvilMinion spawn() {
        PieceEvilMinion newMinion = new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor,
                1, 0, 0, false, false);
        newMinion.updateHungry();
        this.numTimesSpawned++;

        return newMinion;
    }
}
