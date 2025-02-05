public class BoardSquare {
    boolean isEmpty = true;
    Piece piece;
    String squareColor;

    public BoardSquare(String squareColor) {
        this.squareColor = squareColor;
    }

    // Accessor methods
    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String getSquareColor() {
        return squareColor;
    }

    // Mutator method
    public void setPiece(Piece piece) {
        this.piece = piece;
        isEmpty = false;
    }

    public Piece removePiece() {
        Piece temp = piece;
        piece = null;
        isEmpty = true;
        squareColor = "";

        return temp;
    }

    public String toString() {
        String text;
        if(piece == null) {
            text = "-------";
        }
        else {
            text = "-" + piece.toString() + "-";
        }

        return text;
    }
}
