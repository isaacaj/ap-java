package chapters.ch8;

public class EightIA1
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(minimumArray(nums));
        System.out.println(maximumArray(nums));
        System.out.println(minimumArrayIndex(nums));
        System.out.println(maximumArrayIndex(nums));
        System.out.println(isPrime(15));
    }

    private static int indexOfMax(int[] nums)
    {
        int max = nums[0];
        for (int number : nums)
        {
            if (number > max)
            {
                max = number;
            }
        }

        return max;
    }

    private static boolean[] sieve(int n)
    {
        boolean[] possiblePrimes = new boolean[n];

        for (int i = 0; i < n; i++)
        {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0)
            {
                possiblePrimes[i] = true;
            }
        }

        return possiblePrimes;
    }

    private static boolean areFactors(int n, int[] nums)
    {
        for (int num : nums)
        {
            if (n % num != 0)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean arePrimeFactors(int n, int[] nums)
    {
        return false;
    }

    private static boolean isPrime(int number)
    {
        for (int i = number - 1; i > 1; i--)
        {
            if (number % i == 0)
                return false;
        }

        return true;
    }

    private static int maximumArray(int[] nums)
    {
        int max = nums[0];
        for (int number : nums)
        {
            if (number > max)
                max = number;
        }

        return max;
    }

    private static int minimumArray(int[] nums)
    {
        int min = nums[0];
        for (int number : nums)
        {
            if (number < min)
                min = number;
        }

        return min;
    }

    private static int minimumArrayIndex(int[] nums)
    {
        int minIndex = 0;
        for (int number = 0; number < nums.length; number++)
        {
            if (nums[number] < nums[minIndex])
                minIndex = number;
        }

        return minIndex;
    }

    private static int maximumArrayIndex(int[] nums)
    {
        int maxIndex = 0;
        for (int index = 0; index < nums.length; index++)
        {
            if (nums[index] > nums[maxIndex])
                maxIndex = index;
        }

        return maxIndex;
    }
}
