package chapters.ch10.Time;

public class TimeRunner
{
    public static void main(String[] args)
    {
        Time now = new Time(9, 11, 33);
        Time begin = new Time();

        System.out.println(now);
        System.out.println(now.equals(begin));
    }
}
