// --== CS400 File Header Information ==--
// Name: <Colton Carlino>
// Email: <ccarlino@wisc.edu>
// Team: CC
// TA: <Yeping>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
/**
   *
   *
   */

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BackEnd {
  /**
   * Initializes the stock HashTableMap
   */
private HashTableMap<FoodType, Integer> stock = new HashTableMap<FoodType, Integer>();

public enum FoodType{
  COOKIES, BROWNIES, CUPCAKES, BREAD, CAKE;

}

/**
 * adds items to the hashTable and updates the csv afterwards
 * the int[] array currentItems has counts of each FoodType in each index:
 * 0 = COOKIES
 * 1 = BROWNIES
 * 2 = CUPCAKES
 * 3 = BREAD
 * 4 = CAKE
 *
 * @param currentItems is the number of items passed in
 */
public void addManual(int[] currentItems) {
  HashTableMap<FoodType, Integer> updatedStock = new HashTableMap<FoodType, Integer>();
  for (int i = 0; i < currentItems.length; i++) {
      int item = stock.get(FoodType.values()[i]);
      item += currentItems[i];
      updatedStock.put(FoodType.values()[i], item);
  }
  stock = updatedStock;
  write();
}


 

/**
 * removes items to the hashTable and updates the csv afterwards
 * the int[] array currentItems has counts of each FoodType in each index:
 * 0 = COOKIES
 * 1 = BROWNIES
 * 2 = CUPCAKES
 * 3 = BREAD
 * 4 = CAKE
 *
 * @param currentItems is the number of items passed in
 */
public void removeManual(int[] currentItems) {
  HashTableMap<FoodType, Integer> updatedStock = new HashTableMap<FoodType, Integer>();
  for (int i = 0; i < currentItems.length; i++) {
      int item = stock.get(FoodType.values()[i]);
      item -= currentItems[i];
      updatedStock.put(FoodType.values()[i], item);
  }
  stock = updatedStock;
  write();
}

/**
 * codes that are checked for and what they mean
     * CC: cookies
     * BB: brownies
     * CP: cupcakes
     * BD: bread
     * CK: cake
 * @param customerID: this parameter takes the customers ID and the number of what code is wanted on the end of it
 */
public void removeItems(String customerID) throws Exception {
int[] items = new int[] {0, 0, 0, 0, 0};
ArrayList<String>tobeScanned = new ArrayList<String>();
Scanner scan = new Scanner(customerID);
while(scan.hasNext()) {
  tobeScanned.add(scan.next());
}
for (String id : tobeScanned) {
  System.out.println(id);
  String idString = id.substring(0, 2);
  if(idString.equals("CC")) {
    items[0] = Integer.parseInt(id.substring(2));
  }
  if(idString.equals("BB")) {
    items[1] = Integer.parseInt(id.substring(2));
  }
  if(idString.equals("CP")) {
    items[2] = Integer.parseInt(id.substring(2));
  }
  if(idString.equals("BD")) {
    items[3] = Integer.parseInt(id.substring(2));
  }
  if(idString.equals("CK")) {
    items[4] = Integer.parseInt(id.substring(2));
  }
  else {
    throw new Exception("Invalid customerID given");
  }
  
}
removeManual(items);

}

/**
 * loads the csv into the hashTable
 */
public void load() {
  DataWrangler.readCSV(stock, "stock.csv");
}

/**
 * Writes hashTable into the csv
 */
public void write() {
  DataWrangler.writeCSV(stock, "stock.csv");
}

//public HashTableMap<FoodType, Integer> show() {
 //eturn stock;
//} 


}


