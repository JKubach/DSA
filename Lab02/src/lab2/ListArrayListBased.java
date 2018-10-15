package lab2;

import java.util.ArrayList;

public class ListArrayListBased implements ListInterface{

    protected ArrayList<Object> items;  // an array list of objects

    public ListArrayListBased()
    {
        items = new ArrayList<Object>();
    }  // end default constructor

    public boolean isEmpty()
    {
        return (items.isEmpty());
    } // end isEmpty

        public int size()
    {
        return items.size();
    }  // end size

    public void removeAll()
    {
        items.clear();
    } // end removeAll

    public void add(int index, Object item)
            throws  ListIndexOutOfBoundsException
    {
        items.add(index, item);
    } //end add

    public Object get(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
            return items.get(index);
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    public void remove(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
            items.remove(index);
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove
}

