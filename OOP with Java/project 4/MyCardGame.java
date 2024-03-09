import java.util.Arrays;
import java.util.Scanner;

import cardgame.*;

// MyCardGame - provides a menu allowing any of the players to play their card,
//              an option to see the score card, and one to quit the game at any time.
//              When the game is over it dislays the winners.
// author:
// date:
public class MyCardGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Start of MyCardGame\n");

        // CONSTANTS
        final int MENU_EXIT = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES = 5;

        // VARIABLES
        Player p1, p2, p3, p4;
        CardGame game;
        int selection;

        // PROGRAM CODE

        // create players...
        p1 = new Player("p1");
        p2 = new Player("p2");
        p3 = new Player("p3");
        p4 = new Player("p4");

        // create game with the 4 players...
        game = new CardGame(p1, p2, p3, p4);

        // display menu, get and process selection, until exit
        do {
            // display menu
            System.out.println();
            System.out.println("MyCardGame   Round: " + game.getRoundNo()
                    + "\t TurnOfPlayer: " + game.getTurnOfPlayer());
            System.out.println();
            System.out.println(MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays");
            System.out.println(MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays");
            System.out.println(MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays");
            System.out.println(MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays");
            System.out.println(MENU_SCORES + " - Show scores");

            // ask for and get selection
            System.out.println();
            System.out.print("Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();

            // process selection
            if (selection == MENU_PLAY_P1)
                play(p1, game);

            else if (selection == MENU_PLAY_P2) {
                play(p2, game);
            }

            else if (selection == MENU_PLAY_P3)
                play(p3, game);

            else if (selection == MENU_PLAY_P4) {
                play(p4, game);
                game.roundUpdate(); // updates the scores after every round
            }

            else if (selection == MENU_SCORES)
                System.out.println(game.showScoreCard());

            else if (selection != MENU_EXIT)
                System.out.println("Invalid selection! \n");

        } while (selection != MENU_EXIT && !game.isGameOver() && game.getRoundNo() <= 13);

        // display the winners when the game is over
        if (game.getWinners() == null) {
            System.out.println();
            System.out.println("There are no winners. Round one has not been completed.");
        } else if (game.getWinners().length == 1) {
            System.out.println();
            System.out.print("Winner: ");
            System.out.println(game.getWinners()[0]);
        } else {
            System.out.println();
            System.out.print("Winners: ");
            for (int k = 0; k < game.getWinners().length; k++) {
                if (k == game.getWinners().length - 1) {
                    System.out.print(game.getWinners()[k] + ".");
                } else {
                    System.out.print(game.getWinners()[k] + ", ");
                }
            }
            System.out.println();
        }

        System.out.println("\nEnd of MyCardGame\n");

        scan.close();
    }

    // players play with their top cards when it's their turn
    private static boolean play(Player p, CardGame game) {
        Card c = p.getHand().getTopCard();
        boolean accepted;

        if (game.playTurn(p, c)) {
            System.out.println(p + " played the card: " + p.getHand().getTopCard());
            p.playCard();
            accepted = true;
            System.out.println();

        } else {
            System.out.println();
            System.out.println(
                    "It is not this player's turn. It is Player " + game.getTurnOfPlayer() + "'s turn.");
            accepted = false;
        }
        // sets the turn of player
        if (accepted) {
            if (game.getTurnOfPlayer() == 4) {
                game.setTurnOfPlayer(1);
            } else {
                game.setTurnOfPlayer(game.getTurnOfPlayer() + 1);
            }
        }
        return accepted;
    }

} // end class MyCardGame
