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
import sortingClasses.MergeSort;
import sortingClasses.SelectionSort;

/**
 * @author demps
 *
 */
public class SortTests {
	
	public static final int ARRAY_SIZE = 1000;
	public static Integer [] sortingArray;
	public static Integer [] sortedArray;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public final void testBubbleSort() {
		BubbleSort.sort(sortingArray);
		assertArrayEquals(sortedArray, sortingArray);
	}
	
	@Test
	public final void testSelectionSort() {
		SelectionSort.sort(sortingArray);
		assertArrayEquals(sortedArray, sortingArray);
	}
	
	@Test
	public final void testMergeSort() {
		MergeSort.sort(sortingArray, 0, sortingArray.length - 1);
		assertArrayEquals(sortedArray, sortingArray);
	}

}
