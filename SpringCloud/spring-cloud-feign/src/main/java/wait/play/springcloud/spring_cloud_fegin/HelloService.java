package wait.play.springcloud.spring_cloud_fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class)
public interface HelloService {

	@GetMapping("/hello")
	String hello();

	@GetMapping("/hello1")
	User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@PostMapping("/hello2")
	String hello(@RequestBody User user);

}
