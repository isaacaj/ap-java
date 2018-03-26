/** ISAAC ASH-JOHNSON **/
package daily.piDay;

import labs.point.Point;

public class Circle
{
    private double radius;
    private Point center;

    public Circle()
    {
        this(1.0, new Point());
    }

    public Circle(double radius, Point center)
    {
        this.radius = radius;
        this.center = center;
    }

    /**
     * Gets the radius of this Circle.
     *
     * @return Radius of the Circle Object.
     */
    public double getRadius()
    {
        return this.radius;
    }

    /**
     * Gets the diameter of this Circle, radius * 2.
     *
     * @return Diameter of the Circle Object.
     */
    public double getDiameter()
    {
        return 2 * this.radius;
    }

    /**
     * Gets the circumference of this Circle, diameter * PI.
     *
     * @return Circumference of the Circle Object.
     */
    public double getCircumference()
    {
        return getDiameter() * Math.PI;
    }

    /**
     * Gets the area of this Circle, radius^2 * PI.
     *
     * @return Area of the Circle Object.
     */
    public double getArea()
    {
        return this.radius * this.radius * Math.PI;
    }

    public Point getCenter()
    {
        return this.center;
    }

    /**
     * Gets an arc length of the specified degree, circumference * (degrees / 360).
     *
     * @param degrees
     * @return Arc length in relation to degrees and circumference.
     */
    public double getArcLength(double degrees)
    {
        return getCircumference() * (degrees/360);
    }

    /**
     * Tests if a point is within the Circle, OR along it's circumference.
     *
     * @param p: the point to be tested.
     * @return Circumference of the Circle Object.
     */
    public boolean isPointInCircle(Point p)
    {
        double distance = Math.hypot(p.x - this.center.x, p.y - this.center.y);

        return distance <= this.radius;
    }
}
