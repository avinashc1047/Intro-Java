import java.util.ArrayList;
import java.util.Random;

public class Controller {
    GameS22 game;
    TextView txtView;

    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",2,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Adding a new bandit piece to team A
        piecesTeamA.add(new Bandit('D',"Blu",false, true));

        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
       piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",2,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Adding a new bandit piece to team A
        piecesTeamB.add(new Bandit('C',"Red",false, true));

        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller() {
        game = setUpGameModel();
        txtView = new TextView();
        txtView.updateView(game);
    }

    public void carryOutAction(int rowMakingAction, int columnMakingAction, int rowChosenSquare,
                               int columnChosenSquare, char actionType) {
        Action action;

        if(actionType == 'M') {
            action = new ActionMove(game, rowMakingAction, columnMakingAction, rowChosenSquare, columnChosenSquare);
            action.performAction();
        }
        else if(actionType == 'A') {
            action = new ActionAttack(game, rowMakingAction, columnMakingAction, rowChosenSquare, columnChosenSquare);
            action.performAction();
        }
        else if(actionType == 'R') {
            action = new ActionRecruit(game, rowMakingAction, columnMakingAction, rowChosenSquare, columnChosenSquare);
            action.performAction();
        }
        else if(actionType == 'S') {
            action = new ActionSpawn(game, rowMakingAction, columnMakingAction, rowChosenSquare, columnChosenSquare);
            action.performAction();
        }
    }

    public void playGame() {
        int turnCount = 0;
        int initA = game.getCurrentTeam().pieces.size();
        int initB = game.getOpponentTeam().pieces.size();
        Random randBool = new Random();

        while(!game.isGameEnded()) {

            turnCount++;

            // Board Square Modification
            // hidden square trap activated after each team goes one time, so on the 3rd turn
            if (turnCount>2) {
                System.out.println("***The trap door has been activated watch out!***\n");
                if (!game.getBoardSquares()[2][5].isEmpty()) {
                    Piece deadPiece = game.getBoardSquares()[2][5].getPiece();
                    Team currTeam = game.getCurrentTeam();
                    if (deadPiece.getTeamColor().equals(currTeam.getTeamColor())) {
                        game.getBoardSquares()[2][5].removePiece();
                        game.getCurrentTeam().removePieceFromTeam(deadPiece);
                    } else {
                        game.getBoardSquares()[2][5].removePiece();
                        game.getOpponentTeam().removePieceFromTeam(deadPiece);
                    }
                    System.out.println(game);
                    continue;
                }
            }

            // New Rule Modification
            // every third turn, the first piece of a random team is removed
            if(turnCount%4 == 0) {
                System.out.println("***A random piece has been removed from the board!***\n");
                if (randBool.nextBoolean()) {
                    game.getCurrentTeam().pieces.remove(0);
                } else {
                    game.getOpponentTeam().pieces.remove(0);
                }
                System.out.println(game);
                continue;
            }

            txtView.getNextPlayersAction(game);

            while (!Rules.checkValidAction(game, txtView.getRowMakingAction(), txtView.getColumnMakingAction(),
                    txtView.getRowChosenSquare(), txtView.getColumnChosenSquare(), txtView.getActionType())) {
                txtView.getNextPlayersAction(game);
            }

            carryOutAction(txtView.getRowMakingAction(), txtView.getColumnMakingAction(),
                    txtView.getRowChosenSquare(), txtView.getColumnChosenSquare(), txtView.getActionType());

            System.out.println(game);
        }

        int winTeam = game.getWinner().getTeamPieces().size();

        // New Objective Modification
        // new objective check if winner lost any pieces
        if(game.team1.getTeamColor().equals(game.getWinner().getTeamColor())) {
            if(winTeam == initA) {
                System.out.println("WOW! You won the game without loosing any Pieces, Objective accomplished.");
            }
        }
        else if(game.team2.getTeamColor().equals(game.getWinner().getTeamColor())) {
            if(winTeam == initB) {
                System.out.println("WOW! You won the game without loosing any Pieces, Objective accomplished.");
            }
        }

        txtView.printEndOfGameMessage(game);
    }

    public static void main(String[] args) {
        Controller cont = new Controller();
        cont.playGame();
    }

}
