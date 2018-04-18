package experiments;

import java.util.Arrays;

/**
 * Created by 90304755 on 1/4/18.
 */
public class PrintingThings
{
    public static void main(String[] args)
    {
        String[] spaces = {"apple", "banana", null, "thing", null, null, "cherry", "fruit", "potato", null, "cheesy"};

        for (int i = 0; i < spaces.length - 1; i++)
        {
            if (spaces[i] == null && (i != spaces.length - 2))
            {
                for (int j = i; j < spaces.length - 1; j++)
                {
                    String swap = spaces[j];
                    spaces[j] = spaces[j+1];
                    spaces[j+1] = swap;

                    System.out.println(Arrays.toString(spaces));
                }

                i--;
            }
        }
    }
}