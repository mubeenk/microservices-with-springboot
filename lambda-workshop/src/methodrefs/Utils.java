package methodrefs;

public class Utils {
  public static String transform(String s, StringFunction f) {
	//System.out.println(f.getClass().getName());
    return(f.applyFunction(s));
  }
  
  public static String makeExciting(String s) {
    return(s + "!!");
  }
  
  private Utils() {}
}
