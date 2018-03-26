package labs.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanRunner
{
    private static final String fileName = "src/labs/hangman/wordlist.txt";

    public static void main(String[] args) throws FileNotFoundException
    {
        Hangman game = new Hangman(getRandomWord(makeArrayList(fileName)));

        System.out.println(game.getWord());
        System.out.println(game.getProgress());
        game.evaluateGuess('e');
        game.evaluateGuess('t');
        game.evaluateGuess('a');
        game.evaluateGuess('s');
        System.out.println(game.getProgress());
    }

    private static String getRandomWord(ArrayList<String> list)
    {
        Random r = new Random();

        return list.get(r.nextInt(list.size()));
    }

    private static ArrayList<String> makeArrayList(String fileName) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();

        while (input.hasNextLine())
        { list.add(input.nextLine().toLowerCase()); }

        return list;
    }
}
