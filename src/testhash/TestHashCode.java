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
	private int [] wordHashes = null;
	private ArrayList<String> words;
	private static final int TABLE_SIZE = 235003;	//Prime
	private static final int LIST_SIZE = 235900;
	private static final int P = 100030001;
	
//	Test Variables
//	private static final int TABLE_SIZE = 31;	//Prime
//	private static final int LIST_SIZE = 50;
	
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
		int wordCount = 0;
	
		Scanner scan = new Scanner(f);
		
		while (scan.hasNext() && wordCount < LIST_SIZE ) {
			String w = scan.next();
			words.add(w);
			wordCount++;
		}
		scan.close();
	}
	
	/*
	 * Static functions to do the calculations for the hashcodes
	 */
	public static int polyHashCode(int a, String word) {
		char[] array = word.toCharArray();
		int code = array[ 0 ];
		
		for (int i = 1; i < array.length; ++i) {
			code = (code * a) + (int)array[i];
		}
		
//		if (code < 0) System.out.println("code < 0");
		
		return compress(code);
	}
	public static int cyclicHashCode(int shift, String word) {
		int code = 0;
		for (int i = 0; i < word.length(); ++i) {
			code = (code << shift)|(code >>> (32 - shift));
			code += (int) word.charAt(i);
		}
		return compress(code);
	}
	public static int oldHashCode(String word) {
		return -1;
	}
	public static int compress(int code) {
		Random rand = new Random();
		int a = rand.nextInt(P);
		int b = rand.nextInt(P);
		
		code = Math.abs((a*code + b)%P)%TABLE_SIZE;
		return code;
	}
	
	/*
	 * Functions to enclose the function calls for each word in words
	 */
	public void testPoly(int a) {
		//Fill a new HashTable
		wordHashes = new int[TABLE_SIZE];
		for (String w : words) {
			int hCode = polyHashCode(a, w);
			wordHashes[hCode]++;
		}
		
		//Report
		System.out.println("\nFor a = " + a);
		printReport();
	}
	
	/*
	 * Private functions to produce values from the HashTable
	 */
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
				count += i - 1;
		
		return count;
	}
	private void printReport() {
		//TEST
//		printHashCount();
		//TEST
		
		System.out.println("The number of collisions is : " + findCollisions());
		System.out.println("The max hits on an index is : " + findMax());
	}
	private void printHashCount() {
		if (wordHashes == null)
			wordHashes = new int[TABLE_SIZE];
		
		for (int i : wordHashes) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
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

		//poly a = 41
		testHC.testPoly(41);
		
		//poly a = 17
		testHC.testPoly(17);
//		testHC.testHastFunction("polyHashCode", 17);
//		System.out.println("\nWith a polynomial hashCode, a = 17 :");
//		testHC.printReport();
//		
//		// Trying a smaller prime
//		testHC.testHastFunction("polyHashCode", 11);
//		System.out.println("\nWith a polynomial hashCode, a = 11 :");
//		testHC.printReport();
//		
		//TODO shift a = 7
		//TODO old hash code
		
		System.out.println("\nProgramme finished");
	}

}
