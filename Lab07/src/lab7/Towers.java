package lab7;

import java.util.Scanner;

public class Towers {
    Scanner in = new Scanner(System.in);
    public static int count = 0;
    public static int moves = 0;

    public static void main(String args[]) {
        int n;

        Towers towers = new Towers();

        n = towers.getInput();
        towers.solve(n, "Initial", "Destination", "Temporary");
        count++;
        System.out.println("Number of method calls: " + count);
        System.out.println("Number of disk moves " + moves);

    }

    public void solve(int n, String Initial, String Destination, String Temp) {
        count++;
        if (n == 1) {
            System.out.println("Move disk 1 from: " + Initial + " to " + Destination);
            moves++;
        }
        else {
            solve(n - 1, Initial, Temp, Destination);
            System.out.println("Move disk " + n + " from " + Initial + " to " + Destination);
            moves++;
            solve(n - 1, Temp, Destination, Initial);
        }
    }

    public int getInput() {
        int userIn;
        System.out.print("Enter number of towers: ");
        userIn = Integer.parseInt(in.nextLine());
        return userIn;
    }
}
