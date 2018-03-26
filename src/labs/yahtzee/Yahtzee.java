package labs.yahtzee;

import labs.dice.Di;
import util.NumScanner;

public class Yahtzee
{
    private Player[] players;
    private Di[] dice = new Di[5];
    private int keptDice = 0;
    private NumScanner scanner = new NumScanner();
    private YahtzeeScoreKeeper scoreKeeper;

    Yahtzee()
    {
        for (int i = 0; i < dice.length; i++)
        {
            dice[i] = new Di();
        }
    }

    public void start()
    {
        players = new Player[askNumberOfPlayers()];

        for (int player = 0; player < players.length; player++)
        {
            players[player] = new Player();
        }
    }

    public void turn()
    {
        while (players[players.length - 1].getRoundsRemaining() > 0)
        {
            for (int player = 0; player < players.length; player++)
            {
                System.out.println("\nPLAYER " + (player + 1) + "'s TURN: " + players[player].getScore() + "pts");
                rollAll();
                players[player].decrementRolls();
                System.out.println("Your initial roll contains: " + hand() + "\n");
                displayScoringOptions();
                askNumberOfKeptDice();

                if (keptDice < 5)
                {
                    players[player].decrementRolls();

                    selectDiceToReroll();

                    printSelectedDice(dice);

                    rollSelectedDice();

                    System.out.println("Your second roll contains: " + hand() + "\n");

                    displayScoringOptions();

                    keptDice = 0;

                    askNumberOfKeptDice();

                    if (keptDice < 5)
                    {
                        players[player].decrementRolls();

                        selectDiceToReroll();

                        printSelectedDice(dice);

                        rollSelectedDice();

                        System.out.println("Your second roll contains: " + hand() + "\n");

                        displayScoringOptions();

                        keptDice = 0;
                    }
                }

                players[player].addPoints(scoreKeeper.optimalScore(dice));
                players[player].decrementRounds();

                System.out.println("END TURN");
            }
        }
    }

    public void recordScores()
    {

    }

    private void rollAll()
    {
        for (Di di : dice)
        {
            di.reroll();
        }
    }

    private void displayScoringOptions()
    {
        System.out.println("If you keep your current hand, these are your scoring options...\n");
        displayUpperScoringPossibilities();
        displayLowerScoringPossibilities();
    }

    private void displayUpperScoringPossibilities()
    {
        scoreKeeper = new YahtzeeScoreKeeper(dice);

        String scoringOptions = "UPPER BOX:" +
                "\nAces:\t" + scoreKeeper.acesValue() +
                "\nTwos:\t" + scoreKeeper.twosValue() +
                "\nThrees:\t" + scoreKeeper.threesValue() +
                "\nFours:\t" + scoreKeeper.foursValue() +
                "\nFives:\t" + scoreKeeper.fivesValue() +
                "\nSixes:\t" + scoreKeeper.sixesValue();

        System.out.println(scoringOptions);
    }

    private void displayLowerScoringPossibilities()
    {
        scoreKeeper = new YahtzeeScoreKeeper(dice);

        String scoringOptions = "\nLOWER BOX:" +
                "\nThree of a kind: \t" + (scoreKeeper.isThreeOfAKind() ? scoreKeeper.sumOfHand() : 0) +
                "\nFour of a kind: \t" + (scoreKeeper.isFourOfAKind() ? scoreKeeper.sumOfHand() : 0) +
                "\nFull House: \t" + (scoreKeeper.isFullHouse() ? scoreKeeper.getFullHouseValue() : 0) +
                "\nSmall Straight: \t" + (scoreKeeper.isSmallStraight() ? scoreKeeper.getSmallStraightValue() : 0) +
                "\nLarge Straight: \t" + (scoreKeeper.isLargeStraight() ? scoreKeeper.getLargeStraightValue() : 0) +
                "\nYahtzee: \t" + (scoreKeeper.isYahtzee() ? scoreKeeper.getYahtzeeValue() : 0) +
                "\nChance: \t" + scoreKeeper.sumOfHand();

        System.out.println(scoringOptions);
    }

    private void askNumberOfKeptDice()
    {
        System.out.print("How many dice would you like to keep? (0-5)\t");
        keptDice = scanner.nextInt();

        if (keptDice < 0 || keptDice > 5)
        {
            askNumberOfKeptDice();
        }
    }

    private int askNumberOfPlayers()
    {
        System.out.print("How many players would like to play?\t");
        return scanner.nextInt();
    }

    private void selectDiceToReroll()
    {
        for (int i = 0; i < 5 - keptDice; i++)
        {
            int di;

            System.out.print("Which di would you like to re-roll? (1-5)\t");
            di = scanner.nextInt();

            while (di < 1 || di > 5)
            {
                System.out.println("Please select a di. (1-5)\t");
                di = scanner.nextInt();
            }

            dice[di - 1].setSelected(true);
        }
    }

    private void rollSelectedDice()
    {
        for (Di di : dice)
        {
            di.rollIfSelected();
        }
    }

    private void deselectAllDice()
    {
        for (Di di : dice)
        {
            di.setSelected(false);
        }
    }

    private void printSelectedDice(Di[] hand)
    {
        StringBuilder builder = new StringBuilder();

        builder.append("You have selected: ");
        for (Di di : hand)
        {
            if (di.getSelected())
            {
                builder.append(di.getRoll() + " ");
            }
        }

        System.out.println(builder.toString());
    }

    private String hand()
    {
        StringBuilder hand = new StringBuilder();
        for (Di di : dice)
        {
            hand.append(di).append(" ");
        }

        return hand.toString();
    }
}
