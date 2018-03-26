package chapters.ch7;

public class WhileLoopGuess
{
    public static void main(String[] args)
    {
        guess(10, 100);
    }

    private static boolean guess(int num, int guesses)
    {
        while (guesses > 0)
        {
            int guess = (int) (Math.random() * 10) + 1;
            if (guess == num)
            {
                System.out.print(num + " I got it!");
                return true;
            }

            System.out.print(guess + " ");

            guesses--;
        }

        System.out.print(" I give up!");
        return false;
    }
}
