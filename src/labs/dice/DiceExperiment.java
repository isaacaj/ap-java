package labs.dice;

import java.util.Arrays;

public class DiceExperiment
{
    private static Di di1 = new Di();
    private static Di di2 = new Di();

    public static void main(String[] args)
    {
        int[] doublesHist = new int[6];

        for (int i = 0; i < 500; i++)
        {
            di1.reroll();
            di2.reroll();

            if (di1.getRoll() == di2.getRoll())
            {
                doublesHist[di1.getRoll() - 1]++;
            }
        }

        System.out.println(Arrays.toString(doublesHist));
    }
}
