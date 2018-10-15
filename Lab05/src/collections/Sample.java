package collections;

/*
// Instead of putting Packages into the samples bag,
// we'll create a new object Sample. This way we are
// not storing information that we no longer need.
*/

public class Sample {
    private String name;
    private double weight;

    public Sample(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
