package wait.play.springcloud.spring_cloud_config;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceController {
	private final Logger logger = Logger.getLogger(HelloServiceController.class);

	@Autowired
	private DiscoveryClient client;

	@Value("${config.name}")
	String name = "World";

	@GetMapping("/hello")
	public String home() {
		createException("hello");
		return "Hello " + name;
	}

	@GetMapping("/hello1")
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		createException("hello1");
		return new User(name, age);
	}

	@PostMapping("/hello2")
	public String hello(@RequestBody User user) {
		createException("hello2");
		return "Hello, " + user.getName() + " , " + user.getAge();
	}

	private void createException(String mapping) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/" + mapping + ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		int random = new Random().nextInt(100);
		if (random % 9 == 0) {
			throw new RuntimeException("Something is woring with the Service: " + instance.getHost() + " [service_id]: "
					+ instance.getServiceId());
		}
	}

}
