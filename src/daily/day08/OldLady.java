package daily.day08;

public class OldLady
{
    public static void main(String[] args)
    {
        fly(true);
        spider(true);
        bird(true);
        cat(true);
        dog(true);
        wolf(true);
        horse(true);
    }

    private static void fly(boolean isFirst)
    {
        if (isFirst)
        {
            System.out.println("There was an old woman who swallowed a fly,\n" +
                    "I don't know why she swallowed that fly," +
                    "Perhaps she'll die.\n\n");
        } else
        {
            System.out.println("I don't know why she swallowed that fly,\n" + "Perhaps she'll die.\n\n");
        }
    }

    private static void spider(boolean isFirst)
    {
        if (isFirst)
        {
            System.out.println("There was an old woman who swallowed a spider,\n" +
                    "That wriggled and jiggled and tickled inside her.");

            spider(false);
        } else
        {
            System.out.println("She swallowed the spider to catch the fly,");
            fly(false);
        }
    }

    private static void bird(boolean isFirst)
    {
        if (isFirst)
        {
            System.out.println("There was an old woman who swallowed a bird,\n" +
                    "How absurd to swallow a bird.");

            bird(false);
        } else
        {
            System.out.println("She swallowed the bird to catch the spider,");
            spider(false);
        }
    }

    private static void cat(boolean isFirst)
    {
        if (isFirst)
        {
            System.out.println("There was an old woman who swallowed a cat,\n" +
                    "Imagine that to swallow a cat.");

            cat(false);
        } else
        {
            System.out.println("She swallowed the cat to catch the bird,");
            bird(false);
        }
    }

    private static void dog(boolean isFirst)
    {
        if (isFirst)
        {
            System.out.println("There was an old woman who swallowed a dog,\n" +
                    "What a hog to swallow a dog.");

            dog(false);
        } else
        {
            System.out.println("She swallowed the dog to catch the cat,");
            cat(false);
        }
    }

    private static void wolf(boolean isFirst)
    {
        if (isFirst)
        {
            System.out.println("There was an old woman who swallowed a wolf,\n" +
                    "What an appetite to swallow a wolf.");

            wolf(false);
        } else
        {
            System.out.println("She swallowed the wolf to catch the dog,");
            dog(false);
        }
    }

    private static void horse(boolean isFirst)
    {
        System.out.println("There was an old woman who swallowed a horse,\n" +
                "She died of course");
    }
}
