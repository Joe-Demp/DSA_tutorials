package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
	private String filename;
	private HashMap<String, Integer> countOfWords = null;
	public static final String ILLEGAL_CHARS = "('s)|[.,?!'\";:()]";
	
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
		String word;
		
		try {
			scan = new Scanner(file);
			countOfWords = new HashMap<String, Integer>();
			
			while (scan.hasNext()) {
//				scan in file and strip it of non-letter characters
				word = scan.next();
				word = strip(word);
				
				if (countOfWords.containsKey(word)) {
//					get the previous count, increment it and add the new count back in
					int count = countOfWords.get(word);
					countOfWords.put(word, count + 1);
				} else {
//					add the word to the HashMap and set the count to 1
					countOfWords.put(word, 1);
				}	//	end if
			}	//	end while
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return countOfWords;
	}
	
	/**
	 * Removes any non-letter and whitespace characters from a String<br>
	 * 	also turns it to lower-case
	 * @param s a String you wish to sanitize
	 * @return s, stripped of non-letter and whitespace characters, in lower case
	 */
	public static String strip(String s) {
//		Use replaceAll() to change illegal characters to spaces (" ")
//		then trim off whitespace
		s = s.replaceAll(ILLEGAL_CHARS, " ");
		s = s.trim();
		s = s.toLowerCase();
		
		return s;
	}
	
	/**
	 * Gets the most counted String from the HashMap but does not remove it
	 * @return the String with the highest count in the HashMap
	 */
	public String getMax() {
		Integer highest = -1;
		String max = null;
		
		return max;
	}
	
	public void reportWords() {
		//	TODO a series of print statements giving a list of the top ten words
		System.out.println("***Top Ten Words***");
	}

	public static void main(String[] args) {
		WordCounter wc = new WordCounter("sample_text.txt");
		wc.countWordsInFile();
	}

}
