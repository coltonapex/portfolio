//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (PatientRecordSystemP09)
// Files: (PatientRecord.java, PatientRecordNode.java, PatientRecordTree.java,
//////////////// PatientRecordTreeTester.java)
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
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
   * another patientRecord which is older that the one at the root, (4) Try adding a third patient
   * Record which is younger than the one at the root, (5) Try adding at least two further patient
   * records such that one must be added at the left subtree, and the other at the right subtree.
   * For all the above scenarios, and more, double check each time that size() method returns the
   * expected value, the add method call returns true, and that the .toString() method returns the
   * expected string representation of the contents of the binary search tree in an ascendant order
   * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
   * used as a key for a patient record already stored in the tree. Make sure that the
   * addPatientRecord() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {

    PatientRecordTree treeTest1 = new PatientRecordTree();
    if (treeTest1.size() != 0) {
      return false;
    }

    if (!(treeTest1.toString().equalsIgnoreCase(""))) {
      return false;
    }
    if (!(treeTest1.isEmpty())) {
      return false;
    }

    PatientRecordTree treeTest2 = new PatientRecordTree();
    PatientRecord nicole = new PatientRecord("Nicole", "12/7/1998");
    treeTest2.addPatientRecord(nicole);

    if (!(treeTest2.toString().equals(nicole.toString() + "\n"))) {
      System.out.println(treeTest2.toString());
      return false;
    }


    if (treeTest2.isEmpty()) {
      return false;
    }

    if (!(treeTest2.size() == 1)) {
      return false;
    }

    PatientRecordTree treeTest3 = new PatientRecordTree();
    PatientRecord bobby = new PatientRecord("Bobby", "2/2/2010");
    PatientRecord orbit = new PatientRecord("Orbit", "7/30/2008");
    treeTest3.addPatientRecord(bobby);
    treeTest3.addPatientRecord(orbit);

    if (!(treeTest3.toString().equals(orbit.toString() + "\n" + bobby.toString() + "\n"))) {
      return false;

    }

    if (!(treeTest3.size() == 2)) {
      return false;
    }

    PatientRecordTree treeTest4 = new PatientRecordTree();
    PatientRecord bob = new PatientRecord("Bob", "2/2/1991");
    PatientRecord alex = new PatientRecord("Alex", "7/30/2008");
    PatientRecord ben = new PatientRecord("Ben", "8/8/2000");
    treeTest4.addPatientRecord(bob);
    treeTest4.addPatientRecord(alex);
    treeTest4.addPatientRecord(ben);

    if (!(treeTest4.toString()
        .equals(bob.toString() + "\n" + ben.toString() + "\n" + alex.toString() + "\n"))) {
      return false;

    }

    if (!(treeTest4.size() == 3)) {
      return false;
    }

    PatientRecordTree treeTest5 = new PatientRecordTree();
    PatientRecord amy = new PatientRecord("Amy", "2/2/1992");
    PatientRecord lex = new PatientRecord("Lex", "7/30/2008");
    PatientRecord benny = new PatientRecord("Benny", "5/8/2010");
    PatientRecord lenny = new PatientRecord("Lenny", "8/8/1990");
    PatientRecord barry = new PatientRecord("Barry", "8/8/1980");
    treeTest5.addPatientRecord(amy);
    treeTest5.addPatientRecord(lex);
    treeTest5.addPatientRecord(benny);
    treeTest5.addPatientRecord(lenny);
    treeTest5.addPatientRecord(barry);

    if (!(treeTest5.toString().equals(barry.toString() + "\n" + lenny.toString() + "\n"
        + amy.toString() + "\n" + lex.toString() + "\n" + benny.toString() + "\n"))) {
      return false;
    }

    if (!(treeTest5.size() == 5)) {
      return false;
    }

    PatientRecordTree treeTest6 = new PatientRecordTree();
    PatientRecord peter = new PatientRecord("Peter", "12/18/1995");
    PatientRecord jack = new PatientRecord("Jack", "3/20/2000");
    PatientRecord aiden = new PatientRecord("Aiden", "12/18/1995");
    treeTest6.addPatientRecord(peter);
    treeTest6.addPatientRecord(jack);
    treeTest6.addPatientRecord(aiden);

    if (!(treeTest6.toString().equals(peter.toString() + "\n" + jack.toString() + "\n"))) {
      return false;
    }

    if (!(treeTest6.size() == 2)) {
      return false;
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
   * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
   * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
   * try to call lookup() method to search for the patient record at the root of the tree, then a
   * patient records at the right and left subtrees at different levels. Make sure that the lookup()
   * method returns the expected output for every method call. (3) Consider calling .lookup() method
   * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
   * the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {
    PatientRecordTree treeTest1 = new PatientRecordTree();
    try {
      treeTest1.lookup("09/06/2000");
      return false;
    } catch (Exception NoSuchElementException) {
    }
    PatientRecordTree treeTest2 = new PatientRecordTree();
    PatientRecord colton = new PatientRecord("Colton", "09/06/2000");
    PatientRecord aaron = new PatientRecord("Aaron", "10/07/2002");
    PatientRecord nicole = new PatientRecord("Nicole", "12/07/1998");
    PatientRecord libby = new PatientRecord("Libby", "01/20/1999");
    PatientRecord joe = new PatientRecord("Joe", "11/4/1964");
    treeTest2.addPatientRecord(colton);
    treeTest2.addPatientRecord(aaron);
    treeTest2.addPatientRecord(nicole);
    treeTest2.addPatientRecord(libby);
    treeTest2.addPatientRecord(joe);
    if (!(treeTest2.lookup("09/06/2000").equals(colton))) {
      return false;
    }

    if (!(treeTest2.lookup("10/07/2002").equals(aaron))) {
      return false;
    }

    if (!(treeTest2.lookup("11/04/1964").equals(joe))) {
      return false;
    }

    PatientRecordTree treeTest3 = new PatientRecordTree();
    PatientRecord sophia = new PatientRecord("Sophia", "09/20/2002");
    PatientRecord barnard = new PatientRecord("Barnard", "5/17/2010");
    PatientRecord will = new PatientRecord("Will", "03/26/2017");
    treeTest3.addPatientRecord(sophia);
    treeTest3.addPatientRecord(barnard);
    treeTest3.addPatientRecord(will);
    try {
      treeTest3.lookup("4/01/2003");
      return false;
    } catch (Exception NoSuchElementException) {

    }


    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
   * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
   * the height of a PatientRecordTree with the following structure for instance, is 4. (*) / \ (*)
   * (*) \ / \ (*) (*) (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    PatientRecordTree treeNull = new PatientRecordTree();
    if (treeNull.height() != 0) {
      return false;
    }
    PatientRecordTree treeJustOne = new PatientRecordTree();
    PatientRecord sophia = new PatientRecord("Sophia", "01/27/1999");
    treeJustOne.addPatientRecord(sophia);
    if (treeJustOne.height() != 1) {
      return false;
    }


    PatientRecordTree treeTest = new PatientRecordTree();
    PatientRecord colton = new PatientRecord("Colton", "09/06/2000");
    PatientRecord aaron = new PatientRecord("Aaron", "10/07/2002");
    PatientRecord nicole = new PatientRecord("Nicole", "12/07/1998");
    PatientRecord libby = new PatientRecord("Libby", "01/20/1999");
    PatientRecord joe = new PatientRecord("Joe", "11/4/1964");
    PatientRecord rox = new PatientRecord("Rox", "03/05/1965");
    PatientRecord griffin = new PatientRecord("Griffin", "06/16/2001");
    treeTest.addPatientRecord(colton);
    treeTest.addPatientRecord(aaron);
    treeTest.addPatientRecord(nicole);
    treeTest.addPatientRecord(libby);
    treeTest.addPatientRecord(joe);
    treeTest.addPatientRecord(rox);
    treeTest.addPatientRecord(griffin);



    if (treeTest.height() != 4) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {
    PatientRecordTree treeTest = new PatientRecordTree();
    PatientRecord colton = new PatientRecord("Colton", "09/06/2000");
    PatientRecord aaron = new PatientRecord("Aaron", "10/07/2002");
    PatientRecord nicole = new PatientRecord("Nicole", "12/07/1999");
    PatientRecord libby = new PatientRecord("Libby", "01/20/2012");
    PatientRecord joe = new PatientRecord("Joe", "11/4/1964");
    treeTest.addPatientRecord(colton);
    treeTest.addPatientRecord(aaron);
    treeTest.addPatientRecord(nicole);
    treeTest.addPatientRecord(libby);
    treeTest.addPatientRecord(joe);
    if (treeTest.getRecordOfYoungestPatient().toString().equals(libby.toString())) {
      return true;
    }
    System.out.println(treeTest.getRecordOfYoungestPatient().toString());
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {
    PatientRecordTree tree = new PatientRecordTree();
    PatientRecord colton = new PatientRecord("Colton", "09/06/2000");
    PatientRecord aaron = new PatientRecord("Aaron", "10/07/2002");
    PatientRecord nicole = new PatientRecord("Nicole", "12/07/1999");
    PatientRecord libby = new PatientRecord("Libby", "01/20/2012");
    PatientRecord joe = new PatientRecord("Joe", "11/4/1964");
    tree.addPatientRecord(colton);
    tree.addPatientRecord(aaron);
    tree.addPatientRecord(nicole);
    tree.addPatientRecord(libby);
    tree.addPatientRecord(joe);
    if (tree.getRecordOfOldestPatient().toString().equals(joe.toString())) {
      return true;
    }
    System.out.println(tree.getRecordOfOldestPatient().toString());
    return false;
  }


  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out
        .println("testGetRecordOfYoungestPatient returns " + testGetRecordOfYoungestPatient());
    System.out.println("testGetRecordOfOldestPatient returns " + testGetRecordOfOldestPatient());
    System.out.println("testHeight returns " + testHeight());
    System.out.println("testAddPatientRecordAndLookup returns " + testAddPatientRecordAndLookup());
    System.out
        .println("testAddPatientRecordToStringSize returns " + testAddPatientRecordToStringSize());
  }

}
