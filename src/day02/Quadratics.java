package day02;

public class Quadratics
{
    public static void main(String[] args)
    {
        //3x^2 - 8x + 4

        double[] xVal = new double[3];

        xVal[0] = 0.0;
        xVal[1] = 5.5;
        xVal[2] = 2.3;

        for (double num : xVal)
        {
            System.out.println("At X = " + num + " the value is " + (3*(Math.pow(num, 2)) - 8*num + 4));
        }
    }
}
