import java.util.Collections;
public abstract class Game {
    GameBoard board;
    Team team1;
    Team team2;
    String turn;

    public Game(int numRows, int numColumns, Team firstTeam, Team secondTeam) {
        team1 = firstTeam;
        team2 = secondTeam;
        turn = firstTeam.getTeamColor();

        initializeGameBoard(numRows, numColumns);
    }

    public void initializeGameBoard(int numRows, int numColumns) {
        board = new GameBoard(numRows, numColumns);

        for(Piece piece : team1.pieces) {
            board.findRandomEmptySpace().setPiece(piece);
        }

        for(Piece piece : team2.pieces) {
            board.findRandomEmptySpace().setPiece(piece);
        }
    }

    // Accessor methods
    public GameBoard getGameBoard() {
        return board;
    }

    public Team getCurrentTeam() {
        Team retTeam;

        String team1Color = team1.getTeamColor();
        String team2Color = team2.getTeamColor();

        if(turn.equals(team1Color)) {
            retTeam = team1;
        }
        else {
            retTeam = team2;
        }
        return retTeam;
    }

    public Team getOpponentTeam() {
        Team retTeam;

        String team1Color = team1.getTeamColor();
        String team2Color = team2.getTeamColor();

        if(turn.equals(team1Color)) {
            retTeam = team2;
        }
        else {
            retTeam = team1;
        }
        return retTeam;
    }

    public boolean isTurn(Team currTeam) {
        return turn.equals(currTeam.getTeamColor());
    }

    public BoardSquare[][] getBoardSquares() {
        return board.squares;
    }

    public void changeTurn() {
        turn = getOpponentTeam().getTeamColor();
    }

    public abstract boolean isAWinner(Team team1);
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
}
