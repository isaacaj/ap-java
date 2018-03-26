package chapters.ch7;

public class DrawRocketIA1
{
    public static void main(String[] args)
    {
        printTheWholeFlippinThingIHatedThisAssignmentPleaseNeverAssignAnythingThisMonotonousAndObnoxiousAgain(1);
    }

    private static void americanSpaceProgram()
    {
        printTheWholeFlippinThingIHatedThisAssignmentPleaseNeverAssignAnythingThisMonotonousAndObnoxiousAgain(300);
    }

    private static void dumbSovietSpaceTrash()
    {
        printTheWholeFlippinThingIHatedThisAssignmentPleaseNeverAssignAnythingThisMonotonousAndObnoxiousAgain(2);
    }

    private static void printTheWholeFlippinThingIHatedThisAssignmentPleaseNeverAssignAnythingThisMonotonousAndObnoxiousAgain(int numRockets)
    {
        for (int i = 0; i < numRockets; ++i)
        {
            printCone();
            connector();
            stageOne();
            stageTwo();
            connector();
            stageTwo();
            stageOne();
            connector();
            printCone();

            System.out.println("\n\n");
        }
    }

    private static void connector()
    {
        System.out.print("+");
        for (int sym = 0; sym < 12; ++sym)
        {
            if (sym % 2 == 0)
                System.out.print("=");
            else
                System.out.print("*");
        }
        System.out.println("+");
    }

    private static void printCone()
    {
        for (int row = 1; row <= 5; row++)
        {
            for (int i = 5; i >= row; i--)
                System.out.print(" ");
            for (int i = 1; i <= row; i++)
                System.out.print("/");

            System.out.print("**");

            for (int i = 1; i <= row; i++)
                System.out.print("\\");
            for (int i = 5; i >= row; i--)
                System.out.print(" ");

            System.out.println();
        }
    }

    private static void stageOne()
    {
        for (int row = 1; row <= 3; row++)
        {
            System.out.print("|");

            for (int column = 1; column <= 2; column++)
            {
                for (int i = 2; i >= row; i--)
                    System.out.print(".");
                for (int i = 1; i <= row; i++)
                    System.out.print("/\\");
                for (int i = 2; i >= row; i--)
                    System.out.print(".");
            }

            System.out.println("|");
        }
    }

    private static void stageTwo()
    {
        for (int row = 1; row <= 3; row++)
        {
            System.out.print("|");
            for (int column = 1; column <= 2; column++)
            {
                for (int i = 2; i <= row; i++)
                    System.out.print(".");
                for (int i = 3; i >= row; i--)
                    System.out.print("\\/");
                for (int i = 2; i <= row; i++)
                    System.out.print(".");
            }
            System.out.println("|");
        }
    }
}