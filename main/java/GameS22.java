public class GameS22 extends Game{
    public GameS22(int numRows, int numColumns, Team firstTeam, Team secondTeam) {
        super(numRows, numColumns, firstTeam, secondTeam);
    }

    @Override
    public boolean isAWinner(Team team1) {
        return getWinner().getTeamColor().equals(team1.getTeamColor());
    }

    @Override
    public Team getWinner() {
        if(team1.getTeamPieces() != null) {
            return team1;
        }
        else if(team2.getTeamPieces() != null) {
            return team2;
        }
        return null;
    }

    @Override
    public boolean isGameEnded() {
        return (team1.getTeamPieces().size()==0) || (team2.getTeamPieces().size()==0);
    }
}
