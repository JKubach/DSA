package lab7;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n;

        Factorial factorial = new Factorial();

        n = factorial.getInput();
        System.out.println(factorial.recursiveFactorial(n));

    }

    public int recursiveFactorial(int n) {
        int result;
        // double[] array = new double[1000000000];
        if (n == 1 || n == 0) {
            result = 1;
        }
        else {
            result = n * recursiveFactorial(n - 1);
        }
        return result;
    }

    public int getInput() {
        int userIn;
        System.out.print("Enter number to calculate factorial: ");
        userIn = Integer.parseInt(in.nextLine());
        return userIn;
    }

}
