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
 * This class creates a Student and accesses its components
 * 
 * @author Colton Carlino
 */
public class Student {
  private int x;
  private int y;
  private int id;

  /**
   * Constructs a Student
   * 
   * @param xValue   x position for the student
   * @param yValue   y position for the student
   * @param idNumber is the students ID
   */
  public Student(int xValue, int yValue, int idNumber) {
    this.x = xValue;
    this.y = yValue;
    this.id = idNumber;
  }

  /**
   * 
   * gets the x value of the student
   * 
   * @return returns the x value
   * 
   */
  public int getX() {
    return x;
  }

  /**
   * 
   * gets the y value of the student
   * 
   * @return returns the y value
   * 
   */
  public int getY() {
    return y;
  }

  /**
   * 
   * gets the student ID
   * 
   * @return returns the student ID
   * 
   */
  public int getID() {
    return id;
  }


  /**
   * 
   * puts the Student data into a string
   * 
   * @return returns the string
   * 
   */
  public String toString() {
    return id + "(" + x + ", " + "y" + ")";
  }

}
