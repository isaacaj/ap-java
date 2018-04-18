package chapters.ch10;

import java.awt.*;

public class AliasingTest
{
    public static void main(String[] args)
    {
        Rectangle rectangle = new Rectangle(0, 0, 2, 2);
        Rectangle a_rectangle = rectangle;

        System.out.println(getArea(rectangle));
        a_rectangle.grow(4, 4);
        System.out.println(getArea(rectangle));
    }


    private static double getArea(Rectangle r)
    {
        return r.height * r.width;
    }
}
