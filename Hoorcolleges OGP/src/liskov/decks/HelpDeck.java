package liskov.decks;

import be.kuleuven.cs.som.annotate.Raw;
import liskov.cards.*;

/**
 * A class of help decks containing cards.
 * 
 * @version 2.0
 * @author  Eric Steegmans
 */
public class HelpDeck extends FromDeck {

	/**
	 * Initialize this new help deck with given cards.
	 *
	 * @param  cards
	 *         The cards for this new help deck.
	 * @effect This new help deck is initialized as a new from
	 *         deck with the given cards.
	 *       | super(cards)
	 */
	@Raw public HelpDeck(Card... cards) throws IllegalArgumentException {
		super(cards);
	}

	/**
	 * Check whether this help deck can have the given capacity as
	 * its capacity.
	 * 
	 * @return ...
	 */
	@Override
	public boolean canHaveAsCapacity(int minNbCards, int maxNbCards) {
		return false;
	}

}