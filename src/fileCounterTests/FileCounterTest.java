package fileCounterTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import filecounter.RecFileCounter;
import filecounter.StackFileCounter;

/**
 * Class to test the file counter methods
 * All calls use the String testDirectory = "C:/Users/demps/Desktop/cf-tester"
 * @author demps
 *
 */
public class FileCounterTest {
	public static String testDirectory;
	public static String javaFile;
	public static String txtFile;	

	/**
	 * Sets up the Strings for the method calls: directory, java and txt 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDirectory = new String("C:/Users/demps/Desktop/cf-tester");
		javaFile = new String("java");
		txtFile = new String("txt");
	}
	
	/**
	 * Test method for {@link filecounter.RecFileCounter#countFiles(java.lang.String)}.
	 */
	@Test
	public final void testCountFilesString() {
		assertEquals( 17, RecFileCounter.countFiles(testDirectory));
	}

	/**
	 * Test method for {@link filecounter.RecFileCounter#countFiles(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testCountFilesJava() {
		assertEquals( 7, RecFileCounter.countFiles(testDirectory, javaFile));
	}
	
	/**
	 * Test method for {@link filecounter.RecFileCounter#countFiles(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testCountFilesTxt() {
		assertEquals( 10, RecFileCounter.countFiles(testDirectory, txtFile));
	}
	
	/**
	 * Test method for {@link filecounter.StackFileCounter#countFiles(java.lang.String)}.
	 */
	@Test
	public final void testStackCountFilesString() {
		assertEquals( 17, StackFileCounter.countFiles(testDirectory));
	}

	/**
	 * Test method for {@link filecounter.StackFileCounter#countFiles(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testStackCountFilesJava() {
		assertEquals( 7, StackFileCounter.countFiles(testDirectory, javaFile));
	}
	
	/**
	 * Test method for {@link filecounter.StackFileCounter#countFiles(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testStackCountFilesTxt() {
		assertEquals( 10, StackFileCounter.countFiles(testDirectory, txtFile));
	}

}
