package experiments;

import java.util.Scanner;

public class ChangeChallenge
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        NumScanner numScanner = new NumScanner(scanner);

        System.out.println("How many pennies do you have?");
        final int pennies = numScanner.nextInt();

        System.out.println("How many nickels do you have?");
        final int nickels = numScanner.nextInt();

        System.out.println("How much change do you need?");
        final int change = numScanner.nextInt();

        if (makeChange(pennies, nickels, change))
        { System.out.println("You have enough coins to make change."); }

        else
        { System.out.println("Uh oh. You don't have enough change."); }
    }

    // pennies, nickels, and change all must be positive integers
    private static boolean makeChange(int pennies, int nickels, int change)
    {
        return !(nickels == 0 && change > 0) && !(change % (nickels*5) - pennies > 0) && (change - (nickels*5) - pennies <= 0);
    }
}
