//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (P07FileFinder)
// Files: (P07Tester.java, ShallowFileIterator.java, DeepFileIterator.java,
//////////////// FilteredFileIterator.java)
// Course: (CS 300, Spring, and 2020)
//
// Author: (Colton Carlino)
// Email: (ccarlino@wisc.edu )
// Lecturer's Name: (Mouna Kacem)
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: ()
// Partner Email: ()
// Partner Lecturer's Name: ()
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The P07Tester Class is a tester class that tests the correctness of
 * ShallowFileIterator,DeepFileIterator and FilteredFileIterator
 *
 *
 * @author (Colton Carlino)
 */

public class P07Tester {

  /**
   * Tests the correctness of the ShallowFileIterator
   * 
   * @param The file that the user selects
   * 
   * @return returns true if the method works as intended otherwise false
   */
  public static boolean testShallowFileIterator(File userInput) {
    String holder = "";

    String expectedResults =
        "assignments, exam preparation, lecture notes, " + "reading notes, todo.txt, ";

    userInput = new File(userInput.getPath() + File.separator);

    try {
      ShallowFileIterator tester = new ShallowFileIterator(userInput);


      while (tester.hasNext()) {


        holder += tester.next().getName() + ", ";
        holder = holder.replace(File.separator, "/");


      }
    } catch (FileNotFoundException e) {
      return false;
    }



    if (expectedResults.equals(holder)) {
      return true;
    }

    else {
      System.out.println(holder);
      return false;
    }

  }


  /**
   * Tests the correctness of the DeepFileIterator
   * 
   * @param The file that the user selects
   * 
   * @return returns true if the method works as intended otherwise false
   */
  public static boolean testDeepFileIterator(File userInput) {
    userInput = new File(userInput.getPath() + File.separator + "assignments");

    String holder = "";
    String totalString = "";
    String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
        + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
        + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";

    try {
      DeepFileIterator tester = new DeepFileIterator(userInput);

      while (tester.hasNext()) {


        holder += tester.next().getName() + ", ";
        holder = holder.replace(File.separator, "/");


      }
    } catch (FileNotFoundException e) {
      return false;
    }



    if (expectedResults.equals(holder)) {
      return true;
    }

    else {
      System.out.println(totalString);
      return false;
    }

  }


  /**
   * Tests the correctness of the FilteredFileIterator
   * 
   * @param The file that the user selects
   * 
   * @return returns true if the method works as intended otherwise false
   */

  public static boolean testFilteredFileIterator(File userInput) {
    String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
        + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
        + "AlphabetTrain.java, codeSamples.java, ";


    userInput = new File(userInput.getPath() + File.separator);

    String holder = "";
    String totalString = "";

    try {
      FilteredFileIterator tester = new FilteredFileIterator(userInput, ".java");

      while (tester.hasNext()) {


        holder += tester.next().getName() + ", ";
        holder = holder.replace(File.separator, "/");


      }
    } catch (FileNotFoundException e) {
      return false;
    }



    if (expectedResults.equals(holder)) {
      return true;
    }

    else {
      System.out.println(holder);
      return false;
    }


  }


  /**
   * Runs the three test methods and prints out if they are true or if they are false
   * 
   */

  public static void main(String[] args) {

    File selectedFile = new File("..\\P07FileFinder\\filesystem");
    if (selectedFile.isDirectory()) {
      System.out
          .println("testShallowFileIterator() returns " + testShallowFileIterator(selectedFile));
      System.out.println("testDeepFileIterator() returns " + testDeepFileIterator(selectedFile));
      System.out
          .println("testFilteredFileIterator() returns " + testFilteredFileIterator(selectedFile));
    } else {
      System.out.println("is not directory");
    }
  }

}
