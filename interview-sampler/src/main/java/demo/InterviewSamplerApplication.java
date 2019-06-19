package demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterviewSamplerApplication {

	@Bean
	CommandLineRunner stringReversal() {
		
		String task = "streaming";
		System.out.println(task);
		StringBuilder buffer = new StringBuilder(task);
		System.out.println(buffer.reverse().toString());
		return null;
		
	}
	
	@Bean
	CommandLineRunner uniqueString() {
		
		boolean match = false;
		String task = "streamingi";
		char[] sequence = task.toCharArray();
		for(int i=0;i< sequence.length;i++) {
			int loc = task.indexOf(sequence[i]);
			if(loc == i) {
				loc = task.indexOf(sequence[i],i+1);
				if(loc != -1){
					System.out.printf("\n match found for %c \n",sequence[i]);
					break;
				}
			}
		}
		
		return null;
		
	}
	
	@Bean
	CommandLineRunner permutation() {
		
		String first = "abcdefg";
		String second = "efabcgd";
		
		// check length
		if(first.length() != second.length())
			return null;
		
		// sort both
		char[] fArray =  first.toCharArray(); 
		char[] sArray =  second.toCharArray(); 
		
		Arrays.sort(fArray);
		Arrays.sort(sArray);
		
		System.out.println(fArray);
		System.out.println(sArray);

		if(Arrays.equals(fArray, sArray))
			System.out.println("Permutation exist");
		else
			System.out.println("Mismatch");
			
		return null;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(InterviewSamplerApplication.class, args);
	}

}
