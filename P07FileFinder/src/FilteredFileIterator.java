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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class allows the user to filter results from the file search
 * 
 * @author Colton Carlino
 */

public class FilteredFileIterator implements Iterator<File> {
  private DeepFileIterator fileIterator;

  private String searchPattern;

  private File nextMatchingFile;


  /**
   * Constructs a FilteredFileIterator
   * 
   * @param inputFile The file that is iterated through
   * 
   * @param search    The string that is used to filter the results
   * 
   * @throws throws a FileNotFoundException when the file could not be found
   */


  public FilteredFileIterator(File inputFile, String search) throws FileNotFoundException {
    if (inputFile != null && inputFile.exists() && inputFile.isDirectory()) {
      searchPattern = search;
      fileIterator = new DeepFileIterator(inputFile);
      nextMatchingFile = fileHelperMethod();
    } else {
      throw new FileNotFoundException("File not found error");
    }
  }

  /**
   * Helps filter out what files the user is and is not searching for
   * 
   * 
   * @return returns the file only if it matches the searchPattern
   */

  private File fileHelperMethod() {
    while (fileIterator.hasNext()) {
      File hold = fileIterator.next();
      if (hold.getName().contains(searchPattern)) {
        return hold;
      }
    }
    return null;
  }

  /**
   * checks if nextMatchingFile is not null
   * 
   * 
   * @return returns true if nextMatchingFile is not equal to null
   */

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    if (nextMatchingFile != null) {
      return true;
    }
    return false;
  }


  /**
   * Checks if hasNext is true and if it is it calls the fileHelperMethod()
   * 
   * @throws throws a NoSuchElementException when hasNext is false
   * 
   */
  @Override
  public File next() throws NoSuchElementException {
    // TODO Auto-generated method stub
    if (hasNext()) {
      File hold = nextMatchingFile;
      nextMatchingFile = fileHelperMethod();
      return hold;
    } else {
      throw new NoSuchElementException("No such element exception");
    }
  }



}
