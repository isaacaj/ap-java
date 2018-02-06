package experiments;

import java.util.Scanner;

public class CleanScanner
{
    public static int cleanNextInt(Scanner scanner)
    {
        if (scanner.hasNextInt())
        {
            return scanner.nextInt();
        }

        else
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
        }

        else
        {
            System.out.println("Please enter an integer.");
            scanner.nextLine();
            return cleanNextInt(prompt, scanner);
        }
    }
}