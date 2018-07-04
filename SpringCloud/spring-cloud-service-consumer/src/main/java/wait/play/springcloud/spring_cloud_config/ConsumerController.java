package wait.play.springcloud.spring_cloud_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	@Autowired
	HelloService service;

	@GetMapping(value = "/ribbon-consumer-hello-service")
	public String helloServiceConsumer() {
		return service.helloService();
	}

}
