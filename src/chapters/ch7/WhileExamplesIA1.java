package chapters.ch7;

public class WhileExamplesIA1
{
    public static void main(String[] args)
    {
        printOdds();
        printMultiples(300, 3);
        printFourFive(12, 400);
        displayNumbers(50);
        displayNumbers(15, 22);
        tenOnALine(23);
    }

    private static void printOdds()
    {
        int x = 100;
        while (x >= 0)
        {
            if (x % 2 != 0) { System.out.println(x); }
            --x;
        }
    }

    private static void printMultiples(int x, int y)
    {
        while (x >= y)
        {
            if (x % y == 0) { System.out.println(x); }
            x = x - y;
        }
    }

    private static void printFourFive(int lowNum, int highNum)
    {
        while (highNum >= lowNum)
        {
            if (highNum % 4 == 0 && highNum % 5 != 0) { System.out.println(highNum); }
            --highNum;
        }
    }

    private static void displayNumbers(int highNum)
    {
        while (highNum >= 0)
        {
            System.out.println(highNum--);
        }
    }

    private static void displayNumbers(int start, int end)
    {
        while (end >= start)
        {
            System.out.println(end--);
        }
    }

    private static void tenOnALine(int end)
    {
        int line = 0;
        int count = 1;
        while (count <= end)
        {
            if (line == 10)
            {
                System.out.println();
                line = 0;
            }

            System.out.print(count + ", ");
            ++line;
            ++count;
        }
    }
}
