package chapters.ch10;

import labs.dice.Di;

import java.util.Arrays;

public class NumCubeRuns
{
    public static void main(String[] args)
    {
        Di di = new Di();
        int[] ting = new int[10];

        ting = rollsToArray(di, ting.length);
        System.out.println(Arrays.toString(ting));

        System.out.println(getLongestRun(ting));
    }

    private static int[] rollsToArray(Di di, int numRolls)
    {
        int[] rolls = new int[numRolls];

        for (int i = 0; i < numRolls; i++)
        {
            rolls[i] = di.reroll();
        }

        return rolls;
    }

    private static int getLongestRun(int[] values)
    {
        int currentRun = 0, longestRun = 0, longestRunIndex = -1;

        if (values.length <= 1)
            return -1;

        for (int roll = 0; roll < values.length - 1; roll++)
        {
            if (values[roll] == values[roll + 1])
            {
                currentRun++;

                if (currentRun > longestRun)
                {
                    longestRun = currentRun;
                    longestRunIndex = roll - currentRun + 1;
                }
            } else
            {
                currentRun = 0;
            }
        }

        return longestRunIndex;
    }
}
