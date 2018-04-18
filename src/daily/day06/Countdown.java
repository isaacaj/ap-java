package daily.day06;

public class Countdown
{
    public static void main(String[] args)
    {
        countdown(10);
        countdown(4, "apple");
    }

    private static void countdown(int n)
    {
        if (n == 0)
            System.out.println(n);
        else
        {
            System.out.println(n);
            countdown(--n);
        }
    }

    private static void countdown(int n, String message)
    {
        if (n == 0)
        {
            System.out.println(n);
            System.out.println(message);
        } else
        {
            System.out.println(n);
            countdown(--n, message);
        }
    }
}
