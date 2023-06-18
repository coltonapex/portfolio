//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (BadgerCoasterP08)
// Files: (ThemeParkApp.java, BoardingGroup.java, RideQueue.java, BGNode.java, QueueADT.java)
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
import java.util.Queue;

/**
 * This class holds methods that help determine what the queue should do. As in if it should enqueue
 * or dequeue etc. It also implements QueueADT
 * 
 * @author Colton Carlino
 */

public class RideQueue extends Object implements QueueADT<BoardingGroup> {

  private BGNode front;
  private BGNode back;

  private int capacity;
  private int numOfPeople;
  private int numOfGroups;



  /**
   * Constructs a RideQueue
   * 
   * @param capacity is the given capacity of the queue
   * 
   */
  public RideQueue(int capacity) {
    this.capacity = capacity;
  }

  /**
   * @return Returns the current number of groups
   */

  public int size() {
    return numOfGroups;
  }

  /**
   * determines if the line is empty or not
   * 
   * @return returns true if the line is empty otherwise false
   */
  public boolean isEmpty() {
    if (numOfGroups == 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Adds groups to the queue and also checks if that group is a VIP. If it is that group is pushed
   * to the front
   * 
   * @param groupObject. The new group to be added to the queue
   * 
   * 
   * @throws throws a IllegalStateException if the number of people in the line is over the capacity
   */
  public void enqueue(BoardingGroup groupObject) throws IllegalStateException {
    BGNode newGroup = new BGNode(groupObject);
    if (newGroup.getGroup().getGroupNum() + numOfPeople > capacity) {
      throw new IllegalStateException("Sorry the queue is full");
    }

    if (newGroup.getGroup().getVipGroup()) {
      if (front != null) {
        BGNode current = front;
        newGroup.setNext(current);
        front = newGroup;
        numOfPeople = numOfPeople + newGroup.getGroup().getGroupNum();
        numOfGroups++;
      } else {
        back = newGroup;
        front = newGroup;
        numOfPeople = numOfPeople + newGroup.getGroup().getGroupNum();
        numOfGroups++;
      }
    }

    else {
      if (back != null) {
        BGNode current = back;
        current.setNext(newGroup);
        back = current.getNext();
        numOfPeople = numOfPeople + newGroup.getGroup().getGroupNum();
        numOfGroups++;
      } else {
        back = newGroup;
        front = newGroup;
        numOfGroups++;
        numOfPeople = numOfPeople + newGroup.getGroup().getGroupNum();
      }
    }
  }

  /**
   * Removes groups from the queue
   * 
   * 
   * @throws throws a NoSuchElementException when there is nothing to dequeue
   */
  public BoardingGroup dequeue() throws NoSuchElementException {
    if (front == null && back == null) {
      throw new NoSuchElementException("Empty Queue can not remove anything");
    }

    if (front.getNext() == null) {
      BGNode holder = front;
      front = null;
      back = null;
      numOfGroups--;
      numOfPeople = numOfPeople - holder.getGroup().getGroupNum();
      return holder.getGroup();
    } else {
      BGNode holder = front;
      front = holder.getNext();
      numOfGroups--;
      numOfPeople = numOfPeople - holder.getGroup().getGroupNum();
      return holder.getGroup();
    }
  }

  /**
   * Clears the line
   * 
   */
  public void clear() {
    back = null;
    front = null;
    numOfGroups = 0;
    numOfPeople = 0;
  }

  /**
   * Shows what group is in the front of the queue
   * 
   * @return returns the boarding group that is first in line
   * 
   * @throws throws a NoSuchElementException when there is no front of the line
   */
  public BoardingGroup peek() throws NoSuchElementException {
    if (front == null) {
      throw new NoSuchElementException("There is no front of the line");
    }
    return front.getGroup();
  }


  /**
   * states the number of people in the queue as well as the number of groups in the queue
   * 
   * @return returns the string
   * 
   */

  public String toString() {

    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName =
          current.getGroup().getGroupName();/*
                                             * CALL YOUR ACCESSOR FOR GROUP FOLLOWED BY YOUR
                                             * ACCESSOR FOR NAME HERE ON current
                                             */
      s += groupName + " ";
      current = current.getNext();
    }
    return s;

  }






}
