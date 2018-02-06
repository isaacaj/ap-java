package daily.day07;

import java.util.Scanner;
import experiments.CleanScanner;

public class GuessIA1
{
    static Scanner scanner = new Scanner(System.in);
    static int targetNum = (int) (Math.random()*100);

    public static void main(String[] args)
    {
        askForNum();
        evalGuess();
    }

    public static void askForNum()
    {
        System.out.println("\t G U E S S    A    N U M B E R\t\n");
        System.out.println("I am thinking of a number between 0 and 100...");
    }

    public static int getInput()
    {
        return CleanScanner.cleanNextInt("What number am I thinking of?", scanner);
    }

    private static void evalGuess()
    {
        int guess = getInput();
        if(guess == targetNum)
        {
            System.out.println("Correct! Well played, human.");
        }

        else if(guess < targetNum)
        {
            System.out.println("Your guess is too low. Guess again!");
            evalGuess();
        }

        else
        {
            System.out.println("Your guess is too high. Give it another go.");
            evalGuess();
        }
    }
}