package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
	private String filename;
	private HashMap<String, Integer> countOfWords = null;
	
	public WordCounter(String fn) {
		filename = fn;
	}
	
	/**
	 * Counts the number of occurrences of a word in a file and returns the counts in a HashMap
	 * @param fname the path of the file you'd like to investigate
	 * @return a HashMap of the counts of the words if the file was read correctly, null otherwise
	 * @throws FileNotFoundException
	 */
	public HashMap<String, Integer> countWordsInFile() {
		File file = new File(filename);
		Scanner scan;
		
		try {
			scan = new Scanner(file);
			countOfWords = new HashMap<String, Integer>();
			
			while (scan.hasNext()) {
				//	TODO call strip here
				//	TODO fill in actions here to count the words
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return countOfWords;
	}
	
	public static String strip(String s) {
		//	TODO fill in actions here to remove any non-letter chars from the string
		return null;
	}
	
	public void reportWords() {
		//	TODO a series of print statements giving a list of the top ten words
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
