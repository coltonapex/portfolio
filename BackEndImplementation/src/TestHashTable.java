// --== CS400 File Header Information ==--
// Name: <Colton Carlino>
// Email: <ccarlino@wisc.edu>
// Team: CC
// TA: <Yeping>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
/**
   *
   *Contains the test methods for HashTableMap 
   */
public class TestHashTable{

 // create hash table and use methods to test them
  
  // Tests if the size increases when put is called to check if put works
  public static boolean test1() {
    HashTableMap<Integer,String> testMap = new HashTableMap<Integer, String>();
    testMap.put(0, "Aaron");
    testMap.put(1, "Nicole");
    testMap.put(2, "Colton");
    if(testMap.size() == 3) {
      return true;
    }
    System.out.println("size is " + testMap.size());
    return false; 
    }
  
  //Tests the get method by getting something from the hashmap and checking to see if it got the right value
  public static boolean test2() {
    HashTableMap<Integer,String> testMap = new HashTableMap<Integer, String>();
    testMap.put(0,"Aaron");
    testMap.put(1,"Nicole");
    testMap.put(2,"Colton");
    if(testMap.get(2).equals("Colton")) {
      return true;
    }
    System.out.println("what is actually got is " + testMap.get(2));
    return false;  
    }
  // tests to see if the hashMap rehashes correctly
  public static boolean test3() {
    int capacity = 5;
    HashTableMap<Integer,String> testMap = new HashTableMap<Integer, String>(capacity);
    testMap.put(0,"Aaron");
    testMap.put(1,"Nicole");
    testMap.put(2,"Colton");
    testMap.put(3, "Abby");
    if (testMap.getCapacity() == 10) {
      return true;
    }
    System.out.println("actual capacity is " + capacity);
    return false;  
    }
  // tests the remove function
  public static boolean test4() {
    HashTableMap<Integer,String> testMap = new HashTableMap<Integer, String>();
    testMap.put(0,"Aaron");
    testMap.put(1,"Nicole");
    testMap.put(2,"Colton");
    testMap.put(3,"Sophia");
    testMap.remove(2);
    if(testMap.size() == 3) {
      return true;
    }
    System.out.println("actual size is " + testMap.size());
    return false; 
    }
  
  
  //Tests size after a collision
  public static boolean test5() {
    HashTableMap<Integer,String> testMap = new HashTableMap<Integer, String>();
    testMap.put(0, "Aaron");
    testMap.put(1, "Nicole");
    testMap.put(2, "Colton");
    testMap.put(12, "Jill");
    if(testMap.size() == 4) {
      return true;
    }
    System.out.println("size is " + testMap.size());
    return false; 
    }
    
  
  // prints out the tests results
  public static void main(String[] args) {
    System.out.println("test1 returns: " + test1());
    System.out.println("test2 returns: " + test2());
    System.out.println("test3 returns: " + test3());
    System.out.println("test4 returns: " + test4());
    System.out.println("test5 returns: " + test5());
      }
  
}