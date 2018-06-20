package wait.play;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PersonController {
	
	@PostMapping("/person")
	public String person(@ModelAttribute Person person, Model model) {
		model.addAttribute("title","This is a thymeleaf demo");
		List<String> list = new ArrayList<String>();
		list.add("football");
		list.add("basketball");
		list.add("badminton");
		model.addAttribute("list", list);
		return "home";
	}

}
