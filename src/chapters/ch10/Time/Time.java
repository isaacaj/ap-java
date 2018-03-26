package chapters.ch10.Time;

class Time
{
    private int hours, mins, secs;

    Time()
    {
        this.hours = 0;
        this.mins = 0;
        this.secs = 0;
    }

    Time(int hours, int mins, int secs)
    {
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
    }

    @Override
    public String toString()
    {
        return hours + ":" + mins + ":" + secs;
    }

    public boolean equals(Time other)
    {
        return this.hours == other.hours
                && this.mins == other.mins
                && this.secs == other.secs;
    }
}
