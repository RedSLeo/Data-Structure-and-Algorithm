import java.util.Scanner;

public class TriangleUp {

   public void printTriangleUp(int n){
      if (n == 0){
         return;
      }
      
      // Recursive case: print the triangle up to n-1 first
      printTriangleUp(n - 1);
      
      for (int i = 0; i < n; i++ ){
         System.out.print("*");
      }
      
      System.out.println();
   }


   public static void main(String[] args){
      TriangleUp tu = new TriangleUp();
      
      tu.printTriangleUp(10);
      }

}