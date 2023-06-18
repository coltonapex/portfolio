// --== CS400 File Header Information ==--
// Name: <Colton Carlino>
// Email: <ccarlino@wisc.edu>
// Team: <your team name: two letters>
// TA: <Yeping>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

/**
 *creates a hash table and implements the methods needed to populate and remove from the hash table
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  private KeyType key;
  private ValueType value;
  private int size = 0;
  public int capacity = 0;
  // array of linked lists
  private LinkedListCreate<KeyType, ValueType>[] table;

  /**
   * @param capacity: the capacity of the HashMap
   * Constructs a HashTable object with a capacity
   * 
   */
  public HashTableMap(int capacity) {
    table = new LinkedListCreate[capacity];
    this.capacity = capacity;
    // capacity tied to size of array

  }
  
  /**
   * Constructs a HashTableMap object with a capacity of 10
   * 
   */
  public HashTableMap() {
    table = new LinkedListCreate[10];
    capacity = 10;
  }

@Override
// put ID in new linkedList array
/**
 * puts a key with its value into the HashMap
 * 
 * @param key: takes the hash key of the HashMap
 * @param value: takes the value to be put in the HashMap
 * @return returns a true when it inserts a linkedlist node and false when it doesn't
 */
public boolean put( KeyType key, ValueType value) {
  if (capacity == 0) {
    return false;
  }
  
  int hashID = Math.abs((key.hashCode())% capacity);
  
  if(table[hashID]!= null) {
    LinkedListCreate<KeyType,ValueType> hold = table[hashID];
    while (hold!= null) {
    if(hold.getKey().equals(key)) {
      return false;
    }
    else {
    hold = hold.getNext();
    }
  }
  
  
  LinkedListCreate<KeyType,ValueType> newNodes = new LinkedListCreate<KeyType,ValueType>(key,value);
  newNodes.setNext(table[hashID]);
  table[hashID] = newNodes;
  int checkSize = size();
  if(checkSize >= capacity *.8 ) {
    
    rehash();
  }
  }
  else {
    LinkedListCreate<KeyType,ValueType> headNode = new LinkedListCreate<KeyType, ValueType>(key, value);
    table[hashID] = headNode;
    int checkSize = size();
   if(checkSize >= capacity *.8 ) {
     
     rehash();
   }
   return true;
  }
  return false;
}

/**
 * rehashes the HashMap and stores the values back into them
 */
  private void rehash() {
    capacity = capacity * 2;
    LinkedListCreate<KeyType, ValueType>[] holder = table;
    table = new LinkedListCreate[capacity];

    for (int i = 0; i < holder.length; i++) {
      if (holder[i] != null) {
        LinkedListCreate<KeyType, ValueType> place = holder[i];
        put(place.getKey(), place.getValue());
        while (place.getNext() != null) {
          place = place.getNext();
          put(place.getKey(), place.getValue());
        }
      }
      continue;
    }
  }
  

  @Override
  /**
   * searches for a specific key
   * 
   * @param key: the object that get searches for and returns if it is there 
   * @throws NoSuchElementException when the key does not exist or is null
   * @return returns the object that has been gotten
   */
  public Object get(Object key) throws NoSuchElementException {
    // TODO Auto-generated method stub
    if(capacity == 0) {
      return null;
    }
    int hashID = Math.abs((key.hashCode())% capacity);
    LinkedListCreate<KeyType,ValueType> hold = table[hashID];
    while(hold!=null) {
      if(hold.getKey().equals(key)) {
        return hold.getValue();
      }
      else {
        hold = hold.getNext();
      }
    }
    throw new NoSuchElementException("Key not contained");
  }

  @Override
  /**
   * returns the size of the HashMap
   */
  public int size() {
    // TODO Auto-generated method stub
    size = 0;
    for(int i = 0; i<table.length; i++) {
      if(table[i] != null) {
        LinkedListCreate<KeyType, ValueType> place = table[i];
      
      while(place != null) {
        size++;
        if(place.getNext() != null) {
          place = place.getNext();
        }
        else {
          break;
        }
      }
      }
    }
    return size;
  }

  @Override
  public boolean containsKey(Object key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  /**
   * 
   * removes a key from the HashMap
   * 
   * @param key: key that is removed from the HashMap
   * @return returns the removed key
   * 
   */
  public Object remove(Object key) {
    if(capacity == 0) {
      return null;
    }
    int hashID = Math.abs(key.hashCode())% capacity;
    LinkedListCreate<KeyType, ValueType> marker = table[hashID];
    LinkedListCreate<KeyType, ValueType> previousSpot = null;
    while(marker!= null) {
      if(marker.getKey().equals(key)) {
        Object saver = marker.getKey();
        if(previousSpot == null && marker.getNext() != null) {
          table[hashID] = marker.getNext();
        }
        if(previousSpot != null && marker.getNext() == null) {
          previousSpot.setNext(null);
        }
        if(previousSpot == null && marker.getNext() != null) {
          previousSpot.setNext(marker.getNext());
        }
        if(previousSpot == null && marker.getNext() == null) {
          size--;
          table[hashID] = null;
        }
        return saver;
      }
      else {
        previousSpot = marker;
        marker = marker.getNext();
      }
    }
    return null;
  }

  @Override
  /**
   * Clears the entire HashMap
   *  
   */
  public void clear() {
    for(int i = 0; i < table.length; i++) {
      if(table[i] != null);
      table[i] = null;
    }
    // TODO Auto-generated method stub

  }



}
