package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LivelessonsConfigurationCloudserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivelessonsConfigurationCloudserverApplication.class, args);
	}

}
