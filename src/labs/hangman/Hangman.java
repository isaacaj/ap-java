package labs.hangman;

import util.NumScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman
{
    private static final String TITLE = "  o         o\n" +
            " <|>       <|>\n" +
            " < >       < >\n" +
            "  |         |      o__ __o/  \\o__ __o     o__ __o/  \\o__ __o__ __o      o__ __o/  \\o__ __o  \n" +
            "  o__/_ _\\__o     /v     |    |     |>   /v     |    |     |     |>    /v     |    |     |> \n" +
            "  |         |    />     / \\  / \\   / \\  />     / \\  / \\   / \\   / \\   />     / \\  / \\   / \\\n" +
            " <o>       <o>   \\      \\o/  \\o/   \\o/  \\      \\o/  \\o/   \\o/   \\o/   \\      \\o/  \\o/   \\o/\n" +
            "  |         |     o      |    |     |    o      |    |     |     |     o      |    |     |  \n" +
            " / \\       / \\    <\\__  / \\  / \\   / \\   <\\__  < >  / \\   / \\   / \\    <\\__  / \\  / \\   / \\\n" +
            "                                                |                                           \n" +
            "                                        o__     o\n" +
            "                                        <\\__ __/>";
    private static final String FILE_NAME = "src/labs/hangman/res/wordlist.txt";
    private String progress;
    private int wrongGuesses;
    private String word;
    private ArrayList<Character> guessedChars = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    Hangman() throws IOException
    {
        this.wrongGuesses = 0;
        this.word = getRandomWord(makeArrayList(FILE_NAME), askDifficulty());
        this.progress = makeProgressWord(this.word);

        Statistics statistics = new Statistics();
    }

    private static String getRandomWord(ArrayList<String> list, int difficulty)
    {
        Random r = new Random();
        String randomWord = "";

        if (r.nextInt(11) == 10)
        {
            return list.get(2126);
        }

        switch (difficulty)
        {
            default:
                while (randomWord.length() < 2 || randomWord.length() >= 4)
                    randomWord = list.get(r.nextInt(list.size() + 1));
                break;

            case 1:
                while (randomWord.length() < 4 || randomWord.length() >= 6)
                    randomWord = list.get(r.nextInt(list.size() + 1));
                break;

            case 2:
                while (randomWord.length() < 6 || randomWord.length() >= 8)
                    randomWord = list.get(r.nextInt(list.size() + 1));
                break;

            case 3:
                while (randomWord.length() < 8 || randomWord.length() >= 10)
                    randomWord = list.get(r.nextInt(list.size() + 1));
                break;
        }

        if (difficulty > 3)
            while (randomWord.length() < 10)
                randomWord = list.get(r.nextInt(list.size() + 1));

        return randomWord;
    }

    private static ArrayList<String> makeArrayList(String fileName) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();

        while (input.hasNextLine())
        { list.add(input.nextLine().toLowerCase()); }

        return list;
    }

    public void run() throws FileNotFoundException
    {
        startingSequence();

        while (wrongGuesses < 6)
        {
            runTurn();
            if (progress.equalsIgnoreCase(word))
            {
                break;
            }
        }

        endSequence();
    }

    /**
     * Starts the game.
     * <p>
     * Introduces the player to hangman
     * and draws an empty board.
     */
    private void startingSequence()
    {
        evaluateGuess('-', false);

        System.out.println(TITLE);

        System.out.println("Welcome to Hangman!\n");
        System.out.println("I am thinking of a " + word.length() + " letter word.\nGuess the letters!");

        drawBoard(wrongGuesses);
    }

    private void runTurn()
    {
        evaluateGuess(askGuess(), true);
        drawBoard(wrongGuesses);
    }

    private void endSequence() throws FileNotFoundException
    {
        if (wrongGuesses < 6)
        {
            System.out.println("Congratulations! You won!");
        } else
        {
            System.out.println("Better luck next time.");
            System.out.println("The word was: " + word);
        }

        playAgain();
    }

    private void playAgain() throws FileNotFoundException
    {
        System.out.println("Play again? (yes/no)");

        if (scanner.hasNextLine())
        {
            try
            {
                if (Character.toLowerCase(scanner.nextLine().charAt(0)) == 'y')
                {
                    this.word = getRandomWord(makeArrayList(FILE_NAME), askDifficulty());
                    this.wrongGuesses = 0;
                    this.progress = makeProgressWord(word);
                    this.guessedChars = new ArrayList<>();

                    run();
                } else
                {
                    System.out.println("Thanks for playing!");
                }
            } catch (StringIndexOutOfBoundsException e)
            {
                System.out.println("Thanks for playing!");
            }
        }
    }

    private int askDifficulty()
    {
        NumScanner scanner = new NumScanner();
        System.out.println("Pick a difficulty (0 to 4):");
        return scanner.nextInt(0, 5);
    }

    private char askGuess()
    {
        System.out.println("What letter would you like to guess?");
        if (scanner.hasNextLine())
        {
            try
            {
                return scanner.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e)
            {
                System.out.println("Please type a letter.");
                askGuess();
            }

        } else
        {
            scanner.nextLine();
            askGuess();
        }

        return '+';
    }

    /**
     * Creates a String of '*' to create a censored
     * version of the word to display to the player.
     *
     * @param word target word
     * @return Censored word
     */
    private String makeProgressWord(String word)
    {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < word.length(); i++)
        {
            s.append("*");
        }

        return s.toString();
    }

    /**
     * Does TWO things:
     * 1) returns true if the guessed char is correct
     * 2) alters the progress string, which displays characters in the target word
     * that are known to the player.
     *
     * @param c                character to guess
     * @param recordWrongGuess Whether or not to count this guess if it is wrong
     * @return whether or not the guess was correct
     */
    private boolean evaluateGuess(char c, boolean recordWrongGuess)
    {
        c = Character.toLowerCase(c);

        if (guessedChars.contains(c))
            return true;

        boolean correct = false;

        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) == c)
            {
                progress = progress.substring(0, i) + c + progress.substring(i + 1);
                correct = true;
            }
        }

        if (recordWrongGuess && !correct)
        {
            this.wrongGuesses++;
            guessedChars.add(c);
        }

        return correct;
    }

    /**
     * Draws a board and the hanging man based on how many incorrect
     * wrongGuesses there have been (0-6)
     *
     * @param wrongGuesses (0-6) number of wrong wrongGuesses, determines how many
     *                     parts to draw on the man.
     */
    private void drawBoard(int wrongGuesses)
    {
        switch (wrongGuesses)
        {
            case 0:
                System.out.println(
                        "|=================|\n" +
                                "|        |        |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|=================|\n" +
                                progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;

            case 1:
                System.out.println(
                        "|=================|\n" +
                                "|        |        |\n" +
                                "|        O        |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|=================|\n" +
                                progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;

            case 2:
                System.out.println(
                        "|=================|\n" +
                                "|        |        |\n" +
                                "|        O        |\n" +
                                "|        |        |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|=================|\n" +
                                progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;

            case 3:
                System.out.println(
                        "|=================|\n" +
                                "|        |        |\n" +
                                "|        O        |\n" +
                                "|       /|        |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|=================|\n" +
                                progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;

            case 4:
                System.out.println(
                        "|=================|\n" +
                                "|        |        |\n" +
                                "|        O        |\n" +
                                "|       /|\\       |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|=================|\n" +
                                progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;

            case 5:
                System.out.println(
                        "|=================|\n" +
                                "|        |        |\n" +
                                "|        O        |\n" +
                                "|       /|\\       |\n" +
                                "|       /         |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|                 |\n" +
                                "|=================|\n" +
                                progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;

            case 6:
                System.out.println("|=================|\n" +
                        "|        |        |\n" +
                        "|        O        |\n" +
                        "|       /|\\       |\n" +
                        "|       / \\       |\n" +
                        "|                 |\n" +
                        "|                 |\n" +
                        "|                 |\n" +
                        "|                 |\n" +
                        "|=================|\n" +
                        progress + "\nIncorrect guesses: " + guessedChars.toString()
                );
                break;
        }
    }

    private void displayProgressWord()
    {
        System.out.println(progress);
    }

    public int getWrongGuesses()
    {
        return wrongGuesses;
    }

    public String getWord()
    {
        return word;
    }

    public String getProgress()
    {
        return progress;
    }
}
