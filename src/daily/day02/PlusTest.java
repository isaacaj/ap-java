package daily.day02;

// *******************************************************************
//   PlusTest.java
// 
//   Demonstrate the different behaviors of the + operator
// *******************************************************************

public class PlusTest
{
    // -------------------------------------------------
    // main prints some expressions using the + operator
    // -------------------------------------------------
    public static void main(String[] args)
    {
        // Concatenation of two strings using the `+` operator.
        System.out.println ("This is a long string that is the " +
                "concatenation of two shorter strings.");

        // Concatenation of a string, an int, and another string.
        // Will return another string.
        System.out.println ("The first computer was invented about" + 55 +
                "years ago.");

        // Concatenation of a string and two ints.
        // Will return a string, with each int being treated as a string as added from left to right.
        System.out.println ("8 plus 5 is " + 8 + 5);

        // Parenthesis eval. first, causes string to be:
        // "8 plus 5 is 13"
        System.out.println ("8 plus 5 is " + (8 + 5));

        // From left to right, ints get added first.
        // After int addition, ints concatenated into string.
        // Will return: "13 equals 8 plus 5."
        System.out.println (8 + 5 + " equals 8 plus 5.");
    }
}