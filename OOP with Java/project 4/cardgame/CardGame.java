package cardgame;

import java.util.ArrayList;
import java.util.Arrays;

// Cardgame
// author:
// date:
public class CardGame {
    // properties
    Cards fullPack;
    ArrayList<Player> players;
    ScoreCard scoreCard;
    Card[] cardsOnTable;
    int roundNo;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    int turnOfPlayer = 1;
    int noOfcardsPlayed = 0;

    // constructor
    public CardGame(Player p1, Player p2, Player p3, Player p4) {
        players = new ArrayList<>();
        fullPack = new Cards(true);
        scoreCard = new ScoreCard(4);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        fullPack.shuffle();
        fullPack.dealFullPack(p1, p2, p3, p4);
        cardsOnTable = new Card[players.size()];
    }

    // methods

    // checks if player can play the given card
    public boolean playTurn(Player p, Card c) {
        if (isTurnOf(p) && p.getHand().getTopCard().equals(c)) {
            cardsOnTable[players.indexOf(p)] = c;
            noOfcardsPlayed++;
            return true;
        }
        return false;
    }

    // checks if it's the turn of the given player
    public boolean isTurnOf(Player p) {
        if (players.indexOf(p) + 1 == turnOfPlayer) {
            return true;
        }
        return false;
    }

    // checks if the game is over or not
    public boolean isGameOver() {
        if (this.roundNo == 13) {
            return true;
        }
        for (int k = 0; k < players.size(); k++) {
            if (players.get(k).getHand().equals(null)) {
            } else {
                return false;
            }
        }
        return true;
    }

    public int getScore(int playerNumber) {
        return scoreCard.getScore(playerNumber);
    }

    public String getName(int playerNumber) {
        return players.get(playerNumber).getName();
    }

    public void setTurnOfPlayer(int turnOfPlayer) {
        this.turnOfPlayer = turnOfPlayer;
    }

    // updates the scores after every round
    public void roundUpdate() {
        Card biggestCard = cardsOnTable[0];
        for (int i = 1; i < noOfcardsPlayed; i++) {
            if (cardsOnTable[i].compareTo(biggestCard) == 1) {
                biggestCard = cardsOnTable[i];
            }
        }
        for (int j = 0; j < noOfcardsPlayed; j++) {
            if (cardsOnTable[j].getFaceValue() == biggestCard.getFaceValue()) {
                scoreCard.update(j, 1);
            }
        }
        for (int y = 0; y < cardsOnTable.length; y++) {
            cardsOnTable[y] = null;
            noOfcardsPlayed = 0;
        }
    }

    // finds round no
    public int getRoundNo() {
        int largestPack = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHand().valid > largestPack) {
                largestPack = players.get(i).getHand().valid;
            }
        }
        return 14 - largestPack;
    }

    public int getTurnOfPlayer() {
        return turnOfPlayer;
    }

    // returns the names of the winners
    public Player[] getWinners() {
        if (scoreCard.getWinners() != null) {
            Player[] winners = new Player[scoreCard.getWinners().length];
            for (int i = 0; i < scoreCard.getWinners().length; i++) {
                winners[i] = players.get(scoreCard.getWinners()[i] - 1);
            }

            return winners;
        }
        return null;
    }

    public String showScoreCard() {
        return scoreCard.toString();
    }

}