package lab11;

public class Item extends KeyedItem<String> {
    private String item;

    public Item(String item) {
        super(item);
        this.item = item;
    }
}
