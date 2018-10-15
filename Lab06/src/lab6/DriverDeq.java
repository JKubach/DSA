package lab6;

import java.util.Scanner;

public class DriverDeq {
    Scanner in = new Scanner(System.in);
    public static void main(String[]args) {
        int userSelection;
        DriverDeq ui = new DriverDeq();
        Deq<Object> myDeq = new Deq<>();

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 1:
                    ui.insertItem(myDeq);
                    break;
                case 2:
                    ui.insertFirst(myDeq);
                    break;
                case 3:
                    ui.removeItem(myDeq);
                    break;
                case 4:
                    ui.removeLast(myDeq);
                    break;
                case 5:
                    ui.peek(myDeq);
                    break;
                case 6:
                    ui.peekLast(myDeq);
                    break;
                case 7:
                    ui.clear(myDeq);
                    break;
                case 8:
                    ui.display(myDeq);
                    break;
                case 9:
                    ui.exitProgram();
                    break;
            }
        } while (userSelection != 0);

    }

    public void insertItem(Deq myQueue) {
        Object newItem;
        System.out.print("Enter item: ");
        newItem = in.nextLine();
        myQueue.enqueue(newItem);
        System.out.println("Item " + newItem + " has been added to the back");

    }

    public void insertFirst(Deq myQueue) {
        Object newItem;
        System.out.print("Enter item: ");
        newItem = in.nextLine();
        myQueue.enqueueFirst(newItem);
        System.out.println("Item " + newItem + " has been added to the back");
    }

    public void removeItem(Deq myQueue) {
        System.out.println("Item " + myQueue.dequeue() + " has been removed from the front");
    }

    public void removeLast(Deq myQueue) {
        System.out.println("Item " + myQueue.dequeueLast() + " has been removed from the back");
    }

    public void peek(Deq myQueue) {
        System.out.println(myQueue.peek());
    }

    public void peekLast(Deq myQueue) {
        System.out.println(myQueue.peekLast());
    }

    public void clear(Deq myQueue) {
        myQueue.dequeueAll();
    }

    public void display(Deq myQueue) {
        System.out.println(myQueue.toString());
    }

    public int menuSelection() {
        System.out.print("Make your menu selection now: ");
        return Integer.parseInt(in.nextLine().trim());
    }

    public void listOptions() {
        System.out.println("Select from the following menu:");
        System.out.println("    1. Insert item in back of Deq");
        System.out.println("    2. Insert item at front of Deq");
        System.out.println("    3. Remove item from front of Deq");
        System.out.println("    4. Remove item from back of Deq");
        System.out.println("    5. Display front of Deq");
        System.out.println("    6. Display back of Deq");
        System.out.println("    7. Clear Deq");
        System.out.println("    8. Display contents of Deq");
        System.out.println("    9. Exit");
    }

    void exitProgram(){
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}

