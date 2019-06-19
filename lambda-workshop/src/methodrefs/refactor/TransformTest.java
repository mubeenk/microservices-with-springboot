package methodrefs.refactor;

import java.util.*;

public class TransformTest {
  public static void main(String[] args) {
    String s = "Test";
        // SomeClass::staticMethod
    String result1 = Utils.transform(s, Utils::makeExciting);
    System.out.println(result1);
        // someObject::instanceMethod
    String prefix = "Blah";
    String result2 = Utils.transform(s, prefix::concat);
    System.out.println(result2);
        // SomeClass::instanceMethod
    String result3 = Utils.transform(s, String::toUpperCase);
    System.out.println(result3);
        // General types
    List<String> words = Arrays.asList("hi", "bye");
    int size = Utils.transform(words, List::size);
    System.out.println(size);
    String myNumber = "23";
    Integer retVal = Utils.transform(myNumber, Integer::new);
    System.out.println(retVal);
  }
}
