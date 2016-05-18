package liskov.decks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import liskov.cards.Card;
import liskov.cards.JackCard;
import liskov.cards.JokerCard;

public class TargetDeckTest {
    
    private static TargetDeck theDeck;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        theDeck = new TargetDeck(46,new JokerCard());
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void constructor_LegalCase() throws Exception {
        Card theCard = new JackCard();
        TargetDeck theDeck = new TargetDeck(46, theCard);
        assertEquals(1, theDeck.getMinimumNbCards());
        assertEquals(46, theDeck.getMaximumNbCards());
        assertEquals(1, theDeck.getNbCards());
        assertSame(theCard, theDeck.getCardAtTop());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_IllegalCapacity() throws Exception {
        new TargetDeck(0, new JackCard());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_IllegalCard() {
        new TargetDeck(10, null);
    }
    
    @Test public void getMinimumNbCards_SingleCase() {
        assertEquals(1,theDeck.getMinimumNbCards());
    }

    @Test public void canHaveAsCapacity_TrueCase() {
        assertTrue(theDeck.canHaveAsCapacity(1,46));
    }

    @Test public void canHaveAsCapacity_IllegalMinimum() {
        assertFalse(theDeck.canHaveAsCapacity(2,50));
    }

    @Test public void canHaveAsCapacity_IllegalMaximum() {
        assertFalse(theDeck.canHaveAsCapacity(1,0));
    }

}
