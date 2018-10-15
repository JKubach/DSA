package collections;

/*
// This class is used to hold the parameters of each package
// Each package is then contained inside a stack or "bag".
*/

public class Package {
    private String name;
    private double weight;
    private int number;
    private String sender;
    private String recipient;

    public Package(String name, double weight, int number, String sender, String recipient) {
        this.name = name;
        this.weight = weight;
        this.number = number;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getNumber() {
        return number;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return name;
    }
}
