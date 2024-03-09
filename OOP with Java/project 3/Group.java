
/**This program creates Group objects, sets some values for the Group objects, adds teams and games to the group and checks
 * whether a team exists in a group and prints out information about the group.
 * @author Ayca Candan Atac
 */

import java.util.Arrays;

public class Group {

    // instance variables
    private String name;
    private int groupSize;
    private int numberOfTeams;
    private Team[] teams;
    private Game[][] games;
    private int[] points;
    private int[] sortedPoints;

    // constructor
    public Group(String name, int groupSize) {
        teams = new Team[groupSize];
        games = new Game[groupSize][groupSize];
        points = new int[groupSize];
        sortedPoints = new int[groupSize];

        if (groupSize > 0) {
            this.name = name;
            this.groupSize = groupSize;
            this.numberOfTeams = 0;
        }
    }

    // getter methods
    public String getName() {
        return name;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public Team[] getTeams() {
        return teams;
    }

    // this method checks whether a team exists in a group or not
    public boolean teamExists(int ID) {
        if (numberOfTeams == 0) {
            return false;
        } else {
            for (int i = 0; i < numberOfTeams; i++) {
                if (teams[i].getID() == ID) {
                    return true;
                }
            }
            return false;
        }
    }

    // this method adds a team to a group
    public void addTeam(Team team) {
        if (numberOfTeams < groupSize && !teamExists(team.getID())) {
            this.teams[numberOfTeams] = team;
            team.setTeamID(numberOfTeams);
            numberOfTeams++;
        }

    }

    // this method adds a game to a group
    public void addGame(Game game) {
        boolean continuePlay = true;

        if (game.getTeams()[0] != null && game.getTeams()[1] != null) {
            if (this.teamExists(game.getTeams()[0].getID()) && this.teamExists(game.getTeams()[1].getID())) {

                Team team1 = game.getTeams()[0];
                Team team2 = game.getTeams()[1];

                for (int i = 0; (i < numberOfTeams) && continuePlay; i++) {
                    for (int j = 0; (j < numberOfTeams) && continuePlay; j++) {
                        if (this.games[i][j] != null) {
                            for (int k = 0; (k < 2) && continuePlay; k++) {
                                if (games[i][j].getTeams()[k] == team1) {
                                    if (games[i][j].getTeams()[1 - k] == team2) {
                                        continuePlay = false;
                                        System.out.println("Already a game between the teams exist!");
                                    }
                                }
                            }
                        }
                    }
                }
                if (continuePlay) {
                    games[team1.getTeamID()][team2.getTeamID()] = game;
                    games[team2.getTeamID()][team1.getTeamID()] = game;
                    points[team1.getTeamID()] += game.getTeamPoints(team1.getID());
                    points[team2.getTeamID()] += game.getTeamPoints(team2.getID());
                }

            }
        }

    }

    // this method returns information about the teams and their points
    public String teamDisplayer() {
        sortedPoints = Arrays.copyOf(points, groupSize);
        Arrays.sort(sortedPoints);
        String returnStr = "";
        int a = 0;
        String blankStr;
        String blank2;
        int y = 0;
        int boundary = 0;
        for (int b = 0; b + 1 < sortedPoints.length; b++) {
            if ((sortedPoints[b] == sortedPoints[b + 1]) && (sortedPoints[b] != 0)) {
                sortedPoints[b] = 0;
            }
        }
        Arrays.sort(sortedPoints);
        boolean found = false;
        for (int k = sortedPoints.length - 1; (k >= 0) && !found; k--) {
            if (sortedPoints[k] == 0) {
                boundary = k;
                found = true;
            }
        }

        if (this.teams != null) {
            for (int g = sortedPoints.length - 1; g >= boundary; g--) {
                for (y = 0; y < numberOfTeams; y++) {
                    if (sortedPoints[g] == points[y]) {
                        a++;
                        if (this.teams[y].getID() / 10 > 0) {
                            blankStr = "  ";
                            blank2 = " ";
                        } else {
                            blankStr = "  ";
                            blank2 = "  ";
                        }

                        returnStr += (a) + "." + "     " + this.teams[y].getName() + " (" + blank2
                                + this.teams[y].getID() + " )" + blankStr + points[y] + "\n";
                    }
                }
            }
        }

        return returnStr;
    }

    // this method returns information about the group
    public String toString() {
        return "\n==================================\n" + "=" + "        " + "Group " + this.name + " Standings"
                + "       " + "="
                + "\n==================================\n" + teamDisplayer() + "==================================\n";
    }

    public static void main(String[] args) {

        // sample run
        Group B = new Group("B", 3);
        Team germany = new Team(6, "Germany");
        Team turkiye = new Team(38, "Türkiye");
        Team england = new Team(34, "England");
        B.addTeam(england);
        B.addTeam(germany);
        B.addTeam(turkiye);
        Game g1 = new Game(turkiye, germany, 0, 3);
        Game g2 = new Game(turkiye, england, 0, 0);
        Game g3 = new Game(germany, turkiye, 2, 1);
        B.addGame(g2);
        B.addGame(g1);
        B.addGame(g3);
        System.out.println(B.toString());

    }

}
