// --== CS400 File Header Information ==--
// Name: <Colton Carlino>
// Email: <ccarlino@wisc.edu>
// Team: <your team name: two letters>
// TA: <Yeping>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
/**
   * Creates a LinkedList that takes a KeyType and a ValueType
   */
public class LinkedListCreate<KeyType, ValueType> {

  private LinkedListCreate next;
  private KeyType key;
  private ValueType value;
  public LinkedListCreate(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }
  
  /**
   * Gets the key
   * 
   */
  public KeyType getKey() {
    return this.key;
  }
  
  /**
   * Sets the key
   * key: key that is set
   */
  public void setKey(KeyType key) {
  this.key = key;
    
  }
  
  /**
   * Gets the next key
   * 
   */
  public LinkedListCreate getNext() {
    return this.next;
  }
  
  /**
   * Sets the next key
   * @param newNode sets the next node
   * 
   */
  public void setNext(LinkedListCreate newNode) {
    this.next = newNode;
  }
  
  /**
   * Gets the value
   * 
   */
  public ValueType getValue() {
    return this.value;
  }
  
  /**
   * Gets the specified value
   * @param value: the value getting gotten
   * 
   */
  public void getValue(ValueType value) {
  this.value = value;
  }
  
}
