import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// --== CS400 File Header Information ==--
// Name: Nikolaj Hindsbo
// Email:Hindsbo@wisc.edu
// Team: CC
// Role: Data Wrangler 1
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: 

public class DataWrangler {
  
 /*
  * This class helps with reading and writing CSV files for our clients (the bakers).
  * Using FrontEnd as input from the baker, they can modify their stock & the CSV file will update
  * appropriately. Alternatively, they can input their own excel sheets and this class can help with
  * reading the CSV file and adding the stock to the HashTableMap used for this project.
  */
  
  /*
   * The purpose of this method is to read the CSV file, which contains
   * information about the hashtable that contains the stock of the bakery.
   * This function also changes the values stored inside the hashtable.
   * @param - stock - The hashtable containing all of the items that the baker has for his bakery.
   * @param - fileName - the name of the CSV file that is being read
   * @returns - none   ---> This method simply changes the values of the hashtable.
   */
  
  public static void readCSV(HashTableMap<BackEnd.FoodType, Integer> stock, String fileName) {
    // Get all types of food.
    BackEnd.FoodType[] allTypes = BackEnd.FoodType.values();
    
    // Now, read all the content of the CSV file.
    BufferedReader br = null;
    String line = "";
    ArrayList<String> allLines = new ArrayList<String>();
    try {
      br = new BufferedReader(new FileReader(fileName));
      while((line = br.readLine()) != null) {
        // Will parse line to an arraylist, which will be read later.
        allLines.add(line);
      }
    }
    catch(Exception e ) {
      e.printStackTrace();
      return;
    }
    finally {
      if(br != null) {
        try {
          br.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    // Now, we have an arrayList of the CSV file, which we will use
    // to find out which values we need to change in the hashtable.
    addValuesToHashTable(stock, allLines, allTypes);
    
    // Now, the hash table has been updated from the CSV file.
  }
  
  /*
   * The purpose of this method is to read the hashtable, and write an appropriate
   * CSV file, which contains information on the stock of the bakery.
   * @param - stock - The hashtable containing all of the items that the baker has for his bakery.
   * @param - fileName - the name of the file that is being written to
   * @returns  - None         --> Simply writes to the CSV file.
   */
  
  public static void writeCSV(HashTableMap<BackEnd.FoodType, Integer> stock, String fileName) {
    // The hashtable contains all of the items that are in stock for the bakery. Simply, we need to get
    // all values from this hash table and write them appropriately into the CSV file.
    
    
    // Opening the CSV file to be able to write to it.
    FileWriter csvWriter = null;
    try {
      csvWriter = new FileWriter(fileName);
    } catch (IOException e1) {
      // If an error happens, we return with a printed error.
      e1.printStackTrace();
      return;
    }
    
    //After the file is open, writing to it is useful.
    String currentItem = "";
    Integer currentAmount;
    Integer amount;
    BackEnd.FoodType[] allTypes = BackEnd.FoodType.values();
    
    // Goes through all types of food and sees if they are stored in the hashtable.
    for(int i = 0; i < allTypes.length; i++) {
      // Checks if the certain type of food is contained inside the hash table.
      if(stock.containsKey(allTypes[i])) {
        // If the certain type of key is contained in the hash table, we will append it to the CSV with
        // the appropriate amount of stock associated with the item.
        amount = stock.get(allTypes[i]);
        try {
          // Writes to file in formatting: ITEM  NUMBER
          csvWriter.append(allTypes[i].name());
          csvWriter.append(",");
          csvWriter.append(amount.toString());
          csvWriter.append("\n");
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          return;
        }
        
      }
    }
    
    
    //Now, closing the file.
    try {
      csvWriter.flush();
      csvWriter.close();
    } catch (IOException e) {
      // If an error occurs, we return with a printed error.
      e.printStackTrace();
      return;
    }
    
  }
  

  /*
   * The purpose of this method is to act as a helper method to update the hashtable appropriately.
   * @param - stock - The hashtable containing all of the items that the baker has for his bakery.
   * @param - allLines - all lines in the CSV file
   * @param - typesOfFood - all types of food from the BackEnd enumeration.
   * @returns - None      --> simply adds the items to the hash table.
   */
  
  private static void addValuesToHashTable(HashTableMap stock, ArrayList<String> allLines,
      BackEnd.FoodType[] typesOfFood) {
    
    String currentName = "";
    Integer currentAmount;
    for(int i = 0; i < allLines.size(); i++) {
      String[] currentLine = allLines.get(i).split(",");
      // Data is stored in NAME NUMBER forat, so first index will contain the name
      // and the second will contain the amount the baker has.
      currentName = currentLine[0];
      currentAmount = Integer.parseInt(currentLine[1]);
      // For simplicity, we can compare the name to the enums of the Backend class to add to the hashtable.
      switch(currentName) {
        case("COOKIES"):
          stock.put(typesOfFood[0], currentAmount);
          break;
        case("BROWNIES"):
          stock.put(typesOfFood[1], currentAmount);
          break;
        case("CUPCAKES"):
          stock.put(typesOfFood[2], currentAmount);
          break;
        case("BREAD"):
          stock.put(typesOfFood[3], currentAmount);
          break;
        case("CAKE"):
          stock.put(typesOfFood[4], currentAmount);
          break;
      }
    }
  }
}
