package lab4;

//please note that this code is different from the textbook code, because the data is encapsulated!

public class DNode
{
    private Object item;
    private DNode next;
    private DNode back;

    public DNode(Object newItem)
    {
        item = newItem;
        next = this;
        back = this;
    } // end constructor

    public DNode(Object newItem, DNode nextNode, DNode previousNode)
    {
        item = newItem;
        next = nextNode;
        back = previousNode;
    } // end constructor

    public void setItem(Object newItem)
    {
        item = newItem;
    } // end setItem

    public Object getItem()
    {
        return item;
    } // end getItem

    public void setNext(DNode nextNode)
    {
        next = nextNode;
    } // end setNext

    public DNode getNext()
    {
        return next;
    } // end getNext

    public void setBack(DNode previousNode) {
        back = previousNode;
    }

    public DNode getBack() {
        return back;
    }
} // end class Node
