// File Header comes here
import java.util.NoSuchElementException;

/**
 * This class implements a binary search tree (BST) which stores a set of patient records. The left
 * subtree contains the patient records of all the patients who are older than the patient who's
 * PatientRecord is stored at a parent node. The right subtree contains the patient records of all
 * the patients who are younger than the patient who's PatientRecord is stored at a parent node.
 *
 */
public class PatientRecordTree {
  private PatientRecordNode root; // root of this binary search tree
  private int size; // total number of patient records stored in this tree.

  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this PatientRecordTree is empty, false otherwise
   */
  public boolean isEmpty() {
    if (root == null)
      return true;
    else {
      return false;
    }
  }


  private int sizeHelperMethod(PatientRecordNode node) {
    if (node == null)
      return 0;
    else {
      return (sizeHelperMethod(node.getLeftChild()) + sizeHelperMethod(node.getRightChild())) + 1;
    }
  }

  /**
   * Returns the number of patient records stored in this BST.
   * 
   * @return the size of this PatientRecordTree
   */
  public int size() {
    return size = sizeHelperMethod(root);
  }

  /**
   * Recursive helper method to add a new PatientRecord to a PatientRecordTree rooted at current.
   * 
   * @param current   The "root" of the subtree we are inserting newRecord into.
   * @param newRecord The PatientRecord to be added to a BST rooted at current.
   * @return true if the newRecord was successfully added to this PatientRecordTree, false otherwise
   */
  public static boolean addPatientRecordHelper(PatientRecord newRecord, PatientRecordNode current) {

    int checker = newRecord.getDateOfBirth().compareTo(current.getPatientRecord().getDateOfBirth());
    PatientRecordNode holder = new PatientRecordNode(newRecord);
    if (checker == 0) {
      return false;
    }
    if (checker > 0) {
      if (current.getRightChild() == null) {
        current.setRightChild(holder);
        return true;
      } else {
        return addPatientRecordHelper(newRecord, current.getRightChild());
      }
    }

    if (checker < 0) {
      if (current.getLeftChild() == null) {
        current.setLeftChild(holder);
        return true;
      } else {
        return addPatientRecordHelper(newRecord, current.getLeftChild());
      }
    }
    return false;
  }

  /**
   * Adds a new PatientRecord to this PatientRecordTree
   * 
   * @param newRecord a new PatientRecord to add to this BST.
   * @return true if the newRecord was successfully added to this BST, and returns false if there is
   *         a match with this PatientRecord already stored in this BST.
   */
  public boolean addPatientRecord(PatientRecord newRecord) {

    PatientRecordNode holder = new PatientRecordNode(newRecord);
    if (isEmpty()) { // Add newRecord to an empty PatientRecordTree
      root = holder;
      return true;

    } else {// Add newRecord to an non-empty PatientRecordTree

      return addPatientRecordHelper(newRecord, root);
    }
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a PatientRecordTree is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current PatientRecordNode within this BST.
   * @return a String representation of all the PatientRecords stored in the sub-tree
   *         PatientRecordTree rooted at current in increasing order with respect to the patients
   *         dates of birth. Returns an empty String "" if current is null.
   */
  public static String toStringHelper(PatientRecordNode current) {

    if (current == null) {
      return "";
    } else {
      return toStringHelper(current.getLeftChild()) + current.getPatientRecord().getName() + "("
          + current.getPatientRecord().getStringDateOfBirth() + ")" + "\n"
          + toStringHelper(current.getRightChild());
    }
  }

  /**
   * Returns a String representation of all the PatientRecords stored within this BST in the
   * increasing order, separated by a newline "\n". For instance: "Sarah(1/2/1935)" + "\n" +
   * "George(5/27/1943)" + "\n" + "Adam(8/12/1972)" + "\n" + "Norah(11/23/1985)" + "\n" +
   * "William(6/4/1998)" + "\n" + "Nancy(9/12/2003)" + "\n" + "Sam(4/20/2019)" + "\n"
   * 
   * @return a String representation of all the PatientRecords stored within this BST sorted in an
   *         increasing order with respect to the dates of birth of the patients (i.e. from the
   *         oldest patient to the youngest patient). Returns an empty string "" if this BST is
   *         empty.
   */
  public String toString() {

    return toStringHelper(root);
  }

  /**
   * Search for a patient record (PatientRecord) given the date of birth as lookup key.
   * 
   * @param date a String representation of the date of birth of a patient in the format mm/dd/yyyy
   * @return the PatientRecord of the patient born on date.
   * @throws a NoSuchElementException with a descriptive error message if there is no PatientRecord
   *           found in this BST having the provided date of birth
   */
  public PatientRecord lookup(String date) throws NoSuchElementException {
    PatientRecord findRecord = new PatientRecord("", date);
    return this.lookupHelper(findRecord, root);
  }

  /**
   * Recursive helper method to lookup a PatientRecord given a reference PatientRecord with the same
   * date of birth in the subtree rooted at current
   * 
   * @param findRecord a reference to a PatientRecord target we are lookup for a match in the BST
   *                   rooted at current.
   * @param current    "root" of the subtree we are looking for a match to findRecord within it.
   * @return reference to the PatientRecord stored stored in this BST which matches findRecord.
   * @throws NoSuchElementException with a descriptive error message if there is no patient record
   *                                whose date of birth matches date, stored in this BST.
   */
  private PatientRecord lookupHelper(PatientRecord findRecord, PatientRecordNode current)
      throws NoSuchElementException {
    int checker =
        current.getPatientRecord().getDateOfBirth().compareTo(findRecord.getDateOfBirth());
    if (checker == 0) {
      return current.getPatientRecord();
    }
    if (checker < 0) {
      if (current.getRightChild() == null) {
        throw new NoSuchElementException("No patient record matches this");
      } else {
        return lookupHelper(findRecord, current.getRightChild());
      }
    }
    if (checker > 0) {
      if (current.getLeftChild() == null) {
        throw new NoSuchElementException("No patient record matches this");
      } else {
        return lookupHelper(findRecord, current.getLeftChild());
      }
    }
    throw new NoSuchElementException("No patient record matches this");
  }

  /**
   * Computes and returns the height of this BST, counting the number of nodes (PatientRecordNodes)
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current PatientRecordNode within a PatientRecordTree
   * @return height of the subtree rooted at current, counting the number of PatientRecordNodes
   */
  public static int heightHelper(PatientRecordNode current) {
    if (current == null) {
      return 0;
    } else {
      return 1
          + Math.max(heightHelper(current.getLeftChild()), heightHelper(current.getRightChild()));
    }
  }


  /**
   * Returns the PatientRecord of the youngest patient in this BST.
   * 
   * @return the PatientRecord of the youngest patient in this BST and null if this tree is empty.
   */
  public PatientRecord getRecordOfYoungestPatient() {

    if (root == null) {
      return null;
    } else {
      PatientRecordNode current = root;

      while (current.getRightChild() != null) {
        current = current.getRightChild();
      }
      return current.getPatientRecord();
    }
  }

  /**
   * Returns the PatientRecord of the oldest patient in this BST.
   * 
   * @return the PatientRecord of the oldest patient in this BST, and null if this tree is empty.
   */
  public PatientRecord getRecordOfOldestPatient() {
    if (root == null) {
      return null;
    } else {
      PatientRecordNode current = root;

      while (current.getLeftChild() != null) {
        current = current.getLeftChild();
      }
      return current.getPatientRecord();
    }
  }

}
