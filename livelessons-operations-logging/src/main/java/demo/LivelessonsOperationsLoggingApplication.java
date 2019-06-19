package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivelessonsOperationsLoggingApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(
				LivelessonsOperationsLoggingApplication.class);
		//application.setWebEnvironment(false);
		application.run(args);
	}

}
