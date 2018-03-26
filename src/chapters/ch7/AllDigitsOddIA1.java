package chapters.ch7;

public class AllDigitsOddIA1
{
    public static void main(String[] args)
    {
        System.out.print(allDigitsOdd(11111));
    }

    private static boolean allDigitsOdd(int num)
    {
        while (num > 0)
        {
            if (num % 2 == 0)
            {
                return false;
            }

            num /= 10;
        }

        return true;
    }
}
