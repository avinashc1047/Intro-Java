public class ActionSpawn extends Action{
    ActionSpawn(Game newGame, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        super(newGame, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }

    @Override
    public void performAction() {
        // call speak of attacker
        newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece().speak();

        // call the spawn method and store the piece
        // add it to the current team
        Piece newSpawn = newGame.getBoardSquares()[rowFromSquare][columnFromSquare].getPiece().spawn();
        newGame.getCurrentTeam().addPieceToTeam(newSpawn);

        // add the newSpawn to the To square
        newGame.getBoardSquares()[rowToSquare][columnToSquare].setPiece(newSpawn);

        // chnage turn
        newGame.changeTurn();
    }
}