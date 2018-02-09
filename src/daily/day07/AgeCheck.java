package daily.day07;

public class AgeCheck {

    static int myAge = 19;   // I am 19; let me see if I can drive
    public static void main(String[] args) {
        message(myAge);
    }

    // Displays message about driving to user based on given age
    private static void message(int age) {
        if (myAge >= 16) {
            System.out.println("I'm old enough to drive!");
        }
        else {
            System.out.println("Not old enough yet... :*(");
        }
    }
}