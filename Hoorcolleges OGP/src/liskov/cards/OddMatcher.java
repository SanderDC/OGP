package liskov.cards;

public class OddMatcher extends Card {

	@Override
	public boolean matchesOn(Card other) {
		if (other instanceof NumberedCard)
			return ((NumberedCard) other).getValue() % 2 == 1;
		else if (other instanceof OddMatcher)
			return false;
		else if (other instanceof JackCard)
			return true;
		else
			return other.matchesOn(this);
	}

}
