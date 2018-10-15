package lab7;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial3 {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        BigInteger n;

        Factorial3 factorial = new Factorial3();

        n = factorial.getInput();
        System.out.println(factorial.recursiveFactorial(n));

    }

    public BigInteger recursiveFactorial(BigInteger n) {
        BigInteger result;
        // double[] array = new double[1000000000];
        if (n.intValue() == 1 || n.intValue() == 0) {
            result = BigInteger.valueOf(1);
        }
        else {
            result = n.multiply(  recursiveFactorial(n.subtract(BigInteger.valueOf(1))));
        }
        return result;
    }

    public BigInteger getInput() {
        BigInteger userIn;
        System.out.print("Enter number to calculate factorial: ");
        userIn = in.nextBigInteger();
        return userIn;
    }
}
