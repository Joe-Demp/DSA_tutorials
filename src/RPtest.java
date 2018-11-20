import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author demps
 *	A class to test the functionality of the RussianPeasant class,<br>
 *		namely it's multiply method
 */
public class RPtest {

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

	/**
	 * Test method for {@link RussianPeasant#multiply(long, long)}.
	 * Tests the regular case: a < b and 0 < a
	 */
	@Test
	public final void testMultiply1() {
		assertEquals("Test 1", 199211L, RussianPeasant.multiply(237L, 503L));
	}
	
	/**
	 * Test method for {@link RussianPeasant#multiply(long, long)}.
	 * Tests the case: b < a  and 0 < b
	 */
	@Test
	public final void testMultiply2() {
		assertEquals("Test 2", 199211L, RussianPeasant.multiply(503L, 237L));
	}
	
	/**
	 * Test method for {@link RussianPeasant#multiply(long, long)}.
	 * Tests the case: a = b and 0 < a
	 */
	@Test
	public final void testMultiply3() {
		assertEquals("Test 3", 253009L, RussianPeasant.multiply(503L, 503L));
	}
	
	/**
	 * Test method for {@link RussianPeasant#multiply(long, long)}.
	 * Tests the case: a = 0
	 */
	@Test
	public final void testMultiply4() {
		assertEquals("Test 4", 0, RussianPeasant.multiply(0, 503L));
	}

}
