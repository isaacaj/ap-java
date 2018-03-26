package chapters.ch10;

import util.LoremIpsum;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListNames
{
    static LoremIpsum ipsum = new LoremIpsum();

    public static void main(String[] args)
    {
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> fullName = new ArrayList<>();

        System.out.println(firstNames);
    }
}
