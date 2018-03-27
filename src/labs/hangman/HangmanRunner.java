package labs.hangman;

import java.io.FileNotFoundException;

public class HangmanRunner
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Hangman game = new Hangman();

        game.run();
    }


}
