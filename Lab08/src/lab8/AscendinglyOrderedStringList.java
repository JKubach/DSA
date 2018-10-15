package lab8;

public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface {
    private static final int MAX_LIST = 3;
    protected String []items;
    protected int numItems;

    public AscendinglyOrderedStringList()
    {
        items = new String[MAX_LIST];
        numItems = 0;
    }

    public boolean isEmpty()
    {
        return (numItems == 0);
    }

    public int size()
    {
        return numItems;
    }

    public String get(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on get");
        }
    }

    public void add(String item) {
        int index;

        if (numItems == items.length) {
            resize();
        }

        index = search(item);
        if (index <= 0) {
            index = -index;
            for (int pos = numItems - 1; pos >= index; pos--)
            {
                items[pos + 1] = items[pos];
            }
            items[index] = item;
            System.out.println("Item " + item + "inserted in position " + (index));
            numItems++;
        } else {
            System.out.println("Item already exists");
        }
    }

    public void remove(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            for (int pos = index+1; pos < numItems; pos++)

            {
                items[pos-1] = items[pos];
            }
            items[numItems - 1] = null;
            numItems--;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on remove");
        }
    }

    /*
     * Using binary method II
     */

    public int search(String item) {
        int low = 0;
        int high = items.length-1;
        while (low < high) {
            int mid = (low+high)/2;
            String midKey = items[mid];

            if (items[mid] == null || midKey.compareTo(item) >= 0) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        if (item.equals(items[low])) {
            low = low +  1;
                return low;
        }
        else {
            low = -low;
            return low;
        }
    }

    public void clear()
    {
        items = new String[MAX_LIST];
        numItems = 0;
    }

    public void resize() {
        String []tmp;
        tmp = new String[numItems*2 + 1];
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
