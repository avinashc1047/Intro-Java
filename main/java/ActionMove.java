public class ActionMove extends Action {
    ActionMove(Game newGame, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        super(newGame, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }

    @Override
    public void performAction() {
        //call attacker's peak method
        newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece().speak();

        // remove the piece from the From square
        // but first create a place to hold the piece
        Piece tempPiece = newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece();
        newGame.getBoardSquares()[rowFromSquare][columnFromSquare].removePiece();

        // set tempPiece to the To square
        newGame.getBoardSquares()[rowToSquare][columnToSquare].setPiece(tempPiece);

        // change the turn
        newGame.changeTurn();
    }
}
