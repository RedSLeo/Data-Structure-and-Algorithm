import support.LLNode;
import ch03.apps.LinkedListRecursive;

// The algorithm I chose is the "Sieve of Eratosthenes", the most common and simple algorithm.
// The reason I went with this particular algorithm is because it's able to quickly check
// multiple values within the same range to determine whether or not a number is prime.
// Despite me having a small list of numbers it is more ideal for larger range of numbers due to it's
// efficient complexity performance.

public class PrimeNumberLinkedList extends LinkedListRecursive {

   private boolean[] sieveOfEratosthenes(int max) {
      boolean[] isPrime = new boolean[max + 1];
      for (int i = 2; i <= max; i++) {
         isPrime[i] = true;
      }
      
      for (int j = 2; j * j <= max; j++) {
         if (isPrime[j]) {
            for (int multiple = j * j; multiple <= max; multiple += j){
               isPrime[multiple] = false;
            }
         }
      }
      return isPrime;
   }
   
   public int findMax(LLNode<Integer> listRef) {
      int max = Integer.MIN_VALUE;
      while (listRef != null) {
         if (listRef.getInfo() > max) {
            max = listRef.getInfo();
         }
         listRef = listRef.getLink();
      }
      return max;
   }

   private int primeNum(LLNode<Integer> listRef, boolean[] isPrime) {
      if (listRef == null) {
         return 0;
      }
      int count = (listRef.getInfo() > 1 && isPrime[listRef.getInfo()]) ? 1 : 0;
      return count + primeNum(listRef.getLink(), isPrime);
   }
   
   public int sieveCountingPrimes(LLNode<Integer> listRef) {
      int max = findMax(listRef);
      boolean[] isPrime = sieveOfEratosthenes(max);
      return primeNum(listRef, isPrime);
   }
  
   
   public static void main(String[] args) {
      PrimeNumberLinkedList pnll = new PrimeNumberLinkedList();
      
      LLNode<Integer> head = new LLNode<>(6);
      head.setLink(new LLNode<>(13));
      head.getLink().setLink(new LLNode<>(12));
      head.getLink().getLink().setLink(new LLNode<>(19));
      
      int countPrime = pnll.sieveCountingPrimes(head);
      System.out.println("Number of primes within the list: " + countPrime);
   }




}