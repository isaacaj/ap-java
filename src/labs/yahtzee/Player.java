package labs.yahtzee;

public class Player
{
    private static int GLOBAL_ID = 0;

    private int score, rollsRemaining, roundsRemaining, playerID;

    public Player()
    {
        this.score = 0;
        this.rollsRemaining = 3;
        this.roundsRemaining = 13;
        this.playerID = GLOBAL_ID += 1;
    }

    public void decrementRolls()
    {
        this.rollsRemaining--;
    }

    public void decrementRounds()
    {
        this.roundsRemaining--;
    }

    public void endTurn()
    {
        decrementRounds();
        resetRolls();
    }

    private void resetRolls()
    {
        this.rollsRemaining = 3;
    }

    public void addPoints(int points)
    {
        this.score += points;
    }

    public int getScore()
    {
        return this.score;
    }

    public int getRollsRemaining()
    {
        return this.rollsRemaining;
    }

    public int getRoundsRemaining()
    {
        return this.roundsRemaining;
    }

    public int getPlayerID()
    {
        return this.playerID;
    }
}
