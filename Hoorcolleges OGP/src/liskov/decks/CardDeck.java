package liskov.decks;

import java.util.Stack;

import be.kuleuven.cs.som.annotate.*;
import liskov.cards.*;

/**
 * A class of decks containing cards.
 *
 * @invar   Each card deck  can have its capacity as its
 *          capacity.
 *        | canHaveAsCapacity(getMinimumNbCards(),getMaximumNbCards())
 * @invar   Each card deck must have a proper sequence of cards.
 *        | hasProperCards()
 * 
 * @version 2.0
 * @author  Eric Steegmans
 */
public abstract class CardDeck {

    /**
     * Initialize this new empty card deck with given capacity.
     *
     * @param  minNbCards
     *         The minimum number of cards ever on this new card deck.
     * @param  maxNbCards
     *         The maximum number of cards ever on this new card deck.
     * @post   The maximum number of cards for this new card deck is equal
     *         to the given maximum number of cards.
     *       | new.getMaximumNbCards() == maxNbCards
     * @throws IllegalArgumentException
     *         This new card deck can not have a capacity ranging
     *         between the given minimum and maximum number of cards.
     *       | ! canHaveAsCapacity(minNbCards,maxNbCards))
     */
    @Raw @Model
    protected CardDeck(int minNbCards, int maxNbCards)
            throws IllegalArgumentException {
        if (!canHaveAsCapacity(minNbCards, maxNbCards))
            throw new IllegalArgumentException("Illegal capacity!");
        setMaximumNbCards(maxNbCards);
        cards.ensureCapacity(maxNbCards);
    }

    /**
     * Return the maximum number of cards that can be put on this card
     * deck.
     */
    @Basic
    public int getMaximumNbCards() {
        return this.maximumNbCards;
    }

    /**
     * Return the minimum number of cards that must be on this card deck.
     */
    @Basic
    public abstract int getMinimumNbCards();

    /**
     * Check whether this card deck can have the given capacity
     * as its capacity.
     * 
     * @param  minNbCards
     *         The minimum number of cards for the capacity to check.
     * @param  maxNbCards
     *         The maximum number of cards for the capacity to check.
     * @return ...
     */
    @Raw
    public boolean canHaveAsCapacity(int minNbCards, int maxNbCards) {
        return false;
    }

    /**
     * Set the maximum number of cards for this card deck to the
     * given maximum number of cards.
     * 
     * @param  maximumNbCards
     *         The new maximum number of cards for this card deck.
     * @pre    This card deck can have the given maximum number
     *         of cards as part of its capacity.
     *       | canHaveAsCapacity(getMinimumNbCards(),maximumNbCards)
     * @post   The maximum number of cards for this card deck is equal
     *         to the given maximum number of cards.
     *       | new.getMaximumNbCards() == maximumNbCards 
     */
    @Raw
    protected void setMaximumNbCards(int maximumNbCards) {
        assert canHaveAsCapacity(getMinimumNbCards(),maximumNbCards);
        this.maximumNbCards = maximumNbCards;
    }

    /**
     * Variable registering the maximum number of cards for this card deck.
     */
    private int maximumNbCards;

    /**
     * Return the number of cards on this card deck.
     */
    @Basic
    public int getNbCards() {
        return cards.size();
    }

    /**
     * Check whether this card deck has reached its maximum number
     * of cards.
     *
     * @return True if and only if the number of cards on this
     *         card deck is equal to its maximum number of cards.
     *       | result == (getNbCards() == getMaximumNbCards())
     */
    @Raw
    public boolean hasMaximumSize() {
        return getNbCards() == getMaximumNbCards();
    }

    /**
     * Check whether this card deck has reached its minimum number of
     * cards.
     *
     * @return True if and only if the number of cards on this
     *         card deck is equal to its minimum number of cards.
     *       | result == (getNbCards() == getMinimumNbCards())
     */
    @Raw
    public boolean hasMinimumSize() {
        return getNbCards() == getMinimumNbCards();
    }

    /**
     * Return the card at the given index in this card deck.
     *
     * @param  index
     *         The index of the card to be returned.
     * @throws IndexOutOfBoundsException
     *         The given index is below 1 or exceeds the number
     *         of cards on this card deck.
     *       | (index < 1) || (index > getNbCards())
     */
    @Basic
    public Card getCardAt(int index) throws IndexOutOfBoundsException {
        return cards.get(index - 1);
    }

    /**
     * Check whether this card deck can have the given card as one
     * of its cards.
     *
     * @param  card
     *         The card to be checked.
     * @param  index
     *         The index to be checked.
     * @return True if the given card is effective and if the given
     *         index is not below the minimum number of cards for this
     *         card deck, not above the number of cards on this card
     *         deck + 1, nor above the maximum number of cards for
     *         this card deck.
     *        | result ==
     *        |      (card == null)
     *        |   && (index >= getMinimumNbCards())
     *        |   && (index <= getNbCards() + 1)
     *        |   && (index <= getMaximumNbCards())
     */
    public boolean canHaveAsCardAt(Card card, int index) {
    	if (card == null)
    		return false;
    	if ( (index < getMinimumNbCards()) ||
            (index > getNbCards()+1)
            || (index > getMaximumNbCards()) )
    		return false;
    	return true;
    }

    /**
     * Check whether this card deck has a proper sequence of cards.
     * 
     * @return True if and only if this card deck can have each of
     *         its cards at their index.
     *       | result ==
     *       |   for each I in 1..getNbCards():
     *       |     canHaveAsCardAt(getCardAt(I),I)
     */
    public boolean hasProperCards() {
    	for (int i=1; i<=getNbCards(); i++)
    		if (! canHaveAsCardAt(getCardAt(i), i))
    			return false;
    	return true;
    }
    
    /**
     * Return the card on top of this card deck.
     *
     * @return The card on this card deck at the highest index.
     *       | result == getCardAt(getNbCards())
     * @throws IllegalStateException
     *         This card deck is empty.
     *       | getNbCards() == 0
     */
    public Card getCardAtTop() throws IllegalStateException {
        if (getNbCards() == 0)
            throw new IllegalStateException("No top card for an empty deck!");
        return getCardAt(getNbCards());
    }

    /**
     * Check whether the given card is on this card deck.
     *
     * @param  card
     *         The card to be checked.
     * @return True if and only if the given card is loaded at some
     *         index on this card deck.
     *       | result ==
     *       |   (for some I in 1..getNbCards():
     *       |      getCardAt(I) == card) 
     */
    @Raw
    public boolean hasAsCard(Card card) {
    	return cards.contains(card);
    }

    /**
     * Return all the cards loaded on this card deck, with the card on top
     * of this card deck at the end of the resulting array.
     *
     * @return The length of the resulting array is equal to
     *         the number of cards in this card deck.
     *       | result.length == getNbCards()
     * @return Successive elements in the resulting array are the same
     *         as the cards at corresponding positions in this card deck.
     *       | for each I in 1..getNbCards():
     *       |   result[I-1] == getCardAt(I)
     */
    public Card[] getAllCards() {
        Card[] result = new Card[getNbCards()];
        cards.toArray(result);
        return result;
    }

    /**
     * Push the given card on top of this card deck.
     *
     * @param  card
     *         The card to be pushed.
     * @pre    This card deck must accept the given card as its new
     *         top card.
     *       | canHaveAsCardAt(card,getNbCards()+1)
     * @post   The number of cards on this card deck is incremented
     *         by 1.
     *       | new.getNbCards() == getNbCards() + 1
     * @post   The card on top of this card deck is the same as the
     *         given card.
     *       | new.getCardAtTop() == card
     */
    @Raw
    protected void pushCard(Card card) {
        assert canHaveAsCardAt(card,getNbCards()+1);
        cards.push(card);
    }

    /**
     * Remove the card on top of this card deck.
     *
     * @pre    This card deck has not reached its minimal size.
     *       | ! hasMinimumSize()
     * @post   The number of cards on this card deck is decremented
     *         by 1.
     *       | new.getNbCards() == getNbCards() Ð 1
     */
    @Raw
    protected void popCard() {
        assert ! hasMinimumSize();
        cards.pop();
    }

    /**
     * Remove all cards from this card deck.
     * 
     * @pre    The minimum number of cards for this card deck must
     *         be 0.
     *       | getMinimumNbCards() == 0
     * @post   No cards are loaded any more on this card deck.
     *       | new.getNbCards() == 0
     */
    protected void clear() {
        assert getMinimumNbCards() == 0;
        cards.clear();
    }

    /**
     * Variable referencing a stack containing all the cards in this
     * card deck.
     * 
     * @invar  The stack of cards is effective.
     *       | cards != null
     * @invar  This card deck can have each of the cards in the
     *         stack at its corresponding position.
     *       | for each I in 0..cards.size()-1:
     *       |   canHaveAsCardAt(cards.get(I),I+1)
     */
    private final Stack<Card> cards = new Stack<Card>();

    /**
     * Return a textual representation of this card deck.
     * 
     * @return An effective string starting with the simple name of the class
     *         to which this card deck effectively belongs, followed by
     *         the textual representation of each card on this card
     *         deck, separated by comma's and enclosed in square brackets.
     *       | (result != null) &&
     *       | (result.matches(getClass().getSimpleName() + ": [.*]") &&
     *       | (for each I in 1..getNbCards():
     *       |    result.matches(".*[.*"+getCardAt(I)+".*]")
     * @note   The formal specification does not express that the cards
     *         must be displayed in order.
     */
    @Override
    public String toString() {
        String result = this.getClass().getSimpleName() + ": [";
        if (getNbCards() > 0)
            result += getCardAt(1);
        for (int i = 2; i <= getNbCards(); i++)
            result += "," + getCardAt(i);
        return result + "]";
    }

}