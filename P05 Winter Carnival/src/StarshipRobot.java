import java.io.File;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (P05 Winter Carnival)
// Files: (FrozenStatue.java, WinterCarnival.java, StarshipRobot.java, DancingBadger.java)
// Course: (CS 300, Spring, and 2020)
//
// Author: (Aaron Bath)
// Email: (apbath@wisc.edu )
// Lecturer's Name: (Gary Dahl)
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (Colton Carlino)
// Partner Email: (ccarlino@wisc.edu)
// Partner Lecturer's Name: (Mouna Kacem)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x__ Write-up states that pair programming is allowed for this assignment.
// _x__ We have both read and understood the course Pair Programming Policy.
// _x__ We have registered our team prior to the team registration deadline.
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


public class StarshipRobot extends FrozenStatue {

  float[][] beginAndEnd; // array of two positions, that this robot moves back and forth between the
                         // contents of this 2d array are organized as follows: { { beginX, beginY
                         // }, { endX, endY }}
  float[] destination; // the position that this robot is currently moving towards
  float speed; // the speed in pixels that this robot moves durring each update

  public StarshipRobot(float[][] input) {
    super(new float[] {input[0][0],input[0][1]});
    
    beginAndEnd = input;
    destination = input[1];
    speed = 6;
    isFacingRight = true;
    imageName = new String("images" + File.separator + "starshipRobot.png");
  }

  protected boolean moveTowardDestination() {
    
float distance = (float) Math.sqrt((Math.pow(this.x - destination[0], 2) + Math.pow(this.y- destination[1], 2)));

this.x = (float) (this.x + (speed * (destination[0] - this.x)) / distance);
this.y = (float) (this.y + (speed * (destination[1] - this.y)) / distance);

isFacingRight = destination[0] < this.x;

if(speed*2>distance) {
  return true;
}
else {
  return false;
}
  }
  
  

  protected void updateDestination() {
    float[] temp;
    
    destination = beginAndEnd[0];
    temp = beginAndEnd[1];
    beginAndEnd[1] = beginAndEnd[0];
    beginAndEnd[0] = temp;
}
  
  @Override
  public void update(SimulationEngine engine) {
    if(moveTowardDestination()) {
    updateDestination();
    }
    engine.draw(imageName, x, y, isFacingRight);
  }



  public static void main(String[] args) {

  }

}
