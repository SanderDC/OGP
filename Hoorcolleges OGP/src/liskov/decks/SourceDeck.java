package liskov.decks;

import be.kuleuven.cs.som.annotate.Raw;
import liskov.cards.*;

/**
 * A class of source stacks containing cards.
 * 
 * @version 2.0
 * @author  Eric Steegmans
 */
public class SourceDeck extends FromDeck {

	/**
	 * Initialize this new source deck with given cards.
	 *
	 * @param  cards
	 *         The cards for this new source deck.
	 * @effect This new source deck is initialized as a new from
	 *         deck with the given cards.
	 *       | super(cards)
	 */
	@Raw public SourceDeck(Card... cards) throws IllegalArgumentException {
		super(cards);
	}

	/**
	 * Check whether this source deck can have the given capacity as
	 * its capacity.
	 * 
	 * @return ...
	 */
	@Override
	public boolean canHaveAsCapacity(int minNbCards, int maxNbCards) {
		return false;
	}

}