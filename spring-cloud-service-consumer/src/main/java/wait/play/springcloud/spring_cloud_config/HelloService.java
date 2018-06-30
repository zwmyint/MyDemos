package wait.play.springcloud.spring_cloud_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${user.service.name}")
	private String serviceName;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		return restTemplate.getForEntity("http://" + serviceName + "/hello", String.class).getBody();

	}
	
	public String helloFallback() {
		return "Something error!";
	}

}
