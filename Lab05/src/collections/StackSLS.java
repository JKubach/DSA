package collections;

public class StackSLS<T> implements StackInterface<T> {

    private Node<T> top;
   //  private int numItems;

    public StackSLS() {
        top = null;
    }

    public int size() {
        int size = 0;
        for (Node temp = top; temp != null; temp = temp.getNext()) {
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void popAll() {
        top = null;
    }

    public void push (T item) {
        top  = new Node<T>(item, top);
    }

    public T pop()
            throws StackException{
        T result;
        if (top == null) {
            throw new StackException("StackException: Stack is empty on pop");
        }
        else {
            result = top.getItem();
            top = top.getNext();
            return result;
        }
    }

    public T peek() {
        if (top == null) {
            throw new StackException("StackException: Stack is empty on peek()");
        }
        else {
            return top.getItem();
        }
    }

    @Override
    public String toString() {
        Object dataItem;
        Node curr = top;
        String result = "Stack of size " + size() + " has the following items : ";
        for (int i = 0; i < size(); i++) {
            if (curr != null) {
                dataItem = curr.getItem();
                curr = curr.getNext();
                result += dataItem + " ";
            }
        }
        return result;
    }


}
