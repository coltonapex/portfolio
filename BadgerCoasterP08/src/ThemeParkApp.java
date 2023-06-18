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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Driver for RideQueue. Reads commands from a text files and executes them accordingly.
 * 
 * @author Michelle Jensen
 */
public class ThemeParkApp {
  /**
   * Runs the theme park app
   */
  public static void main(String[] args) throws IOException {
    List<String> fileLines = Files.readAllLines(Paths.get("sample.txt"));
    String command = "";
    String[] commandParts;

    // Default queue capacity and ride capacity. Can change values if desired.
    RideQueue coaster = new RideQueue(50);
    int trainCapacity = 24;

    // Process each line in the text file.
    for (int i = 0; i < fileLines.size(); i++) {
      commandParts = fileLines.get(i).split(" ");
      command = commandParts[0].toUpperCase();

      // ENTER Command
      if (command.equals("E")) {
        enter(coaster, commandParts);
      }

      // BREAKDOWN Command
      if (command.equals("B")) {
        breakdown(coaster);
      }

      // PREVIEW Command
      if (command.equals("P")) {
        preview(coaster);
      }

      // RIDE Command
      if (command.equals("R")) {
        ride(coaster, trainCapacity);
      }

      // STATUS Command
      if (command.equals("S")) {
        status(coaster);
      }
    }
  }

  /**
   * prints out that it is retriving the status of the current queue
   * 
   * @param coaster the current rideQueue
   */
  private static void status(RideQueue coaster) {
    System.out.println("Retrieving Status...");
    System.out.println(coaster.toString());
    System.out.println("------------------------------------");
  }

  /**
   * prints out what groups are entering the line
   * 
   * @param coaster      the current rideQueue
   * 
   * @param commandParts the current command that has been inputed
   */

  private static void enter(RideQueue coaster, String[] commandParts) {
    System.out.println("Entering into ride line...");
    String groupName = commandParts[1];
    int groupSize = Integer.parseInt(commandParts[2]);

    BoardingGroup newGroup = new BoardingGroup(groupName, groupSize);
    /*
     * newGroup = CALL YOUR BoardingGroup CONSTRUCTOR HERE. NOTE: var groupName is the name of the
     * group from the file and var groupsize is the number of people
     */

    if (commandParts.length == 4) {
      if (commandParts[3].toUpperCase().equals("V")) {
        newGroup.setVipGroup(true);
        /* CALL YOUR VIP STATUS MUTATOR HERE ON newGroup */
      }
    }

    try {
      coaster.enqueue(newGroup);
      System.out.println(
          groupName + "'s group of " + groupSize + " has entered the line for Badger Coaster.");
    } catch (IllegalStateException e) {
      System.out.println("Cannot fit group of that size into queue.");
    }

    System.out.println("------------------------------------");
  }


  /**
   * prints out if the ride has broken down
   * 
   * @param coaster the current rideQueue
   */

  private static void breakdown(RideQueue coaster) {
    System.out.println("Ride Breakdown...");
    System.out.println("The ride has broken down. All " + coaster.size()
        + " group(s) have been removed from the line.");
    coaster.clear();
    System.out.println("------------------------------------");
  }


  /**
   * prints out the preview of the front of the line
   * 
   * @param coaster the current rideQueue
   */
  private static void preview(RideQueue coaster) {
    System.out.println("Previewing the front of the line...");

    try {
      BoardingGroup peeked = coaster.peek();
      int peekedSize = peeked.getGroupNum();
      /* peekedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON peeked */
      String peekedName = peeked.getGroupName();
      /* peekedName = CALL YOUR NAME ACCESSOR HERE ON peeked */
      System.out
          .println(peekedName + "'s group of " + peekedSize + " is at the front of the line.");
    } catch (NoSuchElementException e) {
      System.out.println("Cannot look at a group from an empty queue.");
    }

    System.out.println("------------------------------------");
  }


  /**
   * prints out that it is running the ride and who has boarded
   * 
   * @param coaster       the current rideQueue
   * 
   * @param trainCapacity the capcity of the train
   */
  private static void ride(RideQueue coaster, int trainCapacity) {
    System.out.println("Boarding and Running the Ride...");
    int ridingTrain = 0;

    while (!coaster.isEmpty()) {
      BoardingGroup peeked = coaster.peek();
      int peekedSize = peeked.getGroupNum();
      /* peekedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON peeked */

      if (ridingTrain + peekedSize > trainCapacity) {
        break;
      }

      try {
        BoardingGroup removed = coaster.dequeue();
        String removedName = removed.getGroupName();
        /* removedName = CALL YOUR NAME ACCESSOR HERE ON removed */
        int removedSize = removed.getGroupNum();
        /* removedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON removed */

        System.out.println(
            removedName + "'s group of " + removedSize + " has boarded the Badger Coaster train.");

        ridingTrain += removedSize;
      } catch (NoSuchElementException e) {
        System.out.println("Cannot remove a group from an empty queue.");
      }
    }

    if (ridingTrain == 0) {
      System.out.println("There is no one on the train to ride.");
    } else {
      System.out.println("Train of " + ridingTrain + " people has left the ride station.");
    }

    System.out.println("------------------------------------");
  }
}
