//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (P10FoodDelivery)
// Files: (Student.java.FoodRobot.java,DeliveryQueue.java,Delivery.java,DeliverySchedule.java)
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


/**
 * This class holds methods that can manipulate the Queue and also return certain aspects of the
 * queue
 * 
 * @author Colton Carlino
 */

import java.util.NoSuchElementException;

public class DeliveryQueue {

  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;


  /**
   * 
   * Creates a DeliveryQueue
   * 
   */
  public DeliveryQueue() {
    size = 0;
    heap = new Delivery[INITIAL_CAPACITY];
  }

  /**
   * 
   * gets the parent index
   * 
   * @return returns the parent index
   * 
   */
  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  /**
   * 
   * gets the right child index
   * 
   * @return returns the right child index
   * 
   */
  private int getRightIndex(int index) {
    return (2 * index) + 2;
  }

  /**
   * 
   * gets the left child index
   * 
   * @return returns the left child index
   * 
   */
  private int getLeftIndex(int index) {
    return (2 * index) + 1;
  }

  /**
   * 
   * recursively percolates up the heap
   * 
   * @param index the current index passed to percolateUp
   * 
   */
  private void percolateUp(int index) {
    if (index > 0) {
      if (heap[getParentIndex(index)].compareTo(heap[index]) > 0) {
        Delivery hold = heap[getParentIndex(index)];
        heap[getParentIndex(index)] = heap[index];
        heap[index] = hold;
        percolateUp(getParentIndex(index));
      }
    }
  }


  /**
   * 
   * recursively percolates down the heap
   * 
   * @param index the current index passed to percolateDown
   * 
   */
  private void percolateDown(int index) {
    if (heap[getLeftIndex(index)] != null && heap[getRightIndex(index)] != null) {


      if (heap[getRightIndex(index)].compareTo(heap[getLeftIndex(index)]) > 0
          && heap[index].compareTo(heap[getLeftIndex(index)]) > 0) {
        Delivery hold = heap[getLeftIndex(index)];
        heap[getLeftIndex(index)] = heap[index];
        heap[index] = hold;
        percolateDown(getLeftIndex(index));
      }


      else if (heap[getLeftIndex(index)].compareTo(heap[getRightIndex(index)]) > 0
          && heap[index].compareTo(heap[getRightIndex(index)]) > 0) {
        Delivery hold = heap[getRightIndex(index)];
        heap[getRightIndex(index)] = heap[index];
        heap[index] = hold;
        percolateDown(getRightIndex(index));
      }

    }
    if (heap[getLeftIndex(index)] != null) {
      if (heap[getLeftIndex(index)].compareTo(heap[index]) < 0) {
        Delivery hold = heap[getLeftIndex(index)];
        heap[getLeftIndex(index)] = heap[index];
        heap[index] = hold;
        percolateDown(getLeftIndex(index));
      }
    }

    if (heap[getRightIndex(index)] != null) {
      if (heap[getRightIndex(index)].compareTo(heap[index]) < 0) {
        Delivery hold = heap[getRightIndex(index)];
        heap[getRightIndex(index)] = heap[index];
        heap[index] = hold;
        percolateDown(getRightIndex(index));
      }
    }
  }


  /**
   * 
   * eliminates all heap order violations from the heap array
   * 
   * 
   */
  private void heapify() {
    for (int i = (heap.length / 2) - 1; i > 0; i--) {
      percolateDown(i - 1);
    }
  }


  /**
   * 
   * adds an offer to the heap
   * 
   * @param offer the offer being added to the heap
   * 
   */
  public void offerDelivery(Delivery offer) {
    if (size % INITIAL_CAPACITY == 0 && size != 0) {
      Delivery[] temp = heap;
      heap = new Delivery[temp.length * 2];
      for (int i = 0; i < temp.length; i++) {
        heap[i] = temp[i];
      }
    }
    heap[size] = offer;
    percolateUp(size);
    size++;
  }


  /**
   * 
   * removes and returns the highest priority delivery object
   * 
   * @throws throws a NoSuchElementException when the heap is empty
   * 
   * @return returns the highest priority delivery object
   * 
   */
  public Delivery pollBestDelivery() throws NoSuchElementException {

    if (size <= 0) {
      throw new NoSuchElementException("“Warning: Empty Heap!");
    }
    Delivery temp = heap[0];
    for (int i = 0; i < size; i++) {
      if (temp.getStudentID() == heap[i].getStudentID()
          || temp.getRobotName().equals(heap[i].getRobotName())) {
        heap[i] = null;
        for (int j = i; j < size; j++) {
          heap[j] = heap[j + 1];
        }
        size--;
        i = i - 1;
      }
    }
    if (size != 0) {
      heapify();
    }
    return temp;

  }

  /**
   * 
   * returns the highest priority delivery object without removing it
   * 
   * @throws throws a NoSuchElementException when the heap is empty
   * 
   * @return returns the highest priority delivery object
   * 
   */
  public Delivery peek() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("“Warning: Empty Heap!");
    }
    return heap[0];
  }


  /**
   * 
   * gets and returns the size
   *
   * @return returns the size of the heap
   * 
   */
  public int getSize() {
    return size;

  }


  /**
   * 
   * checks if the heap is empty or not
   * 
   * @return returns true is the heap is empty false otherwise
   * 
   */
  public boolean isEmpty() {
    if (size <= 0) {
      return true;
    } else {
      return false;
    }

  }

  @Override
  /**
   * 
   * prints out the contents of the heap
   * 
   * @return returns the string form of the heap
   * 
   */
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }

}
