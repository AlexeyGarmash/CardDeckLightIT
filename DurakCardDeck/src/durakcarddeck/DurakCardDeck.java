/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package durakcarddeck;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class DurakCardDeck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] suits = new String[]{"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] names = new String[]{"6", "7", "8", "9",
            "10", "Jack", "Queen", "King", "Ace"};
        Scanner scan = new Scanner(System.in);
        int playerCount = 3;
        do {
            System.out.print("Enter the number of players (between 2 and 6): ");
            playerCount = scan.nextInt(); //show this, while false count of players
        } while (playerCount < 2 || playerCount > 6);
        CardGame game = new CardGame(playerCount);
        game.generateCardDeck(suits, names);
        System.out.println("Shuffle the deck...");
        game.shuffleDeck();
        game.setTrumpSuit();
        System.out.println("Takes the trump card...");
        System.out.println("Trump card: " + game.getTrumpCard());
        System.out.println("Puts the trump card in deck's bottom...");
        System.out.println("Deals the cards...");
        game.dealCards();
        for (int i = 0; i < playerCount; i++) {
            System.out.println((i + 1) + " player, set:\n"
                    + game.getPlayersSets()[i]);
        }
        CardSet maxSet = game.getMaxSet();
        System.out.println(String.format("Set with max strength "
                + "in player %d:\n%s",
                game.getPlayerNum() + 1, maxSet));
    }

}
