package chapters.ch10.miscPractice;

import java.util.Arrays;
import java.util.List;

public class ArrayPractice
{
    public static void main(String[] args)
    {
        testOne();
    }

    private static void testOne()
    {
        int[] list = {1, 2, 2, 2, 4, 4, 1, 0};

        System.out.println(Arrays.toString(remove(list, 2)));
        System.out.println(Arrays.toString(removeAll(list, 2)));

    }

    private static int[] remove(int[] list, int index)
    {
        List<int[]> newList = Arrays.asList(list);
        int[] newArray = new int[list.length - 1];

        newList.remove(index);

        return list;
    }

    private static int[] removeAll(int[] list, int item)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == item)
            {
                list = remove(list, list[i]);
                i--;
            }
        }

        return list;
    }
}
