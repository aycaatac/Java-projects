package lab8;

import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

enum Direction {
    NORTH, EAST, SOUTH, WEST
}

/**
 * This class implements a manager for a game where the goal for a player is
 * to reach the bottom right corner of an n x n room, starting from the upper
 * left cornder and avoiding any enemies (monster, bug, etc.)
 * 
 * @author Ugur Dogrusoz
 */
public class GameManagerRev {
    // static variables/constants

    public static final Random random = new Random();
    private static final int NO_OF_ROWS = 5;
    private static final int NO_OF_COLUMNS = 5;
    private static final int TARGET_X = NO_OF_COLUMNS - 1;
    private static final int TARGET_Y = NO_OF_ROWS - 1;
    private static final int INITIAL_PLAYER_HEALTH = 10;
    private static final int MONSTER_DAMAGE_TO_PLAYER = INITIAL_PLAYER_HEALTH;
    private static final int BUG_DAMAGE_TO_PLAYER = 2;

    // instance variables

    private Player player;
    private Enemy_revision monster;
    private Enemy_revision bug;
    private char inputDir = 's';
    private char playerIcon;
    private char bugIcon;
    private char monsterIcon;

    // scanner
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for the Game Manager class
     */
    public GameManagerRev() {
        this.setupGame();
    }

    // getters

    /**
     * @return number of columns of the grid representing the game room
     */
    public static int getNoOfColumns() {
        return GameManagerRev.NO_OF_COLUMNS;
    }

    /**
     * @return number of rows of the grid representing the game room
     */
    public static int getNoOfRows() {
        return GameManagerRev.NO_OF_ROWS;
    }

    /**
     * @return the player of this game
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * @return the monster of this game
     */
    public Enemy_revision getMonster() {
        return this.monster;
    }

    /**
     * @return the bug of this game
     */
    public Enemy_revision getBug() {
        return this.bug;
    }

    // game setup and playing

    /**
     * This method sets up the game by creating the game objects and
     * positioning them in initial positions (player in upper left corner,
     * monster in the lower right corner and bug in the middle of the room).
     */
    public void setupGame() {
        player = new Player('P', INITIAL_PLAYER_HEALTH);
        player.positionAt(0, 0);
        playerIcon = player.getIcon();
        bug = new Enemy_revision('B');
        bug.positionAt(NO_OF_COLUMNS / 2, NO_OF_ROWS / 2);
        bugIcon = bug.getIcon();
        monster = new Enemy_revision('M');
        monster.positionAt(NO_OF_COLUMNS - 1, NO_OF_ROWS - 1);
        monsterIcon = monster.getIcon();
    }

    /**
     * This method displays the room and the game objects in their current
     * locations.
     */
    public void displayBoard() {
        for (int a = 0; a < NO_OF_COLUMNS; a++) {
            displayRowSeparator();
            for (int c = 0; c <= NO_OF_ROWS; c++) {
                System.out.print("|");
                boolean playerHere = (doCoordsMatch(c, a, player.getX(), player.getY()));
                boolean bugHere = (doCoordsMatch(c, a, bug.getX(), bug.getY()));
                boolean monsterHere = (doCoordsMatch(c, a, monster.getX(), monster.getY()));
                if (playerHere) {
                    if (bugHere) {
                        System.out.print(" " + playerIcon + "" + bugIcon);
                    }
                    if (monsterHere) {
                        System.out.print(monsterIcon + "" + playerIcon + " ");
                    } else if (!(c == bug.getX() && a == bug.getY())) {
                        System.out.print(" ");
                        System.out.print(playerIcon);
                        System.out.print(" ");
                    }
                } else if (bugHere) {
                    if (monsterHere) {
                        System.out.print(monsterIcon + " " + bugIcon);
                    } else {
                        System.out.print(" ");
                        System.out.print(bugIcon);
                        System.out.print(" ");
                    }
                } else if (!playerHere && monsterHere) {
                    System.out.print(" ");
                    System.out.print(monsterIcon);
                    System.out.print(" ");
                }
                if (bugHere && monsterHere && playerHere) {
                    System.out.print(monsterIcon + "" + playerIcon + "" + bugIcon);
                }
                if (!((bugHere) || (monsterHere) || playerHere)) {
                    System.out.print("   ");
                }
            }
        }
        displayRowSeparator();
        System.out.print("Health: ");
        for (int i = 1; i <= player.getHealth(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /*
     * This method is used by displayBoard to print one line of separator between
     * successive rows.
     */
    private void displayRowSeparator() {
        System.out.print("\n-");
        for (int c = 0; c < NO_OF_COLUMNS; c++) {
            System.out.print("----");
        }
        System.out.print("\n");
    }

    /**
     * This method moves all game objects along their current directions.
     * Enemies change directions randomly before moving in the following manner:
     * a monster changes direction randomly with 2 in 3 chance; similary a bug
     * changes direction randomly with 1 in 3 chance.
     */
    public void moveObjects() {
        int randomNo = GameManagerRev.random.nextInt(3);
        if (randomNo == 0) {
            monster.changeDirection();
        } 
        if(randomNo == 1)
        {
            if(monster.getX() > player.getX())
            {
                if(monster.getY() > player.getY())
                {
                    int randomNo2 = GameManagerRev.random.nextInt(2);
                    if(randomNo2 == 0)
                    {
                        monster.changeToDirection(4);
                    }
                    if(randomNo2 == 1)
                    {
                        monster.changeToDirection(1);
                    }
                }
                else
                {
                    int randomNo4 = GameManagerRev.random.nextInt(2);
                    if(randomNo4 == 0)
                        {
                            monster.changeToDirection(4);
                        }
                        if(randomNo4 == 1)
                        {
                            monster.changeToDirection(0);
                        }
                    }
            }

            if(monster.getY() > player.getY() && !(monster.getX() > player.getX())){

                int randomNo3 = GameManagerRev.random.nextInt(2);
                    if(randomNo3 == 0)
                    {
                        monster.changeToDirection(2);
                    }
                    if(randomNo3 == 1)
                    {
                        monster.changeToDirection(0);
                    }
            }
            if(!(monster.getX() > player.getX()) && !(monster.getY() > player.getY()))
            {
                int randomNo5 = GameManagerRev.random.nextInt(2);
                    if(randomNo5 == 0)
                    {
                        monster.changeToDirection(2);
                    }
                    if(randomNo5 == 1)
                    {
                        monster.changeToDirection(1);
                    }
            }
            if(monster.getX() > player.getX() && monster.getY() == player.getY())
            {
                monster.changeToDirection(2);
            }
            if(monster.getY() > player.getY() && monster.getX() == player.getX())
            {
                monster.changeToDirection(1);
            }
            
        else if(randomNo == 2){
            bug.changeDirection();
        }
        
    }

        monster.move();
        bug.move();
        player.move();
    }

    /**
     * This method handles any collisions of game objects appropriately.
     * When an enemy is in the same location as the player, he will lose
     * health by an amount defined as a constant in this class according to
     * the enemy type. Current values mean a collision with a monster will
     * make you lose the game, where a collision with a bug will decrease
     * your health a little.
     */
    public void handleCollisions() {
        if ((bug.getX() == player.getX()) && (bug.getY() == player.getY())) {
            player.loseHeath(BUG_DAMAGE_TO_PLAYER);
        }
        if ((monster.getX() == player.getX()) && (monster.getY() == player.getY())) {
            player.loseHeath(MONSTER_DAMAGE_TO_PLAYER);
        }
    }

    // utility methods

    /**
     * This method reads user input. The user has the choice to quit or provide
     * a new direction for the player. They also have the option to keep the
     * current direction.
     * 
     * @return the input character
     */
    public char readDirection() {
        if (!isGameOver()) {
            System.out.print("\nw: up, x: down, d: right, a: left, s: no\nchange, q: quit: ");
            inputDir = scanner.nextLine().charAt(0);
        }
        return inputDir;
    }

    /**
     * This method checks whether or not the given two corrdinates match.
     */
    public static boolean doCoordsMatch(int x1, int y1, int x2, int y2) {
        if ((x1 == x2) && (y1 == y2)) {
            return true;
        }
        return false;
    }

    /**
     * This method converts a direction provided as an integer into one with
     * the enumeration type Direction.
     * 
     * @param directionInt input integer direction (0, 1, 2, 3)
     * @return returns corresponding enum value (NORTH, SOUTH, EAST, WEST)
     */
    public static Direction intToDirection(int directionInt) {
        if (directionInt == 0) {
            return Direction.NORTH;
        } else if (directionInt == 1) {
            return Direction.SOUTH;
        } else if (directionInt == 2) {
            return Direction.EAST;
        } else { // 3
            return Direction.WEST;
        }
    }

    /**
     * This method converts a direction provided as a character into one with
     * the enumeration type Direction.
     * 
     * @param directionChar input character direction ('w', 'x', 'd', 'a')
     * @return returns corresponding enum value (NORTH, SOUTH, EAST, WEST)
     */

    public static Direction charToDirection(char directionChar) {
        if (directionChar == 'w') {
            return Direction.NORTH;
        } else if (directionChar == 'x') {
            return Direction.SOUTH;
        } else if (directionChar == 'd') {
            return Direction.EAST;
        } else { // 'a'
            return Direction.WEST;
        }
    }

    /**
     * This method checks whether or not the player reached the target location
     * defined as a constant by this class.
     */
    public boolean isTargetReached() {
        if (player != null) {
            if ((player.getX() == TARGET_X) && (player.getY() == TARGET_Y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks whether or not the game is over. Game is over in two
     * ways. If the player loses its health (a loss) or the player reaches its
     * target.
     */
    public boolean isGameOver() {
        if (player != null) {
            if (isTargetReached()) {
                return true;
            }
            if (!player.isHealthy()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GameManagerRev gm = new GameManagerRev();
        Player player = gm.getPlayer();
        char dirChar = 's'; // to get the game loop started

        // initial configuration
        gm.displayBoard();

        // game loop
        while (!gm.isGameOver() && dirChar != 'q') {
            dirChar = gm.readDirection();
            if (dirChar != 's' && dirChar != 'q') {
                player.changeDirection(GameManagerRev.charToDirection(dirChar));
            }

            gm.moveObjects();
            gm.handleCollisions();
            gm.displayBoard();
        }

        // report the result
        if (dirChar == 'q') {
            System.out.println("\nCome back and play again!!!");
        } else if (gm.player.isHealthy()) {
            System.out.println("\nPlayer wins!!!");
        } else {
            System.out.println("\nPlayer loses!!!");
        }

    }
}