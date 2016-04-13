package liskov.cards;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class of numbered cards used in the game of Thieves.
 *
 * @invar  The value of each numbered card must be a valid
 *         value for a numbered card.
 *       | isValidValue(getValue())
 *
 * @version  2.0
 * @author   Eric Steegmans
 */
public class NumberedCard extends Card {

	/**
	 * Initialize this new numbered card with given value.
	 *
	 * @param  value
	 *         The value for this new numbered card.
	 * @post   The value of this new numbered card is equal to the
	 *         given value.
	 *       | new.getValue() == value
	 * @throws IllegalArgumentException
	 *         The given value is not a valid value for a numbered card.
	 *       | ! isValidValue(value)
	 */
	public NumberedCard(int value) throws IllegalArgumentException {
		if (!isValidValue(value))
			throw new IllegalArgumentException(
					"Invalid value for numbered card!");
		this.value = value;
	}

	/**
	 * Return the value of this numbered card.
	 */
	@Basic
	@Immutable
	public int getValue() {
		return this.value;
	}

	/**
	 * Check whether the given value is a valid value
	 * for a numbered card.
	 * 
	 * @return True if and only if the given value is positive
	 *         and does not exceed 10.
	 *       | result == (value >= 1) && (value <= 10)
	 */
	public static boolean isValidValue(int value) {
		return (value >= 1) && (value <= 10);
	}

	/**
	 * Variable registering the value of this numbered card.
	 */
	private final int value;

	/**
	 * Check whether this numbered card matches on the given card.
	 *
	 * @return ...
	 */
	@Override
	public boolean matchesOn(Card other) {
		if (other instanceof NumberedCard)
			return Math.abs(((NumberedCard) other).getValue()-this.getValue()) == 1;
		else
			return other.matchesOn(this);
	}

}