package lab12;
import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int userSelection;
        Driver ui = new Driver();
        HashTable<String, String> table = new HashTable<>();

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);

            switch (userSelection) {
                case 1:
                    ui.insert(table);
                    break;
                case 2:
                    ui.delete(table);
                    break;
                case 3:
                    ui.retrieve(table);
                    break;
                case 4:
                    ui.displayHashIndex(table);
                    break;
                case 5:
                    ui.exitProgram();
                    break;
            }
        } while (userSelection !=5);
    }

    public void insert(HashTable<String, String> table) {
        String key, value;
        System.out.print("Enter Key ");
        key = in.next().trim();
        System.out.println(key);
        System.out.print("Enter Value ");
        value = in.next().trim();
        System.out.println(value);
        table.tableInsert(key, value);
    }

    public void retrieve(HashTable<String, String> table) {
        String key;
        String result;
        System.out.print("Enter key ");
        key = in.next().trim();
        System.out.println(key);

        result = table.tableRetrieve(key);
        if (result != null) {
            System.out.println("Key " + key + " has value of " + result);
        }
        else {
            System.out.println("Key not found!");
        }

    }

    public void delete(HashTable<String, String> table) {
        String key;
        System.out.print("Enter Key");
        key = in.next().trim();
        System.out.println(key);

        if (table.tableDelete(key)) {
            System.out.println("Key " + key + " has been deleted");
        }
        else {
            System.out.println("Key not found in table");
        }
    }

    public void displayHashIndex(HashTable<String, String> table) {
        String key;

        System.out.print("Enter key ");
        key = in.next().trim();
        System.out.println(key);

        System.out.println("Hash index of key " + key + " is " + table.hashIndex(key));
    }

    public int menuSelection() {
        System.out.print("Make your menu selection now: ");
        return Integer.parseInt(in.next().trim());
    }

    public void listOptions(){
        System.out.println("Select from the following menu:");
        System.out.println("    1. Insert a symbol key with an associated value in the table");
        System.out.println("    2. Delete symbol from the table");
        System.out.println("    3. Retrieve and display the value associated with a symbol key in the table");
        System.out.println("    4. Display the hash index of a symbol key");
        System.out.println("    5. Exit Program");
    }

    public void exitProgram(){
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}
