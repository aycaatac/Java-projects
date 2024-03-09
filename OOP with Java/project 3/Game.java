/**
 * This program creates Game objects, has the teams and goals in the game as
 * variables,
 * returns the points given to teams after a game and prints out information
 * about the game.
 * 
 * @author Ayca Candan Atac
 */

public class Game {
    // instance variables
    private Team[] teams;
    private int[] goals;

    // constructor
    public Game(Team team1, Team team2, int team1Goals, int team2Goals) {
        teams = new Team[2];
        goals = new int[2];

        if ((team1 != null && team2 != null) && (team1Goals >= 0 && team2Goals >= 0)) {
            this.teams[0] = team1;
            this.teams[1] = team2;
            this.goals[0] = team1Goals;
            this.goals[1] = team2Goals;
        }
    }

    // getter for teams in a game
    public Team[] getTeams() {
        return this.teams;
    }

    // this method returns the points given to a team after a game
    public int getTeamPoints(int teamID) {
        for (int x = 0; x < teams.length; x++) {
            if (teams[x].getID() == teamID) {
                if (goals[x] > goals[1 - x]) {
                    return 3;
                }
                if (goals[x] == goals[1 - x]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        return 0;

    }

    // this method returns information about the game
    public String toString() {
        return "\n" + this.teams[0].getName() + " vs. " + this.teams[1].getName() + ": " + this.goals[0] + "-"
                + this.goals[1];
    }

    public static void main(String[] args) {

        // sample run
        Team germany = new Team(6, "Germany");
        Team turkiye = new Team(38, "Türkiye");
        Game g1 = new Game(turkiye, germany, 3, 2);
        System.out.println(g1);

    }

}
