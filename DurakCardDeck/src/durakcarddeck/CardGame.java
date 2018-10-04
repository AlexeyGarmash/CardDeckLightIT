package durakcarddeck;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Alex
 */
public class CardGame {

    /**
     * Count of players.
     */
    private final int countPlayers;
    /**
     * Trump card.
     */
    private Card trumpCard;
    /**
     * List of cards, which represent card deck.
     */
    private LinkedList<Card> cardDeck;
    /**
     * Array of players sets.
     */
    private CardSet[] playersSets;
    /**
     * Variable for generate random value.
     */
    private final Random random;
    /**
     * Index of player with max set's strength.
     */
    private int playerNum;

    /**
     * Constructor with parameters.
     *
     * @param countPlayers count of players
     */
    public CardGame(int countPlayers) {
        this.countPlayers = countPlayers;
        this.cardDeck = new LinkedList<>();
        playersSets = new CardSet[countPlayers];
        for (int i = 0; i < playersSets.length; i++) {
            playersSets[i] = new CardSet();
        }
        random = new Random();
    }

    /**
     * Generates the card deck with 36 cards.
     *
     * @param suits all suits in deck
     * @param names all cards names
     */
    public void generateCardDeck(String[] suits, String[] names) {
        for (String suit : suits) {
            for (int n = 0; n < names.length; n++) {
                cardDeck.push(new Card(suit, names[n], n + 1));
            }
        }
    }

    /**
     * Shuffle the card deck.
     */
    public void shuffleDeck() {
        Collections.shuffle(cardDeck);
    }

    /**
     * Takes the trump card and put in bottom of deck.
     */
    public void setTrumpSuit() {
        int randomCard = random.nextInt(cardDeck.size()); //index of random card
        trumpCard = cardDeck.get(randomCard);
        cardDeck.remove(trumpCard);
        cardDeck.addLast(trumpCard);
    }

    /**
     * Deals the cards.
     */
    public void dealCards() {
        int cardsInPlayer = 0;
        int maxCardsInPlayer = 6;
        while (cardsInPlayer < maxCardsInPlayer) {
            for (CardSet set : playersSets) {
                set.addCard(cardDeck.pop(), trumpCard.getSuit());
                /*pop
                                                                 from deck in
                                                                 players sets*/
            }
            cardsInPlayer++;
        }
    }

    /**
     * Takes the set with max strength from all players.
     *
     * @return set with max strength.
     */
    public CardSet getMaxSet() {
        CardSet maxSet = playersSets[0];
        playerNum = 0;
        for (int s = 1; s < playersSets.length; s++) {
            int currValue = playersSets[s].getTotalValue();
            if (currValue > maxSet.getTotalValue()) {
                maxSet = playersSets[s];
                playerNum = s;
            }
        }
        return maxSet;
    }

    public int getCountPlayers() {
        return countPlayers;
    }

    public Card getTrumpCard() {
        return trumpCard;
    }

    public LinkedList<Card> getCardDeck() {
        return cardDeck;
    }

    public CardSet[] getPlayersSets() {
        return playersSets;
    }

    public int getPlayerNum() {
        return playerNum;
    }

}