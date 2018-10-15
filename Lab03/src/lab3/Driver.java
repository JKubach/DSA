package lab3;

import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int menuSelection;

        Driver ui = new Driver();
        MyListReferenceBased myList = new MyListReferenceBased();

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
                    ui.removeAll(myList);
                    break;
                case 5:
                    ui.printList(myList);
                    break;
                case 6:
                    ui.deleteLargestObject(myList);
                    break;
                case 7:
                    myList = ui.reverseList(myList);
                    break;
                case 8:
                    ui.exit();
                    break;
                case 9:
                    ui.deleteSmallestObject(myList);
                    break;
                case 10:
                    ui.compareStrings(myList);
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

    private void addObject(MyListReferenceBased myList) {
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

    private void removeObject(MyListReferenceBased myList) {
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

    private void getObject(MyListReferenceBased myList) {
        int userIndex;
        System.out.print("Enter position to retrieve item from: ");
        userIndex = Integer.parseInt(in.nextLine());
        System.out.println(userIndex);
        if (userIndex <= myList.size()) {
            System.out.println("Item " + myList.get(userIndex) + " retrieved from position " + userIndex + " in the list");
        }
        else {
            System.out.println("Position specified is out of range!");
        }
    }

    private void removeAll(MyListReferenceBased myList) {
        myList.removeAll();
    }

    private void printList(MyListReferenceBased myList) {
        if (myList.size() > 0) {
            System.out.println(myList.toString());
        }
        else {
            System.out.println("List is empty.");
        }
    }

    private void deleteLargestObject(MyListReferenceBased myList) {
        int largestIndex = 0;
        String largestString = "";
        String currentString;
        if (myList.size() > 0) {
            for (int i = 0; i < myList.size(); i++) {
                currentString = myList.get(i).toString();
                if (currentString.compareTo(largestString) > 0 && largestString.compareTo(currentString) < 0 || largestString.equals("")) {
                    largestIndex = i;
                    largestString = myList.get(largestIndex).toString();
                }
            }
            System.out.println("Largest item " + largestString + " deleted.");
            myList.remove(largestIndex);
        }
        else {
            System.out.println("List empty, nothing to delete!");
        }
    }

    private void deleteSmallestObject(MyListReferenceBased myList) {
        int smallestIndex = 0;
        String smallestString = "";
        String currentString;
        if (myList.size() >0) {
            for (int i = 0; i < myList.size(); i++) {
                currentString = myList.get(i).toString();
                if (currentString.compareTo(smallestString) < 0 && smallestString.compareTo(currentString) > 0 || smallestString.equals("")) {
                    smallestIndex = i;
                    smallestString = myList.get(smallestIndex).toString();
                }
            }
            System.out.println("Smallest item " + smallestString + " deleted.");
            myList.remove(smallestIndex);
        }
        else {
            System.out.println("List empty, nothing to delete!");
        }
    }

    private void compareStrings(MyListReferenceBased myList) {
        int userIndex, difference;
        String str1, str2;
        System.out.print("Enter index of first string: ");
        userIndex = Integer.parseInt(in.nextLine());
        System.out.println(userIndex);
        str1 = myList.get(userIndex).toString();
        System.out.print("Enter index of second string: ");
        userIndex = Integer.parseInt(in.nextLine());
        System.out.println(userIndex);
        str2 = myList.get(userIndex).toString();
        difference = str1.compareTo(str2);
        System.out.println("The difference between these two strings is " + difference);
    }

    private MyListReferenceBased reverseList(MyListReferenceBased myList) {
        MyListReferenceBased tempList = new MyListReferenceBased();
        int listSize = myList.size();
        if (listSize > 0) {
            for (int i = 0; i < listSize;  i++) {
                tempList.add(i, myList.get(listSize - 1 - i));
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
        System.out.println("    6. Delete largest item in list");
        System.out.println("    7. Reverse list");
        System.out.println("    8. Exit program");
        System.out.println("    9. Delete smallest item in list (EXTRA)");
        System.out.println("    10. Compare two strings (EXTRA)");
    }

    private void exit() {
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}