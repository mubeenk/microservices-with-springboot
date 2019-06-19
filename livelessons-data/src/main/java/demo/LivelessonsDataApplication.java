package demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LivelessonsDataApplication {

	@Bean
	public InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.save(new Car("Honda", "Civic", 1997));
			repository.save(new Car("Honda", "Accord", 2003));
			repository.save(new Car("Ford", "Escort", 1985));
		};
	}

//	@Bean
//	public CommandLineRunner exampleQuery(CarRepository repository) {
//		System.out.println("By Make");
//		return args -> repository.findByMakeIgnoringCase("Escort")
//				.forEach(System.out::println);
//	}
	

	@Bean
	public CommandLineRunner exampleQuery2(CarRepository repository) {
		System.out.println("By Year");
		return args -> repository.findByYear(2003)
				.forEach(System.err::println);
	}

	
	@Bean
	public CommandLineRunner exampleQuery3(CarRepository repository) {
		System.out.println("By Model");
		return args -> repository.findByModel("Civic")
				.forEach(System.err::println);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(LivelessonsDataApplication.class, args);
	}

}
