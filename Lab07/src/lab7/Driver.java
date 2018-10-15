package lab7;

import java.util.Scanner;

public class Driver {

    Scanner in = new Scanner(System.in);

    public static void main (String args[]) {
        Driver binomial= new Driver();
        int n = 6;
        int k = 4;

        System.out.print("Enter n ");
        n = binomial.getInput();
        System.out.print(n);
        System.out.println();

        System.out.print("Enter k ");
        k = binomial.getInput();
        System.out.print(k);
        System.out.println();
        System.out.println();

        System.out.println(binomial.recursiveBinomial(n, k));
        binomial.displayTriangle(n+1);
        System.out.println(binomial.iterativeBinomial(n+1, k+1));
        System.out.println(binomial.formulaBinomial(n, k));
    }

    public int recursiveBinomial(int n, int k) {
        int result;

        if (k == n || k == 0) {
            result = 1;
        }
        else {
            result = recursiveBinomial(n - 1, k - 1) + recursiveBinomial(n - 1, k);
        }
        return result;
    }

    public int iterativeBinomial(int n, int k) {
        int[][] pascal  = new int[n +1][];
        pascal[1] = new int[1 + 3];
        pascal[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            pascal[i] = new int[i + 2];
            for (int j = 1; j < pascal[i].length - 1; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        // System.out.println(pascal[n][k]);
        return pascal[n][k];
    }

    public int formulaBinomial(int n, int k) {
        int result;
        int top = 1;
        int bot = 1;
        if (n - k > k) {
            for (int i = (n-k+1); i <= n; i++) {
                top *= i;
            }
            //System.out.println(top);
            for (int i = 1; i <= k; i++ ) {
                bot *= i;
            }
            //System.out.println(bot);
            result = top/bot;
            return result;
        }
        else {
            for (int i = (k+1); i <= n; i++) {
                top *= i;

            }
            for (int i = 1; i <= (n-k); i++) {
                bot *= i;
            }
            result = top/bot;
            return result;
        }
    }

    public void displayTriangle(int n) {
        int[][] pascal  = new int[n +1][];
        pascal[1] = new int[1 + 2];
        pascal[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            pascal[i] = new int[i + 2];
            for (int j = 1; j < pascal[i].length - 1; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < pascal[i].length - 1; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <=n; i++) {
            result *= i;
        }
        return result;
    }

    public int getInput() {
        int userIn = Integer.parseInt(in.nextLine());
        return userIn;
    }
}
