import java.io.File;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title: (P05 Winter Carnival)
//Files: (FrozenStatue.java, WinterCarnival.java, StarshipRobot.java, DancingBadger.java)
//Course: (CS 300, Spring, and 2020)
//
//Author: (Aaron Bath)
//Email: (apbath@wisc.edu )
//Lecturer's Name: (Gary Dahl)
//
////////////PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
//Partner Name: (Colton Carlino)
//Partner Email: (ccarlino@wisc.edu)
//Partner Lecturer's Name: (Mouna Kacem)
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_x__ Write-up states that pair programming is allowed for this assignment.
//_x__ We have both read and understood the course Pair Programming Policy.
//_x__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Students who get help from sources other than their partner and the course
//staff must fully acknowledge and credit those sources here. If you did not
//receive any help of any kind from outside sources, explicitly indicate NONE
//next to each of the labels below.
//
//Persons: NONE
//Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////


public class FrozenStatue {
  protected float x; // the horizontal position of this object in pixels from 0-left to 800-right
  protected float y; // the vertical position of this object in pixels from 0-top to 600-bottom
  protected boolean isFacingRight; // used to mirror image (flip left to right) only when this field is false
  protected String imageName; //the relative path to the image file (from the working directory)

  public FrozenStatue(float[] Point) {
   x = Point[0];
   y = Point[1];
   isFacingRight =true;
   imageName = new String("images"+File.separator+"frozenStatue.png");
  }
  
  public void update(SimulationEngine engine) {
    engine.draw(imageName, x, y, isFacingRight);
    
  }
  
  
  
public static void main(String[] args) {
    
  }
  
}

