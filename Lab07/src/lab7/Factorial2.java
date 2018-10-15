package lab7;

import java.util.Scanner;

public class Factorial2 {

    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        long n;

        Factorial2 factorial = new Factorial2();

        n = factorial.getInput();
        System.out.println(factorial.recursiveFactorial(n));

    }

    public long recursiveFactorial(long n) {
        long result;
        // double[] array = new double[1000000000];
        if (n == 1 || n == 0) {
            result = 1;
        }
        else {
            result = n * recursiveFactorial(n - 1);
        }
        return result;
    }

    public long getInput() {
        long userIn;
        System.out.print("Enter number to calculate factorial: ");
        userIn = Long.parseLong(in.nextLine());
        return userIn;
    }


}
