package chapters.ch7;

public class WhileExamples
{
    public static void main(String[] args)
    {
        printOdds();
        printMultiples(300, 3);
    }

    private static void printOdds()
    {
        int x = 100;

        while(x >= 0)
        {
            if (x % 2 == 0)
            {
                System.out.println(x);
            }
        }
    }

    private static void printMultiples(int x, int y)
    {
        
    }
}
