package daily.day03;

import java.util.Scanner;

public class LunarEclipseSurvey
{
    private static Scanner scanner = new Scanner(System.in);

    static int numPeople;
    static String[] people;
    static String[] response;

    public static void main(String[] args)
    {
        System.out.println("How many people need to be surveyed?");
        numPeople = scanner.nextInt();
        people = new String[numPeople];
        response = new String[numPeople];
        scanner.nextLine();
        for (int i = 0; i < numPeople; i++)
        {
            poll(i);
        }

        for (int j = 0; j < numPeople; j++)
        {
            System.out.println(people[j] + "\t| seen eclipse? |\t" + response[j]);
        }
    }

    private static String getName()
    {
        return scanner.nextLine();
    }

    private static String hasSeenEclipse()
    {
        return scanner.nextLine();
    }

    public static void poll(int item)
    {
        System.out.println("What is your name?");
        String name = getName();
        System.out.println("Have you ever seen a lunar eclipse?");
        String seenEclipse = hasSeenEclipse();

        people[item] = name;
        response[item] = seenEclipse;
    }
}
