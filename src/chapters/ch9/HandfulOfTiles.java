package chapters.ch9;

public class HandfulOfTiles
{
    public static void main(String[] args)
    {
        String[] tiles = {"a", "b", "b", "a", "a", "a"};
        String word = "bcaggg";

        System.out.println(isSpellable(tiles, word));
    }

    private static boolean isSpellable(String[] tiles, String word)
    {
        int correctLetters = 0;

        for (int i = 0; i < word.length(); i++)
        {
            System.out.println("Starting first FOR: " + i);
            for (int j = 0; j < tiles.length; j++)
            {
                System.out.println("Starting second FOR: " + j);
                if (!(tiles[j].charAt(0) == '_'))
                {
                    System.out.println("This tile has not been used.");
                    if (tiles[j].equalsIgnoreCase(word.substring(i, 1 + i)))
                    {
                        System.out.println("This tile (" + tiles[j] + ") == " + i + "th letter in word (" + word.substring(i, 1 + i) + "). +1");
                        tiles[j] = "_";
                        correctLetters++;
                    } else
                    {
                        System.out.println("This tile (" + tiles[j] + ") != " + i + "th letter in word (" + word.substring(i, 1 + i) + "). ");
                    }
                } else
                {
                    System.out.println("This tile has been used already :(");
                }
            }
        }

        System.out.println("\nCorrect letters = " + correctLetters + "\t Word length = " + word.length());

        return correctLetters == word.length();
    }
}
