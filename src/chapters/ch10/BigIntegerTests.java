package chapters.ch10;

import java.math.BigInteger;

public class BigIntegerTests
{
    public static void main(String[] args)
    {
        System.out.println(factorial(4));
    }

    public static BigInteger factorial(int x)
    {
        BigInteger total = BigInteger.ONE;
        while (x > 1)
        {
            total = total.multiply(BigInteger.valueOf(x));
            x--;
        }

        return total;
    }

    public static BigInteger pow(int base, int exponent)
    {
        BigInteger total = BigInteger.ONE;

        return total;
    }

}
