package chapters.ch9;

import java.util.Random;

public class Histogram
{
    public static void main(String[] args)
    {
        int[] nums = new int[1000];
        fill(nums);


    }

    private static int[] fill(int[] nums)
    {
        Random random = new Random();

        for (int i = 0; i < nums.length; i++)
            nums[i] = random.nextInt(100);

        return nums;
    }

    private static int[] createHistogram(int[] nums)
    {
        int[] histogram = new int[100];

        for (int num : nums)
        {
            histogram[num]++;
        }

        return histogram;
    }
}
