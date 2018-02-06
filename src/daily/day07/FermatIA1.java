package daily.day07;

import experiments.CleanScanner;
import java.util.Scanner;

public class FermatIA1
{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int a = CleanScanner.cleanNextInt("a = ?", scanner);
        int b = CleanScanner.cleanNextInt("b = ?", scanner);
        int c = CleanScanner.cleanNextInt("c = ?", scanner);
        int n = CleanScanner.cleanNextInt("n = ?", scanner);

        if (Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n) && n > 2)
        {
            System.out.println(Math.pow(a, n) + " + " + Math.pow(b, n) + " = " + Math.pow(c, n));
            System.out.println("Holy smokes, Fermat was wrong!");
        }

        else
        {
            System.out.println(Math.pow(a, n) + " + " + Math.pow(b, n) + " = " + (Math.pow(a, n) + Math.pow(b, n)));
            System.out.println("c^n = " + Math.pow(c, n));
            System.out.println("No, that doesn't work.");
        }
    }
}
