package partOne;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author sande
 *
 */
public class OilTankTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isValidContent_NegContent() {
		assertFalse(OilTank.isValidContents(-100, 200));
	}
	
	@Test
	public void isValidContent_LegalContent() {
		assertTrue(OilTank.isValidContents(100, 200));
	}
	
	@Test
	public void isValidContent_ContentTooLarge() {
		assertFalse(OilTank.isValidContents(-100, 200));
	}
	
	@Test
	public void setContent_LegalCase() {
		OilTank theTank = new OilTank(100,500);
		theTank.setContents(300);
		assertEquals(300,theTank.getContents());
	}
	
}
