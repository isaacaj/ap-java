package chapters.ch7;

public class DigitsInARowIA1
{
    public static void main(String[] args)
    {
        System.out.print(digitsInARow(1222111111));
    }

    private static int digitsInARow(int num)
    {
        int[] digits = new int[10];
        int max = 0;
        for (int i = 0; i < digits.length; i++)
            digits[i] = 0;

        while (num > 0)
        {
            if (num % 10 == (num/10) % 10)
            {
                digits[num % 10]++;
            }

            num = num/10;
        }

        for (int number : digits)
        {
            if (number > max)
            {
                max = number;
            }
        }

        return max + 1;
    }
}
