package daily.day07;

import util.NumScanner;
import java.util.Scanner;

public class FermatIA1
{

    static Scanner scanner = new Scanner(System.in);
    static NumScanner numScanner = new NumScanner();

    public static void main(String[] args)
    {
        System.out.println("a = ?");
        int a = numScanner.nextInt();

        System.out.println("b = ?");
        int b = numScanner.nextInt();

        System.out.println("c = ?");
        int c = numScanner.nextInt();

        System.out.println("n = ?");
        int n = numScanner.nextInt();

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
