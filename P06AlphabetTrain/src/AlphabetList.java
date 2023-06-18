

public class AlphabetList extends Object implements SortedListADT<Cart>{

  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that can be added to this sorted list
private static final Cart MAX_CART = new Cart("Z"); // The largest cart that can be added to this sorted list
private LinkedCart head; // head of this doubly linked list
private LinkedCart tail; // tail of this doubly linked list
private int size; // size of this list
private int capacity; // maximum number of carts which can be stored in this list

/**
 * Constructs an AlphabetList object with capacity at 26
 * 
 */

public AlphabetList(){ //Creates an empty doubly linked list of carts with a capacity equals to 26
  capacity = 26;
  head = null;
  tail = null;
  size = 0;
}


/**
 * Constructs an AlphabetList where the user can set the capacity
 * 
 * @param Capacity: takes the initial capacity of the list 
 * @throws illegal argument exception is thrown if capacity is not a non-zero positive integer an 
 */


public AlphabetList(int capacity) {//Creates an empty doubly linked list of carts with a given capacity
  
  if(capacity <= 0) {
    throw new java.lang.IllegalArgumentException("The capacity of this list must be a non-zero a positive integer.");
  }
  
  this.capacity = capacity;
  head = null;
  tail = null;
  size = 0;
  
}

/**
 * Checks if the list is empty
 * @return returns true if list is empty
 */

@Override
public boolean isEmpty() {
  if(head == null && tail == null) {
    return true;
  }
  
  return false;
}


/**
 * Adds a cart to the list. If the list is full and it tries to add a cart 
 * it.
 * @throws throws an Illegal State Exception the same is true if it tries adding a null object
 * 
 * @param newObject: the new cart object to be added to the list
 */

@Override
public void add(Cart newObject) {
  if(size >= capacity) {
    throw new java.lang.IllegalStateException("This list is full. Cannot add another cart.");
  }
  
//try {
//  if(newObject != null) {
//    
//  }
//}
//catch(Exception e){
//  throw new java.lang.IllegalStateException("Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
//
// }
    try {
  if( newObject.toString().length() > 1 || newObject.compareTo(MIN_CART)<0 || newObject.compareTo(MAX_CART)>0) {
    throw new java.lang.IllegalStateException("Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
  }
 
  } catch(Exception e){
    return;
  }
    
 
    
  
  LinkedCart newLinkedCart = new LinkedCart(newObject);
  LinkedCart currentCart = head;
  if (size == 0) {
    head = newLinkedCart;
    tail = newLinkedCart;
    size++;
    System.out.println("nothing in list");
    return;
  }
  
  if(head.getCart().compareTo(newObject) > 0) {
    newLinkedCart.setNext​(head);
    head.setPrevious​(newLinkedCart);
    head = newLinkedCart;
    size++;
    //System.out.println("head update");
    return;
  }
  
  if(tail.getCart().compareTo(newObject) < 0) {
    tail.setNext​(newLinkedCart);
    newLinkedCart.setPrevious​(tail);
    tail = newLinkedCart;
    size++;
    //System.out.println("tail update");
    return;
  }
  
  //LinkedCart newEdition = new LinkedCart(newObject);
  currentCart = head;
  

  
  
  for(int i = 0; i < size; i++) { 
    int g =i +1;
     //System.out.println("loop ran " + g+ " times, size:" +size);
     
      if(currentCart.getCart().compareTo(newObject)> 0) {
        //System.out.println("middle update");
        size++;
        newLinkedCart.setNext​(currentCart);
        if(currentCart.getPrevious() !=null) {
          newLinkedCart.setPrevious​(currentCart.getPrevious());
          currentCart.getPrevious().setNext​(newLinkedCart);
         
        }
        currentCart.setPrevious​(newLinkedCart);
       
        break;
      }  
      
      currentCart = currentCart.getNext();
      
      
 } 

  
}

/**
 * 
 * @Return returns the size of the list
 */

@Override
public int size() {
  return size;
}

/**
 * Clears the list
 */
@Override
public void clear() {
  head = null;
  tail = null;
  size = 0;
}



/**
 * Gets the index for the letter in the cart
 * @param index is the given index that this method looks for before returning
 * the index.
 * 
 * @throws throws an Out of bounds exception if the index is invalid
 * 
 * @Return returns the index of the carts letter
 */
@Override
public Cart get(int index) {
  if(index<0 || index>=size) {
    throw new java.lang.IndexOutOfBoundsException("Invalid index");
  }
  
  LinkedCart currentCart = head;
  
  for(int i = 0; i<index;i++) {
    currentCart = currentCart.getNext();
  }
  return currentCart.getCart();

}

/**
 * Gets the index for the letter in the cart
 * 
 * @Return returns the letter of the cart at the given index
 */

@Override
public int indexOf(Cart findObject) {
  
  LinkedCart current = head;
  int position = 0;
  for(int i = 0; i < size; i++) {
    if(current.getCart().compareTo(findObject)==0) {
      return position;
    }
    current = current.getNext();
    position++;
  }
  return -1;
}


/**
 * Removes a cart at the given index
 * 
 * @Return returns
 */
@Override
public Cart remove(int index) {
  if(index<0 || index>=size) {
    throw new java.lang.IndexOutOfBoundsException("Invalid index");
  }
  
  LinkedCart removeCart;
  LinkedCart currentCart = head;
  
  for(int i=0; i<index; i++) {
    currentCart = currentCart.getNext();
  }
  
  if(currentCart.getNext().getCart() != null) {
    if(currentCart.getPrevious() == head) {
    currentCart.getNext().setPrevious​(currentCart.getPrevious());
    }
  }


    if(currentCart.getNext() == tail) {
    currentCart.getPrevious().setNext​(currentCart.getNext());
    }
  
    size--;
  
  
  
  return currentCart.getCart();
}


/**
 * Reads the list in order from head to tail and prints it out
 */
public String readForward() {
  String string = "";
  LinkedCart currentCart = head;
  while (currentCart != null) {
  string += currentCart.getCart().toString();
  currentCart = currentCart.getNext();
  }
  return string;
  
}


/**
 * Reads the list in order from tail to head and prints it out
 */
public String readBackward() {
  String string = "";
  LinkedCart currentCart = tail;
  while (currentCart != null) {
  string += currentCart.getCart().toString();
  currentCart = currentCart.getPrevious();
  }
  return string;
  
}

public String toString() {
  
  String string = "This list contains " + size + " cart(s)";
  if (size == 0) {
  return string;
  }
  string += ": [ ";
  LinkedCart currentCart = head;
  while (currentCart != null) {
  string += currentCart.getCart().toString() + " ";
  currentCart = currentCart.getNext();
  }
  string += "]";
  return string;
  
  
}





}
