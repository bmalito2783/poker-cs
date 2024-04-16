import java.util.ArrayList;

public class HandTest {
    public static void main(String[] args) {
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(1, "Spades"));
        hand1.add(new Card(2, "Hearts"));
        hand1.add(new Card(2, "Diamonds"));
        hand1.add(new Card(3, "Clubs"));
        hand1.add(new Card(4, "Spades"));

        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(new Card(1, "Spades"));
        hand2.add(new Card(2, "Hearts"));
        hand2.add(new Card(3, "Diamonds"));
        hand2.add(new Card(3, "Clubs"));
        hand2.add(new Card(4, "Spades"));

        Hand hand1Object = new Hand(hand1);
        Hand hand2Object = new Hand(hand2);

        System.out.println("Hand 1 has one pair: " + hand1Object.isOnePair());
        System.out.println("Hand 2 has one pair: " + hand2Object.isOnePair());
    }
}