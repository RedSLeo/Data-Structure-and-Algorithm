package ch05.collections;

import ch05.collections.SortedLinkedCollection;

public class SLCTest {

   public static void main(String[] args) {
   
      SortedLinkedCollection<Integer> collection1 = new SortedLinkedCollection<>();
      SortedLinkedCollection<Integer> collection2 = new SortedLinkedCollection<>();
      
      collection1.add(11);
      collection1.add(22);
      collection1.add(33);
      collection1.add(28);
      
      System.out.println("Collection 1: " + collection1.toString());
      System.out.println("Smallest element within collection1: " + collection1.smallest());
      System.out.println("Elements that are greater than 17 in within collection1 " + collection1.greater(17));
      
      collection2.add(94);
      collection2.add(51);
      collection2.add(22);
      collection2.add(31);
      
      SortedLinkedCollection<Integer> combinedCollection = collection1.combine(collection2);
      System.out.println("\nCombined Collection: " + combinedCollection.toString());
   
   }
}