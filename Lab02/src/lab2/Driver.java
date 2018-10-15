package lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 01/31/18
 * Submitted:  02/01/18
 * Comment: test suite and sample run attached
 * @author: John 'Johnny' Kubach
 * @version: 2018.01.31
 */

import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int userSelection;
        Driver ui = new Driver();

        /* Comment out one of the two following lines to toggle between
         * Array or ArrayList Implementation
         */
        ListArrayBasedPlus listArrayPlus = new ListArrayBasedPlus();
        // ListArrayListBasedPlus listArrayPlus = new ListArrayListBasedPlus();

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 1:
                    ui.addItem(listArrayPlus);
                    break;
                case 2:
                    ui.removeItem(listArrayPlus);
                    break;
                case 3:
                    ui.getItem(listArrayPlus);
                    break;
                case 4:
                    listArrayPlus.removeAll();
                    break;
                case 5:
                    ui.printList(listArrayPlus);
                    break;
                case 6:
                    listArrayPlus.reverse();
                    break;
                case 7:
                    ui.exitProgram();
            }
        } while (userSelection != 7);
    }

    public void addItem(ListArrayBasedPlus listArrayPlus) {
        int index;
        Object item;
        System.out.println("Your are now entering an item");
        System.out.print("  Enter item: ");
        item = in.nextLine();
        System.out.println(item);
        System.out.print("  Enter position to insert item in: ");
        index = Integer.parseInt(in.nextLine().trim());
        System.out.println(index);
        if (index > listArrayPlus.size()) {
            System.out.println("Position is out of bounds!");
        }
        else {
            listArrayPlus.add(index, item);
            System.out.println("Item " + item + " inserted in position " + index + " in the list.");
        }
    }

    public void removeItem(ListArrayBasedPlus listArrayPlus) {
        int index;
        System.out.print("Enter position to remove item from: ");
        index = Integer.parseInt(in.nextLine().trim());
        System.out.println(index);

        if (index >= listArrayPlus.size())
        {
            System.out.println("Index is out of range!");
        }
        else {
            System.out.println("Item " + listArrayPlus.get(index) + " removed from position " + index + " in the list");
            listArrayPlus.remove(index);
        }
    }


    public void getItem(ListArrayBasedPlus listArrayPlus) {
        int index;
        System.out.print("Enter position to retrieve from list ");
        index = Integer.parseInt(in.nextLine().trim());
        System.out.println(index);

        if (index >= listArrayPlus.size()) {
            System.out.println("Index is out of range!");
        }
        else {
            System.out.println("Item " + listArrayPlus.get(index) + " retrieved from position " + index + " in the list");
        }
    }

    public void printList(ListArrayBasedPlus listArrayPlus) {
        if (listArrayPlus.size() == 0)
        {
            System.out.println("List is empty");
        }
        else {
            System.out.println(listArrayPlus.toString());
        }
    }

    public int menuSelection() {
        System.out.print("Make your menu selection now: ");
        return Integer.parseInt(in.nextLine());
    }

    public void listOptions(){
        System.out.println("Select from the following menu:");
        System.out.println("    1. Insert item to list");
        System.out.println("    2. Remove item from list");
        System.out.println("    3. Get item from list");
        System.out.println("    4. Clear list");
        System.out.println("    5. Print size and contents of list");
        System.out.println("    6. Reverse list");
        System.out.println("    7. Exit program");
    }

    void exitProgram(){
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }

}
