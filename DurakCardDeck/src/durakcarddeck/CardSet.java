package durakcarddeck;

import java.util.LinkedList;

/**
 * Class for represent abstraction card set.
 *
 * @author Alex
 */
public class CardSet {

    /**
     * List of cards in set.
     */
    private LinkedList<Card> cardList;
    /**
     * Total strength of set.
     */
    private int totalValue;

    /**
     * Constructor without parameters.
     */
    public CardSet() {
        this.cardList = new LinkedList<>();
        this.totalValue = 0;
    }

    public LinkedList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(LinkedList<Card> cardList) {
        this.cardList = cardList;
    }

    public int getTotalValue() {
        return totalValue;
    }

    /**
     * Adds a card to the list of cards.
     *
     * @param card object of class Card
     */
    public void addCard(Card card) {
        if (card != null) {
            cardList.push(card);
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Adds a card to the list of cards and calculate total strength of set.
     *
     * @param card object of class Card
     * @param trumpSuit suit of trump card
     */
    public void addCard(Card card, String trumpSuit) {
        if (card != null) {
            cardList.push(card);
            int cardValue = card.getValue();
            if (card.getSuit().equals(trumpSuit)) {
                cardValue *= 10; //if suit is trump, card strength increases
            }
            totalValue += cardValue;
        }
    }

    public Card popCard() {
        return cardList.pop();
    }

    public void removeCard(Card card) {
        cardList.remove(card);
    }

    public void addCardLast(Card card) {
        cardList.addLast(card);
    }

    public Card getCardByIndex(int index) {
        return cardList.get(index);
    }

    @Override
    public String toString() {
        String resultCardList = "";
        resultCardList = cardList.stream().map((card) -> card.toString()).reduce(resultCardList, String::concat);
        resultCardList += String.format("Total strength of set: %d\n", totalValue);
        return resultCardList;
    }

}