package cardgame;

import java.util.ArrayList;
import java.util.Arrays;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard {

    // properties
    int[] scores;
    ArrayList<Integer> winnersAL;

    // constructors
    public ScoreCard(int noOfPlayers) {
        scores = new int[noOfPlayers];

        // init all scores to zero
        for (int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }

    // methods
    public int getScore(int playerNo) {
        return scores[playerNo];
    }

    public void update(int playerNo, int amount) {
        scores[playerNo] += amount;
    }

    public String toString() {
        String s;
        s = "\n"
                + "_____________\n"
                + "\nPlayer\tScore\n"
                + "_____________\n";

        for (int playerNo = 0; playerNo < scores.length; playerNo++) {
            s = s + (playerNo + 1) + "\t" + scores[playerNo] + "\n";
        }

        s += "_____________\n";
        return s;
    }

    // returns the winners numbers
    public int[] getWinners() {
        boolean haventStarted = true;
        for (int l = 0; l < scores.length; l++) {
            if (scores[l] != 0) {
                haventStarted = false;
            }
        }
        if (!haventStarted) {
            winnersAL = new ArrayList<>();
            int highScore = scores[0];
            winnersAL.add(0);

            for (int k = 1; k < scores.length; k++) {
                if (scores[k] == highScore) {
                    winnersAL.add(k);
                } else if (scores[k] > highScore) {
                    int originalSize = winnersAL.size();
                    for (int j = originalSize - 1; j >= 0; j--) {
                        winnersAL.remove(j);
                    }
                    winnersAL.add(k);
                    highScore = scores[k];
                }
            }
            int[] winnersArray = new int[winnersAL.size()];

            for (int j = 0; j < winnersAL.size(); j++) {
                winnersArray[j] = winnersAL.get(j) + 1;
            }
            return winnersArray;
        }
        return null;
    }

} // end class ScoreCard
