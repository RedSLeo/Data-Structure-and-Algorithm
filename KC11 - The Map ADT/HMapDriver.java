package ch08.maps;
import ch08.maps.HMap;

public class HMapDriver {
   
   public static void main(String[] args){
      
      HMap<String, Integer> hmap = new HMap<>();
      
      System.out.println("Car, 1" + hmap.put("Car", 1));
      System.out.println("Plane, 2" + hmap.put("Plane", 2));
      
      System.out.println("Value for Car: " + hmap.get("Car"));
      
      System.out.println("Contains Plane: " + hmap.contains("Plane"));
      
      System.out.println("Size of map: " + hmap.size());
      
      System.out.println("Map is empty? " + hmap.isEmpty());
      
   }
}