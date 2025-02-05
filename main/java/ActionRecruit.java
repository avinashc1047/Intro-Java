public class ActionRecruit extends Action{
    ActionRecruit(Game newGame, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        super(newGame, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }

    @Override
    public void performAction() {
        // call From piece speak method
        newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece().spawn();

        // remove To piece from opponent team
        newGame.getOpponentTeam().removePieceFromTeam(newGame.getBoardSquares()[rowToSquare][columnToSquare].getPiece());

        // add To piece to the current team
        newGame.getCurrentTeam().removePieceFromTeam(newGame.getBoardSquares()[rowToSquare][columnToSquare].getPiece());

        // change the turn
        newGame.changeTurn();
    }
}
