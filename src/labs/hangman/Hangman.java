package labs.hangman;

public class Hangman
{
    private int score;
    private int guesses;
    private String word;
    private String progress;

    private static final int STARTING_GUESSES = 5;

    public Hangman(String word)
    {
        this.score = 0;
        this.guesses = STARTING_GUESSES;
        this.word = word;
        this.progress = makeProgressWord(this.word);
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
     * If c is a correct guess, alters the progress string
     *
     * @param c character to guess
     * @return whether or not the guess was correct
     */
    public boolean evaluateGuess(char c)
    {
        boolean correct = false;

        for (int i = 0; i < word.length() - 1; i++)
        {
            if (word.charAt(i) == c)
            {
                progress = progress.substring(0, i) + c + progress.substring(i + 1);
                correct = true;
            }
        }

        return correct;
    }

    private void displayProgressWord()
    {
        System.out.println(progress);
    }

    public int getScore()
    {
        return score;
    }

    public int getGuesses()
    {
        return guesses;
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
