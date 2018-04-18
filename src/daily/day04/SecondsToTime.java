package daily.day04;

import java.util.Scanner;

public class SecondsToTime
    /*
        Given a random number of seconds,
        display the time (24hr)
     */
{
    static Scanner scanner = new Scanner(System.in);
    static int secs;

    public static void main(String[] args)
    {
        getSecs();
        convertTime();
    }

    private static void getSecs()
    {
        System.out.println("How many seconds would you like to turn into a time?");
        getCleanScan();
    }

    private static void getCleanScan()
    {
        if (scanner.hasNextInt())
        {
            int num = scanner.nextInt();

            if (num >= 0)
            {
                secs = num;
                scanner.nextLine();
            } else
            {
                System.out.println("Please input an integer between 0 and 86400.");
                scanner.nextLine();
                getCleanScan();
            }
        } else
        {
            System.out.println("Please input an integer.");
            scanner.nextLine();
            getSecs();
        }
    }

    private static void convertTime()
    {
        int hrs = secs / (60 * 60);
        int min = (secs % (60 * 60)) / 60;
        int sec = (secs % (60 * 60)) % 60;
        System.out.println(hrs + ":" + min + ":" + sec);
    }
}
