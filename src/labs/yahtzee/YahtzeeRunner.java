package labs.yahtzee;

public class YahtzeeRunner
{
    public static void main(String[] args)
    {
        Yahtzee game = new Yahtzee();

        game.start();
        game.turn();
    }
}
