/**
 * 
 */
package fileCounterTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filecounter.RecFileCounter;

/**
 * Class to test the file counter methods
 * All calls use the String testDirectory = "C:/Users/demps/Desktop/cf-tester"
 * @author demps
 *
 */
public class RecFileCounterTest {
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

}
