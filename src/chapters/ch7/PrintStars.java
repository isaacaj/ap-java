package chapters.ch7;

public class PrintStars
{
    public static void main(String[] args)
    {
        printEvens();

        printEvens(12321);
    }

    private static void printEvens(int max)
    {
        int x = 1;
        while (x <= max)
        {
            if (x % 2 == 0)
            {
                System.out.println(x);
            }

            ++x;
        }
    }

    private static void printEvens()
    {
        int x = 1;
        while (x <= 10)
        {
            if (x % 2 == 0)
            {
                System.out.println(x);
            }

            ++x;
        }
    }
}
