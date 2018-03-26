package util;

import java.util.ArrayList;
import java.util.Arrays;

public class LoremIpsum
{
    public LoremIpsum() {}

    public String[] getFirstNames()
    {
        String[] firstNames = {
                "Aaron", "Benny", "Carol", "Denise", "Eleanor", "Fred", "Gentiana", "Harold", "Isaac", "Joey", "Katherine",
                "Lisa", "Mary", "Ned", "Ollie", "Patrick", "Quinn", "Rachel", "Stan", "Thomson", "Ulrond", "Victoria",
                "Winston", "X", "Yelena", "Zachary"
        };

        ArrayList<String> names = new ArrayList<>(Arrays.asList(firstNames));

        return names.toArray(firstNames);
    }
}