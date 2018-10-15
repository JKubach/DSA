package collections;

public class StackRA<T> implements StackInterface<T>{

    protected T []items;
    protected int numItems;

    public StackRA() {
        items = (T[]) new Object[3];
        numItems = 0;
    }

    public boolean isEmpty() {
        return (numItems == 0);
    }

    public int size() {
        return numItems;
    }

    public void popAll() {
        items = (T[]) new Object[3];
        numItems = 0;
    }

    public void push (T item)
            throws StackException {

        if (numItems == items.length) {
            resize();
        }
        items[numItems++] = item;
    }

    public T pop()
            throws StackException {
        if (numItems != 0) {
            T item = items[numItems -1];
            items[numItems-1] = null;
            numItems --;
            return item;
        }
        else {
            throw new StackException("StackException: Stack is empty on pop()");
        }
    }

    public T peek()
            throws StackException {
        if (numItems != 0) {
            return items[numItems - 1];
        }
        else {
            throw new StackException("StackException: Stack is empty on peek()");
        }
    }

    public void resize() {
        T []tmp;
        tmp = (T[]) new Object[numItems*2 + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    @Override
    public String toString() {
        String result = "Stack of size " + numItems + " has the following items : ";

        for (int i = 0; i < numItems; i++) {
            if (items[i] != null)
                result += items[i] + " ";
        }

        return result;
    }

}
