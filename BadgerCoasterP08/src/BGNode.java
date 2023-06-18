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


/**
 * This class holds methods that make and access BGNodes
 * 
 * @author Colton Carlino
 */
public class BGNode {

  private BoardingGroup group;
  private BGNode next;

  public BGNode(BoardingGroup group) {
    this.group = group;
    this.next = null;
  }

  public BGNode(BoardingGroup group, BGNode next) {
    this.group = group;
    this.next = next;
  }

  /**
   * @return returns the current boarding group
   */
  public BoardingGroup getGroup() {
    return group;
  }

  /**
   * @return returns the next boarding group
   */
  public BGNode getNext() {
    return next;
  }

  /**
   * sets the next boarding group
   */
  public void setNext(BGNode next) {
    this.next = next;
  }

}
