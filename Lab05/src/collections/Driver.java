package collections;

import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int userSelection;
        double totalBagWeight = 0;
        double totalSampleWeight = 0;
        Driver ui = new Driver();

        /*
        try {
            StackInterface<String> packageBag = (StackInterface) Class.forName(args[0]).newInstance();
        }
        catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        catch (InstantiationException e1) {
            e1.printStackTrace();
        }
        catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        */

        StackRA<Package> packageBag = new StackRA<>();
        StackRA<Sample> sampleBag = new StackRA<>();

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 0:
                    ui.exitProgram();
                    break;
                case 1:
                    totalBagWeight += ui.pickUp(packageBag);
                    break;
                case 2:
                    if (ui.askForSample(packageBag)) {
                        ui.addSample(packageBag, sampleBag);    // Take a sample if yes.
                    }
                    totalBagWeight -= ui.updateBagWeight(packageBag);
                    totalSampleWeight += ui.dropOff(packageBag);
                    break;
                case 3:
                    ui.getBagContents(packageBag, totalBagWeight);
                    break;
                case 4:
                    ui.getSampleContents(sampleBag, totalSampleWeight);
                    break;
                case 5:
                    totalSampleWeight -= ui.updateSampleWeight(sampleBag);
                    ui.enjoySample(sampleBag);
                    break;
                case 6:
                    totalSampleWeight = 0;
                    sampleBag.popAll();
                    System.out.println("Sample bag has been emptied");
            }
        } while (userSelection != 0);
    }

    public double pickUp(StackRA<Package> myStack) {
        String name;
        double weight;
        int number;
        String sender;
        String recipient;

        System.out.println("Please specify package info:");
        System.out.print("Item name: ");
        name = in.nextLine().trim();
        System.out.print(name);

        System.out.print("Item weight: ");
        weight = Double.parseDouble(in.nextLine().trim());
        System.out.print(weight);

        System.out.print("Number of items: ");
        number = Integer.parseInt(in.nextLine().trim());
        System.out.print(number);

        System.out.print("Sender: ");
        sender = in.nextLine().trim();
        System.out.print(sender);

        System.out.print("Recipient");
        recipient = in.nextLine().trim();
        System.out.print(recipient);

        Package bagPackage = new Package(name, weight, number, sender, recipient);


        myStack.push(bagPackage);
        System.out.println("A package of " + name +  " each weighing " + weight + " are now in the bag");

        return weight * number;
    }

    public boolean askForSample(StackRA<Package> bag) {
        if (bag.isEmpty()) {
            System.out.println("No deliveries to process!");
            return false;
        }
        else {
            char answer;
            System.out.println("Here is your package " + bag.peek().getRecipient() + ", may I please, please keep a sample (Y/N)?");
            answer = in.nextLine().charAt(0);
            System.out.println(answer);

            if (answer == 'Y') {
                return true;
            }
            return false;
        }
    }

    public double dropOff(StackRA<Package> myStack) {
        if(myStack.isEmpty()) {
            return 0;
        }

        Package pack = myStack.peek();
        myStack.pop();
        return pack.getWeight();
    }

    public void addSample(StackRA<Package> packageBag, StackRA<Sample> sampleBag) {
        Package pack = packageBag.peek();
        Sample newSample = new Sample(pack.getName(), pack.getWeight());
        sampleBag.push(newSample);
    }

    public double updateBagWeight(StackRA<Package> bag) {
        if (!bag.isEmpty()) {
            double weight = bag.peek().getWeight() * bag.peek().getNumber();
            return weight;
        }
        return 0;
    }

    public double updateSampleWeight(StackRA<Sample> bag) {
        if (!bag.isEmpty()) {
            return bag.peek().getWeight();
        }
        return 0;
    }

    public void getBagContents(StackRA<Package> bag, double totalWeight) {
        System.out.println("Bag has " + bag.size() + " items and weighs " + totalWeight + " lbs");
    }

    public void getSampleContents(StackRA<Sample> samples, double totalWeight) {

        System.out.println("Bag has " + samples.size() + " items and weighs " + totalWeight + " lbs");
    }

    public void enjoySample(StackRA<Sample> sampleBag) {
        if (sampleBag.isEmpty()) {
            System.out.println("No samples to enjoy!");
        }
        else {
            System.out.println("This " + sampleBag.peek() + " is amazing! I love free stuff");
            sampleBag.pop();
        }
    }

    public int menuSelection() {
        System.out.print("Make your menu selection now: ");
        return Integer.parseInt(in.nextLine().trim());
    }

    public void listOptions(){
        System.out.println("Select from the following menu:");
        System.out.println("    0. Exit");
        System.out.println("    1. Pick up an order");
        System.out.println("    2. Drop off an order");
        System.out.println("    3. Display number of packages and weight of bag.");
        System.out.println("    4. Display number of items and weight of bag of samples");
        System.out.println("    5. Enjoy an item from bag of samples");
        System.out.println("    6. Empty bag of samples");
    }

    void exitProgram(){
        System.out.println("Exiting program...Good Bye");
        System.exit(0);
    }
}

