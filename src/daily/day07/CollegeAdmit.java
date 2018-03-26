package daily.day07;

import util.NumScanner;

import java.util.Scanner;

public class CollegeAdmit
{
    /*
     University admission program
     What is your GPA? 3.2
     What is your SAT score? 1280
     You were accepted!
     */
    static Scanner scanner = new Scanner(System.in);
    static NumScanner numScanner = new NumScanner();
    static double gpa = -1;
    static int sat = -1;

    public static void main(String[] args)
    {
        askGPA();
        askSAT(gpa);

        if (sat >= 1200) { System.out.println("You were accepted!"); }
        else { System.out.println("Hmm, maybe not."); }
    }

    private static void askGPA()
    {
        System.out.println("What is your GPA?");
        gpa = numScanner.nextDouble();
    }

    private static void askSAT(double GPA)
    {
        if(GPA < 3.0)
        {
            System.out.println("Maybe this college isn't for you.");
        }
        else
        {
            System.out.println("What is your SAT score?");
            sat = numScanner.nextInt();
        }
    }


}
