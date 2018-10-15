package lab6;

import java.util.Scanner;

public class DriverQueue {

    Scanner in = new Scanner(System.in);
    public static void main(String[]args) {
        int userSelection;
        DriverQueue ui = new DriverQueue();
        Queue<Object> myQueue = new Queue<>();

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 1:
                    ui.insertItem(myQueue);
                    break;
                case 2:
                    ui.removeItem(myQueue);
                    break;
                case 3:
                    ui.peek(myQueue);
                    break;
                case 4:
                    ui.clear(myQueue);
                    break;
                case 5:
                    ui.display(myQueue);
                    break;
                case 6:
                    ui.exitProgram();
                    break;
            }
        } while (userSelection != 0);

    }

    public void insertItem(Queue myQueue) {
        Object newItem;
        System.out.print("Enter item: ");
        newItem = in.nextLine();
        myQueue.enqueue(newItem);
        System.out.println("Item " + newItem + " has been added to the back");

    }

    public void removeItem(Queue myQueue) {
        System.out.println("Item " + myQueue.dequeue() + " has been removed from the front");
    }

    public void peek(Queue myQueue) {
        System.out.println(myQueue.peek());
    }

    public void clear(Queue myQueue) {
        myQueue.dequeueAll();
    }

    public void display(Queue myQueue) {
        System.out.println(myQueue.toString());
    }

    public int menuSelection() {
        System.out.print("Make your menu selection now: ");
        return Integer.parseInt(in.nextLine().trim());
    }

    public void listOptions() {
        System.out.println("Select from the following menu:");
        System.out.println("    1. Insert item in back of Queue");
        System.out.println("    2. Remove item from front of Queue");
        System.out.println("    3. Display front of Queue");
        System.out.println("    4. Clear Queue");
        System.out.println("    5. Display contents of Queue");
        System.out.println("    6. Exit");
    }

    void exitProgram(){
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}

