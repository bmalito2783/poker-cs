import java.util.ArrayList;


// public class Card {
//     private String suit;
//     private String value;

//     public Card(String suit, String value) {
//         this.suit = suit;
//         this.value = value;
//     }

//     // getters and setters

//     @Override
//     public String toString() {
//         return value + " of " + suit;
//     }
// }

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void draw(Card card) {
    // Add the card to the hand
    cards.add(card);

    // Sort the hand using a bubble sort algorithm
    for (int i = 0; i < cards.size() - 1; i++) {
        for (int j = i + 1; j < cards.size(); j++) {
            if (compareCards(cards.get(i), cards.get(j)) > 0) {
                Card temp = cards.get(i);
                cards.set(i, cards.get(j));
                cards.set(j, temp);
            }
        }
    }

    // Remove extra cards if the hand size is greater than 5
    while (cards.size() > 5) {
        cards.remove(0);
    }
}

private int compareCards(Card c1, Card c2) {
    return c1.getValue().compareTo(c2.getValue());
}

    public Card discard(Card card) {
        return cards.remove(cards.indexOf(card));
    }

    public Card discard(String suit, String value) {
        for (Card card : cards) {
            if (card.getSuit().equals(suit) && card.getValue().equals(value)) {
                return cards.remove(cards.indexOf(card));
            }
        }
        return null;
    }

    public int compareTo(Hand h) {
        // compare hands based on scoring
        return scoreHand() - h.scoreHand();
    }

    public int scoreHand() {
        if (isStraightFlush()) return 9;
        if (isFourOfKind()) return 8;
        if (isFullHouse()) return 7;
        if (isFlush()) return 6;
        if (isStraight()) return 5;
        if (isThreeOfKind()) return 4;
        if (isTwoPairs()) return 3;
        if (isOnePair()) return 2;
        return 1;
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private boolean isFlush() {
        if (cards.size() < 5) return false;
        String suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraight() {
        if (cards.size() < 5) return false;
        Card prevCard = cards.get(0);
        for (Card card : cards) {
            if (card.getValue().compareTo(prevCard.getValue()) != 1) {
                return false;
            }
            prevCard = card;
        }
        return true;
    }

    private boolean isFourOfKind() {
    for (int i = 0; i < cards.size() - 3; i++) {
        if (cards.get(i).getValue().equals(cards.get(i + 3).getValue())) {
            return true;
        }
    }
    return false;
}

private boolean isFullHouse() {
    if (isThreeOfKind()) {
        ArrayList<Card> copy = new ArrayList<>(cards);
        ArrayList<Card> temp = new ArrayList<>();
        for (Card card : copy) {
            if (!card.getValue().equals(getHighCard().getValue())) {
                temp.add(card);
            }
        }
        return isOnePair(temp);
    }
    return false;
}

private boolean isThreeOfKind() {
    for (int i = 0; i < cards.size() - 2; i++) {
        if (cards.get(i).getValue().equals(cards.get(i + 2).getValue())) {
            return true;
        }
    }
    return false;
}

private boolean isTwoPairs() {
    int pairCount = 0;
    for (int i = 0; i < cards.size() - 1; i++) {
        if (cards.get(i).getValue().equals(cards.get(i + 1).getValue())) {
            pairCount++;
            i++;
        }
    }
    return pairCount == 2;
}

private boolean isOnePair() {
    int pairCount = 0;
    for (int i = 0; i < cards.size() - 1; i++) {
        if (cards.get(i).getValue().equals(cards.get(i + 1).getValue())) {
            pairCount++;
            i++;
        }
    }
    return pairCount == 1;
}

private Card getHighCard() {
    ArrayList<Card> copy = new ArrayList<>(cards);
    sortCards(copy);
    return copy.get(copy.size() - 1);
}

private void sortCards(ArrayList<Card> copy) {
    for (int i = 0; i < copy.size() - 1; i++) {
        for (int j = i + 1; j < copy.size(); j++) {
            if (compareCards(copy.get(i), copy.get(j)) > 0) {
                Card temp = copy.get(i);
                copy.set(i, copy.get(j));
                copy.set(j, temp);
            }
        }
    }
}
}
