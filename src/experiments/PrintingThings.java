package experiments;

/**
 * Created by 90304755 on 1/4/18.
 */
public class PrintingThings
{
    public static void main(String[] args)
    {
        System.out.println(sumDigits(25));
    }

    private static int sumDigits(int num)
    {
        if (num != 0)
            return (num % 10) + sumDigits(num / 10);
        else
            return 0;
    }
}