package labs.hangman;

import java.io.*;
import java.util.Scanner;

public class Statistics
{
    private static final String FILE_PATH = "src/labs/hangman/res/statistics.csv";
    private File stats = new File(FILE_PATH);
    private Scanner scanner;
    private FileOutputStream fos = new FileOutputStream(stats);
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

    public Statistics() throws IOException
    {
        scanner = new Scanner(stats);
        recordLetter('c');
    }

    public void recordLetter(char letter) throws IOException
    {
        int location = findLetterLine(letter);

        writer.newLine();
        writer.append(letter);
        writer.write(letter);
        writer.flush();
        writer.newLine();
        writer.write(letter);
    }

    public void recordWord(String word)
    {
        int location = findWordLine(word);
    }

    public void incrementGuessTotal()
    {

    }

    private int findLetterLine(char letter)
    {
        for (int i = 0; i < 28; i++)
        {
        }

        return -99;
    }

    private int findWordLine(String word)
    {
        return -99;
    }

}
