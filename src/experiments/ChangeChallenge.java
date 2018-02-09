package experiments;

import experiments.NumScanner;
import java.util.Scanner;

public class ChangeChallenge
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final int pennies = NumScanner.cleanNextInt("How many pennies do you have?", scanner);
        final int nickels = NumScanner.cleanNextInt("How many nickels do you have?", scanner);
        final int change = NumScanner.cleanNextInt("How much change needs to be made?", scanner);

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
