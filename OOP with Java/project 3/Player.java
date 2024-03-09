/**
 * This program creates the Player objects, sets some values for the player and
 * prints information about the Player.
 * 
 * @author Ayca Candan Atac
 */

public class Player {

    // instance variables
    private String name;
    private int age;
    private String nationality;
    private int jerseyNumber;
    private String position;
    private int marketValue;

    // constructor
    public Player(String name, int age, String nationality, int jerseyNumber, String position, int marketValue) {
        this.name = name;
        this.nationality = nationality;
        this.position = position;

        if (jerseyNumber >= 1 && jerseyNumber <= 99) {
            this.jerseyNumber = jerseyNumber;
        }

        if (age > 0 && marketValue > 0) {
            this.age = age;
            this.marketValue = marketValue;
        }
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getNationality() {
        return nationality;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        if (jerseyNumber >= 1 && jerseyNumber <= 99) {
            this.jerseyNumber = jerseyNumber;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        if (marketValue > 0) {
            this.marketValue = marketValue;
        }
    }

    // This method returns information about the player
    public String toString() {
        String blankStr = "";
        for (int i = 1; i < 17 - this.name.length() + 2; i++) {
            blankStr += " ";
        }
        return this.name + blankStr + this.age + "        " + this.nationality + "         " + this.jerseyNumber
                + "       "
                + this.position + "     " + this.marketValue;
    }

    public static void main(String[] args) {

        // sample run
        Player p1 = new Player("Raheem Sterling", 27, "England", 17, "Left Wing", 70000000);
        System.out.println(p1);
    }
}
