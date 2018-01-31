package chapters.ch2;

public class Date
{

    public static void main(String[] args)
    {
        String day = "Monday";
        String month = "January";
        int date = 1;
        int year = 2018;

        System.out.println("AMERICAN FORMAT:\n");
        System.out.println(day + ", " + month + " " + date + ", " + year + "\n\n\n");
        System.out.println("EUROPEAN FORMAT:\n");
        System.out.println(day + " " + date + " " + month + " " + year);

    }

}
