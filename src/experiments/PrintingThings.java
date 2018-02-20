package experiments;

/**
 * Created by 90304755 on 1/4/18.
 */
public class PrintingThings
{
    public static void main(String[] args)
    {
        int x = 4;
        int product = 1;
        while (x > 0)
        {
            System.out.println(product = x*product);
            x--;
        }
    }
}