package util;

import java.util.Scanner;

public class NumScanner
{
    private Scanner scanner = new Scanner(System.in);

    public NumScanner() { }

    public double nextDouble()
    {
        if (scanner.hasNextDouble())
        {
            return scanner.nextDouble();
        } else
        {
            System.out.println("Please enter an integer or decimal value.");
            scanner.nextLine();
            return nextDouble();
        }
    }

    public double nextDouble(String prompt)
    {
        if (scanner.hasNextDouble())
        {
            return scanner.nextDouble();
        } else
        {
            System.out.println(prompt + "\n");
            System.out.println("Please enter an integer or decimal value.");
            scanner.nextLine();
            return nextDouble(prompt);
        }
    }

    public int nextInt()
    {
        if (scanner.hasNextInt())
        {
            return scanner.nextInt();
        } else
        {
            System.out.println("Please enter an integer.");
            scanner.nextLine();
            return nextInt();
        }
    }

    public int nextInt(String prompt)
    {
        if (scanner.hasNextInt())
        {
            return scanner.nextInt();
        } else
        {
            System.out.println(prompt + "\n");
            System.out.println("Please enter an integer.");
            scanner.nextLine();
            return nextInt(prompt);
        }
    }
}