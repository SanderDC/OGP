package liskov;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import liskov.cards.CardTest;
import liskov.cards.JackCardTest;
import liskov.cards.JokerCardTest;
import liskov.cards.NumberedCardTest;
import liskov.cards.OddMatcherCardTest;
import liskov.decks.CardDeckTest;
import liskov.decks.FromDeckTest;
import liskov.decks.HelpDeckTest;
import liskov.decks.SourceDeckTest;
import liskov.decks.TargetDeckTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( { CardDeckTest.class, TargetDeckTest.class,
    FromDeckTest.class, HelpDeckTest.class, SourceDeckTest.class,
    CardTest.class, JokerCardTest.class, JackCardTest.class, NumberedCardTest.class,
    OddMatcherCardTest.class})
public class AllTests {
}