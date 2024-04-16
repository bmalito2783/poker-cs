public class Card {
    private String suit; // "Clubs", "Diamonds", "Hearts", "Spades"
    private String value; // "2", "3"..."Jack", "Queen", "King", "Ace"
    
    // Constant used to compare card values.
    private final String values = "2 3 4 5 6 7 8 9 10 Jack Queen King Ace";
    
    // Constructor.  Initialize the suit and value.
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
    
    // Return the suit.
    public String getSuit() {
        return this.suit;
    }
    
    // Return the value.
    public String getValue() {
        return this.value;
    }
    // Return true if the given card has the same suit and value as this card, false otherwise.
    public boolean equals(Card card) {
        return (this.suit.equals(card.getSuit()) && this.value.equals(card.getValue()));
    }
    
    // Return:
    // -1 if this card has a higher value than the given card
    // 0 if the cards have equal value
    // 1 if the given card has a higher value than this card
    public int compareTo(Card card) {
        int thisValue = values.indexOf(this.value);
        int cardValue = values.indexOf(card.value);
        if (cardValue < thisValue)
            return -1;
        else if (cardValue > thisValue)
            return 1;
        else
            return 0;
    }
    
    // Return a printable version of the card's suit and value.
    public String toString() {
        return this.value + " of " + this.suit;
    }
 }