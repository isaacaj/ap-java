package experiments;

import java.util.Scanner;

public class NumScanner
{

    //TODO: Constructors are pretty cool

    public static double cleanNextDouble(Scanner scanner)
    {
        if (scanner.hasNextDouble())
        {
            return scanner.nextDouble();
        } else
        {
            System.out.println("Please enter an integer or decimal value.");
            scanner.nextLine();
            return cleanNextDouble(scanner);
        }
    }

    public static double cleanNextDouble(String prompt, Scanner scanner)
    {
        System.out.println(prompt);
        if (scanner.hasNextDouble())
        {
            return scanner.nextDouble();
        } else
        {
            System.out.println("Please enter an integer or decimal value.");
            scanner.nextLine();
            return cleanNextDouble(prompt, scanner);
        }
    }

    public static int cleanNextInt(Scanner scanner)
    {
        if (scanner.hasNextInt())
        {
            return scanner.nextInt();
        } else
        {
            System.out.println("Please enter an integer.");
            scanner.nextLine();
            return cleanNextInt(scanner);
        }
    }

    public static int cleanNextInt(String prompt, Scanner scanner)
    {
        System.out.println(prompt);
        if (scanner.hasNextInt())
        {
            return scanner.nextInt();
        } else
        {
            System.out.println("Please enter an integer.");
            scanner.nextLine();
            return cleanNextInt(prompt, scanner);
        }
    }

    public static int cleanNextInt(String prompt, Scanner scanner, int lowerLimit, int upperLimit)
    {
        System.out.println(prompt);
        if (scanner.hasNextInt() && scanner.nextInt() >= lowerLimit && scanner.nextInt() <= upperLimit)
        {
            return scanner.nextInt();
        } else
        {
            System.out.println("Please enter an integer between the indicated range. (" + lowerLimit + ", " + upperLimit + ")");
            scanner.nextLine();
            return cleanNextInt(prompt, scanner, lowerLimit, upperLimit);
        }
    }
}