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
 * This class holds methods that help make and access boarding groups
 * 
 * @author Colton Carlino
 */

public class BoardingGroup {

  private int groupNum;
  private String groupName;
  private boolean VIP;

  /**
   * Constructs a BoardingGroup
   * 
   * @param numOfPeople The number of people in the group
   * 
   * @param groupName   The name of the group of the newly created object
   * 
   */
  public BoardingGroup(String groupName, int numOfPeople) {
    this.groupName = groupName;
    this.groupNum = numOfPeople;
    this.VIP = false;
  }

  /**
   * Constructs a BoardingGroup that is a VIP group
   * 
   * @param numOfPeople The number of people in the group
   * 
   * @param groupName   The name of the group of the newly created object
   * 
   * @param VIP         checks whether or not the group is a VIP
   */

  public BoardingGroup(String groupName, int numOfPeople, boolean VIP) {
    this.groupName = groupName;
    this.groupNum = numOfPeople;
    this.VIP = VIP;
  }

  /**
   * @return returns the group number
   */
  public int getGroupNum() {
    return groupNum;
  }

  /**
   * @return returns the group name
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * sets the group name
   */

  public void setGroupName(String name) {
    groupName = name;
  }

  /**
   * sets the number of people in the group
   */
  public void setGroupNum(int num) {
    groupNum = num;
  }

  /**
   * @return returns true if the group is VIP false otherwise
   */
  public boolean getVipGroup() {
    return VIP;
  }


  /**
   * sets the VIP status
   */
  public void setVipGroup(boolean check) {
    VIP = check;
  }

}
