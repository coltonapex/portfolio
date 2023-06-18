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



import java.util.Scanner;
import java.util.ArrayList;

public class CalendarPrinter {


  
  /**
  * Calculates the number of centuries (rounded down) between year 0 and the
  * specified year. For example, the year 2034 has the century index of 20 (as do
  * the other years 2000-2099).
  * @param year to compute the century offset for
  * @return number of centuries between year 0 and the specified year
  */
  public static int fullCenturiesContained(Year year) {
    
    String holder = year.toString();
    if(holder.length()<=2) {
      return 0;
    }
    int centuryCount = Integer.parseInt(holder.substring(0,holder.length()-2));
    
    
    return centuryCount;
  }
  
  
  /**
  * Calculates the number of years between the specified year and the first year of
  * its century. For example, the year 2034 has the offset within its century of 34
  * (as do 1234 and 9999934).
  * @param year to compute the offset within century for
  * @return number of years between the specified year and the first year of century
  */
  public static int yearOffsetWithinCentury(Year year) {
    
    String holder = year.toString();
    int initial = Integer.parseInt(holder); 
    
    int century = fullCenturiesContained(year)*100;
    
    int difference =  initial -century;
    
    return difference;
    
  }
  
  /**
  * This method computes whether the specified year is a leap year or not.
  * @param year is the year is being checked for leap-year-ness
  * @return true when the specified year is a leap year, and false otherwise
  */
  public static boolean isLeapYear(Year year) {
//    if (year is not divisible by 4) then (it is a common year)
//    else if (year is not divisible by 100) then (it is a leap year)
//    else if (year is not divisible by 400) then (it is a common year)
//    else (it is a leap year)
    String holder = year.toString();
    int yearInt = Integer.parseInt(holder); 
    
    if(!(yearInt%4 ==0)){
      return false;
    }
    else if(!(yearInt%100 ==0)) {
      return true;
    }
    else if (!(yearInt%400 ==0)) {
      return false;
    }
    else {
    return true;
    }
    
  }
  
  /**
  * Calculates the number of days in the specified month, while taking into
  * consideration whether or not the specified month is in a leap year.
  * Note: that this is calculated based on the month's monthOfYear and year, and
  * is NOT retrieved from the month's getDayCount() method. This is because this
  * method is used to generate the day objects that are stored within each month.
  * @param month to determine the number of days within (within its year)
  * @return the number of days in the specified month (between 28-31)
  */ 
  public static int numberOfDaysInMonth(Month month) {
    if(isLeapYear(month.getYear()) == true && month.getMonthOfYear() == MonthOfYear.February) {
      return 29;
    }
     if(month.getMonthOfYear() == MonthOfYear.January || month.getMonthOfYear() == MonthOfYear.March||month.getMonthOfYear() == MonthOfYear.May || month.getMonthOfYear() == MonthOfYear.July||month.getMonthOfYear() == MonthOfYear.August||month.getMonthOfYear() == MonthOfYear.October||month.getMonthOfYear() == MonthOfYear.December) {
      return 31;
    }
    
     if(month.getMonthOfYear() == MonthOfYear.April||month.getMonthOfYear() == MonthOfYear.June||month.getMonthOfYear() == MonthOfYear.September || month.getMonthOfYear() == MonthOfYear.November) {
      return 30;
    }
   
     
      return 28;
    
  }
  /**
  * Calculates which day of the week the first day of the specified month falls on.
  * Note: that this is calculated based on the month's monthOfYear and year, and
  * is NOT retrieved from the month's getDayByDate(1) day. This is because this
  * method is used to generate the day objects that are stored within each month.
  * @param month within which we are calculate the day of week for the first day
  * @return DayOfWeek corresponding to the first day within the specified month
  */
  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
   
    String holder = month.getYear().toString();
    int intYear = Integer.parseInt(holder); 
    
    
   
    int intMonth =0;
    
    if(month.getMonthOfYear() == MonthOfYear.March) {
      intMonth=3;
    }
    if(month.getMonthOfYear() == MonthOfYear.April) {
      intMonth=4;
    }
    if(month.getMonthOfYear() == MonthOfYear.May) {
      intMonth=5;
    }
    if(month.getMonthOfYear() == MonthOfYear.June) {
      intMonth=6;
    }
    if(month.getMonthOfYear() == MonthOfYear.July) {
      intMonth=7;
    }
    if(month.getMonthOfYear() == MonthOfYear.August) {
      intMonth=8;
    }
    if(month.getMonthOfYear() == MonthOfYear.September) {
      intMonth=9;
    }
    if(month.getMonthOfYear() == MonthOfYear.October) {
      intMonth=10;
    }
    if(month.getMonthOfYear() == MonthOfYear.November) {
      intMonth=11;
    }
    if(month.getMonthOfYear() == MonthOfYear.December) {
      intMonth=12;
    }
    
    if(intYear == 2000 || intYear ==1900 || intYear == 1800 ) {
      int hold = fullCenturiesContained(month.getYear());
      hold = hold -1;
      
      
      
    if(month.getMonthOfYear() == MonthOfYear.January) {
      intMonth=13;
      if(2==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7){
        return DayOfWeek.Monday;
      }
      if(3==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Tuesday;
      }
      if(4==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Wednesday;
      }
      if(5==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Thursday;
      }
      if(6==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        System.out.println("brug");
        return DayOfWeek.Friday;
      }
      if(0==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Saturday;
      }
      
      return DayOfWeek.Sunday;
      
    }
    if(month.getMonthOfYear() == MonthOfYear.February) {
      intMonth=14;   
      if(2==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Monday;
      }
      if(3==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Tuesday;
      }
      if(4==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Wednesday;
      }
      if(5==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Thursday;
      }
      if(6==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Friday;
      }
      if(0==(1 + (((13*(intMonth+1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(hold)/4) + (5*hold))%7) {
        return DayOfWeek.Saturday;
      }
      
      return DayOfWeek.Sunday;
    }
    }
    
    if(month.getMonthOfYear() == MonthOfYear.January) {
      intMonth=13;
      if(2==(1 + ((13*(intMonth +1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Monday;
      }
      if(3==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Tuesday;
      }
      if(4==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Wednesday;
      }
      if(5==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Thursday;
      }
      if(6==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Friday;
      }
      if(0==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Saturday;
      }
      
      return DayOfWeek.Sunday;
      
    }
    if(month.getMonthOfYear() == MonthOfYear.February) {
      intMonth=14;   
      if(2==(1 + ((13*(intMonth +1))/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Monday;
      }
      if(3==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Tuesday;
      }
      if(4==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Wednesday;
      }
      if(5==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Thursday;
      }
      if(6==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Friday;
      }
      if(0==(1 + (13*(intMonth +1)/5)+((intYear-1)%100) +((intYear-1)%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
        return DayOfWeek.Saturday;
      }
      
      return DayOfWeek.Sunday;
    }
    
      
    if(2==(1 + ((13*(intMonth +1))/5)+((intYear)%100) +(intYear%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
      return DayOfWeek.Monday;
    }
    if(3==(1 + (13*(intMonth +1)/5)+((intYear)%100) +(intYear%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
      return DayOfWeek.Tuesday;
    }
    if(4==(1 + (13*(intMonth +1)/5)+((intYear)%100) +(intYear%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
      return DayOfWeek.Wednesday;
    }
    if(5==(1 + (13*(intMonth +1)/5)+((intYear)%100) +(intYear%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
      return DayOfWeek.Thursday;
    }
    if(6==(1 + (13*(intMonth +1)/5)+((intYear)%100) +(intYear%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
      return DayOfWeek.Friday;
    }
    if(0==(1 + (13*(intMonth +1)/5)+((intYear)%100) +(intYear%100/4)+(fullCenturiesContained(month.getYear())/4) + (5*fullCenturiesContained(month.getYear())))%7) {
      return DayOfWeek.Saturday;
    }
    
    return DayOfWeek.Sunday;
    
  }
  /**
  * Calculates the day of the week that follows the specified day of week.
  * For example, Thursday comes after Wednesday, and Monday comes after Sunday.
  * @param dayBefore is the day of week that comes before the day of week returned
  * @return day of week that comes after dayBefore
  */
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
    
    if (dayBefore == DayOfWeek.Monday){
      return DayOfWeek.Tuesday;
    }
    if (dayBefore == DayOfWeek.Tuesday){
      return DayOfWeek.Wednesday;
    }
    if (dayBefore == DayOfWeek.Wednesday){
      return DayOfWeek.Thursday;
    }
    if (dayBefore == DayOfWeek.Thursday){
      return DayOfWeek.Friday;
    }
    if (dayBefore == DayOfWeek.Friday){
      return DayOfWeek.Saturday;
    }
    if (dayBefore == DayOfWeek.Saturday){
      return DayOfWeek.Sunday;
    }
    return DayOfWeek.Monday;
  }
  
  /**
  * Calculates the month of the year that follows the specified month. For example,
  * July comes after June, and January comes after December.
  * @param monthBefore is the month that comes before the month that is returned
  * @return month of year that comes after monthBefore
  */
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
    
    if (monthBefore == MonthOfYear.January){
      return MonthOfYear.February;
    }
    if (monthBefore == MonthOfYear.February){
      return MonthOfYear.March;
    }
    if (monthBefore == MonthOfYear.March){
      return MonthOfYear.April;
    }
    if (monthBefore == MonthOfYear.April){
      return MonthOfYear.May;
    }
    if (monthBefore == MonthOfYear.May){
      return MonthOfYear.June;
    }
    if (monthBefore == MonthOfYear.June){
      return MonthOfYear.July;
    }
    if (monthBefore == MonthOfYear.July){
      return MonthOfYear.August;
    }
    if (monthBefore == MonthOfYear.August){
      return MonthOfYear.September;
    }
    if (monthBefore == MonthOfYear.September){
      return MonthOfYear.October;
    }
    if (monthBefore == MonthOfYear.October){
      return MonthOfYear.November;
    }
    if (monthBefore == MonthOfYear.November){
      return MonthOfYear.December;
    }
    return MonthOfYear.January;
    
  }
  /**
  * Creates a new month object and fully initializes with its corresponding days.
  * @param monthOfYear which month of the year this new month represents
  * @param year in which this month is a part
  * @return reference to the newly created month object
  */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
    Month name = new Month(monthOfYear, year);
    int i=0;
    int j=0;
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Monday) {
       j=0;
    }
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Tuesday) {
      j=1;
   }
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Wednesday) {
      j=2;
   }
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Thursday) {
      j=3;
   }
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Friday) {
      j=4;
   }
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Saturday) {
      j=5;
   }
    if(calcFirstDayOfWeekInMonth(name)==DayOfWeek.Sunday) {
      j=6;
   }
   
    
    
    
   
   
   
    
    
    for(i = 1; i <= numberOfDaysInMonth(name); i++) {
     if(j == 0) {
      name.addDay( new Day(DayOfWeek.Monday,i, name));
      j++;
      continue;
     }
     if(j == 1) {
       name.addDay( new Day(DayOfWeek.Tuesday,i, name));
       j++;
       continue;
      }
     if(j == 2) {
       name.addDay( new Day(DayOfWeek.Wednesday,i, name));
       j++;
       continue;
      }
     if(j == 3) {
       name.addDay( new Day(DayOfWeek.Thursday,i, name));
       j++;
       continue;
      }
     if(j == 4) {
       name.addDay( new Day(DayOfWeek.Friday,i, name));
       j++;
       continue;
      }
     if(j == 5) {
       name.addDay( new Day(DayOfWeek.Saturday,i, name));
       j++;
       continue;
      }
     if(j == 6) {
       name.addDay( new Day(DayOfWeek.Sunday,i, name));
       j=0;
      }
     
     
     
    }
   

return name;
  }
  
  /**
  * Prints the contents of the specified month object in calendar form. This
  * printout should begin with the Month an year of the month. The next line should
  * contain the three letter abbreviations for the seven days of the week. And then
  * the dates of each day of that month should follow: one week per line, with
  * periods in positions of days that are a part of the month before or after. For
  * example, January 2020 should be printed as follows:
  *
  * January 2020
  * MON TUE WED THU FRI SAT SUN
  * . . 1 2 3 4 5
  * 6 7 8 9 10 11 12
  * 13 14 15 16 17 18 19
  * 20 21 22 23 24 25 26
  * 27 28 29 30 31 . .
  *
  * @param month which is to be printed by this method
  */
  public static void printMonth(Month month) {
   DayOfWeek firstDay = calcFirstDayOfWeekInMonth(month);
   int count = 0;
   System.out.println(month.getMonthOfYear().toString() + " " + month.getYear().toString()); 
   System.out.println("MON TUE WED THU FRI SAT SUN");
   for(int i = 0; i < firstDay.ordinal(); i++ ) {
     System.out.print("." + " ");
     count++;
   }
   for(int i = 1; i <= numberOfDaysInMonth(month); i++) {
     System.out.print(i + " ");
     
     if((i+count)%7 == 0) {
     System.out.println();
     }
     
   }
   int totalSum = numberOfDaysInMonth(month) + count;
   for(int i = (totalSum)%7; i < 7; i++ ) {
     System.out.print("." + " ");
   }
   //System.out.println(calcFirstDayOfWeekInMonth(month));
  }
  /**
  * Creates an array list of months that are initialized with their full complement
  * of days. Prints out each of these months in calendar form, and then returns the
  * resulting ArrayList.
  * @param month of the year for the first month that is created and printed
  * @param year that the first month created and printed is a part of
  * @param count is the total number of sequential months created and printed
  * @return the array list of months that this method generates and prints.
  */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count){
    Month newMonth = createNewMonth( month,year);
    ArrayList<Month> calendar = new ArrayList<Month>();
    for(int i = 0; i < count; i++) {
      if(CalendarPrinter.monthOfYearAfter(month) == month.January) {
        newMonth = createNewMonth( month,year);
        int currentYear = year.intValue();
        currentYear++;
        year = new Year(currentYear);
      }
      calendar.add(newMonth);
      CalendarPrinter.printMonth(newMonth);
      month = CalendarPrinter.monthOfYearAfter(month);
      newMonth = createNewMonth( month,year);
      
      
    }
    return calendar;
    
  }
  
  
  /**
  * Driver for the CalendarPrinter Application. This program asks the user to enter
  * an initial month, an initial year, and the total number of months to create and
  * display in calendar form.
  * @param args is not used by this program
  */
  public static void main(String [] args) {
    long start = System.currentTimeMillis();
   // print welcome message
   Scanner in = new Scanner(System.in);
   System.out.println("Welcome to the Calendar Printer.");
   System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
   // read input from the user
   System.out.print("Enter the month to begin calendar: ");
   String monthString = in.nextLine().trim();
   System.out.print("Enter the year to begin calendar: ");
   String yearString = in.nextLine().trim();
   System.out.print("Enter the number of months to include in this calendar: ");
   String countString = in.nextLine().trim();
   // convert user input into usable form
   monthString = monthString.substring(0,3).toUpperCase();
   MonthOfYear month = null;
   for(int i=0;i<MonthOfYear.values().length;i++)

  if(monthString.equals(MonthOfYear.values()[i].name().substring(0,3).toUpperCase()))
   month = MonthOfYear.values()[i];
   Year year = new Year(Integer.parseInt(yearString.trim()));
   int count = Integer.parseInt(countString.trim());
   // create months and display them in calendar form
   System.out.println();
   createAndPrintMonths(month,year,count);
   // display thank you message
   System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
   System.out.println("Thanks, and have a nice day.");
   in.close();
   long end = System.currentTimeMillis();
   long total = end - start;
   System.out.println(total);
  }
  
}


