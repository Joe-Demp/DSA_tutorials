package testhash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 * Class to test different HashCodes
 * @author demps
 *
 */
public class TestHashCode {
	private int [] wordHashes;
	private ArrayList<String> words;
	private static final int TABLE_SIZE = 235003;	//Prime
	private static final int LIST_SIZE = 235900;
	private static final int P = 100030001;
	
	public TestHashCode() {
		words = new ArrayList<String>(LIST_SIZE);
		
		try {
			importWords();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}
	
	private void importWords() throws FileNotFoundException{
		File f = new File("C:\\Users\\demps\\git\\DSA_tutorials\\words.txt");
		
	
		Scanner scan = new Scanner(f);
		
		while (scan.hasNext()) {
			String w = scan.next();
			words.add(w);
		}
		scan.close();
	}
	
	public int polyHashCode(int a, String word) {
		char[] array = word.toCharArray();
		int code = array[ 0 ];
		
		for (int i = 1; i < array.length; ++i) 
			code = (code * a) + (int)array[i];
		
//		if (code < 0) System.out.println("code < 0");
		
		return code;
	}
	public int cyclicHashCode(int shift, String word) {
		int code = 0;
		for (int i = 0;i<0;);
		return code;
	}
	public int oldHashCode(String word) {
		return -1;
	}
	private int compress(int code) {
		Random rand = new Random(101);
		int a = rand.nextInt(P);
		int b = rand.nextInt(P);
		
		code = Math.abs((a*code + b)%P)%TABLE_SIZE;
		return code;
	}
	
	public void testHastFunction(String functionName, int ashift) {
		wordHashes = new int[TABLE_SIZE];
		int code = -1;
		
		for (String word : words) {
			switch (functionName) {
			case "polyHashCode":
				code = polyHashCode(ashift, word);
				break;
			case "cyclicHashCode":
				code = cyclicHashCode(ashift, word);
				break;
			case "oldHashCode":
				code = oldHashCode(word);
				break;
			}
			code = compress(code);
			wordHashes[code]++;
		}//	end while
	}
	
	private int findMax() {
		int max = -1;
		for (int i : wordHashes)
			if (i > max)
				max = i;
		
		return max;
	}
	private int findCollisions() {
		int count = 0;
		for (int i : wordHashes)
			if (i > 1)
				count++;
		
		return count;
	}
	private void printReport() {
		System.out.println("The number of collisions is : " + findCollisions());
		System.out.println("The max hits on an index is : " + findMax());
	}
	
//	public void testImportWords() {
//		for (String s : words)
//			System.out.println(s);
//	}
	
	public static void main(String[] args) {
		// 	TODO Auto-generated method stub
		//	TODO take in Strings from words.txt
//		Imports all the words into the words ArrayList
		TestHashCode testHC = new TestHashCode();
		
		//	TODO call the hashcode methods
		//TODO poly a = 41
		testHC.testHastFunction("polyHashCode", 41);
		System.out.println("With a polynomial hashCode, a = 41 :");
		testHC.printReport();
		
		//TODO poly a = 17
		testHC.testHastFunction("polyHashCode", 17);
		System.out.println("\nWith a polynomial hashCode, a = 17 :");
		testHC.printReport();
		
		// Trying a smaller prime
		testHC.testHastFunction("polyHashCode", 11);
		System.out.println("\nWith a polynomial hashCode, a = 11 :");
		testHC.printReport();
		
		//TODO shift a = 7
		//TODO old hash code
		
		System.out.println("\nProgramme finished");
	}

}
