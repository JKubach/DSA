package lab12;
// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique items(at most one
//             item with a given search key at any time)
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K,V> {
    private ChainNode[] table;     // hash table
    private int size = 0;          // size of table, i.e. number of entries ((key,value) associations)

    public HashTable() {
        table = new ChainNode[3];
    }  // end default constructor

    // table operations
    public boolean tableIsEmpty() {
        return size==0;
    }  // end tableIsEmpty

    public int tableLength() {
        return size;
    }  // end tableLength


//implement the following 4 methods

    public boolean tableInsert(K key, V value) //inserts  association (key,value) only if key is not already in HashTable and returns true; returns false if the key already has an associated value in HashTable and does not insert
    {
        int index;
        boolean duplicate = false;
        boolean nullValue = false;
        index = hashIndex(key);

        ChainNode<K, V> curr = table[index];
        ChainNode<K, V> newNode = new ChainNode<>(key, value, null);
        if (curr != null) {
           while (!nullValue && !duplicate) {
                if (curr.getKey().equals(key)) {
                    duplicate = true;
                }
                else if (curr.getNext() == null) {
                    nullValue = true;
                }
                else {
                    curr = curr.getNext();
                }
           }
        }
        else {
            table[index] = newNode;
            size++;
            return true;
        }
        if (!duplicate) {
            System.out.println("COLLISION");
            curr.setNext(newNode);
            System.out.println("COLLISION RESOLVED");
            size++;
            return true;
        }
        return false;
    }

    public boolean tableDelete(K searchKey) //deletes the key and its association from the HashTable if it is in the table and returns true; returns false if key is not in the HashTable
    {
        int index;
        index = hashIndex(searchKey);
        ChainNode<K, V> node = table[index];

        if (node.getKey().equals(searchKey)) {
            table[index] = node.getNext();
            size--;
            return true;
        }
        while (node.getNext() != null) {
            if (node.getNext().getKey().equals(searchKey)) {
                node.setNext(node.getNext().getNext());
                size --;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public V tableRetrieve(K searchKey) //returns the value associated with searchkey in HashTable or null if there is no association
    {
        int index;
        index = hashIndex(searchKey);
        ChainNode<K, V> node = table[index];

        while (node != null) {
            if (searchKey.toString().equals(node.getKey())) {
                return node.getValue();
            }
            else {
                node = node.getNext();
            }
        }
        return null;
    }

    public int hashIndex(K key) {
        int horner = 0;
        int mapKey;
        int resultKey;
        int length = key.toString().length();
        int [] characters = new int[length];

        for(int i = 0; i < length; i++) {
            mapKey = key.toString().charAt(i) - ('A') + 1;
            characters[i] = mapKey;
            horner += characters[i] << ((length - 1 - i) * 5);
        }
        resultKey = horner % table.length;
        return resultKey;
    }
}  // end HashTable


