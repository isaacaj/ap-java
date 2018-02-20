package daily.day08;

import experiments.NumScanner;
import java.util.Scanner;

public class WhatSeason
{
    static Scanner scanner = new Scanner(System.in);
    static NumScanner numScanner = new NumScanner(scanner);

    public static void main(String[] args)
    {
        evalMonth();
    }

    private static int askMonth()
    {
        System.out.println("What is the month?");
        return numScanner.nextInt();
    }

    private static void evalMonth()
    {
        int month = askMonth();

        if (month >= 6 && month < 9)
        {
            System.out.println("It is summer.");
        }
        else if (month >= 9 && month < 12)
        {
            System.out.println("It is autumn.");
        }
        else if (month >= 1 && month < 3)
        {
            System.out.println("It is winter.");
        }
        else if (month >= 3 && month < 6)
        {
            System.out.println("It is spring.");
        }
        else
        {
            System.out.println("You have entered an invalid month.");
            evalMonth();
        }
    }


    private static int askDate()
    {
        System.out.println("What is the date?");
        return numScanner.nextInt();
    }

    private static int askYear()
    {
        System.out.println("What is the year?");
        return numScanner.nextInt();
    }
}
