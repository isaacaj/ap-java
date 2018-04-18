package daily.day07;

public class JuiceIA1
{
    public static void main(String[] args)
    {
        for (int bottles = 99; bottles > 0; --bottles)
        {
            System.out.println(bottles + " bottles of juice on the wall,");
            System.out.println(bottles + " bottles of juice!");
            System.out.println("ya' take one down, ya' pass it around");
            System.out.println(bottles + " bottles of juice on the wall!\n");
        }

        System.out.println("\n\nNo bottles of juice on the wall,");
        System.out.println("No bottles of juice,");
        System.out.println("ya' can't take one down, ya' can't pass it around");
        System.out.println("'cause there are no more bottles of juice on the wall!");
    }
}
