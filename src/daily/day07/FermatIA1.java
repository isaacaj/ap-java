package daily.day07;

import experiments.NumScanner;
import java.util.Scanner;

public class FermatIA1
{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int a = NumScanner.cleanNextInt("a = ?", scanner);
        int b = NumScanner.cleanNextInt("b = ?", scanner);
        int c = NumScanner.cleanNextInt("c = ?", scanner);
        int n = NumScanner.cleanNextInt("n = ?", scanner);

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
