package liskov.cards;

/**
 * A class of joker cards used in a game of Thieves.
 * 
 * @version 2.0
 * @author  Eric Steegmans
 */
public class JokerCard extends Card {

	/**
	 * Initialize this new joker card.
	 */
	public JokerCard() {
	}

	/**
	 * Check whether this joker card matches on the given card.
	 *
	 * @return ...
	 */
	@Override
	public final boolean matchesOn(Card other) {
		return false;
	}

}