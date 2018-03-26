package labs.hangman.starters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	String fileName = "words.txt"; // change this to use a different file of
									// words.
	ArrayList<String> words;

	/*
	 * Constructor - this is done
	 */
	public Dictionary(String thefileName, int length) throws FileNotFoundException {
		// this.words = new ArrayList<String>();
		// read in the file
		Scanner input = new Scanner(new File(thefileName));
		// create an array list, to put the words into
		this.words = new ArrayList<String>();

		// read in the file, one line at a time
		while (input.hasNextLine()) {
			String line = input.nextLine();
			// make everything lower case
			line = line.toLowerCase();
			//only have words of length added to the ArrayList
			if (line.length() == length) {
				words.add(line);
			}
		}
	}

	/*
	 * picks a random word from the Dictionary
	 * FINISH THIS using makeARandom
	 */
	public String getWord() {
		String s = "";
		
		
		
		return s;
	}
	
	
	
	/*
	 * helps pick a random number
	 */
	private static int makeARandom(int low, int high) {
		return (int) (Math.random() * high + low);
	}

}