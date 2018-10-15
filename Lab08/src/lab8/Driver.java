package lab8;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/09/18
 * Submitted:  04/09/18
 * Comment: test suite and sample run attached
 * @author: John Kubach
 * @version: 2018.04.09
 */

import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int userSelection;
        Driver ui = new Driver();

        ListArrayBasedPlus<Integer> listArrayPlus = new ListArrayBasedPlus<>();

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 1:
                    ui.insertItem(listArrayPlus);
                    break;
                case 2:
                    ui.removeItem(listArrayPlus);
                    break;
                case 3:
                    ui.getItem(listArrayPlus);
                    break;
                case 4:
                    ui.getSearchInput(listArrayPlus);
                    break;
                case 5:
                    listArrayPlus.removeAll();
                    break;
                case 6:
                    ui.printList(listArrayPlus);
                    break;
                case 7:
                    ui.exitProgram();
            }
        } while (userSelection != 7);
    }


    public void insertItem(ListArrayBasedPlus<Integer> listArrayPlus) {
        int searchKey;
        int index;
         System.out.println("Your are now entering an item");
        System.out.print("  Enter item: ");
        searchKey = Integer.parseInt(in.nextLine());
        System.out.println(searchKey);


        index = searchList(listArrayPlus, searchKey);
        if (index >= 0) {
            listArrayPlus.add(index, searchKey);
            System.out.println(searchKey + " added at index " + index);
        }
        else if (index < 0) {
            System.out.println("Item already exists at index " + (-index - 1));
        }
    }

    /*
     * Using method III from class.
     */

    public void getSearchInput(ListArrayBasedPlus listArrayPlus) {
        int searchKey;
        int result;
        System.out.print("Enter key: ");
        searchKey = Integer.parseInt(in.nextLine());
        System.out.println(searchKey);

        result = searchList(listArrayPlus, searchKey);
        if (result >= 0) {
            System.out.println(searchKey + " not found, stopped at index " + result);
        }
        else if (result < 0) {
            System.out.println("Key found at index " + (-result - 1));
        }

    }

    public int searchList(ListArrayBasedPlus<Integer> listArrayPlus, int searchKey) {
        int index;
        for (index = 0; index < listArrayPlus.size(); index++) {

            System.out.println(listArrayPlus.get(index));
            if (searchKey == listArrayPlus.get(index)) {
                return (-index - 1);
            }
        }
        return index;
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
        System.out.println("    4. Search for a specified item in the list");
        System.out.println("    5. Clear list");
        System.out.println("    6. Print size and contents of list");
        System.out.println("    7. Exit program");
    }

    void exitProgram(){
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}
