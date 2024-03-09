
/** A class for Qatar 2022 World Cup
*   Turkiye is also qualified in this version :)
*   Market values and player information is obtained from Transfermarkt.com
*   @author Ozcan Ozturk
*   @version 1.0
*/
import java.util.Arrays;
import java.util.Scanner;

public class Qatar2022 {

    public static void main(String[] args) {
        // Scanner object
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        boolean isOver = false;
        boolean isCitizen = false;

        // Form the English Team
        Team england = new Team(34, "England");
        england.addPlayer(new Player("Raheem Sterling", 27, "England", 17, "Left Wing", 70000000));
        england.addPlayer(new Player("Phil Foden", 22, "England", 47, "Central Midfield", 110000000));
        england.addPlayer(new Player("Jack Grealish", 27, "England", 10, "Left Wing", 70000000));
        england.addPlayer(new Player("Declan Rice", 23, "England", 41, "Defensive Midfield", 80000000));
        england.addPlayer(new Player("Declan Rice", 23, "England", 41, "Defensive Midfield", 80000000));
        england.addPlayer(new Player("Aaron Ramsdale", 24, "England", 23, "Goalkeeper", 30000000));
        england.addPlayer(new Player("Aaron Ramsdale", 24, "England", 23, "Goalkeeper", 30000000));
        england.addPlayer(new Player("Jordan Pickford", 28, "England", 1, "Goalkeeper", 28000000));
        england.addPlayer(new Player("Nick Pope", 30, "England", 13, "Goalkeeper", 18000000));
        england.addPlayer(new Player("Ben White", 25, "England", 21, "Centre Back", 45000000));
        england.addPlayer(new Player("John Stones", 28, "England", 5, "Centre Back", 30000000));
        england.addPlayer(new Player("Harry Maguire", 29, "England", 6, "Centre Back", 30000000));
        england.addPlayer(new Player("Eric Dier", 28, "England", 15, "Centre Back", 30000000));
        england.addPlayer(new Player("Conor Coady", 29, "England", 16, "Centre Back", 18000000));
        england.addPlayer(new Player("Luke Shaw", 27, "England", 3, "Left Back", 28000000));
        england.addPlayer(new Player("Kyle Walker", 32, "England", 2, "Right Back", 15000000));
        england.addPlayer(new Player("Jude Bellingham", 19, "England", 22, "Central Midfield", 100000000));
        england.addPlayer(new Player("Harry Kane", 29, "England", 9, "Centre Forward", 90000000));

        // Form the Turkish Team
        Team turkiye = new Team(38, "Turkiye");
        turkiye.addPlayer(new Player("Ugurcan Çakir", 26, "Turkiye", 23, "Goalkeeper", 14000000));
        turkiye.addPlayer(new Player("Altay Bayindir", 24, "Turkiye", 1, "Goalkeeper", 13000000));
        turkiye.addPlayer(new Player("Çaglar Söyüncü", 26, "Turkiye", 4, "Centre Back", 22000000));
        turkiye.addPlayer(new Player("Ozan Kabak", 22, "Turkiye", 15, "Centre Back", 10000000));
        turkiye.addPlayer(new Player("Tayyip Sanuç", 22, "Turkiye", 6, "Centre Back", 3800000));
        turkiye.addPlayer(new Player("Eren Elmali", 22, "Turkiye", 13, "Left Back", 4200000));
        turkiye.addPlayer(new Player("Zeki Çelik", 25, "Turkiye", 2, "Right Back", 15000000));
        turkiye.addPlayer(new Player("Salih Özcan", 24, "Turkiye", 5, "Defensive Midfield", 17000000));
        turkiye.addPlayer(new Player("Hakan Çalhanoglu", 28, "Turkiye", 10, "Central Midfield", 35000000));
        turkiye.addPlayer(new Player("Arda Güler", 17, "Turkiye", 25, "Attacking Midfield", 10000000));
        turkiye.addPlayer(new Player("Kerem Aktürkoglu", 24, "Turkiye", 7, "Left Wing", 13000000));
        turkiye.addPlayer(new Player("Cengiz Ünder", 25, "Turkiye", 17, "Right Wing", 17000000));
        turkiye.addPlayer(new Player("Enes Ünal", 25, "Turkiye", 16, "Centre Forward", 25000000));
        turkiye.addPlayer(new Player("Umut Bozok", 26, "Turkiye", 19, "Centre Forward", 5500000));
        turkiye.addPlayer(new Player("Cenk Tosun", 31, "Turkiye", 9, "Centre Forward", 2000000));

        // Form the Germany Team
        Team germany = new Team(6, "Germany");
        germany.addPlayer(new Player("Andre Ter Stegen", 30, "Germany", 22, "Goalkeeper", 30000000));
        germany.addPlayer(new Player("Manuel Neuer", 36, "Germany", 1, "Goalkeeper", 12000000));
        germany.addPlayer(new Player("Antonio Rüdiger", 29, "Germany", 2, "Centre Back", 40000000));
        germany.addPlayer(new Player("Niklas Süle", 27, "Germany", 15, "Centre Back", 35000000));
        germany.addPlayer(new Player("Thilo Kehrer", 26, "Germany", 5, "Centre Back", 22000000));
        germany.addPlayer(new Player("David Raum", 24, "Germany", 3, "Left Back", 26000000));
        germany.addPlayer(new Player("Lukas Klostermann", 26, "Germany", 16, "Right Back", 14000000));
        germany.addPlayer(new Player("Joshua Kimmich", 27, "Germany", 6, "Defensive Midfield", 80000000));
        germany.addPlayer(new Player("Leon Goretzka", 27, "Germany", 8, "Central Midfield", 65000000));
        germany.addPlayer(new Player("Ilkay Gündogan", 32, "Germany", 21, "Central Midfield", 25000000));
        germany.addPlayer(new Player("Jamal Musiala", 19, "Germany", 14, "Attacking Midfield", 100000000));
        germany.addPlayer(new Player("Leroy Sane", 26, "Germany", 19, "Left Wing", 70000000));
        germany.addPlayer(new Player("Serge Gnabry", 27, "Germany", 10, "Right Wing", 65000000));
        germany.addPlayer(new Player("Karim Adeyemi", 20, "Germany", 24, "Right Wing", 35000000));
        germany.addPlayer(new Player("Youssoufa Moukoko", 18, "Germany", 26, "Centre Forward", 30000000));
        germany.addPlayer(new Player("Niclas Füllkrug", 29, "Germany", 9, "Centre Forward", 5000000));

        // Create a Group to play the matches in the group
        // Group is created with 4 teams but 3 teams have already
        // been created manually to have some data ready to be used.
        Group groupA = new Group("A", 4);

        // Add the teams to Group "A"
        groupA.addTeam(germany);
        groupA.addTeam(england);
        groupA.addTeam(turkiye);

        // first decision
        System.out.println("---------------------------------------------------");
        System.out.println("Welcome to Qatar 2022! Get Ready for the World Cup!");
        System.out.println("---------------------------------------------------");
        System.out.println("-------------- Group: " + groupA.getName() + "-------------------");
        System.out.println(
                "1 - Create a new Team\n2 - Display a Team\n3 - Add a Player to a Team\n4 - Remove a Player with ID from a Team\n5 - Add a Game to the Group\n6 - Display Standings\n7 - Exit");
        System.out.println("-------------------------------------------");
        System.out.print("Your choice: ");
        if (scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
        } else {
            System.out.println("Please try again and enter an integer for your choice.");
        }

        // decision loop
        while ((userChoice != 7 && !isOver) && (userChoice >= 1 && userChoice <= 7)) {
            if (userChoice == 1) {
                if (groupA.getNumberOfTeams() >= 4) {
                    System.out.println("Group already has 4/4 teams.");
                    isOver = true;
                } else {
                    System.out.print("What is the unique ID of the Team?: ");
                    if (scanner.hasNextInt()) {
                        int teamID = scanner.nextInt();
                        if (teamID <= 0) {
                            System.out.println("Team ID cannot be negative!");
                            isOver = true;
                        } else {
                            if (!isOver) {
                                scanner.nextLine();
                                System.out.print("What is the name of the Team?: ");
                                String teamName = scanner.nextLine();
                                Team newTeam = new Team(teamID, teamName);
                                groupA.addTeam(newTeam);
                            }
                        }
                    }
                }
            }
            if (userChoice == 2) {
                System.out.print("What is the unique ID of the Team?: ");
                int teamID = scanner.nextInt();
                if (teamID <= 0) {
                    System.out.println("Team ID cannot be negative!");
                    isOver = true;
                } else {
                    if (groupA.teamExists(teamID)) {
                        for (int k = 0; k < groupA.getNumberOfTeams(); k++) {
                            if (groupA.getTeams()[k].getID() == teamID) {
                                System.out.println(groupA.getTeams()[k].toString());
                            }
                        }
                    } else {
                        System.out.println("Team does not exist!");
                        isOver = true;
                    }
                }
            }
            if (userChoice == 3) {
                System.out.print("What is the unique ID of the Team to add the Player?: ");
                int teamID = scanner.nextInt();
                if (teamID < 0) {
                    System.out.println("Team ID cannot be negative!");
                    isOver = true;
                } else {
                    boolean teamExists = false;
                    if (!(groupA.getNumberOfTeams() == 0)) {
                        for (int j = 0; j < groupA.getNumberOfTeams(); j++) {
                            if (groupA.getTeams() != null) {
                                if (groupA.getTeams()[j].getID() == teamID) {
                                    teamExists = true;
                                }
                            }
                        }
                    }
                    if (!teamExists) {
                        System.out.println("This team does not exist!");
                        isOver = true;
                    }
                    if (teamExists) {
                        scanner.nextLine();
                        System.out.print("Enter the name of the player: ");
                        String playerName = scanner.nextLine();
                        System.out.print("Enter the age of the player: ");
                        int playerAge = scanner.nextInt();
                        scanner.nextLine();
                        if (playerAge < 0) {
                            System.out.println("Player age should be positive!");
                            isOver = true;
                        }
                        if (!isOver) {
                            System.out.print("Enter the nationality of the player: ");
                            String playerNat = scanner.nextLine();
                            if (groupA.getNumberOfTeams() == 0) {
                                System.out.println("Team does not exist!");
                                isOver = true;
                            }
                            for (int j = 0; j < groupA.getNumberOfTeams() && !(groupA.getNumberOfTeams() == 0); j++) {
                                if (groupA.getTeams()[j].getID() == teamID) {
                                    String newNAme = groupA.getTeams()[j].getName();
                                    if ((newNAme.equals(playerNat))) {
                                        isCitizen = true;
                                    }
                                }
                            }
                            if (!isCitizen) {
                                System.out.println("Player must be a citizen of the country!");
                                isOver = true;
                            }
                            if (!isOver && isCitizen) {
                                System.out.print("Enter the jersey number of the player: ");
                                int playerJerNo = scanner.nextInt();
                                scanner.nextLine();
                                if (playerJerNo >= 1 && playerJerNo <= 99) {
                                    isOver = false;
                                } else {
                                    System.out.println("Jersey number should be between 1 and 99!");
                                    isOver = true;
                                }
                                if (!isOver) {
                                    if (groupA.getNumberOfTeams() == 0) {
                                        System.out.println("This team does not exist!");
                                        isOver = true;
                                    }
                                    for (int j = 0; j < groupA.getNumberOfTeams()
                                            && !(groupA.getNumberOfTeams() == 0); j++) {
                                        if (groupA.getTeams()[j].getID() == teamID) {
                                            if ((groupA.getTeams()[j].playerExists(playerJerNo))) {
                                                System.out.println("Player with this jersey number already exists!");
                                                isOver = true;
                                            }
                                        }
                                    }
                                    if (!isOver) {
                                        System.out.print("Enter the position of the player: ");
                                        String playerPos = scanner.nextLine();
                                        System.out.print("Enter the market value of the player: ");
                                        int playerMarVal = scanner.nextInt();
                                        scanner.nextLine();
                                        if (!(playerMarVal > 0)) {
                                            System.out.println("Market value cannot be negative!");
                                            isOver = true;
                                        }
                                        if (!isOver) {
                                            for (int j = 0; j < groupA.getNumberOfTeams(); j++) {
                                                if (groupA.getTeams()[j].getID() == teamID) {
                                                    Player newPlayer = new Player(playerName, playerAge, playerNat,
                                                            playerJerNo, playerPos, playerMarVal);
                                                    groupA.getTeams()[j].addPlayer(newPlayer);
                                                }
                                            }
                                        }

                                    }
                                }
                            }

                        }
                    }
                }
            }
            if (userChoice == 5) {
                System.out.print("What is the unique ID of the First Team?:");
                int firstID = scanner.nextInt();
                Team team1 = null;
                Team team2 = null;
                boolean teamExists = false;
                boolean teamExists2 = false;
                if (firstID <= 0) {
                    System.out.println("Team ID cannot be negative!");
                    isOver = true;
                } else {
                    for (int k = 0; k < groupA.getNumberOfTeams(); k++) {
                        if (groupA.getTeams()[k].getID() == firstID) {
                            team1 = groupA.getTeams()[k];
                            teamExists = true;
                        }
                    }
                    if (!teamExists) {
                        System.out.println("First team does not exist!");
                        isOver = true;
                    } else {
                        scanner.nextLine();
                        System.out.print("What is the unique ID of the Second Team?:");
                        int secondID = scanner.nextInt();
                        if (secondID <= 0) {
                            System.out.println("Team ID cannot be negative!");
                            isOver = true;
                        } else {
                            for (int b = 0; b < groupA.getNumberOfTeams(); b++) {
                                if (groupA.getTeams()[b].getID() == secondID) {
                                    team2 = groupA.getTeams()[b];
                                    teamExists2 = true;
                                }
                            }
                            if (!teamExists2) {
                                System.out.println("Second team does not exist!");
                                isOver = true;
                            } else {
                                scanner.nextLine();
                                System.out.print("Enter the score (such as 2 1): ");
                                int firstGoals = scanner.nextInt();
                                if (firstGoals < 0) {
                                    System.out.println("Scores can not be negative!");
                                    isOver = true;
                                } else {
                                    int secondGoals = scanner.nextInt();
                                    if (secondGoals < 0) {
                                        System.out.println("Scores can not be negative!");
                                        isOver = true;
                                    } else {
                                        Game newGame = new Game(team1, team2, firstGoals, secondGoals);
                                        groupA.addGame(newGame);
                                    }
                                }

                            }

                        }

                    }

                }
            }
            if (userChoice == 4) {
                System.out.print("What is the unique ID of the Team to remove the Player?: ");
                int teamID = scanner.nextInt();
                scanner.nextLine();
                if (teamID < 0) {
                    System.out.println("Team ID cannot be negative!");
                    isOver = true;
                } else {
                    boolean teamExists = false;
                    if (!(groupA.getNumberOfTeams() == 0)) {
                        for (int j = 0; j < groupA.getNumberOfTeams(); j++) {
                            if (groupA.getTeams() != null) {
                                if (groupA.getTeams()[j].getID() == teamID) {
                                    teamExists = true;
                                }
                            }
                        }
                    }
                    if (!teamExists) {
                        System.out.println("This team does not exist!");
                        isOver = true;
                    }
                    if (teamExists) {
                        System.out.print("Enter the jersey number of the player: ");
                        int playerJerNo = scanner.nextInt();
                        scanner.nextLine();
                        if (!(playerJerNo >= 1 && playerJerNo <= 99)) {
                            System.out.println("Jersey number should be between 1 and 99!");
                            isOver = true;
                        }
                        if (!isOver) {
                            boolean playerExists = false;
                            for (int r = 0; r < groupA.getNumberOfTeams(); r++) {
                                if (groupA.getTeams()[r].getID() == teamID) {
                                    if (groupA.getTeams()[r].playerExists(playerJerNo)) {
                                        playerExists = true;
                                        groupA.getTeams()[r].removePlayer(playerJerNo);
                                    }
                                }
                            }
                            if (!playerExists) {
                                System.out.println("Player does not exist!");
                                isOver = true;
                            }
                        }
                    }
                }
            }
            if (userChoice == 6) {
                System.out.println(groupA.toString());
            }

            if (!isOver) {
                System.out.println("---------------------------------------------------");
                System.out.println("Welcome to Qatar 2022! Get Ready for the World Cup!");
                System.out.println("---------------------------------------------------");
                System.out.println("-------------- Group: " + groupA.getName() + "-------------------");
                System.out.println(
                        "1 - Create a new Team\n2 - Display a Team\n3 - Add a Player to a Team\n4 - Remove a Player with ID from a Team\n5 - Add a Game to the Group\n6 - Display Standings\n7 - Exit");
                System.out.println("-------------------------------------------");
                System.out.print("Your choice: ");
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                } else {
                    System.out.println("Please try again and enter an integer for your choice.");
                }
            }

        }

    }
}