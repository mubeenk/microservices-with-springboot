package demo;

import java.util.Arrays;

import org.omg.CORBA.PERSIST_STORE;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyRestProjectApplication {

//	@Bean
//	InitializingBean seedDatabase(PersonRepository repository) {
//		return () -> {
//			repository.save(new Person("Honda", "Civic@gmail"));
//			repository.save(new Person("Honda", "Accord@gmail"));
//			repository.save(new Person("Ford", "Escort@gmail"));
//		};
//	}
	
	@Bean
	CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {
			personRepository.findAll().forEach(System.out::println);
		};
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(MyRestProjectApplication.class, args);
	}

}
