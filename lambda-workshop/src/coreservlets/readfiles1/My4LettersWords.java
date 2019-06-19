package coreservlets.readfiles1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class My4LettersWords {

	public static void main(String[] args) throws Exception {

		String inputFile = "enable1-word-list.txt";
		     
		List<String> newWords= 			
					  Files.lines(Paths.get(inputFile))
		             .filter(word -> word.length() == 4)
		             .distinct()
		             .sorted()
		             .collect(Collectors.toList());
		   // System.out.printf("%s words with q but not u.%n", wordCount);
		
		Files.write(Paths.get("newWords-list.txt"), 
					newWords, 
					Charset.defaultCharset());
		
		try(PrintWriter writer = new PrintWriter(
									Files.newBufferedWriter(Paths.get("newWords-list-upgrade.txt"),
															Charset.defaultCharset()))){
			for(String line:newWords) {
				writer.printf(" line ### %s \n", line);
			}
		}
	}

}
