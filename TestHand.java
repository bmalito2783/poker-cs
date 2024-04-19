// public class TestHand {

//     public static void main(String[] args) {
//         Hand hand = new Hand();

//         System.out.println("Test Hand Creation: ");
//         System.out.println("Expected: Hand object created with no cards.");
//         System.out.println("Actual: " + hand.getCards().size() + " cards in hand.");
//         System.out.println();

//         System.out.println("Test Adding Cards: ");
//         Card card1 = new Card("HEARTS", "ACE");
//         hand.draw(card1);
//         System.out.println("Expected: Hand object has 1 card.");
//         System.out.println("Actual: " + hand.getCards().size() + " cards in hand.");
//         System.out.println();

//         System.out.println("Test Sorting Cards: ");
//         Card card2 = new Card("HEARTS", "KING");
//         Card card3 = new Card("HEARTS", "QUEEN");
//         Card card4 = new Card("HEARTS", "JACK");
//         Card card5 = new Card("HEARTS", "TEN");
//         hand.draw(card2);
//         hand.draw(card3);
//         hand.draw(card4);
//         hand.draw(card5);
//         System.out.println("Expected: Cards in hand are sorted.");
//         System.out.println("Actual: " + hand.getCards());
//         System.out.println();

//         System.out.println("Test Discarding Cards: ");
//         Card discardedCard = hand.discard(card2);
//         System.out.println("Expected: Card is discarded from hand.");
//         System.out.println("Actual: " + discardedCard.toString() + " discarded.");
//         System.out.println("Actual: " + hand.getCards().size() + " cards in hand.");
//         System.out.println("Actual: " + hand.getCards());
//         System.out.println();

//         System.out.println("Test Comparing Hands: ");
//         Hand hand2 = new Hand();
//         hand2.draw(card1);
//         hand2.draw(card2);
//         hand2.draw(card3);
//         hand2.draw(card4);
//         hand2.draw(card5);
//         int comparisonResult = hand.compareTo(hand2);
//         if (comparisonResult < 0) {
//             System.out.println("Expected: Hand 1 has lower score than Hand 2.");
//             System.out.println("Actual: Hand 1 has lower score than Hand 2.");
//         } else if (comparisonResult > 0) {
//             System.out.println("Expected: Hand 1 has higher score than Hand 2.");
//             System.out.println("Actual: Hand 1 has higher score than Hand 2.");
//         } else {
//             System.out.println("Expected: Hand 1 has same score as Hand 2.");
//             System.out.println("Actual: Hand 1 has same score as Hand 2.");
//         }
//         System.out.println();

//         System.out.println("Test Scoring Hand: ");
//         hand.draw(card1);
//         hand.draw(card2);
//         hand.draw(card3);
//         hand.draw(card4);
//         hand.draw(card5);
//         int score = hand.scoreHand();
//         System.out.println("Expected: Hand score is 50 (straight flush).");
//         System.out.println("Actual: Hand score is " + score + ".");
//     }
// }