//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   (PiggyBank)
// Files:   (PiggyBank.java, PiggyBankTester.java,PiggyBankDriver.java)
// Course:  (course number, term, and year)
//
// Author:  (Colton Carlino)
// Email:   (ccarlino@wisc.edu )
// Lecturer's Name: (Mouna Kacem)
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    (Aaron Bath)
// Partner Email:   (apbath@wisc.edu)
// Partner Lecturer's Name: (Gary Dahl)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x__ Write-up states that pair programming is allowed for this assignment.
//   _x__ We have both read and understood the course Pair Programming Policy.
//   _x__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////



public class CalendarTester {

  
  public static boolean testFullCenturiesContained () {
    if(CalendarPrinter.fullCenturiesContained(new Year(2)) != 0) {
      return false;
  }
    if(CalendarPrinter.fullCenturiesContained(new Year(2000)) != 20) { 
      return false;
  }
    if(CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444) {
      return false;
    }
    return true;
   }
  
  public static boolean testYearOffsetWithinCentury () {
    if(CalendarPrinter.yearOffsetWithinCentury(new Year(2)) != 2) {
      return false;
  }
    if(CalendarPrinter.yearOffsetWithinCentury(new Year(2020)) != 20) { 
      return false;
  }
    if(CalendarPrinter.yearOffsetWithinCentury(new Year(44444)) != 44) {
      return false;
    }
    return true;
   }
  
  public static boolean testIsLeapYear() {
    if(CalendarPrinter.isLeapYear(new Year(2)) != false) {
      System.out.println("year1");
      return false;
  }
    if(CalendarPrinter.isLeapYear(new Year(2020)) != true) { 
      System.out.println("year2");
      return false;
  }
    if(CalendarPrinter.isLeapYear(new Year(44444)) != true) {
      System.out.println("year3");
      return false;
    }
    return true;
   }
  
  public static boolean testNumberOfDaysInMonth() {
    Year year1 = new Year(2021);
     MonthOfYear month2 = MonthOfYear.June;
     Year year2 = new Year(2012);
     MonthOfYear month1 = MonthOfYear.February;
     Year year3 = new Year(2020);
     
    
    
    if(CalendarPrinter.numberOfDaysInMonth(new Month(month1,year1)) != 28) {
      System.out.println("year1");
      return false;
  }
    if(CalendarPrinter.numberOfDaysInMonth(new Month(month2,year2)) != 30) { 
      System.out.println("year2");
      return false;
  }
    if(CalendarPrinter.numberOfDaysInMonth(new Month(month1,year3)) != 29) {
      System.out.println("year3");
      return false;
    }
    return true;
   }
  
  public static boolean testCalcFirstDayOfWeekInMonth() {
    Year year1 = new Year(2020);
    MonthOfYear month1 = MonthOfYear.April;
     
     Year year2 = new Year(2012);
     MonthOfYear month2 = MonthOfYear.May;
     
     Year year3 = new Year(1900);
     MonthOfYear month3 = MonthOfYear.January;
     
    
    
    if(CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(month1,year1)) != DayOfWeek.Wednesday) {
      System.out.println("fail1");
     return false;
    }
    if(CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(month2,year2)) != DayOfWeek.Tuesday) {
      System.out.println("fail2");
      return false;
  }
    if(CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(month3,year3)) != DayOfWeek.Monday) {
      System.out.println("fail3");
      return false;
  }
    
    return true;
   }
  
  public static boolean testMonthOfYearAfter() {
      
    
    if(CalendarPrinter.monthOfYearAfter(MonthOfYear.August) != MonthOfYear.September) {
      System.out.println("fail1");
      return false;
      
  }
    if(CalendarPrinter.monthOfYearAfter(MonthOfYear.April) != MonthOfYear.May) {
      System.out.println("fail2");
      return false;
  }
    if(CalendarPrinter.monthOfYearAfter(MonthOfYear.January) != MonthOfYear.February) {
      System.out.println("fail3");
      return false;
  }
    
    return true;
   }
  
  public static boolean testDayOfWeekAfter() {
    
    if(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday) != DayOfWeek.Saturday) {
      System.out.println("fail1");
      return false;
  }
    if(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Saturday) != DayOfWeek.Sunday) {
      System.out.println("fail2");
      return false;
  }
    if(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Wednesday) != DayOfWeek.Thursday) {
      System.out.println("fail3");
      return false;
  }
    
    return true;
   }
  
  public static boolean testCreateNewMonth() {
      
    Year year1 = new Year(2021);
    MonthOfYear month1 = MonthOfYear.February;
     
     Year year2 = new Year(2019);
     MonthOfYear month2 = MonthOfYear.March;
     
     Year year3 = new Year(2011);
     MonthOfYear month3 = MonthOfYear.June;
     
     
     Month name = CalendarPrinter.createNewMonth(month1, year1);
    if(name.getDayCount() != 28) {
      System.out.println("fail1");
      return false;
      
  }
    Month name2 = CalendarPrinter.createNewMonth(month2, year2);
    if(name2.getDayCount() != 31) {
      System.out.println("fail2");
      return false;
      
  }
    Month name3 = CalendarPrinter.createNewMonth(month3, year3);
    if(name3.getDayCount() != 30) {
      System.out.println("fail3");
      return false;
      
  }
    
    return true;
   }
  
  public static boolean testPrintMonth() {
    
    Year year1 = new Year(2020);
    MonthOfYear month1 = MonthOfYear.January;
     
     Year year2 = new Year(2019);
     MonthOfYear month2 = MonthOfYear.March;
     
     Year year3 = new Year(2011);
     MonthOfYear month3 = MonthOfYear.June;
     
     CalendarPrinter.printMonth( new Month(month1,year1));
    
    return true;
   }
  
  public static void main(String[] args) {
    System.out.println("testFullCenturiesContained: "+ testFullCenturiesContained());
    System.out.println("testYearOffsetWithinCentury: "+ testYearOffsetWithinCentury());
    System.out.println("testIsLeapYear: "+ testIsLeapYear());
    System.out.println("testNumberOfDaysInMonth: "+ testNumberOfDaysInMonth());
    System.out.println("testCalcFirstDayOfWeekInMonth: "+ testCalcFirstDayOfWeekInMonth());
    System.out.println("testDayOfWeekAfter: "+ testDayOfWeekAfter());
    System.out.println("testMonthOfYearAfter: "+ testMonthOfYearAfter());
    System.out.println("testCreateNewMonth: "+ testCreateNewMonth());
     testPrintMonth();
  }
  
}

