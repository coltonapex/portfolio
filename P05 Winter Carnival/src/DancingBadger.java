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


public class DancingBadger extends StarshipRobot {

  protected DanceStep[] danceSteps;
  protected int stepIndex;
  
public DancingBadger(float[] input, DanceStep[] steps) {
  super( new float[][] {input, steps[0].getPositionAfter(input)} );
    float x = input[0];
    float y = input[1];
    speed = 2;
    imageName = new String("images" + File.separator + "dancingBadger.png");
    isFacingRight = true;
    destination = steps[0].getPositionAfter(destination); 
    stepIndex = 1;
    danceSteps = steps;
    
  }


protected void updateDestination() {
  float[] temp;
  
  destination = danceSteps[stepIndex].getPositionAfter(destination);
  if(stepIndex < danceSteps.length-1) {
    stepIndex++;
  }
  else {
    stepIndex = 0;
  }
  
}



public static void main(String[] args) {
    
  }
}

