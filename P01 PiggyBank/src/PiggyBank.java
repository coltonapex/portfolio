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


import java.util.Random;

public class PiggyBank {
  public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
  // coins names
  public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
  public final static String NO_SUCH_COIN = "N/A"; // N/A string
  private final static Random RAND_GEN = new Random(100); // generator of random integers



  /**
   * Returns the name of a specified coin value
   * 
   * @param coin represents a coin value in cents.
   * @return the String name of a specified coin value if it is valid and N/A if the coin value is
   *         not valid
   */


  public static String getCoinName(int coin) {

    int i;

    for (i = 0; i < COINS_VALUES.length; i++) {
      if (COINS_VALUES[i] == coin) {
        return COINS_NAMES[i];
      }
    }
    return NO_SUCH_COIN;
  }


  /**
   * Returns the balance of a piggy bank in cents
   * 
   * @param coins an oversize array which contains all the coins held in a piggy bank
   * @param size  the total number of coins stored in coins array
   * @return the total value of the coins held in a piggy bank in cents
   */
  public static int getBalance(int[] coins, int size) {

    int i;
    int total = 0;

    for (i = 0; i < size; i++) {
      total = total + coins[i];
    }

    return total;
  }

  /**
   * Returns the total number of coins of a specific coin value held in a piggy bank
   *
   * @param coinValue the value of a specific coin
   * @param coins     an oversize array which contains all the coins held in a piggy bank
   * @param size      the total number of coins stored in coins array
   * @return the number of coins of value coinValue stored in the array coins
   */
  public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
    int total = 0;
    int i;

    for (i = 0; i < size; i++) {
      if (coins[i] == coinValue) {
        total++;
      }
    }


    return total;
  }

  /**
   * Displays information about the content of a piggy bank
   *
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  number of coin held array coins
   */
  public static void printPiggyBank(int[] coins, int size) {
    System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
    System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
    System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
    System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
    System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
  }

  /**
   * Adds a given coin to a piggy bank. This operation can terminate successfully or unsuccessfully.
   * For either cases, this method displays a descriptive message for either cases.
   *
   * @param coin  the coin value in cents to be added to the array coins
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  the total number of coins contained in the array coins before this addCoin method
   *              is called.
   * @return the new size of the coins array after trying to add coin.
   */
  public static int addCoin(int coin, int[] coins, int size) {

    if (getCoinName(coin).equals(NO_SUCH_COIN)) {
      System.out.println(coin + " cents is not a valid US currency coin.");
      return size;
    }

    if (size >= coins.length) {
      System.out
          .println("Tried to add a " + coin + ", but could not because the piggy bank is full.");
      return size;
    }
    size++;
    coins[size - 1] = coin;
    System.out.println("Added a " + coin + ".");

    return size;
  }

  /**
   * Removes an arbitrary coin from a piggy bank. This method may terminate successfully or
   * unsuccessfully. In either cases, a descriptive message is displayed.
   *
   * @param coins an oversize array which contains the coins held in a piggy bank
   * @param size  the number of coins held in the coins array before this method is called
   * @return the size of coins array after this method returns successfully
   */
  public static int removeCoin(int[] coins, int size) {

    if (size < 1) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
      return size;
    }



    int index = RAND_GEN.nextInt(size);

    int i;
    size = size - 1;
    System.out.println("Removed a " + getCoinName(coins[index]) + ".");
    for (i = index; i < size; i++) {
      coins[i] = coins[i++];
    }

    return size;
  }

  /**
   * Removes all the coins in a piggy bank. It also displays the total value of the removed coins
   *
   * @param coins an oversize array storing the coins held in a piggy bank application
   * @param size  number of coins held in coins array before this method is called
   * @return the new size of the piggy bank after removing all its coins.
   */
  public static int emptyPiggyBank(int[] coins, int size) {
    int i;

    if (size <= 0) {
      System.out.println("Zero coin removed. The piggy bank is already empty.");
      return 0;
    }

    System.out.println("All done. " + getBalance(coins, size) + " cents removed.");
    for (i = 0; i < size; i++) {
      coins[i] = 0;
    }

    return 0;
  }

  
  
  
  
  /**
   * Removes all the coins in a piggy bank. It also displays the total value of the removed coins
   *
   * @param valueToRemove  the target index that is to be removed
   * @param size  number of coins held in coins array before this method is called
   * @return the modified array
   */
  private static int[] removeSpecific(int valueToRemove, int coins[], int size) {
    int i = 0;

    for (i = valueToRemove; i < size; i++) {

      coins[i] = coins[(i + 1)];

    }
    coins[(size)] = 0;
    // checking
    System.out.print("array actually is "); //remove
    for (i = 0; i < size; i++) {
      System.out.print(coins[i] + " ");
    }
    System.out.println(""); //remove


    return coins;
  }


  /**
   * Removes the least number of coins needed to fulfill a withdrawal request
   *
   * @param amount amount to withdraw given in cents
   * @param coins  an oversize array storing the coins held in a piggy bank
   * @param size   number of coins stored in coins array before this method is called
   * @return perfect size array of 5 elements, index 0 stores the new size of the piggy bank after
   *         this method returns. Indexes 1, 2, 3, and 4 store respectively the number of removed
   *         quarters, dimes, nickels, and pennies.
   */
  public static int[] withdraw(int amount, int[] coins, int size) {
    int i;

    int[] holder = new int[coins.length];

    for (i = 0; i < coins.length; i++) {
      holder[i] = coins[i];
    }

    if (amount > getBalance(coins, size)) {
      System.out
          .println("Unable to withdraw " + amount + " cents. NOT enough money in the piggy bank.");
      return coins;
    }

    int balance = getBalance(coins, size);

    int quarterI = getSpecificCoinCount(25, coins, size);
    int dimeI = getSpecificCoinCount(10, coins, size);
    int nickleI = getSpecificCoinCount(5, coins, size);
    int pennyI = getSpecificCoinCount(1, coins, size);

    int amount2 = amount;


    int[] total = new int[5];
    total = new int[] {size, 0, 0, 0, 0}; // return array

    total[0] = size;
    while (amount >= 25 && quarterI >= 1) {
      amount = amount - 25;
      quarterI--;
      total[0] = total[0] - 1;
      total[1] = total[1] + 1;
    }
    while (amount >= 10 && dimeI >= 1) {
      amount = amount - 10;
      dimeI--;
      total[0] = total[0] - 1;
      total[2] = total[2] + 1;
    }
    while (amount >= 5 && nickleI >= 1) {
      amount = amount - 5;
      nickleI--;
      total[0] = total[0] - 1;
      total[3] = total[3] + 1;
    }
    while (amount >= 1 && pennyI >= 1) {
      amount = amount - 1;
      pennyI--;
      total[0] = total[0] - 1;
      total[4] = total[4] + 1;
    }

    if (amount == 0) {
      int quarterF = total[1];
      int dimeF = total[2];
      int nickleF = total[3];
      int pennyF = total[4];
      int indexRemove = 0;

      System.out.print("array originally is ");//remove
      for (i = 0; i < size; i++) {
        System.out.print(coins[i] + " ");
      }
      System.out.println("");

      // quarter
      while (quarterF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 25) {
            System.out.println("it hit 25" + "(" + i + ")");//remove
            quarterF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }

      // dime
      while (dimeF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 10) {
            System.out.println("it hit 10" + "(" + i + ")");//remove
            dimeF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }

      // nickle
      while (nickleF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 5) {
            System.out.println("it hit 5" + "(" + i + ")");//remove
            nickleF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }
      // penny
      while (pennyF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 1) {
            System.out.println("it hit 1" + "(" + i + ")");//remove
            pennyF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }

      // checking
      System.out.print("array finally is ");//remove
      for (i = 0; i < size; i++) {
        System.out.print(coins[i] + " ");
      }
      System.out.println("");

      return total;
    }


    total = new int[] {size, 0, 0, 0, 0}; // return array

    quarterI = getSpecificCoinCount(25, coins, size);
    dimeI = getSpecificCoinCount(10, coins, size);
    nickleI = getSpecificCoinCount(5, coins, size);
    pennyI = getSpecificCoinCount(1, coins, size);

    total[0] = size;

    while (amount2 >= 25 && quarterI >= 1) {
      amount2 = amount2 - 25;
      quarterI--;
      total[0] = total[0] - 1;
      total[1] = total[1] + 1;
    }
    while (amount2 >= 10 && dimeI >= 1) {
      amount2 = amount2 - 10;
      dimeI--;
      total[0] = total[0] - 1;
      total[2] = total[2] + 1;
    }
    while (amount2 >= 5 && nickleI >= 1) {
      amount2 = amount2 - 5;
      nickleI--;
      total[0] = total[0] - 1;
      total[3] = total[3] + 1;
    }
    while (amount2 >= 1 && pennyI >= 1) {
      amount2 = amount2 - 1;
      pennyI--;
      total[4] = total[4] + 1;
    }

    if (amount2 > 0) {
      total[4] = 0;
      if (nickleI >= 1) {
        total[0] = total[0] - 1;
        nickleI--;
        total[3] = total[3] + 1;
      }
      int quarterF = total[1];
      int dimeF = total[2];
      int nickleF = total[3];
      int pennyF = total[4];
      int indexRemove = 0;

      System.out.print("array originally is ");//remove
      for (i = 0; i < size; i++) {
        System.out.print(coins[i] + " ");
      }
      System.out.println("");

      // quarter
      while (quarterF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 25) {
            System.out.println("it hit 25" + "(" + i + ")");//remove
            quarterF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }

      // dime
      while (dimeF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 10) {
            System.out.println("it hit 10" + "(" + i + ")");//remove
            dimeF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }

      // nickle
      while (nickleF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 5) {
            System.out.println("it hit 5" + "(" + i + ")");//remove
            nickleF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }
      // penny
      while (pennyF >= 1) {

        for (i = 0; i < size; i++) {
          if (coins[i] == 1) {
            System.out.println("it hit 1" + "(" + i + ")");//remove
            pennyF--;
            size = size - 1;
            coins = removeSpecific(i, coins, size);
            break;
          }
        }
      }

      // checking
      System.out.print("array finally is ");//remove
      for (i = 0; i < size; i++) {
        System.out.print(coins[i] + " ");
      }
      System.out.println("");

      return total;
    }



    return total;
  }


}




