package liskov.cards;

/**
 * A class of cards used in the game of Thieves.
 * 
 * @version  2.0
 * @author   Eric Steegmans
 */
public abstract class Card implements Cloneable {

    /**
     * Check whether this card matches on the given card.
     *
     * @param  other
     *         The card to match with.
     * @return ...
     */
    public abstract boolean matchesOn(Card other);
            
}