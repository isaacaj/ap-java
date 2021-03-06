package chapters.ch2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time
{
    // Instantiate Date and DateFormat classes. Very useful.
    static Date date = new Date();
    static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args)
    {
        // Parse the bits of the formatted date into integers.
        int hrs = Integer.parseInt(dateFormat.format(date).substring(0, 2));
        int min = Integer.parseInt(dateFormat.format(date).substring(3, 5));
        int sec = Integer.parseInt(dateFormat.format(date).substring(6));

        final int SECS_PER_DAY = 86400;
        final int SECS_PER_MIN = 60;
        final int MIN_PER_HOUR = 60;

        int elapsedSecs = ((hrs * MIN_PER_HOUR * SECS_PER_MIN) + (min * SECS_PER_MIN) + sec); // number of seconds since midnight
        int remainingSecs = (SECS_PER_DAY - elapsedSecs);

        float percentDay = (float) elapsedSecs / SECS_PER_DAY * 100;

        // Prints the useful things.
        System.out.println(date + "\n");

        System.out.println(dateFormat.format(date));

        // Unnecessary check to ensure time is correct
        if (elapsedSecs + remainingSecs == SECS_PER_DAY)
        {
            System.out.println("\nSeconds since midnight: " + elapsedSecs);

            System.out.println("\nSeconds until midnight: " + remainingSecs); // 86400 is the num of secs in a day
        } else
        {
            System.out.println("Something went wrong! Calculations with seconds are incorrect.");
        }

        System.out.printf("\n%.1f", percentDay);
        System.out.println("% of the day has elapsed.");
    }
}