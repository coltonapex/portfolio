// --== CS400 File Header Information ==--
// Name: Casey Lin
// Email: cmlin@wisc.edu
// Team: CC
// TA: Yeping
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * HashTableMap implementation. contains methods for adding,
 * removing, and handling collisions.
 * @param <KeyType> Generic KeyType
 * @param <ValueType> Generic ValueType
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    private LinkedList<HashPair<KeyType, ValueType>>[] hashTable;
    private int size;

    //Constructors

    /**
     * constructs a new instance of HashTableMap with size 0 and with int capacity
     * @param capacity the max size of the hashTable
     */
    public HashTableMap(int capacity) {
        //i am not sure how to do this without warnings
        hashTable = new LinkedList[capacity];
        this.size = 0;
    }

    /**
     * Default Constructor for HashTableMap, creates a new HashTableMap with capacity 10
     */
    public HashTableMap() {
        this(10);
    }

    /**
     * Extends the hashtable by doubling and rehashing
     */
    public void extend() {
        //reset size, otherwise rehashing causes keys to get counted twice
        size = 0;

        //rename old table
        LinkedList[] temp = hashTable;

        //create a new table
        hashTable = new LinkedList[hashTable.length * 2];


        //TODO: rehash every key
        for (LinkedList<HashPair> hashPairs : temp) {
            if (hashPairs != null) {
                for (HashPair<KeyType, ValueType> hashPair : hashPairs) {
                    put(hashPair.getKey(), hashPair.getValue());
                }
            }
        }
    }

    /**
     * adds a new key value pair to the hashtable
     *
     * @param key the key to be added
     * @param value the value to be added
     * @return whether the key was successfully added or not
     */
    public boolean put(KeyType key, ValueType value) {

        //hash index is abs value of the hashcode, modulo size of table
        int index = Math.abs(key.hashCode()) % hashTable.length;

        //now add the key, value pair
        HashPair<KeyType, ValueType> pair = new HashPair<KeyType, ValueType>(key, value);

        //if index is null, add :)
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(pair);
            size++;
            if (((double) size / hashTable.length) >= 0.8) {
                extend();
            }
            return true;
        } else {
            //check every element in the linked list, see if it's a duplicate//or has same key
            for (HashPair<KeyType, ValueType> tablePair : hashTable[index]) {
                if (tablePair.getKey().equals(pair.getKey())) {
                    return false;
                } else {
                    hashTable[index].add(pair);
                    size++;
                    if (((double) size / hashTable.length) >= 0.8) {
                        extend();
                    }
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * gets the value associated with key from the HashTableMap.
     * @param key the key used
     * @return the value in the HashPair within the HashTable.
     * @throws NoSuchElementException
     */
    public ValueType get(KeyType key) throws NoSuchElementException {
        int index = Math.abs(key.hashCode()) % hashTable.length;

        //check for collisions
        if (hashTable[index] == null) {
            throw new NoSuchElementException("Key does not exist in HashTable!");
        } else {
            //check every element in the linked list, see if it's a duplicate
            for (HashPair<KeyType, ValueType> pair : hashTable[index]) {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        throw new NoSuchElementException("Key does not exist in HashTable!");
    }

    /**
     * finds the amount of elements in the table
     * @return size of the hashtable
     */
    public int size() {
        return size;
    }

    /**
     * method to check whether key is present in hashtable
     * @param key the key to be passed in
     * @return whether key exists in the hashtable or not
     */
    public boolean containsKey(KeyType key) {
        for (LinkedList<HashPair<KeyType, ValueType>> pairs: hashTable) {
            if (pairs != null) {
                for (HashPair<KeyType, ValueType> pair : pairs) {
                    if (pair.getKey().equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * removes the hashpair and returns the value associated with the key.
     * @param key the key to be passed in
     * @return the value associated with the HashPair removed
     */
    public ValueType remove(KeyType key) {
        int index = Math.abs(key.hashCode()) % hashTable.length;

        if (hashTable[index] == null) {
            return null;
        } else {
            //check every element in the linked list, see if it's a duplicate
            for (int i = 0; i < hashTable[index].size(); i++) {
                HashPair<KeyType, ValueType> pair = hashTable[index].get(i);
                if (pair.getKey().equals(key)) {
                    if (hashTable[index].size() == 1) {
                        hashTable[index] = null;
                    } else {
                        hashTable[index].remove(i);
                    }
                    size--;
                    return pair.getValue();
                }
            }
        }

        return null;

    }

    /**
     * clears the hashtable.
     */
    public void clear() {
        hashTable = new LinkedList[10];
        this.size = 0;
    }

    /**
     * toString method for this HashTableMap.
     * @param showContents whether to show contents of HashTable or not
     * @return String representation of the HashTable
     */
    public String toString(boolean showContents) {
        String output = "HashTable: \n" +
                "Size: " + size + "\n" +
                "Capacity:" + hashTable.length + "\n";
        if (showContents) {
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[i] != null) {
                    for (HashPair<KeyType, ValueType> pair: hashTable[i]) {
                        output = output + pair.toString() + "\n";
                    }
                }
            }
        }


        return output;

    }

    /**
     * default toString, shows elements by default
     * @return String representation of the HashTable
     */
    @Override
    public String toString() {
       return toString(true);
    }

    /**
     * gets the capacity of the current HashTable
     * @return the current capacity of the HashTable
     */
    public int getCapacity() {
        return hashTable.length;
    }
}

