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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * This class allows the user to see the deepest directory in a file
 * 
 * @author Colton Carlino
 */
public class DeepFileIterator implements Iterator<File> {

  private int nextIndex;

  private File[] folderContents;

  private DeepFileIterator contentsIterator;


  /**
   * Constructs a DeepFileIterator
   * 
   * @param inputFile The file that is iterated through
   * 
   * @throws throws a FileNotFoundException when the file could not be found
   */

  public DeepFileIterator(File inputFile) throws FileNotFoundException {
    if (!inputFile.exists() || !inputFile.isDirectory()) {

      throw new FileNotFoundException("File not found error");

    }
    nextIndex = 0;
    folderContents = inputFile.listFiles();
    Arrays.sort(folderContents);
  }


  /**
   * checks if contentsIterator has a next value
   * 
   * 
   * @return returns true if contentsIterator is not null and hasNext otherwise false
   */

  @Override
  public boolean hasNext() {
    if (contentsIterator != null && contentsIterator.hasNext()) {
      return true;
    }
    if (nextIndex < folderContents.length) {
      return true;
    }
    return false;
  }

  /**
   * Checks if hasNext is true and if it is it iterates through contentsIterator
   * 
   * @throws throws a NoSuchElementException when hasNext is false
   * 
   * @return returns the current file at the given index then increments that index
   */

  @Override
  public File next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("No such element error");
    }
    if (contentsIterator != null && contentsIterator.hasNext()) {
      return contentsIterator.next();
    }

    File hold = folderContents[nextIndex];
    nextIndex++;
    if (hold.isDirectory()) {
      try {

        contentsIterator = new DeepFileIterator(hold);



      } catch (FileNotFoundException e) {
        System.out.println("Error");
        contentsIterator = null;
      }
    }
    return hold;



  }
}
