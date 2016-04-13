package liskov.decks;

import be.kuleuven.cs.som.annotate.*;
import liskov.cards.*;

/**
 * A class of from decks containing cards.
 *   A from deck serves to take cards from.
 * 
 * @version 2.0
 * @author  Eric Steegmans
 */
public abstract class FromDeck extends CardDeck {

	/**
	 * Initialize this new from deck with given cards.
	 *
	 * @param  cards
	 *         The cards to be loaded on this new from deck.
	 * @effect This new from deck is initialized as a card deck with
	 *         0 as its minimum number of cards and with the length
	 *         of the given array of cards as its maximum number of cards.
	 *       | super(0,cards.length)
	 * @post   The number of cards on this new from deck is set
	 *         to the length of the given array of cards.
	 *       | new.getNbCards() == cards.length
	 * @post   This new from deck stores each of the given cards
	 *         in the same order.
	 *       | for each I in 1..cards.length:
	 *       |   new.getCardAt[I] == cards[I-1]
	 * @throws IllegalArgumentException
	 *         This new from deck cannot have at least one of the given
	 *         cards as its card at the corresponding index
	 *       | for some I in 1..cards.length:
	 *       |   !canHaveAsCardAt(cards[I-1],I)
	 * @throws IllegalArgumentException
	 *         The given array of cards has at least one card at
	 *         several positions.
	 *       | for some I,J in 0..cards.length-1:
	 *       |   (I != J) && (cards[I] == cards[J])
	 */
	@Raw @Model
	protected FromDeck(Card... cards) throws IllegalArgumentException {
		super(0, cards.length);
		for (int pos = 0; pos < cards.length; pos++) {
			if (!canHaveAsCardAt(cards[pos], pos + 1))
				throw new IllegalArgumentException("Illegal card!");
			pushCard(cards[pos]);
		}
	}

	/**
	 * Return the minimum number of cards that must be on this from deck.
	 *
	 * @return Always 0.
	 *       | result == 0
	 */
	@Override
	public final int getMinimumNbCards() {
		return 0;
	}

	/**
	 * Check whether this from deck can have the given capacity as
	 * its capacity.
	 * 
	 * @return ...
	 */
	@Override
	public boolean canHaveAsCapacity(int minNbCards, int maxNbCards) {
		return false;
	}

	/**
	 * Move the card on top of this from deck on top of the given
	 * target deck.
	 *
	 * @param  target
	 *         The target deck for the transfer.
	 * @post   The new number of cards on this from deck is equal
	 *         to its old number of cards minus 1.
	 *       | new.getNbCards() = getNbCards() Ð 1
	 * @post   The new number of cards on the given target deck is
	 *         equal to its old number of cards + 1.
	 *       | (new target).getNbCards() == target.getNbCards() + 1
	 * @post   The new card on top of this target deck is the same as
	 *         the card that was on top of this from deck.
	 *       | (new target).getCardAtTop() == getCardAtTop()
	 * @throws IllegalStateException
	 *         ...
	 */
	public void moveTop(TargetDeck target) throws IllegalStateException {
	}

}