// File header comes here
/**
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    
  
    Cart cartObj = new Cart("Boy");   
    LinkedCart testLinkedCart = new LinkedCart(cartObj);
    
    if(!(testLinkedCart.getCart().getCargo() == "Boy")) {
      System.out.println(testLinkedCart.getCart());
      System.out.println(cartObj.toString());
      return false;
    }
    
    
    
    return true;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
    AlphabetList testList = new AlphabetList();
    if(testList.isEmpty()) {
      return true;
    }
    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    try {
    AlphabetList testList = new AlphabetList(-1);
    }
    catch(Exception e) {
      System.out.println("bruh");
      return true;
    }
 
    return false;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
    AlphabetList testList = new AlphabetList();
    Cart testCart = new Cart("E");
    Cart testCart2 = new Cart(null);
    Cart testCart3 = new Cart("Hello");
    Cart testCart4 = new Cart("E"); //need to add duplicate
    
    System.out.println(testList.toString());
    
    testList.add(testCart);
    //testList.add(testCart2);
    testList.add(testCart3);
    testList.add(testCart4);
    System.out.println(testList.toString());
    System.out.println(testList.readForward());
    if(testList.size() == 1) {
      return true;
    }
    System.out.println(testList.size());
    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
    AlphabetList testList = new AlphabetList();
    Cart testCart = new Cart("E");
    Cart testCart2 = new Cart("G");
    Cart testCart3 = new Cart("A");
    Cart testCart4 = new Cart("B");
    
    System.out.println(testList.toString());
    
    testList.add(testCart);
    testList.add(testCart2);
    testList.add(testCart3);
    testList.add(testCart4);
    
    System.out.println("index testing for G: " + testList.indexOf(testCart2));
    System.out.println("get letter at index 3: " + testList.get(3));
    
    System.out.println(testList.toString());
    System.out.println(testList.readForward());
    if(testList.size() == 4) {
      return true;
    }
    System.out.println(testList.size());
    System.out.println();
    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. For each of those scenarios, make sure that the 
   * size of the list is appropriately updated after a call without errors of the add() method, 
   * and that the contents of the list is as expected whatever if list is read in the forward or 
   * backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
    return false;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    return false;
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  
  public static void main(String[] args) {
System.out.println("testLinkedCart returns: " + testLinkedCart());
System.out.println("testAlphabetListConstructorIsEmpty returns: " + testAlphabetListConstructorIsEmpty());
System.out.println("testAlphabetListAdd() returns: " + testAlphabetListAdd());
System.out.println("testAlphabetListAddBadInput() returns: " + testAlphabetListAddBadInput());
System.out.println("testAlphabetListConstructorBadInput() returns: " + testAlphabetListConstructorBadInput());
  }
}
