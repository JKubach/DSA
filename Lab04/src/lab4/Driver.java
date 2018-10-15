package lab4;

import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int menuSelection;

        Driver ui = new Driver();
        ListCDLSBased myList = new ListCDLSBased();

        ui.welcomeMessage();

        do {
            menuSelection = ui.menuSelect();
            System.out.println(menuSelection);

            switch (menuSelection) {
                case 1:
                    ui.addObject(myList);
                    break;
                case 2:
                    ui.removeObject(myList);
                    break;
                case 3:
                    ui.getObject(myList);
                    break;
                case 4:
                    myList.removeAll();
                    break;
                case 5:
                    ui.printList(myList);
                    break;
                case 6:
                    myList = ui.reverseList(myList);
                    break;
                case 7:
                    ui.exit();
                    break;
                default:
                    System.out.println("Enter a valid selection.");
            }
        }while(menuSelection != 8);
    }

    private int menuSelect() {
        System.out.print("Make your menu selection now: ");
        return Integer.parseInt(in.nextLine());
    }

    private void addObject(ListCDLSBased myList) {
        Object userInput;
        int userIndex;
        System.out.println("You are now inserting an item into the list");
        System.out.print("Enter item: ");
        userInput = in.nextLine();
        System.out.println(userInput);
        System.out.print("Enter position to insert item in: ");
        userIndex = Integer.parseInt(in.nextLine());
        System.out.println(userIndex);
        if (userIndex <= myList.size()) {
            myList.add(userIndex, userInput);
            System.out.println("Item " + userInput + " inserted in position " + userIndex + " in the list");
        }
        else {
            System.out.println("Position specified is out of range!");
        }
    }

    private void removeObject(ListCDLSBased myList) {
        int userIndex;
        System.out.print("Enter position to remove item from ");
        userIndex = Integer.parseInt(in.nextLine());
        System.out.println(userIndex);
        if (userIndex <= myList.size()) {
            System.out.println("Item " + myList.get(userIndex) + " removed from position " + userIndex + " in the list");
            myList.remove(userIndex);
        }
        else {
            System.out.println("Position specified is out of range!");
        }
    }

    private void getObject(ListCDLSBased myList) {
        int userIndex;
        System.out.print("Enter position to retrieve item from: ");
        userIndex = Integer.parseInt(in.nextLine());
        System.out.println(userIndex);
        if (userIndex < myList.size()) {
            System.out.println("Item " + myList.get(userIndex) + " retrieved from position " + userIndex + " in the list");
        }
        else {
            System.out.println("Position specified is out of range!");
        }
    }

    private void printList(ListCDLSBased myList) {
        if (myList.size() > 0) {
            System.out.println(myList.toString());
        }
        else {
            System.out.println("List is empty.");
        }
    }

    private ListCDLSBased reverseList(ListCDLSBased myList) {
        ListCDLSBased tempList = new ListCDLSBased();
        int listSize = myList.size();
        if (listSize > 0) {
            for (int i = 0; i < listSize;  i++) {
                tempList.add(i, myList.get(listSize - 1 - i));
                System.out.println(tempList.get(i));
            }

              //  myList = tempList;

            System.out.println("List has been reversed");
            System.out.print("Here is the content: ");
            for (int i = 0; i < listSize; i++) {
                System.out.print(tempList.get(i) + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("List is empty.. nothing to reverse!");
        }
        return tempList;
    }

    private void welcomeMessage() {
        System.out.println("Select from the following menu: ");
        System.out.println("    1. Insert item to list");
        System.out.println("    2. Remove item from list");
        System.out.println("    3. Get item from list");
        System.out.println("    4. Clear list");
        System.out.println("    5. Print size and content of list");
        System.out.println("    6. Reverse List");
        System.out.println("    7. Exit Program");
    }

    private void exit() {
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}