package lab8;

public class ListArrayBasedPlus<T> extends ListArrayBased<T> {

    public ListArrayBasedPlus() {
        super();
    }

    public void add(int index, T item)
            throws  ListIndexOutOfBoundsException
    {
        if (numItems == items.length )  //fixes implementation errors and programming errors.
        {
            resize();
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            super.add(index, item);
        }
    } //end add

    public void reverse() {
        for(int i = 0; i < numItems/2; i++) {
            T tempObject = items[i];
            items[i] = items[numItems - i - 1];
            items[numItems - i - 1] = tempObject;
        }
        System.out.println("List reversed");
    }

    public void resize() {
        T []tmp;
        tmp = (T[]) new Object[numItems*2 + 1];
        for (int i = 0; i < numItems; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    @Override
    public String toString() {
        String result = "List of size " + size() + " has the following items : ";

        for (int i = 0; i < size(); i++) {
            if (items[i] != null)
                result += items[i] + " ";
        }

        return result;
    }
}
