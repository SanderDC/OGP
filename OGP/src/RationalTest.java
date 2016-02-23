import org.junit.*;
import static org.junit.Assert.*;

public class RationalTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void constructor_NegDenom() throws IllegalDenominatorException{
		Rational rat = new Rational(43,-67);
		assertEquals(-43,rat.getNumerator());
		assertEquals(67,rat.getDenominator());
	}
	
	@Test(expected=IllegalDenominatorException.class)
	public void constructor_IllegalDenom()throws IllegalDenominatorException {
		new Rational(45,0);
	}
}
