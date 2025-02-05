public class ActionAttack extends Action {

    //Constructor
    public ActionAttack (Game newGame, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        super(newGame, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }

    @Override
    public void performAction() {
        //call the From Piece’s speak method
        newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece().speak();

        //remove the attacked Piece from the board
        Piece attacked = newGame.getBoardSquares()[rowToSquare][columnToSquare].getPiece();
        newGame.getBoardSquares()[rowToSquare][columnToSquare].removePiece();

        //remove the attacked Piece from the opponent’s team
        newGame.getOpponentTeam().removePieceFromTeam(attacked);

        //move the Piece on the From Square to the To Square.
        Piece attacker = newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece();
        newGame.getBoardSquares()[rowToSquare][columnToSquare].setPiece(attacker);
        newGame.getBoardSquares()[rowFromSquare][columnFromSquare].removePiece();

        //change the turn
        newGame.changeTurn();
    }
}