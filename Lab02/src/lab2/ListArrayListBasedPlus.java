package lab2;

import java.util.Collections;

public class ListArrayListBasedPlus extends ListArrayListBased {

    public void reverse() {
        Collections.reverse(items);
    }

        @Override
    public String toString() {
        String result = "List of size " + size() + " has the following items : ";

        for (int i = 0; i < size(); i++) {
            if (get(i)!= null)
                result += get(i) + " ";
        }

        return result;
    }
}
