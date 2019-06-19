package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@Component
@RestController
public class GreetingController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	@RequestMapping("/greeting")
	public String greeting() {
		return String.format("Hello from %s !",eurekaClient.getApplication(appName).getName());
	}

}
