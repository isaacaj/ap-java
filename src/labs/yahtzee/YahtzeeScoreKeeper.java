package labs.yahtzee;

import labs.dice.Di;

public class YahtzeeScoreKeeper
{
    private Di[] hand;

    private final int FULL_HOUSE_POINT_VAL = 25;
    private final int SMALL_STRAIGHT_POINT_VAL = 30;
    private final int LARGE_STRAIGHT_POINT_VAL = 40;
    private final int YAHTZEE_POINT_VAL = 50;

    public YahtzeeScoreKeeper(Di[] hand)
    {
        this.hand = hand;
    }

    private int[] histogramDi()
    {
        int[] hist = new int[6];

        for (Di di : this.hand)
        {
            switch (di.getRoll())
            {
                case 1:
                    hist[0]++;
                    break;
                case 2:
                    hist[1]++;
                    break;
                case 3:
                    hist[2]++;
                    break;
                case 4:
                    hist[3]++;
                    break;
                case 5:
                    hist[4]++;
                    break;
                case 6:
                    hist[5]++;
                    break;
            }
        }

        return hist;
    }

    public int sumOfHand()
    {
        int sum = 0;

        for (Di di : hand)
        {
            sum += di.getRoll();
        }

        return sum;
    }

    public int optimalScore(Di[] hand)
    {
        this.hand = hand;

        return Math.max(getOptimalLowerBoxScore(), getOptimalUpperBoxScore());
    }

    //UPPER BOX
    public int acesValue() { return histogramDi()[0]; }

    public int twosValue() { return histogramDi()[1] * 2; }

    public int threesValue() { return histogramDi()[2] * 3; }

    public int foursValue() { return histogramDi()[3] * 4; }

    public int fivesValue() { return histogramDi()[4] * 5; }

    public int sixesValue() { return histogramDi()[5] * 6; }

    /**
     * Finds the largest scoring option for the upper box.
     *
     * @return highest upper box value
     */
    public int getOptimalUpperBoxScore()
    {
        // spaghetti code, serves it's purpose.
        return Math.max(Math.max(Math.max(acesValue(), twosValue()), Math.max(threesValue(), foursValue())), Math.max(fivesValue(), sixesValue()));
    }

    // LOWER BOX
    public boolean isThreeOfAKind()
    {
        for (int i : histogramDi())
        {
            if (i == 3)
            {
                return true;
            }
        }

        return false;
    }

    public boolean isFourOfAKind()
    {
        for (int i : histogramDi())
        {
            if (i == 4)
            {
                return true;
            }
        }

        return false;
    }

    public boolean isFullHouse()
    {
        boolean isThree = false, isTwo = false;

        for (int i : histogramDi())
        {
            if (i == 3)
            {
                isThree = true;
            }

            if (i == 2)
            {
                isTwo = true;
            }
        }

        return isThree && isTwo;
    }

    public int getFullHouseValue() { return FULL_HOUSE_POINT_VAL; }

    public boolean isSmallStraight()
    {
        int uniqueRollCounter = 0;

        for (int i : histogramDi())
        {
            if (i == 1)
            {
                uniqueRollCounter++;
            }
        }

        return uniqueRollCounter == 4;
    }

    public int getSmallStraightValue() { return SMALL_STRAIGHT_POINT_VAL; }

    public boolean isLargeStraight()
    {
        int uniqueRollCounter = 0;

        for (int i : histogramDi())
        {
            if (i == 1)
            {
                uniqueRollCounter++;
            }
        }

        return uniqueRollCounter == 5;
    }

    public int getLargeStraightValue() { return LARGE_STRAIGHT_POINT_VAL; }

    public boolean isYahtzee()
    {
        int firstDi = hand[0].getRoll();

        for (int di = 1; di < hand.length; di++)
        {
            if (hand[di].getRoll() != firstDi)
            {
                return false;
            }
        }

        return true;
    }

    public int getYahtzeeValue() { return YAHTZEE_POINT_VAL; }

    public int getOptimalLowerBoxScore()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("You got... ");

        if (isYahtzee())
        {
            builder.append("YAHTZEE!");
            System.out.println(builder.toString());
            return 50;
        } else if (isLargeStraight())
        {
            builder.append("LARGE STRAIGHT!");
            System.out.println(builder.toString());
            return 40;
        } else if (isSmallStraight())
        {
            builder.append("SMALL STRAIGHT!");
            System.out.println(builder.toString());
            return 30;
        } else if (isFullHouse())
        {
            builder.append("FULL HOUSE!");
            System.out.println(builder.toString());
            return 25;
        } else if (isFourOfAKind())
        {
            builder.append("FOUR OF A KIND!");
            System.out.println(builder.toString());
            return sumOfHand();
        } else if (isThreeOfAKind())
        {
            builder.append("THREE OF A KIND!");
            System.out.println(builder.toString());
            return sumOfHand();
        } else
        {
            builder.append("You do not have any lower box scoring options.");
            System.out.println(builder.toString());
            return 0;
        }
    }
}
