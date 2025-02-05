public abstract class Piece{
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    // Helper function to the set the teamColor used in the Team class
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public abstract void speak();
    public abstract boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol);

    @Override
    public String toString() {
        if(this instanceof Bandit) {
            if(this.isHidden()) {
                return "--~--";
            }
        }
        return (this.teamColor + " " + this.symbol);
    }

    public abstract Piece spawn();
}
