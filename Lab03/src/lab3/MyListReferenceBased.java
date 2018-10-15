package lab3;

public class MyListReferenceBased implements ListInterface{
    private Node head;

    public MyListReferenceBased() {
        head = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        int size = 0;
        for (Node temp = head; temp != null; temp = temp.getNext()) {
            size++;
        }
        return size;
    }

    private Node find(int index) {
        Node curr = head;
        for (int skip = 0; skip < index; skip++) {
            curr = curr.getNext();
        }
        return curr;
    }

    public Object get(int index)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < size()) {
            Node curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
        }
    }

    public void add(int index, Object item)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 ) {
            if (index == 0) {
                Node newNode = new Node(item, head);
                head = newNode;
            }
            else {
                Node prev = find(index-1);
                Node newNode = new Node(item, prev.getNext());
                prev.setNext(newNode);
            }
        }
        else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
        }
    }

    public void remove(int index)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < size()) {
            if (index == 0) {
                head = head.getNext();
            }
            else {
                Node prev = find(index-1);
                Node curr = prev.getNext();
                prev.setNext(curr.getNext());
            }
            size();
        }
        else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on remove");
        }
    }

    public void removeAll() {
        head = null;
    }

    @Override
    public String toString() {
        Object dataItem;
        Node curr = head;
        String result = "List of size " + size() + " has the following items : ";
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
