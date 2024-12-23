package ch08.maps;

public class BSTMapTest {
   public static void main(String[] args) {
   
      BSTMap<String, Integer> map = new BSTMap<>();
      
      System.out.println("Entries:");
      
      map.put("Bob", 40);
      map.put("Mary", 37);
      map.put("Susan", 12);
      
      System.out.println("Entry Size: " + map.size());
      
      System.out.println("\nGetting entries:");
      System.out.println("Bob: " + map.get("Bob"));
      System.out.println("Zack: " + map.get("Zack"));
      
      System.out.println("\nRemoving 'Bob'");
      map.remove("Bob");
      System.out.println("Contains 'Bob': " + map.contains("Bob"));
      System.out.println("Entry Size: " + map.size());
      
      System.out.println("\nIterating through the map:");
      for (MapEntry<String, Integer> entry : map) {
         System.out.println(entry);
      }
   
   }

}