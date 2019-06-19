package coreservlets.readfiles1;

import java.nio.file.*;

public class XsAndYs {
  public static void main(String[] args) throws Exception {
    String inputFile = "enable1-word-list.txt";
    //Files.lines(Paths.get(inputFile)).forEach(System.out::println);
    
    long tick1 =System.currentTimeMillis();
    int letterCount = 
        Files.lines(Paths.get(inputFile))
        	 //.parallel()
             .filter(word -> word.contains("x"))
             .filter(word -> word.contains("y"))
             .mapToInt(String::length)
             .sum();
    long tick2 =System.currentTimeMillis();
    System.out.printf("%,d total letters in words with " +
                      "both x and y.%n with Time taken is %d" , letterCount,(tick2-tick1));
  }
}
