package wait.play.springcloud.spring_cloud_fegin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

	@Autowired
	HelloService hello;

	@GetMapping(value = "/feign-consumer")
	public String helloConsumer() {
		return hello.hello();
	}

	@GetMapping(value = "/feign-consumer-2")
	public String helloConsumer2() {
		StringBuffer sb = new StringBuffer();
		return sb.append(hello.hello()).append("\n").append(hello.hello("User1", 30)).append("\n")
				.append(hello.hello(new User("user2", 28))).toString();
	}

}
