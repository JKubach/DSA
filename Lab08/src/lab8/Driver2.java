package lab8;

import java.util.Scanner;
public class Driver2 {

    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int userSelection;
        Driver2 ui = new Driver2();

        AscendinglyOrderedStringList orderedList = new AscendinglyOrderedStringList();
        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 1:
                    ui.insertItem(orderedList);
                    break;
                case 2:
                    ui.removeItem(orderedList);
                    break;
                case 3:
                    ui.getItem(orderedList);
                    break;
                case 4:
                    ui.searchList(orderedList);
                    break;
                case 5:
                    orderedList.clear();
                    break;
                case 6:
                    ui.printList(orderedList);
                    break;
                case 7:
                    ui.exitProgram();
            }
        } while (userSelection != 7);
    }



    public void insertItem(AscendinglyOrderedStringList orderedList) {
        String searchKey;
        System.out.println("Your are now entering an item");
        System.out.print("  Enter item: ");
        searchKey = in.nextLine();
        System.out.println(searchKey);
        orderedList.add(searchKey);
    }



    public void removeItem(AscendinglyOrderedStringList orderedList) {
        int index;
        System.out.print("Enter position to remove item from: ");
        index = Integer.parseInt(in.nextLine().trim());
        System.out.println(index);

        if (index >= orderedList.size())
        {
            System.out.println("Index is out of range!");
        }
        else {
            System.out.println("Item " + orderedList.get(index) + " removed from position " + index + " in the list");
            orderedList.remove(index);
        }
    }


    public void getItem(AscendinglyOrderedStringList orderedList) {
        int index;
        System.out.print("Enter position to retrieve from list ");
        index = Integer.parseInt(in.nextLine().trim());
        System.out.println(index);

        if (index >= orderedList.size()) {
            System.out.println("Index is out of range!");
        }
        else {
            System.out.println("Item " + orderedList.get(index) + " retrieved from position " + index + " in the list");
        }
    }

    public void searchList(AscendinglyOrderedStringList orderedList) {
        String key;
        int index;
        System.out.print("Enter key to search: ");
        key = in.nextLine().trim();

        index = orderedList.search(key);
        if (index > 0) {
            System.out.println("Key " + key + " found at index " + (index-1));
        }
        else{

            System.out.println("Key could not be found, stopped at index " + (-index));
            }
        }


    public void printList(AscendinglyOrderedStringList orderedList) {
        if (orderedList.size() == 0)
        {
            System.out.println("List is empty");
        }
        else {
            System.out.println(orderedList.toString());
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
