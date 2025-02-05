public class GameBoard {
    int numRows;
    int numColumns;
    BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        this.numColumns = numColumns;
        this.numRows = numRows;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    // Accessor methods
    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds(int rowIndex, int columnIndex) {
        boolean inBound = false;

        if((rowIndex > -1) && (columnIndex > -1)) {
            inBound = (rowIndex < numRows) && (columnIndex < numColumns);
        }

        return inBound;
    }

    private void setUpEmptyBoard() {
        for (int i = 0; i < squares.length; ++i) {
            for(int j = 0; j < squares[i].length; ++j) {
                if(((j+1)%2) == 0) {
                    squares[i][j] = new BoardSquare("Red");
                }
                else {
                    squares[i][j] = new BoardSquare("Blue");
                }
            }
        }
    }

    public BoardSquare findRandomEmptySpace(){
        boolean empty = false;
        int randRow = 0;
        int randColumn = 0;
        while (!empty){
            randRow = (int)(Math.random() * (numRows-1));
            randColumn = (int)(Math.random() * (numColumns-1));
            empty = squares[randRow][randColumn].isEmpty();
        }
        return squares[randRow][randColumn];
    }

    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}