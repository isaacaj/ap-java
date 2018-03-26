package chapters.ch7;

public class NumStarsIA1
{
    public static void main(String[] args)
    {
        numStars(7);
    }

    private static void numStars(int x)
    {
        int line = 0;
        int index = x;
        int count = 0;

        while (index > 0)
        {
            while (count < x)
            {
                while (line > 0)
                {
                    System.out.print("*");
                    --line;
                    ++count;
                }
                System.out.print(++count);
            }
            System.out.println();
            count = 0;
            line = --index;
        }
    }
}
