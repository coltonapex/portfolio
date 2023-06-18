import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

public class ExceptionalBankTester {


/**
* This method checks whether the ExceptionalBank constructor throws an
* IllegalArgumentException with appropriate error message, when it is passed
* a zero or a negative capacity. This test must fail if another kind of exception
* is thrown for such test scenario.
*
* @return true when this test verifies a correct functionality, and false otherwise
*/

public static boolean testExceptionalBankConstructor() {
try {
// create an exceptional bank with a negative capacity
ExceptionalBank bank = new ExceptionalBank(-10);
System.out.println(
"Problem detected. The constructor call of the ExceptionalBank class did not "
+ "throw an IllegalArgumentException when it is passed a negative capacity.");
return false; // return false if no exception has been thrown
} catch (IllegalArgumentException e1) {
// check that the caught IllegalArgumentException includes
// an appropriate error message
if (e1.getMessage() == null // your test method should not throw
// a NullPointerException,but must return false if e1.getMessage is null
|| !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
System.out.println(
"Problem detected. The IllegalArgumentException thrown by the constructor "
+ "call of the ExceptionalBank class when it is passed a negative capacity "
+ "does not contain an appropriate error message.");
return false;
}
} catch (Exception e2) {
// an exception other than IllegalArgumentException has been thrown
System.out.println(
"Problem detected. An unexpected exception has been thrown when calling the "
+ "constructor of the ExceptionBank class with a negative argument. "
+ "An IllegalArgumentException was expected to be thrown. "
+ "But, it was NOT the case.");
e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
// constructor code.
return false;
}
return true; // test passed
}

public static boolean testAddCoin() {
try {
ExceptionalBank errorBank = new ExceptionalBank(1);
errorBank.addCoin(null);

} 
catch (IllegalArgumentException e) {
if (e.getMessage() == null || !e.getMessage().contains("WARNING! You cannot add a null reference to this bank")) {
  System.out.println(e.getMessage());
  return false;
}
}
return true;
}


public static boolean testRemoveCoin() {
try {
ExceptionalBank errorBank1 = new ExceptionalBank(1);
errorBank1.removeCoin();
} 
catch (NoSuchElementException e) {
if (e.getMessage() == null || !e.getMessage().contains("WARNING! This bank is empty. Unable to remove a coin.")) {
  System.out.println(e.getMessage());
  return false;
}
}
return true;
}

public static boolean testGoodExceptionalBankConstructor() {
try {
ExceptionalBank goodBank = new ExceptionalBank(20);
if(!( goodBank.getSize() == 0 && goodBank.capacity() == 20)) {
  return false;
}
} 
catch (Exception e) {
return false;
}
return true;
}



public static boolean testAddCoins()  {

try {
ExceptionalBank errorBank1 = new ExceptionalBank(20);
errorBank1.addCoins​(null);
} 
catch (Exception e) {
if (e.getMessage() == null || !e.getMessage().contains("WARNING! The addCoins() method does not accept a null reference as input.")) {
  System.out.println(e.getMessage());
  return false;
}
}

try {
ExceptionalBank errorBank1 = new ExceptionalBank(20);
errorBank1.addCoins​("penny: 5");
} 
catch (DataFormatException e) {
if (e.getMessage() == null || !e.getMessage().contains("The format of the command line " + "penny:ten" + " is incorrect.")) {
  System.out.println(e.getMessage());
  return false;
}
}
catch (Exception e) {
  return false;
}


try {
ExceptionalBank errorBank1 = new ExceptionalBank(20);
errorBank1.addCoins​("pen:20");
} 
catch (Exception e) {
if (e.getMessage() == null || !e.getMessage().contains("The coin name provided in the command line " + "pen:20" + " is invalid.")) {
  System.out.println(e.getMessage());
  return false;
}
}


try {
ExceptionalBank errorBank1 = new ExceptionalBank(20);
errorBank1.addCoins​("Quarters:-10");
} 
catch (DataFormatException e) {
if (e.getMessage() == null || !e.getMessage().contains("The format of the command line " + "Quarters:-10" + " is incorrect.")) {
  System.out.println(e.getMessage());
  return false;
}
}

return true;
}



public static boolean testLoadCoin()  {

try {
ExceptionalBank errorBank1 = new ExceptionalBank();
java.io.File f = new java.io.File("sample3.txt");
errorBank1.loadCoins​(f);
} 
catch (FileNotFoundException e) {
if (e.getMessage() == null || !e.getMessage().contains("WARNING! The addCoins() method does not accept a null reference as input.")) {
  System.out.println(e.getMessage());
  return false;
}
}
return true;
}


public static void main(String[] args) {
  System.out.println("testExceptionalBankConstructor(): " + testExceptionalBankConstructor());
  System.out.println("testAddCoin(): " + testAddCoin());
  System.out.println("testRemoveCoin(): " + testRemoveCoin());
  System.out.println("testAddCoins(): " + testAddCoins());
  System.out.println("testGoodExceptionalBankConstructor(): " + testGoodExceptionalBankConstructor());
  System.out.println("testLoadCoin(): " + testLoadCoin());
}
}



