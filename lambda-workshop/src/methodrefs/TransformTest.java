package methodrefs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransformTest {
	
	public void spanThreads() {
		ExecutorService taskList = Executors.newFixedThreadPool(5);
		int counter =0;
		taskList.execute( () -> {
				// TODO Auto-generated method stub
				int x=0;
				try {
					wait(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int tty = 9;
			}
		);
		
 	}

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
    
    final String str="repository";
    
    // SomeClass::instanceMethod
    String result4 = Utils.transform(s, (xsttr)->str.toUpperCase());
    
    System.out.println(result4);
    
  }
}
