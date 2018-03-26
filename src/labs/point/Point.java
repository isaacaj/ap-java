/**
 * ISAAC ASH-JOHNSON
 **/
package labs.point;

public class Point
{

    // Instance Variables
    public int x;
    public int y;

    // Constructors
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point p)
    {
        this(p.x, p.y);
    }

    public Point()
    {
        this(0, 0);
    }

    /**
     * Returns which quadrant of the x/y plane this Point
     * object falls in. Quadrant 1 contains all points
     * whose x and y values are both positive. Quadrant
     * 2 contains all points with negative x but positive y.
     * Quadrant 3 contains all points with negative x and y values.
     * Quadrant 4 contains all points with positive x but negative y.
     * If the point lies directly on the x and/or y axis, return 0.
     * bob.quadrant(); --> 2 (think test question)
     */
    public int quadrant()
    {
        if (x > 0 && y > 0) { return 1; } else if (x < 0 && y > 0) { return 2; } else if (x < 0 && y < 0)
        {
            return 3;
        } else if (x > 0 && y < 0) { return 4; } else { return 0; }
    }


    // Negates and swaps the x/y coordinates of the Point object.
    // For example, if an object pt initially represents the
    // point (5, -3), after a call of pt.flip(); , the object
    // should represent (3, -5). If the same object initially
    // represents the point (4, 17), after a call to pt.flip();,
    // the object should represent (-17, -4).
    public void flip()
    {
        int flip = this.x;
        this.x = -this.y;
        this.y = -flip;
    }


    // Modify the toString method in the Point class.
    // Make it return a string in the following format.
    // For example, if a Point object stored in a
    // variable pt represents the point (5, -17),
    // return the string:
    // x.toString() x
    // Point(x=5,y=-17)
    // If the client code were to call System.out.println(pt); ,
    // that text would be shown on the console.
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean isVertical(Point p)
    {
        return p.x == this.x;
    }

    public boolean isHorizontal(Point p)
    {
        return p.y == this.y;
    }

    public int manhattanDistance(Point p)
    {
        return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
    }

    public double slope(Point p)
    {
        if (this.x == p.x)
        {
            throw new IllegalArgumentException("Slope cannot be undefined!");
        }
        return (p.y - this.y) / (p.x - this.x);
    }

    public double distance(Point p)
    {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }
}

