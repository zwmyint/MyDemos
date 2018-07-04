package wait.play.springcloud.spring_cloud_fegin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
	private final Logger logger = Logger.getLogger(HelloServiceFallback.class);

	@Override
	public String hello() {
		logger.error("Trigger fallback service");
		return "error";
	}

	@Override
	public User hello(String name, Integer age) {
		logger.error("Trigger fallback service");
		return new User("error", -1);
	}

	@Override
	public String hello(User user) {
		logger.error("Trigger fallback service");
		return "error";
	}

}
