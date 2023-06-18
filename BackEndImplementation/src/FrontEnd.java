// --== CS400 File Header Information ==--
// Name: Tony Busko
// Email: awbusko@wisc.edu
// Team: CC
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.Scanner;


/*
 * This class helps is the bakers user interface to input orders and update stock accordingly.
 */
public class FrontEnd {
    public static Scanner sc = new Scanner(System.in);
    public static String input = "";
    public static BackEnd back = new BackEnd();
    
    //Provides three different options for the user to take (update stock, put in a customer order, and exit)
    public static void runInterfaceOptions() {
      input = "";
      System.out.println("Enter \"1\" to maunnally update stock\nEnter \"2\" to put in a customer order\n" + 
                        "Enter \"3\" to exit");
      input = sc.nextLine();
      
      if (input.equals("1")) 
        updateStock();
      else if (input.equals("2"))
        completeOrder();
      else if (input.equals("3")) {
        sc.close();
        System.out.println("Thanks for using the Bakery Stock Interface");
      }
      else {
        System.out.println("Please selected from one of these three options:");
        runInterfaceOptions();
      } 
    }
    
    //updates the stock whether its removed or adding items
    public static void updateStock() {
      back.addManual(createUpdateStock());    
      System.out.println("Stock updated successfully!\n");
      runInterfaceOptions();
    }
    
    //checks to see if input is a single int 
    public static boolean checkInputInt(String in) {
      if (in.length() != 1 && !checkIfAllInts(in)) {
        System.out.println("Please select from one of these options");
        return false;
      }
      return true;
    }
    
    //completes an order using an order number that will be provided by the website or manually creating one
    public static void completeOrder() {
      String phoneNumber;
      int[] updateStockValues = new int[5];
      
      while (true) {
        System.out.println("Do you have a order number(1) or are you manually creating one(2)?");
        input = sc.nextLine();
        
        if (checkInputInt(input)) {
          if (input.equals("1")) {
            while (true) {
              System.out.println("Please enter the 15 digit order number");
              input = sc.nextLine();
              
              if (input.length() == 15 && checkIfAllInts(input)) {
                phoneNumber = input.substring(0, 10);
                for (int i=0; i < 5; i++) {
                  updateStockValues[i] = Integer.parseInt(input.substring(10 + i, 11 + i)) * -1;
                }
                
                break;
              }
              else
                System.out.println("Please make sure the order number is 15 integers with no spaces or other characters");
            }
            
            back.addManual(updateStockValues);
            break;
          }
          
          if (input.equals("2")) {
            while (true) {
              System.out.println("Please input a 10 digit phone number");
              input = sc.nextLine();
              
              if (input.length() == 10 && checkIfAllInts(input)) {
                phoneNumber = input;
                break;
              }
              else 
                System.out.println("Please make sure the phone number is 10 digits with no spaces or other characters");
            }
            
            updateStockValues = createUpdateStock();
            back.addManual(createUpdateStock());
            break;
          }
        }
      }
      System.out.println("Order complete!\n");
      runInterfaceOptions();
    }
    
    //Creates an array of the stock items that are being added or removed to be passed to Back end
    public static int[] createUpdateStock() {
      int[] updateStockValues = new int[5];
      
      while (true) {
        System.out.println("How much bread would you like to add or remove to the stock? Input a positive integer to add and a negative integer to remove");
        input = sc.nextLine();
        if (checkIfAllInts(input)) {
          updateStockValues[1] = Integer.parseInt(input);
          break;
        }
        System.out.println("Please select from one of these options");
      }
      
      while (true) {
        System.out.println("How many donuts would you like to add or remove to the stock? Input a positive integer to add and a negative integer to remove");
        input = sc.nextLine();
        if (checkIfAllInts(input)) {
          updateStockValues[1] = Integer.parseInt(input);
          break;
        }
        System.out.println("Please select from one of these options");
      }
      
      while (true) {
        System.out.println("How many buns would you like to add or remove to the stock? Input a positive integer to add and a negative integer to remove");
        input = sc.nextLine();
        if (checkIfAllInts(input)) {
          updateStockValues[2] = Integer.parseInt(input);
          break;
        }
        System.out.println("Please select from one of these options");
      }
      
      while (true) {
        System.out.println("How many bagels would you like to add or remove to the stock? Input a positive integer to add and a negative integer to remove");
        input = sc.nextLine();
        if (checkIfAllInts(input)) {
          updateStockValues[3] = Integer.parseInt(input);
          break;
        }
        System.out.println("Please select from one of these options");
      }
      
      while (true) {
        System.out.println("How many cookies would you like to add or remove to the stock? Input a positive integer to add and a negative integer to remove");
        input = sc.nextLine();
        if (checkIfAllInts(input)) {
          updateStockValues[4] = Integer.parseInt(input);
          break;
        }
        System.out.println("Please select from one of these options");
      }  
      
      return updateStockValues;
    }
    
    //Checks if all the characters in a string is an integer. Except if the first integer is a negative to account for negative numbers
    public static boolean checkIfAllInts(String str) {
      if (!Character.isDigit(str.charAt(0)) && !str.substring(0,1).equals("-") )
        return false;
      for (int i=1; i<str.length(); i++) {
        if (!Character.isDigit(str.charAt(i)))
          return false;
      }
      return true;
    }

    public static void main(String[] args) {
      back.load();
      System.out.println("Welcome to the Bakery Stock Interface");
      runInterfaceOptions();
    }
}
