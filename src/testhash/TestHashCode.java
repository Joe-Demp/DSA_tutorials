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
	private static final int TABLE_SIZE = 235901;	//Prime
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
		int code = word.charAt(0);
		
		for (int i = 1; i < word.length(); ++i) {
			code = (code * a) + word.charAt(i);
		}
				
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
		int hash = 0;
		int skip = Math.max(1, word.length() / 8);
		for (int i = 0; i < word.length(); i += skip)
			hash = (hash * 37) + word.charAt(i);
		return compress(hash);
	}
	public static int compress(int code) {
		Random rand = new Random(100);
		int a = rand.nextInt(P);	//since the random object has been seeded, a and b are constant
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
		System.out.println("\nPolynomial For a = " + a);
		printReport();
	}
	public void testCyclic(int shift) {
		//Fill a new HashTable
		wordHashes = new int[TABLE_SIZE];
		for (String w : words) {
			int hCode = cyclicHashCode(shift, w);
			wordHashes[hCode]++;
		}
		
		//Report
		System.out.println("\nCyclic for shift = " + shift);
		printReport();
	}
	public void testOldHash() {
		//Fill a new HashTable
		wordHashes = new int[TABLE_SIZE];
		for (String w : words) {
			int hCode = oldHashCode(w);
			wordHashes[hCode]++;
		}
		
		//Report
		System.out.println("\nFor old hash ");
		printReport();
	}
	public void testNewHash() {
		//Fill a new HashTable
		wordHashes = new int[TABLE_SIZE];
		for (String w : words) {
			int hCode = compress(w.hashCode());
			wordHashes[hCode]++;
		}
		
		//Report
		System.out.println("\nFor new hash ");
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

		//shift a = 7
		testHC.testCyclic(7);
		
		//old hash code
		testHC.testOldHash();
		
		//new hash code
		testHC.testNewHash();
		
		System.out.println("\nProgramme finished");
	}

}
