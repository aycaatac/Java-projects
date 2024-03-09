package cardgame;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player {
    // properties
    String name;
    Cards hand;

    // constructors
    public Player(String name) {
        this.name = name;
        this.hand = new Cards(false);
    }

    // methods
    public String getName() {
        return name;
    }

    public Cards getHand() {
        return hand;
    }

    // adds the given card to hand if player does not already have it
    public void add(Card c) {
        if (!this.hand.hasCard(c)) {
            this.hand.addTopCard(c);
        }
    }

    // removes the played card from player's hand
    public Card playCard() {
        Card topCard = this.hand.getTopCard();
        this.hand.removeCard(topCard);

        return topCard;
    }

    public String toString() {
        return this.getName();
    }

} // end class Player
