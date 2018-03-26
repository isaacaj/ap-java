package labs.hangman.starters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WritingToFiles {

	public static void main(String[] args) throws IOException {
		String[] words = new String[1];
		words[0] = "hello";
		writeFile(words);
	}

	public static void writeFile(String[] words) throws IOException {
		File fout = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for(int i = 0; i < words.length; i++){
			bw.write(words[i]);
			bw.newLine();
		}

		bw.close();
	}
}
