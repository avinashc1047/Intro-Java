import java.util.ArrayList;
public class Team {
    String teamColor;
    ArrayList<Piece> pieces;

    public Team(String teamColor, ArrayList<Piece> pieces) {
        this.teamColor = teamColor;
        this.pieces = pieces;
    }

    // Accessor method
    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return pieces;
    }

    public void removePieceFromTeam(Piece remPiece) {
        pieces.remove(remPiece);
    }

    // helper function set in the super Piece class to change the teamColor
    public void addPieceToTeam(Piece newPiece) {
        newPiece.setTeamColor(teamColor);
        pieces.add(newPiece);
    }

    @Override
    public String toString() {
        String pieceVals = "";

        for(Piece piece : pieces) {
            pieceVals += piece.toString() + "\t";
        }
        return "Team " + teamColor + " Pieces :\n" + pieceVals;
    }
}
