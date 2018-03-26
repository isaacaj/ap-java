package chapters.ch9;

import java.util.Random;

public class StringArrays
{
    static Random random = new Random();
    public static void main(String[] args)
    {
        String[] apples = {"Red Lady", "Honeycrisp", "Granny Smith"};
        printStringArray(apples);
        printStringArray(putToLower(apples));
        System.out.println(longestItem(apples));

        int[] nums = new int[1000];
        fillArrayRand(nums);

        System.out.println(isPerfect(apples));
    }

    private static void fillArrayRand(int[] nums)
    {
        for (int i = 0; i < 1000; i++)
            nums[i] = random.nextInt(1000) + 1;
    }

    private static void printStringArray(String[] words)
    {
        for (String word : words)
        {
            System.out.println(word);
        }
    }

    private static String[] putToLower(String[] words)
    {
        for (int i = 0; i < words.length; i++)
        {
            words[i] = words[i].toLowerCase();
        }

        return words;
    }

    private static String longestItem(String[] words)
    {
        String longest = words[0];
        for (String item : words)
        {
            if (longest.length() < item.length())
                longest = item;
        }

        return longest;
    }

    private static int wordsStartVowel(String[] words)
    {
        int count = 0;
        for (String word : words)
        {
            if (startsVowel(word))
                count++;
        }

        return count;
    }

    private static boolean startsVowel(String word)
    {
        char firstChar = word.charAt(0);
        return (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u');
    }

    private static boolean isPerfect(String[] words)
    {
        String prevWord = words[0];

        for (int i = 1; i < words.length; i++)
        {
            if (prevWord.length() > words[i].length())
            {
                return false;
            }

            prevWord = words[i];
        }

        return true;
    }
}
