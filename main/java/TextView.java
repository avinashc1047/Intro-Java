import java.util.Scanner;

public class TextView {
    int rowMakingAction;
    int columnMakingAction;
    int rowChosenSquare;
    int columnChosenSquare;
    char actionType;

    // getter
    public int getRowMakingAction() {
        return rowMakingAction;
    }

    public int getColumnMakingAction() {
        return columnMakingAction;
    }

    public int getRowChosenSquare() {
        return rowChosenSquare;
    }

    public int getColumnChosenSquare() {
        return columnChosenSquare;
    }

    public char getActionType() {
        return actionType;
    }

    public static int getValidInt(int minVal, int maxVal, Scanner scnr) {
        boolean working = true;
        int userVal = 0;

        while (working) {
            if (scnr.hasNextInt()) {
                userVal = scnr.nextInt();
                if ((userVal >= minVal) && (userVal <= maxVal)) {
                    working = false;
                }
                else {
                    System.out.println("Type a different number: ");
                }
            }
            else {
                scnr.next();
            }
        }
        return userVal;
    }

    public static char getUsersNextActionType(Scanner scr) {
        String userStr = "";
        boolean found = false;
        System.out.println("The action types include:\n" +
                "Action: A\n" +
                "Recruit: R\n" +
                "Move: M\n" +
                "Spawn: S");
        while (!found) {
            System.out.println("Type the letter of the action type that you want: ");
            userStr = scr.next().toLowerCase();
            if (userStr.charAt(0) == 'a' || userStr.charAt(0) == 'm' ||
                    userStr.charAt(0) == 'r' || userStr.charAt(0) == 's') {
                found = true;
            }
        }
        return userStr.toUpperCase().charAt(0);
    }

    public void getNextPlayersAction(GameS22 game) {
        Scanner scr = new Scanner(System.in);
        actionType = getUsersNextActionType(scr);

        // ask for From square
        System.out.println("PLease type the Row of the Attacking square: ");
        rowMakingAction = getValidInt(0, game.getGameBoard().getNumRows(), scr);
        System.out.println("PLease type the Column of the Attacking square: ");
        columnMakingAction = getValidInt(0, game.getGameBoard().getNumColumns(), scr);

        // ask for To square
        System.out.println("PLease type the Row of the Defending square: ");
        rowChosenSquare = getValidInt(0, game.getGameBoard().getNumRows(), scr);
        System.out.println("PLease type the Column of the Defending square: ");
        columnChosenSquare = getValidInt(0, game.getGameBoard().getNumColumns(), scr);
    }

    public void updateView(GameS22 game) {
        System.out.println(game);
    }

    public void printEndOfGameMessage(GameS22 game) {
        System.out.println("The game has ended and the winning team is Team " + game.getWinner().getTeamColor());
    }
}
