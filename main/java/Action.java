public abstract class Action {
    Game newGame;
    int rowFromSquare;
    int columnFromSquare;
    int rowToSquare;
    int columnToSquare;

    Action(Game newGame, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare){

        this.newGame = newGame;
        this.rowFromSquare = rowFromSquare;
        this.columnFromSquare = columnFromSquare;
        this.rowToSquare = rowToSquare;
        this.columnToSquare = columnToSquare;

    }

    public abstract void performAction();
}