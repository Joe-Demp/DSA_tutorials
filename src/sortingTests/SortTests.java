/**
 * 
 */
package sortingTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sortingClasses.BubbleSort;

/**
 * @author demps
 *
 */
public class SortTests {
	
	public final int ARRAY_SIZE = 1000;
	public Integer [] sortingArray;
	public Integer [] sortedArray;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		sortedArray = new Integer[ ARRAY_SIZE ];
		for (int i = 0; i < ARRAY_SIZE; ++i)
			sortedArray[ i ] = i;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sortingArray = new Integer[ ARRAY_SIZE ];
		for (int i = ARRAY_SIZE - 1; i >= 0; --i)
			sortingArray[ i ] = i;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		sortingArray = null;
	}

	/**
	 * Test method for {@link sortingClasses.BubbleSort#sort(java.lang.Integer[])}.
	 */
	@Test
	public final void testSort() {
		BubbleSort.sort(sortingArray);
		assertArrayEquals(sortedArray, sortingArray);
	}

}
