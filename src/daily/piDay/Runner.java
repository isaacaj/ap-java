/**
 * ISAAC ASH-JOHNSON
 **/
package daily.piDay;

import labs.point.Point;
import util.NumScanner;

public class Runner
{
    public static void main(String[] args)
    {
        NumScanner numScanner = new NumScanner();
        Circle circle = new Circle();

        System.out.println("Radius\tCenter\tCircumference");
        System.out.println(circle.getRadius() + "\t" + circle.getCenter() + "\t" + circle.getCircumference());
        System.out.println("\n\nEnter a degree to calculate arc length: ");
        int degree = numScanner.nextInt();
        System.out.println("Arc Length:");
        System.out.println(circle.getArcLength(degree));
        System.out.println("Test if a point is within the circle:");
        System.out.println("x: ");
        int x = numScanner.nextInt();
        System.out.println("y: ");
        int y = numScanner.nextInt();
        System.out.println("Is in circle: " + circle.isPointInCircle(new Point(x, y)));
    }
}
