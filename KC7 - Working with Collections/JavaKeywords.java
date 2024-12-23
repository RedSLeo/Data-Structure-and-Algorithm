import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Collection;


public class JavaKeywords {
   
    private static Collection<String> loadKeywords(String filePath) throws FileNotFoundException {
         Collection<String> keywords = new HashSet<>();
         File file = new File(filePath);
         Scanner scanner = new Scanner(file);
         
         while (scanner.hasNextLine()) {
            String keyword = scanner.nextLine().trim();
            keywords.add(keyword);
         }
         scanner.close();
         return keywords;
      
      }
      
      
   private static int countWordsInFile(Collection<String> keywords, String javaFilePath) throws FileNotFoundException {
      int keywordCount = 0;
      File file = new File(javaFilePath);
      Scanner scanner = new Scanner(file);
      
      while (scanner.hasNext()) {
         String word = scanner.next();
         if (keywords.contains(word)) {
            keywordCount++;
         }
      
      }
      scanner.close();
      return keywordCount;
   
   
   }
   
   public static void main(String[] args) {
   
   // Do not remove
      if (args.length != 1) {
         System.out.println("Usage: java KeywordCounter <JavaFile.java>");
         return;
      }
      
      String javaFilePath = args[0];
      String keywordFilePath = "Keywords.txt";
      
      try {
      
         Collection<String> keywords = loadKeywords(javaFilePath);
         
         int keywordCount = countWordsInFile(keywords, javaFilePath);
         
         System.out.println(javaFilePath + " contains " + keywordCount + " keywords");
      
      } catch (FileNotFoundException e) {
         System.out.println("FILE NOT FOUND");
         e.printStackTrace();
      
      }   

   }

}