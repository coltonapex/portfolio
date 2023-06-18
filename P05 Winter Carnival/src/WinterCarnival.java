import java.io.File;
import java.util.ArrayList;

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


public class  WinterCarnival extends SimulationEngine {
  private  ArrayList<FrozenStatue> objects;
  
  public void update() {
    //frozenstatue test
//    float[] testing = new float[] { 400, 300};     
//    FrozenStatue test = new FrozenStatue(testing);
//    test.update( this );

    //wintercarnival test
    //draw("images"+File.separator+"dancingBadger.png", 400, 300, false);
      
    //3. Creating and Updating Multiple FrozenStatue objects
 int i=0;
 for (i=0;i<objects.size();i++) {
   objects.get(i).update( this );
 }
    
  }
  
  public WinterCarnival() {
    float[] floatStatue1 = new float[] { 600, 100};     
  FrozenStatue statue1 = new FrozenStatue(floatStatue1);
  
  float[] floatStatue2 = new float[] { 200, 500};     
  FrozenStatue statue2 = new FrozenStatue(floatStatue2);
  
  
  
  float[][] floatRobot1 = new float[2][2];
  floatRobot1[0][0] = 0;
  floatRobot1[0][1] = 0;
  floatRobot1[1][0] = 600;
  floatRobot1[1][1] = 100;
  
  float[][] floatRobot2 = new float[2][2];
  floatRobot2[0][0] = 800;
  floatRobot2[0][1] = 300;
  floatRobot2[1][0] = 200;
  floatRobot2[1][1] = 500;
  
  StarshipRobot robot1 = new StarshipRobot(floatRobot1);
  StarshipRobot robot2 = new StarshipRobot(floatRobot2);
  
  
  
  float[] floatBadger1 = new float[2];
  floatBadger1[0] = 304;
  floatBadger1[1] = 268;
  
  float[] floatBadger2 = new float[2];
  floatBadger2[0] = 368;
  floatBadger2[1] = 268;
  
  float[] floatBadger3 = new float[2];
  floatBadger3[0] = 432;
  floatBadger3[1] = 268;
  
  float[] floatBadger4 = new float[2];
  floatBadger4[0] = 496;
  floatBadger4[1] = 268;
  
  DanceStep[] danceSteps = new DanceStep[] {DanceStep.Left,DanceStep.Right,DanceStep.Right,DanceStep.Left,DanceStep.Down,DanceStep.Left,DanceStep.Right,DanceStep.Right,DanceStep.Left,DanceStep.Up};
  DancingBadger badger1 = new DancingBadger(floatBadger1,danceSteps);
  DancingBadger badger2 = new DancingBadger(floatBadger2,danceSteps);
  DancingBadger badger3 = new DancingBadger(floatBadger3,danceSteps);
  DancingBadger badger4 = new DancingBadger(floatBadger4,danceSteps);
  
    objects = new ArrayList<>();
    objects.add(statue1);
    objects.add(statue2);
    objects.add(robot1);
    objects.add(robot2);
    objects.add(badger1);
    objects.add(badger2);
    objects.add(badger3);
    objects.add(badger4);
    
  }

  public static void main(String[] args) {

    WinterCarnival carnival = new WinterCarnival();    
    carnival.update();
    
  }
}  

