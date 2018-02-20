package experiments;

import java.util.Scanner;

public class NumScanner
{
    Scanner _scanner;

    public NumScanner(Scanner scanner) { this._scanner = scanner; }

    public double nextDouble()
    {
        if (_scanner.hasNextDouble())
        {
            return _scanner.nextDouble();
        } else
        {
            System.out.println("Please enter an integer or decimal value.");
            _scanner.nextLine();
            return nextDouble();
        }
    }

    public double nextDouble(String prompt)
    {
        if (_scanner.hasNextDouble())
        {
            return _scanner.nextDouble();
        } else
        {
            System.out.println("Please enter an integer or decimal value.");
            _scanner.nextLine();
            return nextDouble(prompt);
        }
    }

    public int nextInt()
    {
        if (_scanner.hasNextInt())
        {
            return _scanner.nextInt();
        } else
        {
            System.out.println("Please enter an integer.");
            _scanner.nextLine();
            return nextInt();
        }
    }

    public int nextInt(String prompt)
    {
        if (_scanner.hasNextInt())
        {
            return _scanner.nextInt();
        } else
        {
            System.out.println("Please enter an integer.");
            _scanner.nextLine();
            return nextInt(prompt);
        }
    }
}