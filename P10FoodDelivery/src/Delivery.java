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
 * This class implements comparable and accesses and creates delivery objects
 * 
 * @author Colton Carlino
 */

public class Delivery implements Comparable<Delivery> {
  private int studentId;
  private String robotName;
  private int distance;

  /**
   * Constructs a Delivery object
   * 
   * @param student is the student input to get their ID
   * @param robot   is the robot of which you get its name
   * 
   */
  public Delivery(Student student, FoodRobot robot) {
    this.studentId = student.getID();
    this.robotName = robot.getName();
    this.distance =
        Math.abs(student.getX() - robot.getX()) + Math.abs(student.getY() - robot.getY());
  }


  /**
   * gets the distance between a tudent and robot
   * 
   * @return returns the distance between a student and robot
   * 
   */
  public int getDistance() {
    return distance;

  }

  /**
   * gets the student ID
   * 
   * @return returns the student ID
   * 
   */
  public int getStudentID() {
    return studentId;

  }

  /**
   * gets the robots name
   * 
   * @return returns the robots name
   * 
   */
  public String getRobotName() {
    return robotName;

  }


  /**
   * compares two deliveries to check which one is higher priority. It first checks if distance is
   * different if not then it checks if student id is different. If not it compares the robot names
   * to see if those are different
   * 
   * @param anotherDelivery is the delivery that the current one is being compared to
   * 
   * @return returns either a positive or negative number
   * 
   */

  public int compareTo(Delivery anotherDelivery) {
    if (anotherDelivery.distance != distance) {
      return distance - anotherDelivery.distance;
    }
    if (anotherDelivery.studentId != studentId) {
      return studentId - anotherDelivery.studentId;
    }
    return this.robotName.compareTo(anotherDelivery.robotName);
  }



  /**
   *
   * compares objects to check if they are equal to each other
   * 
   * @param deliverEquals is the variable that student ID is being compared to
   * 
   * @return returns true if two things are equal otherwise it returns false
   * 
   */
  public boolean equals(Object deliverEquals) {
    if (deliverEquals instanceof Delivery) {
      return this.studentId == ((Delivery) deliverEquals).studentId
          || this.robotName.equals(((Delivery) (deliverEquals)).robotName);
    }

    if (deliverEquals instanceof Student) {
      return this.studentId == ((Student) deliverEquals).getID();
    }
    if (deliverEquals instanceof FoodRobot) {
      return this.robotName.equals(((FoodRobot) deliverEquals).getName());
    }
    return false;
  }


  /**
   *
   * returns the string representation of the data inputted
   * 
   * @return returns the string representation of the data inputted
   * 
   */
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }

}
