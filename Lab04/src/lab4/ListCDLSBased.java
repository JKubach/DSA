package lab4;

// Please note that this code is slightly different from the textbook code
//to reflect the fact that the Node class is implemented using data encapsulation

// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListCDLSBased implements ListInterface
{
    // reference to linked list of items
    private DNode head;
    private int numItems; // number of items in list

    public ListCDLSBased()
    {
        numItems = 0;
        head = null;
    }  // end default constructor

    public boolean isEmpty()
    {
        return numItems == 0;
    }  // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size


    private DNode find(int index)
    {
        DNode curr = head;
        if (index > numItems / 2) {
            int findIndex = numItems - index;
            for (int i = findIndex; i > 0; i--) {
                curr = curr.getBack();
            }
            return curr;
        }
        else {
            for (int i = index; i > 0; i--) {
                curr = curr.getNext();
            }
            return curr;
        }
    }

    public Object get(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // get reference to node, then data in node
            DNode curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems + 1) {
            if (head == null) {
                DNode newNode = new DNode(item);
                head = newNode;
            }
            else {
                DNode curr;
                if (index == numItems || index == 0) {
                    curr = head;
                }
                else {
                    curr = find(index);
                }
                DNode newNode = new DNode(item, curr, curr.getBack());
                curr.getBack().setNext(newNode);
                curr.setBack(newNode);
                if (index == 0) {
                    head = newNode;
                }
            }
            numItems++;
        }
        else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
        } // end if
    }  // end add

    public void remove(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index <= numItems)
        {
            DNode prev;
            if (index == 0) {
                prev = head.getBack();
            }
            else {
                prev = find(index - 1);
            }
            prev.getNext().getNext().setBack(prev);
            prev.setNext(prev.getNext().getNext());
            if(index == 0) {
                head = prev.getNext();
            }
            numItems--;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on remove");
        }
    }

    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        head = null;
        numItems = 0;
    } // end removeAll

    @Override
    public String toString() {
        Object dataItem;
        DNode curr = head;
        String result = "List of size " + size() + " has the following items : ";
        for (int i = 0; i < size(); i++) {
            if (curr != null) {
                dataItem = curr.getItem().toString();
                curr = curr.getNext();
                result += dataItem + " ";
            }
        }
        return result;
    }


} // end ListReferenceBased

