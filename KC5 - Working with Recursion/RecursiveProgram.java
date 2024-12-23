import java.util.Scanner;

public class RecursiveProgram {
   
   public int Sum(int N){
      if (N == 0){
          return 0;
      }
      else {
         return (N + Sum(N - 1)); 
      }
   
   }
   
   public int BiPower(int N){
      if (N == 0){
         return 1;
     }
     else {
         return (2 * BiPower(N - 1));
     }
   }
   
   public int TimesFive(int N){
      if (N == 0){
         return  0;
      } else {
         return (5 + TimesFive(N - 1));
   }
  }
   
   
   public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      RecursiveProgram rp = new RecursiveProgram();
      
      System.out.println("Enter a non-negative integer.");
      
      int N = scanner.nextInt();
      
      if (N > 0){
         System.out.println("Sum(" + N + ") = " + rp.Sum(N));
         System.out.println("BiPower(" + N + ") = " + rp.BiPower(N));
         System.out.println("TimesFive(" + N + ") = " + rp.TimesFive(N));
      } else {
      System.out.println("Please input a non-negative integer.");
      }
      
      scanner.close();
   }
}