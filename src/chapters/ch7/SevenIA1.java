package chapters.ch7;

public class SevenIA1
{
    public static void main(String[] args)
    {
        System.out.println(squareRoot(20));
        System.out.println(pow(55, 1));
        System.out.println(factorial(5));
        System.out.println(myexp(5, 2));
        System.out.println();
    }

    private static double squareRoot(double a)
    {
        double x0 = a / 2;
        double x1 = (x0 + a / x0) / 2;

        while (Math.abs(x0 - x1) > 0.0001D)
        {
            x0 = x1;
            x1 = (x0 + a / x0) / 2;
        }

        return x1;
    }

    private static double pow(double base, int power)
    {
        double result = 1;

        for (int i = 0; i < power; i++)
        {
            result = result * base;
        }

        return result;
    }

    private static int factorial(int number)
    {
        int result = 1;

        for (int i = 0; i < number; i++)
        {
            result = (number - i) * result;
        }

        return result;
    }

    private static double myexp(int x, int n)
    {
        double numerator = 1;
        double denominator = 1;
        double sum = 0.0;

        for (int i = 1; i <= n; i++)
        {
            sum += numerator / denominator;

            numerator *= x;
            denominator *= i;
        }

        return sum;
    }
}
