package demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Component
public class RegularClient {

	@Autowired
	private EurekaClient client;
	
	@Bean
	public CommandLineRunner exampleQuery() {
		System.out.println("hitting client");
		Application app = client.getApplication("SPRING-EUREKA-CLIENT");
		InstanceInfo instance = app.getInstances().get(0);
		String hostName = instance.getHostName();
		String appName = instance.getAppName();
		System.out.print(hostName + " - " + appName);
		return args -> Arrays.asList(hostName,appName);
	}
	
	public void doRequest() {
		
	}
}
