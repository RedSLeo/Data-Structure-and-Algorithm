import java.util.Random;
import java.util.Scanner;

public class ArraySkills {

   public static void removeNameByIndex(String[] array, int index) {
      if (index >= 0 && index < array.length) {
         array[index] = null;
      } else {
         System.out.println("Invalid Index");
      }
   }

   public static String[] swapElements(String[] array, int X, int Y){
      if (X < 0 || Y < 0 || X >= array.length || Y >= array.length) {
         System.out.println("Invalid numbers");
         return array;
      }

      String temp = array[X];
      array[X] = array[Y];
      array[Y] = temp;

      return array;
   }

   public static void shuffledArray(String[] array) {
      Random rando = new Random();

      for (int i = 0; i < array.length; i++) {
         int indexRandomizer = rando.nextInt(array.length);
         String temp = array[indexRandomizer];
         array[indexRandomizer] = array[i];
         array[i] = temp;
      }
   }

   public static String longestString(String[] strings) {
      if (strings == null || strings.length == 0) {
         return null;
      }
      String longest = "";

      for (String str : strings) {
         if (str != null && str.length() > longest.length()){
            longest = str;
         }
      }
      return longest;
   }

   public static String shortestString(String[] strings) {
      if (strings == null || strings.length == 0){
         return null;
      }
      String shortest = null;

      for (String str : strings) {
         if (str != null && (shortest == null || str.length() < shortest.length())) {
            shortest = str;
         }
      }
      return shortest;
   }

   public static int linearSearch(String[] array, String target){
      for (int i = 0; i < array.length; i++){
         if (array[i] != null && array[i].equals(target)){
            return i;
         }
      }
      return -1;
   }

   public static void elementShift(String[] array, int remIndex){
      if (remIndex < 0 || remIndex >= array.length) {
         System.out.println("Not a valid index");
         return;
      }

      for (int i = remIndex; i < array.length - 1; i++){
         array[i] = array[i + 1];
      }
      
      array[array.length - 1] = null;
   }

    public static void main(String[] args) {
    
       // ***********************
       // For each item below you must code the solution using a plain 
       //  Java array. You may not use any of the methods found in the 
       //  Arrays class or the Collections classes. Manually perform
       //  all operations without relying on system libraries to do the work.
       //
    
       // ***********************
       // Use this array for all operations
       String[] myData = new String[21];
    
       //  1. Instantiate the given array to hold 10 Strings.

       myData[0] = "Mango";
       myData[1] = "Watermelon";
       myData[2] = "Strawberry";
       myData[3] = "Banana";
       myData[4] = "Dragonfruit";
       myData[5] = "Kiwi";
       myData[6] = "Papaya";
       myData[7] = "Pineapple";
       myData[8] = "Guava";
       myData[9] = "Star apple";


       //  2. Add your name to the Array at index 0 and a friend's name to the 
       //      Array at index 4
      myData[0] = "Leo";
      myData[4] = "Will";
             
       //  3. Move your friend's name to index 0 (overwriting your name) in the 
       //      array and "delete" their name from index 4
      //  removeElementByIndex(myData, 4);
      myData[0] = myData[4];
      removeNameByIndex(myData, 4);

       //  4. Fill up all of the remaining indeces in the array with more names
       myData[10] = "Brenda";
       myData[11] = "Johnny";
       myData[12] = "Zach";
       myData[13] = "Cody";
       myData[14] = "Lisa";
       myData[15] = "Pops";
       myData[16] = "Patricia";
       myData[17] = "Andrea";
       myData[18] = "Bobby";
       myData[19] = "Cory";
       myData[20] = "Raven";
       
       //  5. Swap the values at index 5 and index 1. Put the value at index 5 
       //      in index 1 and the value at index 1 in index 5.
      swapElements(myData, 1, 5);

       
       //  6. Print the array from beginning to end.
       for (int i = 0; i < myData.length; i++){
         System.out.println("Index " + i + ": " + myData[i]);
      }
       
       //  7. Shuffle the array of strings. In other words, randomize the 
       //      contents of the array like you might a deck of cards. It's OK
       //      to use a Random object or the Math.random() method here.
      shuffledArray(myData);
      System.out.println("\nShuffled Array: ");

      for ( int i = 0; i < myData.length; i++){
         System.out.println("Index " + i + ": " + myData[i]);
      }
       
       //  8. Find and print the longest and shortest Strings in the array.
       //      It's fine to use Math class methods here.
       String longestString = longestString(myData);
       System.out.println("\nLongest String in Array: " + longestString);

       String shortestString = shortestString(myData);
       System.out.println("Shortest String in Array: " + shortestString);
       
       //  9. Add up the total number of characters in all of the strings in 
       //      the array and print the answer
       int numCharacters = 0;

       for (String i : myData){
         if (i != null){
            numCharacters += i.length();
         }
       }

       System.out.println("\nTotal Characters: " + numCharacters);
    
       // 10. Prompt the user for a String and then perform a linear search 
       //      of the array to see if that string is or is not in the array. 
       //      Print if it is or is not found.
       Scanner scanner = new Scanner(System.in);

       System.out.println("\nEnter a Name or Fruit: ");
       String response = scanner.nextLine();

       int result = linearSearch(myData, response);

       if (result != -1) {
         System.out.println("Found " + response + " at index: " + result);
       } else {
         System.out.println(response + " is not found in the array.");
       }
       
       // 11. Remove the item at index 4 of the array by shifting everything 
       //      after it one spot over. This is similar to how everybody waiting
       //      in a line steps up one step if somebody in front of them leaves 
       //      the line. This means your array should have one empty index at 
       //      the end after the shift (delete the duplicate item at the end).
       elementShift(myData, 4);
       for (int i = 0; i < myData.length; i++){
         System.out.println(myData[i]);
      }
       
       // 12. Create a new array that is twice as big as the current array and
       //      copy all of the items from the old array to the new array. When 
       //      complete, assign the new bigger array to the myData variable so 
       //      the old array gets garbage collected..
       
       String[] newData = new String[myData.length * 2];

       for (int i = 0; i < myData.length; i++){
         newData[i] = myData[i];
       }

       myData = newData;

       for (int i = 0; i < myData.length; i++){
         System.out.println(myData[i]);
      }

       
       // 13. Prompt the user to enter 2 numbers within the range of the array's
       //      length. If the first is larger than the second print backwards 
       //      from that index to the first. If the second is larger than the 
       //      first, print forward in the array from the first index to the second.
      System.out.println("Enter the first index number (0 to " + (myData.length - 1) + "): ");
      int firstIndex = scanner.nextInt();

      System.out.println("Enter the second index number (0 to " + (myData.length - 1) + "): ");
      int secondIndex = scanner.nextInt();

      scanner.close();

      if (firstIndex < 0 || firstIndex >= myData.length || secondIndex < 0 || secondIndex >= myData.length){
         System.out.println("The index number must be between 0 and " + (myData.length - 1));
         return;
      }

      // Creates the appropriate direction
      if (firstIndex > secondIndex) {
         System.out.println("Printing backwards from index " + firstIndex + " to index " + secondIndex);
         for (int i = firstIndex; i >= secondIndex; i--) {
            if (myData[i] != null) {
               System.out.println("Index " + i + ": " + myData[i]);
            } else {
               System.out.println("[empty]");
            }
         }
      } else if (secondIndex > firstIndex) {
         System.out.println("Printing forward from index " + firstIndex + " to index " + secondIndex);
         for (int i = firstIndex; i <= secondIndex; i++) {
            if (myData[i] != null) {
               System.out.println("Index " + i + ": " + myData[i]);
            } else {
               System.out.println("[empty]");
            }
         }
      } else {
         System.out.println("Since both index numbers are the same, here is the element at index " + firstIndex + ":");
         if (myData[firstIndex] != null) {
            System.out.println(myData[firstIndex]);
         } else {
            System.out.println("[empty]");
         }
      }
     }
 
 }
