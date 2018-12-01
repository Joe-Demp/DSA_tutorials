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
	private static final int SIZE = 235900;
	
	public TestHashCode() {
		wordHashes = new int[SIZE];
		words = new ArrayList<String>(SIZE);
		
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
			code = (code * a) + array[i];
		
		return code;
	}
	public int cyclicHashCode(int shift, String word) {
		return -1;
	}
	public int oldHashCode(String word) {
		return -1;
	}
	private int compress(int code) {
		return code % SIZE;
	}
	
	public void testHastFunction(String f, int ashift) {
		for (int i : wordHashes) wordHashes[i] = 0;
		int code = -1;
		
		for (String word : words) {
			switch (f) {
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
	private void printReport() {
		System.out.println("The number of collisions is : " + findMax());
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
		
		System.out.println("Programme finished");
	}

}
