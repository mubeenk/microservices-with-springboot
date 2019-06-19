package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LivelessonsDataCmdLineRunnerApplication {

	@Bean
	CommandLineRunner exampleFork() {
		return (args) -> {
			System.out.println("this is command line");
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LivelessonsDataCmdLineRunnerApplication.class, args);
	}

}
