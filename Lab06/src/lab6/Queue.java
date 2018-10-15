package lab6;

public class Queue<T> implements QueueInterface<T> {

    T [] items;
    int front;
    int back;
    int numItems;

    public Queue() {
        front = back = numItems = 0;
        items = (T[]) new Object[3];
    }

    public boolean isEmpty() {
        if (numItems == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(T newItem)
        throws QueueException {
        if (numItems == items.length) {
            resize();
        }
            items[back] = newItem;
            back = (back + 1) % items.length;
            numItems ++;
    }

    public T dequeue()
        throws QueueException {
        if (numItems != 0) {
            T item = items[front];
            items[front] = null;
            front = (front + 1) % items.length;
            numItems--;
            return item;
        }
        else {
            throw new QueueException("QueueException: Queue is empty on dequeue");
        }
    }

    public void dequeueAll() {
        items = (T[]) new Object[3];
        front = back = numItems = 0;
    }

    public T peek()
        throws QueueException {
        if (numItems != 0) {
            return items[front];
        }
        else {
            throw new QueueException("QueueException: Queue is empty on peek");
        }
    }

    protected void resize() {
        T []tmp;
        tmp = (T[]) new Object[numItems*2 + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[(front + i) % items.length];
        }
        front = 0;
        back = numItems;
        items = tmp;
    }

    @Override
    public String toString() {
        String result = "Queue of size " + numItems + " has the following items: ";
        if(numItems == 0)
            result = "No items";
        for(int i = 0; i < numItems; i++) {
            result += items[(i + front) % items.length] + " ";
        }
        return result;
    }
}

