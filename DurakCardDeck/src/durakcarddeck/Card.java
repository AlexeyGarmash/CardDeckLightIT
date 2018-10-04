package durakcarddeck;

/**
 * Class for represent abstraction of playing card.
 *
 * @author Alex
 */
public class Card {

    /**
     * Card's suit (diamonds, hearts, etc.).
     */
    private String suit;
    /**
     * Card's name (Jack, King, etc.).
     */
    private String name;
    /**
     * Card's strength.
     */
    private int value;

    /**
     * Constructor with parameters.
     *
     * @param cardSuit card's suit
     * @param cardName card's name
     * @param cardValue card's strength
     */
    public Card(final String cardSuit, final String cardName, final int cardValue) {
        this.suit = cardSuit;
        this.name = cardName;
        this.value = cardValue;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", name, suit);
    }

}
