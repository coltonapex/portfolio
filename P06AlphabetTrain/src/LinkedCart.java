
public class LinkedCart {
  private final Cart CART; // data field of this linked Cart
  private LinkedCart previous; // reference to the previous linked cart in a list of carts
  private LinkedCart next; // reference to the next linked cart in a list of carts
  
  
  LinkedCart(Cart cart){   //Creates a new LinkedCart object with specific data cart and null for both previous and next linked carts
    CART = cart;
  previous = null;
  next = null;
  
  }
    LinkedCart(Cart cart, LinkedCart previous, LinkedCart next){    //Creates a new LinkedCart object with specific data cart, previous and next linked carts
      CART = cart;
      this.previous = previous;
      this.next = next;
    }
  
    
    /**
     * Returns a reference to the data cart of this linked cart
     */
    public Cart getCart() {  
      return CART;   
    
}
    
    
    /**
     * Returns a reference to the next LinkedCart attached to this LinkedCart
     */
    
    public LinkedCart getNext() {//
    return next;
    }
    
    
    /**
     * Returns a reference to the previous LinkedCart attached to this LinkedCart
     */
    
      public LinkedCart getPrevious() {   //Returns a reference to the previous LinkedCart attached to this linked cart
      return previous;
      
    }
      
      /**
       * sets the next LinkedCart attached to this LinkedCart
       */
      public void setNext​(LinkedCart next) {   //Sets the next LinkedCart attached to this LinkedCart
       //next.getCart();
        this.next = next;
      }
      
      
      /**
       * Sets the previous LinkedCart attached to this LinkedCart
       */
    public void setPrevious​(LinkedCart previous) {  //Sets the previous LinkedCart attached to this LinkedCart
      // previous.getCart();
      this.previous = previous;
    }
    
    }
    
    
