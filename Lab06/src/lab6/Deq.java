package lab6;

public class Deq<T> extends Queue<T> implements ExtendedQueueInterface<T>{

    public void enqueueFirst(T newItem)
            throws ExtendedQueueException {
        if (numItems == items.length) {
            resize();
        }
        front = ((((front - 1) % items.length) + items.length) % items.length);
        items[front] = newItem;
        numItems++;
    }

    public T dequeueLast()
            throws ExtendedQueueException {
        back = ((((back - 1) % items.length) + items.length) % items.length);
        T item = items[back];
        items[back] = null;
        numItems--;
        return item;
    }

    public T peekLast() {
        return items[((((back - 1) % items.length) + items.length) % items.length)];
    }
}
