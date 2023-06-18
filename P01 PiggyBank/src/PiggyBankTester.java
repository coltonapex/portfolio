//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   (PiggyBank)
// Files:   (PiggyBank.java, PiggyBankTester.java,PiggyBankDriver.java)
// Course:  (course number, term, and year)
//
// Author:  (Colton Carlino)
// Email:   (ccarlino@wisc.edu )
// Lecturer's Name: (Mouna Kacem)
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    (Aaron Bath)
// Partner Email:   (apbath@wisc.edu)
// Partner Lecturer's Name: (Gary Dahl)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x__ Write-up states that pair programming is allowed for this assignment.
//   _x__ We have both read and understood the course Pair Programming Policy.
//   _x__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////



public class PiggyBankTester {

  /**
   * Checks whether PiggyBank.getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getBalanceTestMethod() {
    // scenario 1 - empty piggy bank
    int[] coins = new int[10]; // array storing the coins held in a piggy bank
    int size = 0; // number of coins held in coins array
    if (PiggyBank.getBalance(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an empty piggy bank.");
      return false;
    }
    // scenario 2 - non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    size = 5;
    if (PiggyBank.getBalance(coins, size) != 42) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, a nickel, a dime, and a quarter.");
      return false;
    }
    // scenario 3 - another non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0};
    size = 3;
    if (PiggyBank.getBalance(coins, size) != 16) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, a nickel, and a dime, only.");
      return false;
    }
    return true;
  }

  
  /**
   * Checks whether PiggyBank.getSpecificCoinCountTestMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getSpecificCoinCountTestMethod() {

    int[] coins = new int[] {1, 2, 5};
// looks for nickels with only one instance
    if (!(PiggyBank.getSpecificCoinCount(5, coins, 3) == 1)) {
      return false;
    }

    int[] coins2 = new int[] {1, 1, 1, 1, 2000, 5};
 // looks for pennies with multiple instances.
    if (!(PiggyBank.getSpecificCoinCount(1, coins2, 6) == 4)) {
      return false;
    }

    int[] coins3 = new int[] {1, 2, 5};
 // looks for quarter when no instance exists
    if (!(PiggyBank.getSpecificCoinCount(25, coins3, 3) == 0)) {
      return false;
    }

    return true;
  }


  /**
   * Checks whether PiggyBank.getCoinNameTestMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getCoinNameTestMethod() {
    // change some coin values and names
    PiggyBank.COINS_NAMES[1] = "Two cents";
    PiggyBank.COINS_NAMES[3] = "Fifty Cents";
    PiggyBank.COINS_VALUES[1] = 2;
    PiggyBank.COINS_VALUES[3] = 50;

    // consider all coin values as input arguments
    for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
      if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
        return false;
    // consider input argument which does not correspond to a coin value
    if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
      return false;
    if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
      return false;
    return true;
  }

  /**
   * Checks whether PiggyBank.addCoinTestMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean addCoinTestMethod() {
// checks if size stays the same
    int[] coins = new int[] {1, 2, 5};
    int size = 2;
    int coin = 33;
    if (!(PiggyBank.addCoin(coin, coins, size) == 2)) {
      System.out.println("fail");
      return false;
    }


 // checks if it will add coin when size is greater than length
    int[] coins3 = new int[] {1, 1, 1, 1, 2000, 5};
    int size3 = 55;
    int coin3 = 1;
    if ((!(PiggyBank.addCoin(coin3, coins3, size3) == 55))) {
      System.out.println("fail2");
      return false;
    }
// checks if it actually adds a coin
    int[] coins2 = new int[] {1, 1, 1, 1, 2000, 5};
    int size2 = 5;
    int coin2 = 1;
    if ((!(PiggyBank.addCoin(coin2, coins2, size2) == 6))) {
      System.out.println("fail3");
      return false;
    }

    return true;
  }


  
  /**
   * Checks whether PiggyBank.removeCoinTestMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean removeCoinTestMethod() {


    int[] coins = new int[] {1, 1, 1, 1, 2000, 5};
    // checks if size is one less than it was before
    // returns false if failed
    if ((!(PiggyBank.removeCoin(coins, 3) == 2))) {
      return false;
    }

    return true;
  }

  
  /**
   * Checks whether PiggyBank.withdrawTestMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean withdrawTestMethod() {

    // checks if withdrawl removed the amount of coins that it should have
    int[] coins = new int[] {1, 1, 5, 5, 5, 10, 10, 25, 25};
    int[] total = new int[] {6, 1, 1, 1, 0};
    if ((PiggyBank.withdraw(40, coins, 9).equals(total))) {
      return false;
    }
    
    //checks if the right amount of smallest change over value is taken
    coins = new int[] {1, 1, 5, 5, 5, 10, 25};
    total = new int[] {6, 1, 1, 1, 0};
    if ((PiggyBank.withdraw(48, coins, 7).equals(total))) {
      return false;
    }
    return true;

  }


  /**
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {

    System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
    System.out.println("getBalanceTest(): " + getBalanceTestMethod());
    System.out.println("getSpecificCoinCountTestMethod(): " + getSpecificCoinCountTestMethod());
    System.out.println("getSpecificCoinCountTestMethod(): " + addCoinTestMethod());
    System.out.println("removeCoinTestMethod():" + removeCoinTestMethod());
    System.out.println("withdrawTestMethod():" + withdrawTestMethod());
  }

}



