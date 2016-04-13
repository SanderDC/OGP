package liskov.cards;

/**
 * A class of jack cards used in a game of Thieves.
 * 
 * @version  2.0
 * @author   Eric Steegmans
 */
public class JackCard extends Card {

	/**
	 * Initialize this new jack card.
	 */
	public JackCard() {
	}

	/**
	 * Check whether this jack card matches on the given card.
	 *
	 * @return ...
	 */
	@Override
	public boolean matchesOn(Card other) {
		return false;
	}

}