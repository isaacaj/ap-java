package daily.day05;

import util.NumScanner;

import java.util.Scanner;

public class IfElseDemo
{
    static Scanner scanner = new Scanner(System.in);
    static NumScanner numScanner = new NumScanner();
    static String name;
    static int age;

    public static void main(String[] args)
    {
        System.out.println("Hello! What is your name?");
        name = scanner.nextLine();
        System.out.println("Alright, " + name + ". How old are you?");
        age = numScanner.nextInt();
        giveAdvice(age, name);
    }

    private static void giveAdvice(int age, String name)
    {
        if (age <= 15)
            System.out.println("Ha, you're barely considered a citizen!");
        else if (age <= 17)
            System.out.println("How's the drivers license treating you, " + name + "?");
        else if (age >= 18)
            System.out.println("Brush up on your politics, you'll be voting in the next election!");
    }
}