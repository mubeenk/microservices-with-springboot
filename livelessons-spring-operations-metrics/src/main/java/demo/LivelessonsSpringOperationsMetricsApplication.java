package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class LivelessonsSpringOperationsMetricsApplication {

//	@Bean
//	@Primary
//	public InMemoryRichGaugeRepository inMemoryRichGaugeRepository() {
//		return new InMemoryRichGaugeRepository();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(LivelessonsSpringOperationsMetricsApplication.class, args);
	}

}
