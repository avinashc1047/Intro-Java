public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int num);
    public abstract boolean validAttackPath(int rowAttacker, int columnAttacker,
                                             int rowAttackee, int columnAttackee);
}
