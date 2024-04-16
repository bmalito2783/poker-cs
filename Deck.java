import java.util.Random;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards; // The deck of cards
    
    // Create a full shuffled deck of cards.
    public Deck() {
        reset();
    }
    
    // Remove and return the first card in the list.
    public Card dealCard() {
        return this.cards.remove(0);
    }
    
    // Put the given card in the deck. If:
    // position = 0:  put at the front of the list
    // position = 1:  put at the end of the list
    // position = 2:  insert at random position
    public void putCard(Card card, int position)
    {
        if (!this.cards.contains(card))
            if (position == 0)
                this.cards.add(0, card);
            else if (position == 1)
                this.cards.add(card);
            else {
                Random rand = new Random();
                int pos = rand.nextInt(this.cards.size()-1);
                this.cards.add(pos, card);
            }
    }
    
    // If the card with the given suit and value is in the list, return the card.  Return null if not in the list.
    public Card getCard(String suit, String value) {
        Card currentCard = null;
        for(int i=0; i < this.cards.size(); i++) {
            currentCard = this.cards.get(i);
            if (currentCard.getSuit().equals(suit) && currentCard.getValue().equals(value))
                return this.cards.remove(i);
        }
        return null;
    }
    
    // If there is a card with the given suit and value in the list, return the card.  Return null if not in the list.
    public Card getCard(Card card) {
        return getCard(card.getSuit(), card.getValue());
    }
    
    // Restore the deck to a full shuffled deck.
    public void reset() {
        createCards();
        shuffle();
    }
    
    // Rearrange the cards in the deck in random order.
    // Create a new empty deck, insert the cards into the new deck in random order,
    // then replace the deck.
    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random rand = new Random();

        for(int i=0; i<this.cards.size(); i++) {
            if (tempDeck.size() == 0)
                tempDeck.add(cards.remove(i));
            else {
                int pos = rand.nextInt(tempDeck.size()-1);
                tempDeck.add(pos, cards.remove(i));
            }
        }

        cards = tempDeck;
    }
    
    // Initialize the list to a full 52 card deck (no shuffle).
    private void createCards() {
        this.cards = new ArrayList<Card>();
        this.cards.add(new Card("Spades", "Ace"));
        this.cards.add(new Card("Spades", "2"));
        this.cards.add(new Card("Spades", "3"));
        this.cards.add(new Card("Spades", "4"));
        this.cards.add(new Card("Spades", "5"));
        this.cards.add(new Card("Spades", "6"));
        this.cards.add(new Card("Spades", "7"));
        this.cards.add(new Card("Spades", "8"));
        this.cards.add(new Card("Spades", "9"));
        this.cards.add(new Card("Spades", "10"));
        this.cards.add(new Card("Spades", "Jack"));
        this.cards.add(new Card("Spades", "Queen"));
        this.cards.add(new Card("Spades", "King"));
        this.cards.add(new Card("Diamonds", "Ace"));
        this.cards.add(new Card("Diamonds", "2"));
        this.cards.add(new Card("Diamonds", "3"));
        this.cards.add(new Card("Diamonds", "4"));
        this.cards.add(new Card("Diamonds", "5"));
        this.cards.add(new Card("Diamonds", "6"));
        this.cards.add(new Card("Diamonds", "7"));
        this.cards.add(new Card("Diamonds", "8"));
        this.cards.add(new Card("Diamonds", "9"));
        this.cards.add(new Card("Diamonds", "10"));
        this.cards.add(new Card("Diamonds", "Jack"));
        this.cards.add(new Card("Diamonds", "Queen"));
        this.cards.add(new Card("Diamonds", "King"));
        this.cards.add(new Card("Clubs", "Ace"));
        this.cards.add(new Card("Clubs", "2"));
        this.cards.add(new Card("Clubs", "3"));
        this.cards.add(new Card("Clubs", "4"));
        this.cards.add(new Card("Clubs", "5"));
        this.cards.add(new Card("Clubs", "6"));
        this.cards.add(new Card("Clubs", "7"));
        this.cards.add(new Card("Clubs", "8"));
        this.cards.add(new Card("Clubs", "9"));
        this.cards.add(new Card("Clubs", "10"));
        this.cards.add(new Card("Clubs", "Jack"));
        this.cards.add(new Card("Clubs", "Queen"));
        this.cards.add(new Card("Clubs", "King"));
        this.cards.add(new Card("Hearts", "Ace"));
        this.cards.add(new Card("Hearts", "2"));
        this.cards.add(new Card("Hearts", "3"));
        this.cards.add(new Card("Hearts", "4"));
        this.cards.add(new Card("Hearts", "5"));
        this.cards.add(new Card("Hearts", "6"));
        this.cards.add(new Card("Hearts", "7"));
        this.cards.add(new Card("Hearts", "8"));
        this.cards.add(new Card("Hearts", "9"));
        this.cards.add(new Card("Hearts", "10"));
        this.cards.add(new Card("Hearts", "Jack"));
        this.cards.add(new Card("Hearts", "Queen"));
        this.cards.add(new Card("Hearts", "King"));
    }
}