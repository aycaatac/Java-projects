
/**This program creates Team objects, sets some values for the Team, 
 * has some methods to arrange players in a Team and prints information about the Team.
 * @author Ayca Candan Atac
 */
import java.util.ArrayList;

public class Team {

    // instance variables
    private int ID;
    private String name;
    private int averageAge;
    private int marketValue;
    private ArrayList<Player> squad;
    private int sum = 0;
    private int teamID;

    // constructor
    public Team(int ID, String name) {
        this.name = name;
        if (ID > 0) {
            this.ID = ID;
        }
        this.averageAge = 0;
        this.marketValue = 0;
        squad = new ArrayList<Player>();
    }

    // getter and setter methods
    public ArrayList<Player> getSquad() {
        return squad;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public int getMarketValue() {
        return marketValue;
    }

    // This method checks whether a player exists in a team or not
    public boolean playerExists(int jerseyNumber) {
        for (int i = 0; i < squad.size(); i++) {
            Player player1 = squad.get(i);
            if (player1.getJerseyNumber() == jerseyNumber) {
                return true;
            }
        }
        return false;
    }

    // This method adds a player to the team
    public void addPlayer(Player player) {
        boolean canAdd = true;
        for (int i = 0; i < squad.size(); i++) {
            Player player1 = squad.get(i);
            if (player1.equals(player)) {
                canAdd = false;
            }
        }

        if (canAdd && (player.getNationality().equals(this.name))) {
            squad.add(player);
            sum += player.getAge();
            this.averageAge = sum / squad.size();
            this.marketValue += player.getMarketValue();
        }
    }

    // this method removes a player from the team
    public void removePlayer(int jerseyNumber) {
        for (int i = 0; i < squad.size(); i++) {
            Player player1 = squad.get(i);
            if (player1.getJerseyNumber() == jerseyNumber) {
                squad.remove(i);
                sum -= player1.getAge();
                this.averageAge = sum / squad.size();
                this.marketValue -= player1.getMarketValue();
            }
        }
    }

    // this method returns player informations
    public String printPlayers(Team team) {
        String returnStr = "";
        for (int k = 0; k < this.squad.size(); k++) {
            returnStr += squad.get(k).toString() + "\n";
        }
        return returnStr;
    }

    // this method returns information about the team
    public String toString() {
        return "=================================================================================\n" + "="
                + "                        " + "Team Details"
                + "                           " + "=\n"
                + "=================================================================================\n"
                + "ID: " + this.ID + "\nTeam: " + this.name + "\nAverage age: " + this.averageAge
                + "\nMarket Value: "
                + this.marketValue
                + "\nSquad is composed of following players: "
                + "\n---------------------------------------------------------------------------------\n"
                + "Name              Age       Nationality     Number   Position      Market Value"
                + "\n---------------------------------------------------------------------------------\n"
                + printPlayers(this)
                + "\n=================================================================================";

    }

    public static void main(String[] args) {

        // sample run
        Team turkiye = new Team(38, "Türkiye");
        Player p1 = new Player("Altay Bayindir", 24, "Türkiye", 1, "Goalkeeper", 13000000);
        Player p2 = new Player("Çaglar Söyüncü", 26, "Türkiye", 4, "Centre Back", 22000000);
        turkiye.addPlayer(p1);
        turkiye.addPlayer(p2);
        System.out.println(turkiye);
    }
}
