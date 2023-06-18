/**
 * A driver class to try out and test the Candidate instantiable class.
 *
 * @author CS 200
 */
public class CandidateTester {

  public static void main(String [] args) {

    //********************************************************
    //Task 3: Using the Candidate class
    //********************************************************
    Candidate candidate1 = new Candidate();
    Candidate candidate2 = new Candidate();
    Candidate candidate3 = new Candidate();
    String name1 = "George Washington";
    String name2 = "Thomas Jefferson";

    // The code below tests the accessor and mutator methods
    // already coded in the Candidate class.
    System.out.println("*** Calling setName() ***");
    candidate1.setName(name1);
    candidate2.setName(name2);
    candidate3.setName("Benjamin Franklin");

    System.out.println("*** Testing getName() ***");
    System.out.println("Candidate1's name: " + candidate1.getName()
                            + " should be " + name1);
    System.out.println("Candidate2's name: " + candidate2.getName()
                            + " should be " + name2);
    System.out.println("Candidate3's name: " + candidate3.getName()
                            + " should be Benjamin Franklin");

    //********************************************************
    // ADD CODE LIKE ABOVE TO TEST THAT YOUR OTHER ACCESSOR AND
    // MUTATOR METHODS WORK CORRECTLY.
    //
    // When you are finished this "driver" program should
    // test each method of the Candidate class.
    //********************************************************

  }

}