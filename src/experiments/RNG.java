package experiments;

import java.util.Arrays;

public class RNG
{
    public static void main(String[] args)
    {
        int[] randomNumsTo100 = new int[100];
        int[] histogram = new int[100];

        for (int i = 0; i < randomNumsTo100.length; i++)
        {
            randomNumsTo100[i] = (int) (100 * Math.random());
        }

        System.out.println(Arrays.toString(randomNumsTo100));

        for (int i : randomNumsTo100)
        {
            histogram[i]++;
        }

        System.out.println(Arrays.toString(histogram));
    }
}
