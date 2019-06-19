package demo;

import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name="spring-cloud-eureka-client")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}