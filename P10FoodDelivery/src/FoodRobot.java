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
 * This class creates a foodRobot and accesses its components
 * 
 * @author Colton Carlino
 */

public class FoodRobot {

  private int x;
  private int y;
  private String name;

  /**
   * Constructs a FoodRobot
   * 
   * @param xValue    x position for the robot
   * @param yValue    y position for the robot
   * @param robotName is the robots name
   */
  public FoodRobot(int xValue, int yValue, String robotName) {
    this.x = xValue;
    this.y = yValue;
    this.name = robotName;
  }


  /**
   * 
   * gets the x value of the FoodRobot
   * 
   * @return returns the x value
   * 
   */
  public int getX() {
    return x;
  }


  /**
   * 
   * gets the y value of the FoodRobot
   * 
   * @return returns the y value
   * 
   */
  public int getY() {
    return y;
  }


  /**
   * 
   * gets the name of the robot
   * 
   * @return returns the name of the robot
   * 
   */
  public String getName() {
    return name;
  }

  /**
   * 
   * puts the FoodRobot data into a string
   * 
   * @return returns the string
   * 
   */
  public String toString() {
    return name + "(" + x + ", " + "y" + ")";
  }


}
