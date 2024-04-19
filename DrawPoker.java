import java.util.Scanner;

public class DrawPoker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the deck
        Deck deck = new Deck();
        deck.shuffle();

        // Ask the user how many hands
        System.out.print("How many hands? ");
        int numHands = scanner.nextInt();
        Hand[] hands = new Hand[numHands];

        // Deal the cards
        for (int i = 0; i < numHands; i++) {
            hands[i] = new Hand();
            for (i = 0; i < 5; i++) {
                hands[i].draw(deck, 5);
            }
        }

        // Play the game
        while (true) {
            for (int i = 0; i < numHands; i++) {
                System.out.println("Hand " + (i+1) + ": " + hands[i]);
                System.out.print("Stand pat or draw up to three cards (s/d)? ");
                String choice = scanner.next();
                if (choice.equals("s")) {
                    // Stand pat
                } else if (choice.equals("d")) {
                    System.out.print("Which cards to discard (e.g. 1 3 5)? ");
                    String[] discardInput = scanner.next().split(" ");
                    int[] discardIndices = new int[discardInput.length];
                    for (int j = 0; j < discardInput.length; j++) {
                        discardIndices[j] = Integer.parseInt(discardInput[j]) - 1;
                    }
                    hands[i].discard(discardIndices);
                    hands[i].draw(deck, discardIndices.length);
                }
            }

            // Decide winner of the hand
            Hand winner = findWinner(hands);
            System.out.println("Winner: " + winner);

            // Play another hand if the user asks
            System.out.print("Play another hand (y/n)? ");
            String playAgain = scanner.next();
            if (!playAgain.equals("y")) {
                break;
            }
        }

        scanner.close();
    }

    private static Hand findWinner(Hand[] hands) {
        // Decide winner of the hand
        // ...
        return hands[0]; // replace with actual winner
    }
}