import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author:
// date:
public class CardGameTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Start of CardGameTest\n");

        // CONSTANTS

        // VARIABLES
        Card c;
        Cards cards;
        ScoreCard scores;
        Player p;
        CardGame game;

        // PROGRAM CODE

        // test Card class
        c = new Card(0);
        System.out.println(c);
        System.out.println();

        // test Cards class
        cards = new Cards(true);
        cards.addTopCard(c);

        // test ScoreCard class
        scores = new ScoreCard(4);
        scores.update(3, 1);
        scores.update(1, 2);
        System.out.println("\n" + scores);

        // test Player class
        p = new Player("pTest");
        p.add(c);
        System.out.println("Player's name is: " + p);
        System.out.println("Player's hand is: ");
        System.out.println(p.getHand());

        // test CardGame class too?
        Player p1 = new Player("test1");
        Player p2 = new Player("test2");
        Player p3 = new Player("test3");
        Player p4 = new Player("test4");

        game = new CardGame(p1, p2, p3, p4);
        System.out.print("Players in this game are: ");
        for (int k = 0; k < game.getPlayers().size(); k++) {
            System.out.print(game.getPlayers().get(k) + " ");
        }
        System.out.println("\nEach player has " + p1.getHand().getValid() + " cards.");
        System.out.println(game.showScoreCard());

        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.

        System.out.println("\nEnd of CardGameTest\n");

        scan.close();
    }

} // end of class CardGameTest
