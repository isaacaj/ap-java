package labs.dice;

import java.util.Random;

public class Di
{
    private Random r = new Random();
    private boolean selected = false;
    private int roll;

    public Di()
    {
        this.roll = r.nextInt(6) + 1;
    }

    /**
     * "Re-rolls" the di, generating a new random number.
     *
     * @return random integer between 1 and 6
     */
    public int reroll()
    {
        return this.roll = r.nextInt(6) + 1;
    }

    /**
     * Gets the current number displayed on the di.
     *
     * @return current state of di
     */
    public int getRoll()
    {
        return this.roll;
    }

    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }

    public boolean getSelected()
    {
        return this.selected;
    }

    public void rollIfSelected()
    {
        if (selected)
        {
            reroll();
        }
    }

    public String toString()
    {
        return "" + getRoll();
    }
}
