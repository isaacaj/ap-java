package chapters.ch8;

import util.NumScanner;

public class TestScoresIA1
{
    public static void main(String[] args)
    {

    }

    private static int getScore(int scoreIndex)
    {
        NumScanner scanner = new NumScanner();

        System.out.print("Score number " + scoreIndex + " is: ");
        return scanner.nextInt();
    }
}
