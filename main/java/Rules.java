public class Rules {
    public static boolean checkValidAction(GameS22 currGame, int rowMakingAction, int columnMakingAction,
                                   int rowChosenSquare, int columnChosenSquare, char actionType) {
        //in bounds
        if(currGame.getGameBoard().inBounds(rowMakingAction, columnMakingAction) &&
                currGame.getGameBoard().inBounds(rowChosenSquare, columnChosenSquare)) {

            // Attacker exists
            if(currGame.getGameBoard().squares[rowMakingAction][columnMakingAction] != null) {
                Piece attackPiece = currGame.getGameBoard().squares[rowMakingAction][columnMakingAction].getPiece();

                // Attacker has turn
                if(currGame.getCurrentTeam().getTeamColor().equals(attackPiece.getTeamColor())) {

                    //check if defender square is empty
                    if(actionType == 'M') {
                        if(attackPiece.validMovePath(rowMakingAction, columnMakingAction, rowChosenSquare, columnChosenSquare)) {
                            return currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare].isEmpty();
                        }
                    }

                    // minion or blue hen then check if defender is empty
                    else if(actionType == 'S') {
                        if(attackPiece.validSpawnPath(rowMakingAction, columnMakingAction, rowChosenSquare, columnChosenSquare)) {
                            if ((attackPiece instanceof PieceMinion || attackPiece instanceof PieceBlueHen)) {
                                return currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare] == null;
                            }
                        }
                    }

                    // minion or bluehen the check if defender square has opponent
                    else if(actionType == 'R') {

                        if (!currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare].isEmpty()) {
                            Piece defenderPiece = currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare].getPiece();

                            if (attackPiece instanceof PieceMinion) {
                                if (((PieceMinion) attackPiece).validRecruitPath(rowMakingAction, columnMakingAction,
                                        rowChosenSquare, columnChosenSquare)) {
                                    return currGame.getOpponentTeam().getTeamColor().equals(defenderPiece.getTeamColor());
                                }
                                return false;
                            }

                            else if(attackPiece instanceof PieceBlueHen) {
                                if (((PieceBlueHen) attackPiece).validRecruitPath(rowMakingAction,
                                        columnMakingAction, rowChosenSquare, columnChosenSquare)) {
                                    return currGame.getOpponentTeam().getTeamColor().equals(defenderPiece.getTeamColor());
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }

                    else if(actionType == 'A') {
                        if (!currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare].isEmpty()) {
                            Piece defenderPiece = currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare].getPiece();
                            //for buzz and bluehen
                            if ((attackPiece instanceof PieceBuzz || attackPiece instanceof PieceBlueHen)) {
                                // defender is opponent
                                if (currGame.getOpponentTeam().getTeamColor().equals(defenderPiece.getTeamColor())) {
                                    /// buzz cant attack if laser not on
                                    if (attackPiece instanceof PieceBuzz) {
                                        if(((PieceBuzz) attackPiece).validAttackPath(rowMakingAction, columnMakingAction,
                                                rowChosenSquare, columnChosenSquare)) {
                                            if (((PieceBuzz) attackPiece).canAttack()) {
                                                ((PieceBuzz) attackPiece).setNumAttacks((((PieceBuzz) attackPiece).getNumAttacks())+1);
                                                return true;
                                            }
                                        }
                                        return false;
                                    }
                                    else {
                                        if(((PieceBlueHen) attackPiece).validAttackPath(rowMakingAction, columnMakingAction,
                                                rowChosenSquare, columnChosenSquare)) {
                                            ((PieceBlueHen) attackPiece).setNumAttacks(((PieceBlueHen) attackPiece).getNumAttacks()+1);
                                            return true;
                                        }
                                    }
                                }
                            }

                            // for bandit piece
                            else if (attackPiece instanceof Bandit) {
                                if(((Bandit) attackPiece).validAttackPath(rowMakingAction, columnMakingAction, rowChosenSquare,
                                        columnChosenSquare)) {
                                    // check if hidden or not
                                    // if hidden can't attack
                                    if(!attackPiece.isHidden()) {
                                        ((Bandit) attackPiece).setNumAttacks(((Bandit) attackPiece).getNumAttacks()+1);
                                        return true;
                                    }
                                }
                            }

                            //for evil minion, only evil not all minion
                            else if (attackPiece instanceof PieceEvilMinion) {
                                if(((PieceEvilMinion) attackPiece).validAttackPath(rowMakingAction, columnMakingAction,
                                        rowChosenSquare, columnMakingAction)) {
                                    //check if hungry
                                    if (((PieceEvilMinion) attackPiece).canAttack()) {
                                        //for same team attack
                                        if (currGame.getCurrentTeam().getTeamColor().equals(attackPiece.getTeamColor())) {
                                            //need to change friendly minion into an evil minion
                                            currGame.getGameBoard().squares[rowChosenSquare][columnChosenSquare]
                                                    .setPiece(attackPiece.spawn());
                                            return true;
                                        }
                                        ((PieceEvilMinion) attackPiece).setNumAttacks(((PieceEvilMinion) attackPiece).getNumAttacks()+1);
                                        //default opponent attack
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
