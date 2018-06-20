package wait.play;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
	
	@RequestMapping(value = { "/home", "/" })
	public String home(Model model) {
		model.addAttribute("title", "This is a thymeleaf demo");
		List<String> list = new ArrayList<String>();
		list.add("football");
		list.add("basketball");
		list.add("badminton");
		Person person = new Person();
		model.addAttribute("list", list);
		model.addAttribute("person", person);
		return "home";
	}
}
