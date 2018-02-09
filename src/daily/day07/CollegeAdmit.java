package daily.day07;

import java.util.Scanner;
import experiments.NumScanner;

public class CollegeAdmit
{
    /*
     University admission program
     What is your GPA? 3.2
     What is your SAT score? 1280
     You were accepted!
     */
    static Scanner scanner = new Scanner(System.in);

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
        gpa = NumScanner.cleanNextDouble("What is your GPA?", scanner);
    }

    private static void askSAT(double GPA)
    {
        if(GPA < 3.0)
        {
            System.out.println("Maybe this college isn't for you.");
        }
        else
        {
            sat = NumScanner.cleanNextInt("What is your SAT score?", scanner);
        }
    }


}
