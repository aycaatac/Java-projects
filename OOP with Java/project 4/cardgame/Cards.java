package cardgame;

import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:
// date:
public class Cards {
    final int NOOFCARDSINFULLPACK = 52;

    // properties
    Card[] cards;
    int valid; // number of cards currently in collection
    Random random = new Random();

    // constructors
    public Cards(boolean fullPack) {
        cards = new Card[NOOFCARDSINFULLPACK];
        valid = 0;

        if (fullPack) {
            createFullPackOfCards();
        }
    }

    // methods
    public Card getTopCard() {
        return cards[valid - 1];
    }

    public boolean addTopCard(Card c) {
        if (valid < cards.length) {
            cards[valid] = c; // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }

    private void createFullPackOfCards() {
        for (int i = 0; i < 53; i++) {
            addTopCard(new Card(i));
        }
    }

    // shuffles the cards
    public void shuffle() {
        Card temp;
        int randomNo;
        for (int i = 0; i < valid; i++) {
            randomNo = random.nextInt(valid);
            temp = cards[i];
            cards[i] = cards[randomNo];
            cards[randomNo] = temp;
        }
    }

    // where else do we use this??
    public boolean hasCard(Card c) {
        for (int k = 0; k < this.valid; k++) {
            if (cards[k].equals(c)) {
                return true;
            }
        }
        return false;
    }

    public int getNOOFCARDSINFULLPACK() {
        return NOOFCARDSINFULLPACK;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    // removes the given card from player's hand
    public void removeCard(Card c) {
        for (int j = this.valid - 1; j >= 0; j--) {
            if (this.cards[j].equals(c)) {
                this.cards[j] = null;
                this.valid--;
            }
        }
    }

    // deals the whole pack to players
    public void dealFullPack(Player p1, Player p2, Player p3, Player p4) {
        for (int k = 0; k < 13; k++) {
            p1.add(cards[k]);
        }
        for (int k = 13; k < 26; k++) {
            p2.add(cards[k]);
        }
        for (int k = 26; k < 39; k++) {
            p3.add(cards[k]);
        }
        for (int k = 39; k < 52; k++) {
            p4.add(cards[k]);
        }
    }

    public String toString() {
        for (int i = 0; i < this.valid; i++) {
            System.out.println(cards[i].toString());
        }
        return "";
    }

} // end class Cards
